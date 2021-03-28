package com.bykenyodarz.market.data.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @Size(max = 20)
    private String id;

    @Column(name = "nombre")
    @Size(max = 40)
    private String nombre;

    @Column(name = "apellidos")
    @Size(max = 100)
    private String apellido;

    @Column(name = "celular")
    private Integer celular;

    @Column(name = "direccion")
    @Size(max = 80)
    private String direccion;

    @Column(name = "correo_electronico")
    @Size(max = 70)
    @Email
    private String  correoElectronico;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

}
