package com.universidad.repository;

import com.universidad.entity.MovimientoStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovimientoStockRepository extends JpaRepository<MovimientoStock, Long> {

    List<MovimientoStock> findByProductoId(Long productoId);
}
