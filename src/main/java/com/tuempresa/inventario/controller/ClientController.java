package com.tuempresa.inventario.controller;

import com.tuempresa.inventario.controller.dto.ClientRegistrationRequest; // Importa el DTO
import com.tuempresa.inventario.service.ClientService; // Importa el servicio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * Controlador REST para manejar las operaciones relacionadas con Clientes.
 * La ruta base para este controlador es /api/clients.
 */
@RestController
@RequestMapping("/api/clients") // Mantenemos esta ruta para que el JS funcione: http://localhost:8080/api/clients/register
@CrossOrigin(origins = "*") // Permite la comunicación con tu frontend
public class ClientController {

    private final ClientService clientService;

    @Autowired
    // Inyección de dependencia del ClientService
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Endpoint de Health Check simple.
     * Verifica si el servidor está activo y respondiendo.
     * URL: http://localhost:8080/api/clients/status
     */
    @GetMapping("/status")
    public ResponseEntity<String> checkStatus() {
        return new ResponseEntity<>("Backend is Running (Status: OK)", HttpStatus.OK);
    }
    
    /**
     * Endpoint para registrar un nuevo cliente.
     * URL: http://localhost:8080/api/clients/register
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerClient(@RequestBody ClientRegistrationRequest request) {
        try {
            // Llama al servicio para realizar el mapeo, encriptación y guardado en la DB
            clientService.registerNewClient(request); 
            
            // Si el servicio no lanza excepción, el registro fue exitoso
            // Usamos HttpStatus.CREATED (201) para indicar que un recurso fue creado
            return new ResponseEntity<>(
                Map.of("message", "Client registered successfully"), 
                HttpStatus.CREATED
            );
        } catch (IllegalArgumentException e) {
            // Maneja errores de validación, por ejemplo: email duplicado o datos faltantes
            System.err.println("Registration error: " + e.getMessage());
            return new ResponseEntity<>(
                Map.of("message", "Error en el registro: " + e.getMessage()), 
                HttpStatus.BAD_REQUEST // Código 400
            );
        } catch (Exception e) {
            // Maneja cualquier otro error inesperado (ej: fallo de conexión a la DB)
            e.printStackTrace(); // Imprime el stack trace para depuración
            return new ResponseEntity<>(
                Map.of("message", "Internal server error during registration: " + e.getMessage()), 
                HttpStatus.INTERNAL_SERVER_ERROR // Código 500
            );
        }
    }
}
