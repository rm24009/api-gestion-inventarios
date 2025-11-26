package com.universidad.dto;

import com.universidad.entity.TipoMovimiento;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MovimientoStockDto {

    private Long id;


    private Long productoId;        // Para .getProductoId()
    private TipoMovimiento tipoMovimiento; // Para .getTipoMovimiento()
    private Integer cantidad;       // Para .getCantidad()

    private LocalDateTime fechaMovimiento;
}