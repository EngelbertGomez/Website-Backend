// Archivo: src/main/java/com/tuempresa/inventario/WebsiteBackendApplication.java
package com.tuempresa.inventario; // <--- Importante: El paquete base

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebsiteBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteBackendApplication.class, args);
    }
}