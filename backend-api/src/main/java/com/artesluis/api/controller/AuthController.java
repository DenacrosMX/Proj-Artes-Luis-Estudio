package com.artesluis.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
    String usuario = body.getOrDefault("usuario", "");
    String password = body.getOrDefault("password", "");

    if ("admin".equals(usuario) && "admin123".equals(password)) {
      return ResponseEntity.ok(Map.of(
        "message", "Login exitoso",
        "token", "demo-token-123",
        "rol", "ADMIN"
      ));
    }

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
      .body(Map.of(
        "error", "UNAUTHORIZED",
        "message", "Credenciales invalidas"
      ));
  }
}
