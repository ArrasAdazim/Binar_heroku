package com.binar.grab.service.impl;

import com.binar.grab.model.Barang;
import com.binar.grab.model.Supplier;
import com.binar.grab.repository.BarangRepository;
import com.binar.grab.repository.SupplierRepository;
import com.binar.grab.service.BarangService;
import com.binar.grab.util.TemplateResponse;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class BarangImpl implements BarangService {

    public static final Logger log = LoggerFactory.getLogger(BarangImpl.class);

    //1. call repository banrang dan supplierbi
    @Autowired
    public BarangRepository barangRepository;

    @Autowired
    public SupplierRepository supplierRepository;

    @Autowired
    public TemplateResponse templateResponse;

    @Override
    public Map insert(Barang obj, Long idsupplier) {
        try {
            if(templateResponse.chekNull(obj.getNama())){
                return   templateResponse.templateEror("Nama is Requiered");
            }

            if(templateResponse.chekNull(obj.getHarga())){
                return  templateResponse.templateEror("Harga is requiered");
            }

            if(templateResponse.chekNull(idsupplier)){
                return templateResponse.templateEror("Id Supplier is requiered");
            }
            Supplier chekId = supplierRepository.getbyID(idsupplier);
            if(templateResponse.chekNull(chekId)){
                return   templateResponse.templateEror("Id Supplier NOt found");
            }
            //do save
            obj.setSupplier(chekId);
            Barang barangSave = barangRepository.save(obj);
            return templateResponse.templateSukses(barangSave);
        }catch (Exception e){
            return templateResponse.templateEror(e);
        }

    }

    @Override
    public Map getAll(int size, int page) {
        Pageable show_data = PageRequest.of(page, size);
        Page<Barang> list = barangRepository.getAllData(show_data);
        return templateResponse.templateSukses(list);
    }


    @Override
    public Map update(Barang barangReq, Long idsupplier) {
       try{
           if(templateResponse.chekNull(idsupplier)){
               return   templateResponse.templateEror("id Supplier is Requiered");
           }
            Supplier chekId = supplierRepository.getbyID(idsupplier);
           if(templateResponse.chekNull(chekId)){
               return  templateResponse.templateEror("Id Supplier Not Found");
           }

           if(templateResponse.chekNull(barangReq.getId())){
               return templateResponse.templateEror("Id Barang is requiered");
           }
           Barang chekIdBarang = barangRepository.getByID(barangReq.getId());
           if(templateResponse.chekNull(chekId)){
               return   templateResponse.templateEror("Id Supplier Not found");
           }

           chekIdBarang.setNama(barangReq.getNama());
           chekIdBarang.setHarga(barangReq.getHarga());
           chekIdBarang.setStok(barangReq.getStok());
           chekIdBarang.setSatuan(barangReq.getSatuan());

           Barang dosave =barangRepository.save(chekIdBarang);

           return  templateResponse.templateSukses(dosave);

       }catch (Exception e){

           return templateResponse.templateEror(e);

       }
    }

    @Override
    public Map delete(Long barang) {

        try {
            if(templateResponse.chekNull(barang)){
                return templateResponse.templateEror("Id Barang is requiered");
            }
            Barang chekIdBarang = barangRepository.getByID(barang);
            if(templateResponse.chekNull(chekIdBarang)){
                return   templateResponse.templateEror("Id Barang Not found");
            }

            chekIdBarang.setDeleted_date(new Date());
            barangRepository.save(chekIdBarang);

            return templateResponse.templateSukses("Sukses delete");
        }catch (Exception e){
            return templateResponse.templateEror(e);
        }

    }

    @Override
    public Map getAll() {
        return null;
    }


    @Override
    public Map findByNama(String nama, Integer page, Integer size) {
        try {
            Pageable show_data = PageRequest.of(page,size);
            Page<Barang> list = barangRepository.findByNama(nama,show_data);
            return templateResponse.templateSukses(list);

        }catch (Exception e){
            return templateResponse.templateEror(e);
        }
    }

    @Override
    public Page<Barang> findByNamaLike(String nama, Pageable pageable) {
        try {

            Page<Barang> list = barangRepository.findByNamaLike("'%"+nama+"%'",pageable);
            return list;

        }catch (Exception e){
            log.error("Ada error dimethod findByNamaLike: " + e);
            return null ;
        }
    }
}
