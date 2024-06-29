package com.enviro.assessment.grad001.thamsanqandaba.controller;

/**
 * File Controller for handling file upload and data retrieval
 * Author: thamsanqa 2024
 **/

import com.enviro.assessment.grad001.thamsanqandaba.dto.FileResponse;
import com.enviro.assessment.grad001.thamsanqandaba.model.EnvironmentalData;
import com.enviro.assessment.grad001.thamsanqandaba.service.EnvironmentalDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class FileController {

    @Autowired
    private EnvironmentalDataService dataService;  // Service for data operations

    @Autowired
    private ObjectMapper objectMapper; // ObjectMapper for JSON serialization

    // Endpoint for file upload
    @PostMapping("/upload")
    public ResponseEntity<FileResponse> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileType = detectFileType(file); // Determine the file type

            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            List<EnvironmentalData> dataList;

            // Process file based on type
            if ("csv".equalsIgnoreCase(fileType)) {
                dataList = processCsvFile(reader);
            } else if ("txt".equalsIgnoreCase(fileType)) {
                dataList = processTxtFile(reader);
            } else {
                return new ResponseEntity<>(new FileResponse("Unsupported file type"), HttpStatus.BAD_REQUEST);
            }

            dataService.saveAllData(dataList); // Save processed data
            return new ResponseEntity<>(new FileResponse("File uploaded successfully"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new FileResponse("Failed to upload file: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint to retrieve all data
    @GetMapping("/data")
    public List<EnvironmentalData> getAllData() {
        return dataService.getAllData();
    }

    // Helper method to detect file type based on its extension
    private String detectFileType(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (fileName != null && fileName.contains(".")) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        return "";
    }

    // Process CSV file and convert each line to EnvironmentalData objects
    private List<EnvironmentalData> processCsvFile(BufferedReader reader) {
        String[] headers = reader.lines().findFirst().orElse("").split(",");
        return reader.lines()
                .map(line -> parseCsvLineToJson(line, headers))
                .collect(Collectors.toList());
    }

    // Process TXT file and convert each line to EnvironmentalData objects
    private List<EnvironmentalData> processTxtFile(BufferedReader reader) {
        // Example: Process TXT file assuming each line is a separate data entry
        return reader.lines()
                .map(this::parseTxtLineToJson)
                .collect(Collectors.toList());
    }

    // Parse CSV line to EnvironmentalData object
    private EnvironmentalData parseCsvLineToJson(String line, String[] headers) {
        String[] fields = line.split(",");
        EnvironmentalData data = new EnvironmentalData();

        try {
            // Construct a JSON string for dynamic data using headers
            Map<String, String> dataMap = new HashMap<>();
            for (int i = 0; i < fields.length; i++) {
                dataMap.put(headers[i], fields[i]);
            }
            String json = objectMapper.writeValueAsString(dataMap);
            data.setDynamicDataJson(json);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    // Parse TXT line to EnvironmentalData object
    private EnvironmentalData parseTxtLineToJson(String line) {
        EnvironmentalData data = new EnvironmentalData();

        try {
            // Construct a JSON string for dynamic data
            String json = objectMapper.writeValueAsString(Map.of("content", line));
            data.setDynamicDataJson(json);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}