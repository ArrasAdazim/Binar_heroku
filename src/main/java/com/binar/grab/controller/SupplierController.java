package com.binar.grab.controller;

import com.binar.grab.model.Supplier;
import com.binar.grab.service.SupplierInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1/binar/supplier")
public class SupplierController {

    @Autowired
    public SupplierInterface supplierInterface;

    @PostMapping("")
    public ResponseEntity<Map> save (@RequestBody Supplier objModel){
        Map obj = supplierInterface.insert(objModel);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }
}
