package com.universidad.controller;

import com.universidad.entity.MovimientoStock;
import com.universidad.entity.Producto;
import com.universidad.entity.TipoMovimiento;
import com.universidad.entity.Usuario;
import com.universidad.repository.MovimientoStockRepository;
import com.universidad.repository.ProductoRepository;
import com.universidad.repository.UsuarioRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
@RequiredArgsConstructor
public class MovimientoStockController {

    private final MovimientoStockRepository movimientoRepository;
    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;

    @GetMapping
    public List<MovimientoStock> all() {
        return movimientoRepository.findAll();
    }

    // Nota: Asegúrate de tener este método en tu repositorio si lo usas
    // @GetMapping("/producto/{productoId}")
    // public List<MovimientoStock> byProducto(@PathVariable Long productoId) {
    //    return movimientoRepository.findByProductoId(productoId);
    // }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody MovimientoRequest request) {
        // 1. Buscar Producto
        Producto producto = productoRepository.findById(request.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // 2. Buscar Usuario (Opcional: Si falla, puedes comentar estas líneas si no envías usuarioId)
        Usuario usuario = null;
        if (request.getUsuarioId() != null) {
            usuario = usuarioRepository.findById(request.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        }

        // 3. Validar Stock para SALIDAS
        if (request.getTipo() == TipoMovimiento.SALIDA) {
            if (producto.getStock() < request.getCantidad()) {
                return ResponseEntity.badRequest()
                        .body("Stock insuficiente. Disponible: " + producto.getStock());
            }
        }

        // 4. Actualizar Stock del Producto
        if (request.getTipo() == TipoMovimiento.ENTRADA) {
            producto.setStock(producto.getStock() + request.getCantidad());
        } else {
            producto.setStock(producto.getStock() - request.getCantidad());
        }
        productoRepository.save(producto); // Guardamos el nuevo stock

        // 5. Guardar el Movimiento
        MovimientoStock movimiento = new MovimientoStock();
        movimiento.setProducto(producto);
        movimiento.setUsuario(usuario);
        movimiento.setCantidad(request.getCantidad());
        movimiento.setTipoMovimiento(request.getTipo());
        movimiento.setFechaMovimiento(LocalDateTime.now());

        MovimientoStock guardado = movimientoRepository.save(movimiento);

        return ResponseEntity.status(201).body(guardado);
    }

    // Clase interna DTO para recibir la petición
    @Data
    public static class MovimientoRequest {
        private TipoMovimiento tipo;
        private Integer cantidad;
        private Long productoId;
        private Long usuarioId;
    }
}