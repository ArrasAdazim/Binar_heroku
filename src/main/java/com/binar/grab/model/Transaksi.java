package com.binar.grab.model;

import lombok.Data;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "transaksi")
@Where(clause = "deleted_date is null")

public class Transaksi extends AbstractDate implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "barang_id")
    Barang barang;

    @ManyToOne
    @JoinColumn(name = "pembeli_id")
    Pembeli pembeli;

    private Double harga;
    private int qty;




}
