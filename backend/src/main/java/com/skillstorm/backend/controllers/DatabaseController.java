package com.skillstorm.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

//web bindings
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//need for file grabbing
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
@CrossOrigin
public class DatabaseController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/resetDB")
    public ResponseEntity<String> resetDB() {
        String sql;
        try {
            // Load SQL 
  // Use the class loader to get the resource as an InputStream
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("data.sql");
            

        if (inputStream == null) {
            throw new IllegalArgumentException("File not found!");
        } else {
            // Convert the InputStream to a String
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
                sql =  reader.lines().collect(Collectors.joining("\n"));
            } catch (Exception e) {
                throw new RuntimeException("Failed to read the file", e);
            }
        }

            // Split each line on ';'
            String[] sqlStatements = sql.split(";");

            //execute
            for (String statement : sqlStatements) {
                if (!statement.trim().isEmpty()) {
                    jdbcTemplate.execute(statement);
                }
            }
            
            return ResponseEntity.ok("SQL script executed successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error executing SQL script: " + e.getMessage());
        }
    }

}
