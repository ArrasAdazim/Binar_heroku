package com.binar.grab.model;

import lombok.Data;

@Data // Getter dan Setter dari Lombok
public class PerpustakaanDummy {

    // 2. Membuat Model
    private Long id;
    private String judul;
    private String penerbit;
    private int qty;
    private String penulis;
    private String editor ;

    public PerpustakaanDummy(Long id, String judul, String penerbit, String penulis, String editor, int qty) {
        this.id=id;
        this.judul=judul;
        this.penerbit=penerbit;
        this.penulis=penulis;
        this.editor=editor;
        this.qty=qty;
    }
}
