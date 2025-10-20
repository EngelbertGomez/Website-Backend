package com.tuempresa.inventario.controller.dto; // 💡 ¡Asegúrate que el paquete sea este!

public class ClientRegistrationRequest {

    private String accountType;
    private String cedula;
    private String nombre;
    private String email;
    private String celular;
    private String password;
    private String rnc; 
    private String numEmpleado;

    // Constructor vacío
    public ClientRegistrationRequest() {
    }

    // Getters y Setters (Necesarios para que Spring mapee el JSON)

    public St