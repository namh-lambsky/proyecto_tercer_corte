package com.dwawu.proyecto_corte_3_soa.Model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "detalles_productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(scope =ProductDetail.class , generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ProductDetail implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "producto_id",referencedColumnName = "id")
    private Product product;

    @Column(name = "cantidad")
    private long quantity;

    @Column(name = "subtotal")
    private double subtotal;

    @ManyToOne
    @JoinColumn(name = "factura_id",referencedColumnName = "id")
    private Receipt receipt;

    @Override
    public String toString() {
        return "ProductDetail{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                ", receipt=" + receipt +
                '}';
    }
}
