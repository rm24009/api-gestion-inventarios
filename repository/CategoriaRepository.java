package main.java.com.universidad.inventario_api.repository;

import com.universidad.inventario.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}