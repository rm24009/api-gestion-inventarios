package com.universidad.entity;

import jakarta.persistence.*;
import lombok.Data; // Importante
import java.time.LocalDateTime;

@Entity
@Data // <--- Asegúrate de tener esto
@Table(name = "movimientos_stock")
public class MovimientoStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto; // Esto permite movimiento.setProducto()

    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipoMovimiento; // Esto permite movimiento.setTipoMovimiento()

    private Integer cantidad; // Esto permite movimiento.setCantidad()

    private LocalDateTime fechaMovimiento;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}