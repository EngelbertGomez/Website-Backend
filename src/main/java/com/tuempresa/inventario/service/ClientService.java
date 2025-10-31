package com.tuempresa.inventario.service;

import com.tuempresa.inventario.controller.dto.ClientRegistrationRequest;
import com.tuempresa.inventario.model.Cliente;
import com.tuempresa.inventario.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Clase de servicio que contiene la lógica de negocio para los clientes,
 * incluyendo el registro, validación y la encriptación de contraseñas.
 */
@Service
public class ClientService {

    private final ClientRepo clientRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ClientService(ClientRepo clientRepo, PasswordEncoder passwordEncoder) {
        this.clientRepo = clientRepo;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Registra un nuevo cliente en la base de datos (Supabase).
     * Incluye validación de email y encriptación de contraseña.
     * * @param request el DTO con los datos de registro recibidos del frontend.
     * @return el objeto Cliente persistido.
     * @throws IllegalArgumentException si el email ya está registrado.
     */
    public Cliente registerNewClient(ClientRegistrationRequest request) {
        
        // --- 1. VALIDACIÓN: Asegurar que el email no esté en uso ---
        if (clientRepo.findByEmail(request.getEmail()).isPresent()) {
            // Lanza una excepción que será manejada por el controlador (HTTP 400 Bad Request)
            throw new IllegalArgumentException("El correo electrónico ya está registrado.");
        }
        
        // --- 2. MAPEO y ENCRIPTACIÓN ---
        
        // 2a. Crear la entidad a partir del DTO
        Cliente newClient = new Cliente();
        newClient.setTipoCuenta(request.getAccountType());
        newClient.setCedula(request.getCedula());
        newClient.setNombre(request.getNombre());
        newClient.setEmail(request.getEmail());
        newClient.setCelular(request.getCelular());
        
        // 2b. ENCRIPTAR LA CONTRASEÑA (¡Paso de Seguridad CRÍTICO!)
        // Usa el bean BCryptPasswordEncoder que se define en SecurityConfig.java
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        newClient.setPassword(encodedPassword);
        
        // 2c. Asignar campos condicionales
        if ("negocios".equalsIgnoreCase(request.getAccountType())) {
            newClient.setRnc(request.getRnc());
        } else if ("admin".equalsIgnoreCase(request.getAccountType())) {
            newClient.setNumEmpleado(request.getNumEmpleado());
        }
        
        // --- 3. GUARDADO: Persistir el objeto en Supabase ---
        return clientRepo.save(newClient);
    }
}
