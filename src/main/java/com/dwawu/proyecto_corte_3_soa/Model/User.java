package com.dwawu.proyecto_corte_3_soa.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(scope = User.class, generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class User implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre")
    @NotEmpty(message="no puede estar vacio")
    @Size(min=4, max=12, message="el tamaño tiene que estar entre 4 y 12")
    private String name;

    @Column(name = "apellido")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "tipo_usuario")
    private int user_type;

    @Column(name = "telefono")
    private long phone;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Receipt> receiptList;

    @PrePersist
    public void prePersist() {
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", user_type=" + user_type +
                ", phone=" + phone +
                ", date=" + date +
                ", receiptList=" + receiptList +
                '}';
    }
}
