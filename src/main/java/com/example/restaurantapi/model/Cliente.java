package com.example.restaurantapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre",nullable = false)
    @NotEmpty(message="no puede estar vacio")
    @Size(min=2, max=20, message="el tamaño tiene que estar entre 2 y 20")
    private String nombre;

    @Column(name = "apellido")
    @NotEmpty(message="no puede estar vacio")
    private String apellido;

    @Column(name = "email",nullable = false,unique = true)
    @NotEmpty(message="no puede estar vacio")
    @Email(message="no es una dirección de correo válida")
    private String email;

    @Column(name = "telefono",nullable = false)
    private long telefono;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fecha_creacion;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"cliente","hibernateLazyInitializer","handler"},allowSetters = true)
    private List<Factura> facturas;


    @PrePersist
    @PreUpdate
    public void on_update() {
        fecha_creacion = new Date();
    }
}
