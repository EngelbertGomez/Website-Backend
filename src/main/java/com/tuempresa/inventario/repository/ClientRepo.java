package com.tuempresa.inventario.repository;

import com.tuempresa.inventario.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio de Spring Data JPA para la entidad Cliente.
 * Proporciona métodos CRUD básicos y permite definir consultas personalizadas.
 */
@Repository
public interface ClientRepo extends JpaRepository<Cliente, Long> {

    /**
     * Busca un cliente por su dirección de correo electrónico.
     * Este método es usado en el servicio para validar que el email no esté duplicado.
     * Spring Data JPA genera automáticamente la consulta SQL a partir del nombre del método.
     * @param email El correo electrónico a buscar.
     * @return Un Optional que contiene el Cliente si se encuentra, o un Optional vacío.
     */
    Optional<Cliente> findByEmail(String email);
}
