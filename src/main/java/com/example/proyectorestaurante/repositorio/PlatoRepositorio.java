package com.example.proyectorestaurante.repositorio;

import com.example.proyectorestaurante.entidad.Plato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepositorio extends JpaRepository<Plato,Long> {

    boolean existsByNombrePlato(String nombre);
    Page<Plato> findByCategoriaAndSede(String categoria, String sede, Pageable paginador);

}
