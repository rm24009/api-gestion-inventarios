package com.universidad.controller;

import com.universidad.entity.Alerta;
import com.universidad.repository.AlertaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
public class AlertaController {

    private final AlertaRepository alertaRepository;

    public AlertaController(AlertaRepository alertaRepository) {
        this.alertaRepository = alertaRepository;
    }

    @GetMapping
    public List<Alerta> all() {
        return alertaRepository.findAll();
    }

    @GetMapping("/activas")
    public List<Alerta> activas() {
        return alertaRepository.findByEstado("ACTIVA");
    }

    @GetMapping("/resueltas")
    public List<Alerta> resueltas() {
        return alertaRepository.findByEstado("RESUELTA");
    }

    @PutMapping("/{id}/resolver")
    public ResponseEntity<Alerta> resolver(@PathVariable Long id) {
        return alertaRepository.findById(id)
                .map(alerta -> {
                    alerta.setEstado("RESUELTA");
                    return ResponseEntity.ok(alertaRepository.save(alerta));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}