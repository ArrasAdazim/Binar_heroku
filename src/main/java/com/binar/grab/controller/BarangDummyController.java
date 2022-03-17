package com.binar.grab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/binar/")
public class BarangDummyController {
    @GetMapping
            ("test")
    @ResponseBody

    public ResponseEntity<Map> test() {
        Map map = new HashMap();
        map.put("data", "sukses saya");
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }
}
