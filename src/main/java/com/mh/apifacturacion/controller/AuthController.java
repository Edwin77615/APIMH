package com.mh.apifacturacion.controller;

import com.mh.apifacturacion.dto.AuthRequest;
import com.mh.apifacturacion.dto.AuthResponse;
import com.mh.apifacturacion.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) { this.authService = authService; }

    @PostMapping
    public ResponseEntity<AuthResponse> auth(@ModelAttribute AuthRequest req) {
        AuthResponse resp = authService.authenticate(req);
        if ("OK".equals(resp.getStatus())) return ResponseEntity.ok(resp);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resp);
    }
}
