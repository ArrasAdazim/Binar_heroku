package com.binar.grab.controller;


import com.binar.grab.model.Mahasiswa;
import com.binar.grab.repository.MahasiswaRepository;
import com.binar.grab.service.MahasiswaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@RestController
@RequestMapping("/v1/mhs")
public class MahasiswaController {

    @Autowired
    public MahasiswaInterface serviceMahasiswa;

    @Autowired
    public MahasiswaRepository mahasiswaRepository;

    @PostMapping("")
    public ResponseEntity <Map> save (@RequestBody Mahasiswa objModel){
        Map save= serviceMahasiswa.insert(objModel);
        return new ResponseEntity<Map>(save,HttpStatus.OK);
    }
}
