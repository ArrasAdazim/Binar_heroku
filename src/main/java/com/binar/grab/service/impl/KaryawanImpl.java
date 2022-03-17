package com.binar.grab.service.impl;

import com.binar.grab.model.Karyawan;
import com.binar.grab.model.Training;
import com.binar.grab.repository.KaryawanRepository;
import com.binar.grab.service.KaryawanService;
import com.binar.grab.util.TemplateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class KaryawanImpl implements KaryawanService {
    public static final Logger log = LoggerFactory.getLogger(KaryawanImpl.class);

    @Autowired
    public TemplateResponse templateResponse;
    @Autowired
    public KaryawanRepository karyawanRepository;


    @Override
    public Map insert(Karyawan obj) {
        try{
            // Cek apakah request dari klien kosong atau tidak
            if(templateResponse.chekNull(obj.getNama())){
                return templateResponse.templateEror("Nama tidak boleh kosong");
            }
            // Save data
            Karyawan save = karyawanRepository.save(obj);
            return templateResponse.templateSukses(save);
        }catch (Exception e){
            log.error("Error pada method insert Karyawan");
            return templateResponse.templateEror(e);
        }

    }

    @Override
    public Map update(Karyawan obj) {
        try{
            // Cek apakah request dari klien kosong atau tidak
            if(templateResponse.chekNull(obj.getId())){
                return templateResponse.templateEror("Id tidak boleh kosong");
            }
            Karyawan update = karyawanRepository.getById(obj.getId());
            // Cek apakah id dari database dengan request klien ada atau tidak
            if (templateResponse.chekNull(update)){
                return templateResponse.templateEror("Id tidak ditemukan");
            }
            // Update data
            update.setNama(obj.getNama());

            // Save data
            Karyawan save = karyawanRepository.save(update);
            return templateResponse.templateSukses(save);
        }catch (Exception e){
            log.error("Error pada method update Karyawan");
            return templateResponse.templateEror(e);
        }

    }

    @Override
    public Map delete(Long idKaryawan) {
        try {
            if (templateResponse.chekNull(idKaryawan)){
                return templateResponse.templateEror("Id Karyawan kosong");
            }
            Karyawan checkId = karyawanRepository.getById(idKaryawan);
            if (templateResponse.chekNull(checkId)){
                return templateResponse.templateEror("Id Karyawan tidak ditemukan");
            }

            karyawanRepository.delete(checkId);
            return templateResponse.templateSukses("Sukses Delete " + checkId.getNama());
        }catch (Exception e){
            log.error("Error pada method delete karyawan");
            return templateResponse.templateEror(e);
        }

    }

    @Override
    public Map findByNama(String nama, Integer page, Integer size) {
        return null;
    }

    @Override
    public Page<Karyawan> findByNamaLike(String nama, Pageable pageable) {
        return null;
    }
}
