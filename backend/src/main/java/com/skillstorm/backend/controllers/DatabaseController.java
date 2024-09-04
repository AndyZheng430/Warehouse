package com.skillstorm.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


//web bindings
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

//need for file grabbing
import java.nio.file.Files;
import java.nio.file.Paths; 


@RestController
@RequestMapping("/test")
@CrossOrigin
public class DatabaseController {
      @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ResourceLoader resourceLoader;

    @PostMapping("/resetDB")
    public ResponseEntity<String> resetDB() {
        try {
            // Load SQL 
            Resource resource = resourceLoader.getResource("classpath:sql/data.sql");

            // Read into script
            String sql = new String(Files.readAllBytes(Paths.get(resource.getURI())));

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

    @PostMapping("/clearDB")
    public ResponseEntity<String> clearDB() {
        try {
            // Load SQL 
            Resource resource = resourceLoader.getResource("classpath:sql/reset.sql");

            // Read into script
            String sql = new String(Files.readAllBytes(Paths.get(resource.getURI())));

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
