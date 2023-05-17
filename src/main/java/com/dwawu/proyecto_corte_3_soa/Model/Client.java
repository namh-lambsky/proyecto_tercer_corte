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
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(scope =Client.class , generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "nombre")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name = "telefono")
    private long phone;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    private List<Receipt> receiptList;
}
