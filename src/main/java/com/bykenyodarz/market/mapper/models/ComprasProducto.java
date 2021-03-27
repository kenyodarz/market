package com.bykenyodarz.market.mapper.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

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

}
