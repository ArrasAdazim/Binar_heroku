package com.binar.grab.controller;


import com.binar.grab.model.PerpustakaanDummy;
import com.binar.grab.service.PerpustakaanDummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/binar/buku/")
public class PerpustakaanDummyController {
    @Autowired
    public PerpustakaanDummyService perpustakaanDummyService;

    @PostMapping("save")
    public ResponseEntity<Map> save(
            @RequestBody PerpustakaanDummy objModel){
        Map obj = perpustakaanDummyService.simpan(objModel);
        return  new ResponseEntity<Map>(obj, HttpStatus.OK);
    }
    @PutMapping("update")
    public ResponseEntity<Map> update(
            @RequestBody PerpustakaanDummy objModel){
        Map obj = perpustakaanDummyService.update(objModel);
        return  new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @GetMapping("list")
    @ResponseBody
    public ResponseEntity<List<PerpustakaanDummy>> getList(){
        List<PerpustakaanDummy>c =perpustakaanDummyService.list();
        return new ResponseEntity<List<PerpustakaanDummy>>(c,HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map> delete(@PathVariable(value = "id") Long id) {

        Map obj = new HashMap();
        perpustakaanDummyService.delete(id);
        obj.put("data", "sukses delete");
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

//    @DeleteMapping("delete/{id}")
//    public void delete(@PathVariable("id")Long id){
//        this.perpustakaanDummyService.delete(id);
//    }

}
