package com.example.restaurantapi.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(scope = Producto.class, generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Producto implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre_producto")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad")
    private long cantidad;

    @Column(name = "precio_unitario")
    private double precio_unitario;

    @Column(name = "IVA")
    private boolean iva;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fecha_creacion;

    @PrePersist
    @PreUpdate
    public void on_update() {
        fecha_creacion = new Date();
    }
}
