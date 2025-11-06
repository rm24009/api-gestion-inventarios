package com.universidad.controller;

import com.universidad.entity.Proveedor;
import com.universidad.repository.ProveedorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    private final ProveedorRepository proveedorRepository;

    public ProveedorController(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    // 🔹 GET todos los proveedores
    @GetMapping
    public List<Proveedor> all() {
        return proveedorRepository.findAll();
    }

    // 🔹 GET por ID
    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> get(@PathVariable Long id) {
        return proveedorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 POST para crear proveedor
    @PostMapping
    public ResponseEntity<Proveedor> create(@RequestBody Proveedor proveedor) {
        return ResponseEntity.status(201).body(proveedorRepository.save(proveedor));
    }

    // 🔹 PUT para actualizar proveedor
    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> update(@PathVariable Long id, @RequestBody Proveedor proveedor) {
        return proveedorRepository.findById(id)
                .map(p -> {
                    p.setNombre(proveedor.getNombre());
                    p.setContacto(proveedor.getContacto());
                    return ResponseEntity.ok(proveedorRepository.save(p));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 DELETE por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        proveedorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
