package com.bykenyodarz.market.persistence.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "compras_productos")
public class ComprasProducto {

    @EmbeddedId
    private ComprasProductoPK id;

    @Column (name = "cantidad")
    private Integer cantidad;

    @Column (name = "total")
    private Double total;

    @Column(name = "estado")
    private Boolean estado;

    @ManyToOne
    @MapsId("idCompra")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;


}
