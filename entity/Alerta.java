package com.universidad.inventario.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alertas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alerta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha;
    private String estado; // ACTIVA / RESUELTA
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
}