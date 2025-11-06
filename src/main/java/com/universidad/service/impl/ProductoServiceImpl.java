package com.universidad.service.impl;

import com.universidad.dto.ProductoDto;
import com.universidad.entity.Categoria;
import com.universidad.entity.Producto;
import com.universidad.entity.Proveedor;
import com.universidad.repository.CategoriaRepository;
import com.universidad.repository.ProductoRepository;
import com.universidad.repository.ProveedorRepository;
import com.universidad.service.ProductoService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProveedorRepository proveedorRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository,
                               CategoriaRepository categoriaRepository,
                               ProveedorRepository proveedorRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto crearProductoDesdeDTO(ProductoDto dto) {
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        Proveedor proveedor = proveedorRepository.findById(dto.getProveedorId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setNivelCritico(dto.getNivelCritico());
        producto.setCategoria(categoria);
        producto.setProveedor(proveedor);

        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProductoDesdeDTO(Long id, ProductoDto dto) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        Proveedor proveedor = proveedorRepository.findById(dto.getProveedorId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setNivelCritico(dto.getNivelCritico());
        producto.setCategoria(categoria);
        producto.setProveedor(proveedor);

        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
