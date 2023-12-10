package com.leiber.TaskApp.web.controller;

import com.leiber.TaskApp.auth.dto.AuthResponse;
import com.leiber.TaskApp.auth.dto.LoginRequest;
import com.leiber.TaskApp.auth.dto.RegisterRequest;
import com.leiber.TaskApp.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "Income a Application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Deny access")
    })
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", "Inicio de sesión exitoso");
        responseBody.put("data", response);
        return ResponseEntity.ok(responseBody);
    }

    @Operation(summary = "Register a user a Application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Deny access")
    })
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>>register(@RequestBody RegisterRequest request) {
        authService.register(request);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuario registrado con éxito");
        return ResponseEntity.ok(response);
    }
}
