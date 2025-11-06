package com.universidad.service;

import com.universidad.dto.ProductoDto;
import com.universidad.entity.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> listarProductos();

    Producto obtenerPorId(Long id);

    Producto crearProductoDesdeDTO(ProductoDto dto);

    Producto actualizarProductoDesdeDTO(Long id, ProductoDto dto);

    void eliminarProducto(Long id);
}
