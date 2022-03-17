package com.binar.grab.service;

import com.binar.grab.model.Pembeli;

import java.util.Map;

public interface PembeliService {

    public Map simpan (Pembeli obj);
    public Map update (Pembeli obj);
    public Map delete (Long idPembeli);
}
