package com.binar.grab.service.impl;

import com.binar.grab.model.Supplier;
import com.binar.grab.repository.SupplierRepository;
import com.binar.grab.service.SupplierInterface;
import com.binar.grab.util.TemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class SupplierImpl implements SupplierInterface {

    //panggil repository :
    @Autowired
    public SupplierRepository supplierRepository;

    @Autowired
    TemplateResponse templateResponse;

    @Override
    public Map insert(Supplier obj) {
        try {
            if(templateResponse.chekNull(obj.getNama())){
                return templateResponse.templateEror("Nama Tidak boleh null");
            }

            if(templateResponse.chekNull(obj.getAlamat())){
                return templateResponse.templateEror("Alamat Tidak boleh null");
            }
            Supplier saveObj =  supplierRepository.save(obj);
            return templateResponse.templateSukses(saveObj);
        }catch (Exception e){
            return templateResponse.templateEror(e);
        }
    }

}
