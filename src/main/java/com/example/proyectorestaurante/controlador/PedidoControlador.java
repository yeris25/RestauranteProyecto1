package com.example.proyectorestaurante.controlador;

import com.example.proyectorestaurante.Utiles.EstadoPedido;
import com.example.proyectorestaurante.dto.PedidoDTO;
import com.example.proyectorestaurante.dto.PedidoErrorDTO;
import com.example.proyectorestaurante.dto.PedidoRespuestaDTO;
import com.example.proyectorestaurante.entidad.Pedido;
import com.example.proyectorestaurante.servicio.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restauranteAPI/pedido")
public class PedidoControlador {

    @Autowired
    PedidoServicio pedidoServicio;

    @PostMapping
    public ResponseEntity<PedidoDTO> registrar(@RequestBody Pedido pedido){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(pedidoServicio.crearPedido(pedido));
        }catch(Exception error){
            PedidoErrorDTO respuestaError = new PedidoErrorDTO();
            respuestaError.setMensajeError(error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(respuestaError);
        }
    }

    @GetMapping
    public ResponseEntity <List<PedidoRespuestaDTO>> obtenerPlatosPaginadosYFiltrados(
            @RequestParam() Character rol,
            @RequestParam() EstadoPedido categoria,
            @RequestParam() String sede,
            @RequestParam() int numerodeRegistros
    ){
        try {
            Page<PedidoRespuestaDTO> edidosPaginados = pedidoServicio.obtenerListaPedidoPorEstadoYSede(rol, sede, categoria, numerodeRegistros);
            List<PedidoRespuestaDTO> listapedidos = edidosPaginados.getContent();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(listapedidos);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @PutMapping("/estado/{id}")
    public ResponseEntity<PedidoDTO> actualizarEstadoPreparando(@PathVariable Integer id,  @RequestBody Pedido datosPedido){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(pedidoServicio.actualizarPedidoAEnPreparacion(id,datosPedido));
        }catch(Exception error){
            PedidoErrorDTO respuestaError= new PedidoErrorDTO();
            respuestaError.setMensajeError(error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(respuestaError);
        }
    }



}