package com.universidad.controller;

import com.universidad.dto.ProductoDto;
import com.universidad.entity.Producto;
import com.universidad.service.ProductoService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> all() {
        return productoService.listarProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> get(@PathVariable Long id) {
        Producto producto = productoService.obtenerPorId(id);
        return producto != null ? ResponseEntity.ok(producto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody @Valid ProductoDto dto) {
        Producto creado = productoService.crearProductoDesdeDTO(dto);
        return ResponseEntity.status(201).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody @Valid ProductoDto dto) {
        Producto actualizado = productoService.actualizarProductoDesdeDTO(id, dto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}
