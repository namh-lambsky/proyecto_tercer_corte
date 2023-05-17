package com.dwawu.proyecto_corte_3_soa.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(scope =Product.class , generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "nombre_producto")
    private String name;

    @Column(name="descripcion")
    private String description;

    @Column(name="cantidad")
    private long quantity;

    @Column(name="tipo_paquete")
    private String package_type;

    @Column(name="precio_unitario")
    private double unitary_price;

    @Column(name = "IVA")
    private boolean iva;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductDetail> productDetailList;
}
