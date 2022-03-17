package com.binar.grab.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "pembeli")
@Where(clause = "deleted_date is null")
public class Pembeli extends AbstractDate implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama", nullable = false, length = 45)
    private String nama;


    @OneToOne(mappedBy = "pembeli")
    private PembeliDetail pembeliDetail;

    @OneToMany(mappedBy = "pembeli")
    List<Transaksi> transaksi;

}
