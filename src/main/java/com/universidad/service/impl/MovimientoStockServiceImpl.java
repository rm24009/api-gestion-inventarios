package com.universidad.service.impl;

import com.universidad.dto.MovimientoStockDto;
import com.universidad.entity.MovimientoStock;
import com.universidad.entity.Producto;
import com.universidad.entity.TipoMovimiento;
import com.universidad.repository.MovimientoStockRepository;
import com.universidad.repository.ProductoRepository;
import com.universidad.service.MovimientoStockService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MovimientoStockServiceImpl implements MovimientoStockService {

    private final MovimientoStockRepository movimientoRepository;
    private final ProductoRepository productoRepository;

    @Override
    @Transactional // ESTA ANOTACIÓN ES CLAVE: Asegura que si falla algo, no se guarde nada.
    public MovimientoStockDto guardar(MovimientoStockDto movimientoDto) {
        // 1. Buscar el producto en la base de datos
        Producto producto = productoRepository.findById(movimientoDto.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + movimientoDto.getProductoId()));

        // 2. Lógica de Negocio: Calcular el nuevo stock
        if (movimientoDto.getTipoMovimiento() == TipoMovimiento.ENTRADA) {
            // Si entra mercancía, SUMAMOS
            producto.setStock(producto.getStock() + movimientoDto.getCantidad());
        } else if (movimientoDto.getTipoMovimiento() == TipoMovimiento.SALIDA) {
            // Si sale mercancía, validamos que haya suficiente
            if (producto.getStock() < movimientoDto.getCantidad()) {
                throw new RuntimeException("Error: Stock insuficiente. Stock actual: " + producto.getStock());
            }
            // RESTAMOS
            producto.setStock(producto.getStock() - movimientoDto.getCantidad());
        }

        // 3. Guardar el Producto con el stock actualizado
        productoRepository.save(producto);

        // 4. Crear y guardar el Movimiento de Stock para el historial
        MovimientoStock movimiento = new MovimientoStock();
        movimiento.setProducto(producto);
        movimiento.setCantidad(movimientoDto.getCantidad());
        movimiento.setTipoMovimiento(movimientoDto.getTipoMovimiento());
        movimiento.setFechaMovimiento(LocalDateTime.now());
        MovimientoStock movimientoGuardado = movimientoRepository.save(movimiento);
        movimientoDto.setId(movimientoGuardado.getId());

        return movimientoDto;
    }
}