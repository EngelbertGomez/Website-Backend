package com.tuempresa.inventario.controller;

import com.tuempresa.inventario.controller.dto.ClientRegistrationRequest; // 💡 Importa el DTO
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

// Necesitas la anotación @RestController para que Spring sepa que esta clase maneja peticiones REST
@RestController
@RequestMapping("/api/clients") // 💡 Define la base URL, el JS apunta a este path
// @CrossOrigin es vital para permitir peticiones desde el frontend (que corre en el navegador/otro puerto)
@CrossOrigin(origins = "*") // "*" es para permitir TODAS, luego puedes restringirlo a tu dominio de frontend.
public class ClientController {

    // 💡 Método de prueba para verificar la conexión
    @PostMapping("/register")
    public ResponseEntity<?> registerClient(@RequestBody ClientRegistrationRequest registrationRequest) {
        
        // --- PRUEBA DE CONEXIÓN ---
        System.out.println("--- DATOS RECIBIDOS DEL FRONTEND ---");
        System.out.println("Tipo de Cuenta: " + registrationRequest.getAccountType());
        System.out.println("Nombre: " + registrationRequest.getNombre());
        System.out.println("Email: " + registrationRequest.getEmail());
        System.out.println("Cédula: " + registrationRequest.getCedula());
        System.out.println("RNC (si aplica): " + registrationRequest.getRnc());
        System.out.println("Número Empleado (si aplica): " + registrationRequest.getNumEmpleado());
        System.out.println("--- FIN DATOS RECIBIDOS ---");

        // Retorna una respuesta de ÉXITO (código 200 OK)
        return ResponseEntity.ok(Map.of("message", "Registro temporalmente exitoso. Conexión Backend OK."));
    }

    // Puedes agregar más métodos (endpoints) aquí más adelante
}