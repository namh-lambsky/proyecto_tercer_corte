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
@Table(name = "detalles_productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(scope =Receipt.class , generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Receipt {
    @Id
    @Column(name = "id_detalles_productos")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Client client;

    @OneToMany(mappedBy = "receipt",cascade = CascadeType.ALL)
    private List<ProductDetail> productDetailList;
    
    @Column(name = "valor_total")
    private double total;
    
    public double getTotal(){
        double total=0;
        for (ProductDetail productDetail:productDetailList
             ) {
                     total+=productDetail.getSubtotal();
        }
        return total;
    }


}
