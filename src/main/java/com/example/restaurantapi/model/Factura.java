package com.example.restaurantapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "facturas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Factura implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties(value = {"facturas","hibernateLazyInitializer", "handler"},allowSetters = true)
    private Cliente cliente;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL  )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<ItemFactura> items;

    @Column(name = "valor_total")
    private double total;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fecha_creacion;

    @PrePersist
    @PreUpdate
    public void on_update() {
        fecha_creacion = new Date();
    }
}
