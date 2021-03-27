package com.bykenyodarz.market.mapper.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "nombre")
    @Size(max = 45)
    private String nombre;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    @Size(max = 150)
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    @Column(name = "estado")
    private Boolean estado;

}
