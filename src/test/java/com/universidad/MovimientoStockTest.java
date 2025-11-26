package com.universidad;

import com.universidad.entity.Producto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovimientoStockTest {

    @Test
    void testCalculoStockEntrada() {
        // 1. Preparar: Un producto con stock 10
        Producto producto = new Producto();
        producto.setStock(10);

        Integer cantidadEntrada = 5;

        // 2. Actuar: Simular la lógica de ENTRADA
        int nuevoStock = producto.getStock() + cantidadEntrada;
        producto.setStock(nuevoStock);

        // 3. Verificar: El stock debe ser 15
        assertEquals(15, producto.getStock(), "El stock debería aumentar a 15");
    }

    @Test
    void testCalculoStockSalida() {
        // 1. Preparar: Un producto con stock 20
        Producto producto = new Producto();
        producto.setStock(20);

        Integer cantidadSalida = 5;

        // 2. Actuar: Simular la lógica de SALIDA
        int nuevoStock = producto.getStock() - cantidadSalida;
        producto.setStock(nuevoStock);

        // 3. Verificar: El stock debe ser 15
        assertEquals(15, producto.getStock(), "El stock debería disminuir a 15");
    }
}