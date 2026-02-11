package com.artesluis.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

  @GetMapping("/estadisticas")
  public ResponseEntity<?> estadisticas(@RequestHeader(value = "X-Role", required = false) String role) {
    if (role == null || !role.equalsIgnoreCase("ADMIN")) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN)
        .body(Map.of(
          "error", "FORBIDDEN",
          "message", "Acceso no autorizado para el rol proporcionado"
        ));
    }

    return ResponseEntity.ok(Map.of(
      "usuariosActivos", 42,
      "imagenesPublicadas", 18,
      "timestamp", System.currentTimeMillis()
    ));
  }
}
