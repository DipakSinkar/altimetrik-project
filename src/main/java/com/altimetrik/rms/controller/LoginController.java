package com.altimetrik.rms.controller;

import com.altimetrik.rms.dto.LoginRequest;
import com.altimetrik.rms.entity.Remitter;
import com.altimetrik.rms.services.IRemitterService;
import com.altimetrik.rms.services.RemitterServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api") // Include the base URL "/api"
public class LoginController {
    @Autowired
    private IRemitterService iRemitterService;

    @PostMapping("/login") // Add "/login" to specify the login endpoint
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest loginRequest) {
        Remitter remitter = iRemitterService.getRemitterById(loginRequest.getRemitterAccountNumber());

        if (remitter != null && remitter.getRemitterPassword().equals(loginRequest.getRemitterPassword())) {
            return ResponseEntity.ok("Login successful!"+remitter.getName());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }
    @GetMapping("/getUserName")
    @ResponseBody
    public String getUserName() {
        // Replace this with your logic to get the user's name
        String userName = ""; // Replace with your actual logic
        return userName;
    }

}
