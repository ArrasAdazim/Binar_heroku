package com.binar.grab.service;

import com.binar.grab.model.Barang;

import java.util.Map;

public interface BarangRestTemplateService {
    public Map insert(Barang barang, Long idsupplier);

    Map getAll(int size, int page);

    public Map update(Barang barang, Long idsupplier);

    public Map delete(Long barang);


}
