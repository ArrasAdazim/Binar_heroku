package com.binar.grab.controller;


import com.binar.grab.model.Barang;
import com.binar.grab.service.BarangRestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/rt/")
public class BarangRestTemplateController {
    @Autowired
    public BarangRestTemplateService service;



    @GetMapping("/list")
    public ResponseEntity<Map> listByBama(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam() String nama) {
        Pageable show_data = PageRequest.of(page, size);
        Map list = service.getAll(size, page);
        return new ResponseEntity<Map>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/save/{idsupplier}")// localhost :8080/v1/binar/save
    public ResponseEntity<Map> save(@PathVariable(value = "idsupplier") Long idsupplier,  @RequestBody Barang objModel) {

        Map map = new HashMap();
        Map obj = service.insert(objModel, idsupplier);
        map.put("Request =", objModel);
        map.put("Response =", obj);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);// response
    }

}
