package com.bykenyodarz.market.mapper.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @Column(name = "id_compra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompra;

    @Column(name="id_cliente")
    private Integer idCliente;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    @Size(max = 1)
    private String medioPago;

    @Column(name = "comentario")
    @Size(max = 300)
    private String comentario;

    @Column(name = "estado")
    @Size(max = 1)
    private String estado;

}
