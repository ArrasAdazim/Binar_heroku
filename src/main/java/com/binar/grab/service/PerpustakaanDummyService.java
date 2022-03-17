package com.binar.grab.service;

import com.binar.grab.model.PerpustakaanDummy;

import java.util.List;
import java.util.Map;

public interface PerpustakaanDummyService {

    // Membuat Kerangka Method

    public Map simpan (PerpustakaanDummy obj);
    public Map update (PerpustakaanDummy obj);
    public PerpustakaanDummy findDataById(Long id);
    public List<PerpustakaanDummy> list();
    public void delete(Long id);

}
