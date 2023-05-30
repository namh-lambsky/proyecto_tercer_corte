package com.dwawu.proyecto_corte_3_soa.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(scope = Receipt.class, generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Receipt implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id")
    private User user;

    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL  )
    private List<ProductDetail> productDetailList;

    @Column(name = "valor_total")
    private double total;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date date;

    @PrePersist
    public void prePersist() {
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", user=" + user +
                ", productDetailList=" + productDetailList +
                ", total=" + total +
                ", date=" + date +
                '}';
    }
}
