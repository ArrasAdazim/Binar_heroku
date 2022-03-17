package com.binar.grab.model;

import lombok.Data;
import org.hibernate.annotations.Where;
import javax.persistence.*;

@Data
@Entity
@Table(name = "rekening")
@Where(clause = "deleted_date is null")
public class Rekening {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "jenis", nullable = false)
    private String jenis;

    @Column(name = "nomor", nullable = false, length = 45)
    private Long nomor;

    @ManyToOne
    @JoinColumn(name = "id_karyawan")
    Karyawan karyawan;
}
