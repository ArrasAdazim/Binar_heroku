package com.binar.grab.service.impl;

import com.binar.grab.model.PerpustakaanDummy;
import com.binar.grab.service.PerpustakaanDummyService;
import com.binar.grab.util.TemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service

    public class PerpustakaanDummyImpl implements PerpustakaanDummyService {

    // 3. Membuat Logic
    @Autowired
    public TemplateResponse templateResponse;

    //Untuk menampung data
    public List<PerpustakaanDummy> datalist =new ArrayList<>();

    @Override
    public Map simpan(PerpustakaanDummy obj) {

        try{
            datalist.add(obj); // Menambah Data
            return templateResponse.templateSukses(obj);
        }catch (Exception e){
            return templateResponse.templateEror(e);
        }
    }

    @Override
    public Map update(PerpustakaanDummy obj) {
        try{
            if (obj.getId() == null) {
                return templateResponse.templateEror("id harus diisi");
            }
            PerpustakaanDummy updateData = null;
            for (PerpustakaanDummy data : datalist) {
                if (data.getId() == obj.getId()) {
                    updateData = new PerpustakaanDummy(
                            data.getId(),
                            obj.getJudul(),
                            obj.getPenerbit(),
                            obj.getPenulis(),
                            obj.getEditor(),
                            obj.getQty()
                    );
                    datalist.add(updateData);
                    datalist.remove(data);
                }
            }
            return templateResponse.templateSukses(updateData);
        }catch (Exception e){
            return templateResponse.templateEror(e);
        }



    }

    @Override
    public PerpustakaanDummy findDataById(Long id) {
        return null;
    }

    @Override
    public List<PerpustakaanDummy> list() {
        return datalist;
    }

    @Override
    public void delete(Long id) {
        for(PerpustakaanDummy obj : datalist ){
            if(obj.getId() == id){
                datalist.remove(obj);
            }
        }
    }

}
