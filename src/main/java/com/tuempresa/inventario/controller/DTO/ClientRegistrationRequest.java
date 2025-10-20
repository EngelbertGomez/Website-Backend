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

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRnc() { return rnc; }
    public void setRnc(String rnc) { this.rnc = rnc; }

    public String getNumEmpleado() { return numEmpleado; }
    public void setNumEmpleado(String numEmpleado) { this.numEmpleado = numEmpleado; }
}