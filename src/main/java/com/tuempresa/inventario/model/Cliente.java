package com.tuempresa.inventario.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoCuenta; // admin, socio, regular
    private String cedula;
    private String nombre;
    private String email;
    private String celular;
    private String rnc;
    private String numEmpleado;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipoCuenta() { return tipoCuenta; }
    public void setTipoCuenta(String tipoCuenta) { this.tipoCuenta = tipoCuenta; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    public String getRnc() { return rnc; }
    public void setRnc(String rnc) { this.rnc = rnc; }

    public String getNumEmpleado() { return numEmpleado; }
    public void setNumEmpleado(String numEmpleado) { this.numEmpleado = numEmpleado; }
}
