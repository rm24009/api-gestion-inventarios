package main.java.com.universidad.inventario_api.Service;

import com.universidad.inventario.entity.Producto;
import java.util.List;

public interface ProductoService {
    Producto crearProducto(Producto p);
    List<Producto> listarProductos();
    Producto obtenerPorId(Long id);
}