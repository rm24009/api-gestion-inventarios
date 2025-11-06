package com.universidad.dto;

import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDto {

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;

    @NotNull
    @Positive
    private Double precio;

    @NotNull
    @Min(0)
    private Integer stock;

    @NotNull
    @Min(0)
    private Integer nivelCritico;

    @NotNull
    private Long categoriaId;

    @NotNull
    private Long proveedorId;
}
