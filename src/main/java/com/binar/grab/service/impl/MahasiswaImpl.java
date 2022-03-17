package com.binar.grab.service.impl;

import com.binar.grab.model.Mahasiswa;
import com.binar.grab.repository.MahasiswaRepository;
import com.binar.grab.service.MahasiswaInterface;
import com.binar.grab.util.TemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MahasiswaImpl implements MahasiswaInterface {

    @Autowired
    public TemplateResponse templateResponse;

    @Autowired
    public MahasiswaRepository mahasiswaRepository;

    @Override
    public Map insert(Mahasiswa obj) {
        try{
            Mahasiswa mhs = mahasiswaRepository.save(obj);
            return templateResponse.templateSukses(mhs);
        }catch (Exception e){
            return templateResponse.templateEror(e);
        }

    }

    @Override
    public Map update(Mahasiswa obj) {
        return null;
    }

    @Override
    public Map delete(Long obj) {
        return null;
    }
}
