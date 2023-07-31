package com.example.proyectorestaurante.servicio;

import com.example.proyectorestaurante.dto.PlatoRespuestaDTO;
import com.example.proyectorestaurante.entidad.Plato;
import com.example.proyectorestaurante.mapas.PlatoMapa;
import com.example.proyectorestaurante.repositorio.PlatoRepositorio;
import com.example.proyectorestaurante.validaciones.PlatoValidacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockingDetails;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PlatoServicioTest {

    private Plato plato;

    private PlatoRespuestaDTO platoRespuestaDTO;
    @Mock
    PlatoRepositorio platoRepositorio;

    @InjectMocks
    PlatoServicio platoServicio;
    @Mock
    PlatoValidacion platoValidacion;

    @Mock
    PlatoMapa platoMapa;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        Long id = 1L;
        char rol = 'A';
        String nombre = "Helado";
        Integer precio = 200;
        String descripcion = "Esta es un descripcion de prueba";
        String url = "Esra es una url de prueba";
        String categoria = "postre";
        boolean estado = true;
        String sede = "medellin";
        double tiempoPreparacion = 2.7;
        plato = new Plato(id, rol, nombre, precio, descripcion, url, sede, estado, categoria, tiempoPreparacion);

    }
    @Test
    void crearPlatocorrecto() throws Exception{
        when(platoRepositorio.save(plato)).thenReturn(plato);
        platoRespuestaDTO result = platoServicio.crearPlato(plato);
        assertEquals(result,platoRespuestaDTO);
    }
}
