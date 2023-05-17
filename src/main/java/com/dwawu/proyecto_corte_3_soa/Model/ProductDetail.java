package com.dwawu.proyecto_corte_3_soa.Model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detalles_productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(scope =ProductDetail.class , generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ProductDetail {
    @Id
    @Column(name = "id_detalles_productos")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_producto",referencedColumnName = "id")
    private Product product;

    @Column(name = "cantidad")
    private long quantity;

    @Column(name = "subtotal")
    private double subtotal;

    @ManyToOne
    @JoinColumn(name = "id_factura",referencedColumnName = "id")
    private Receipt receipt;

    public double getSubtotal(){
        if (this.product.isIva()){
            return (this.product.getUnitary_price()*0.19)*this.quantity;
        }
        else {
            return this.product.getUnitary_price()*this.quantity;
        }
    }

}
