package com.github.sadiker.IstanbulAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.github.sadiker.IstanbulAPI.models.district.ReplyDistrict;
import com.github.sadiker.IstanbulAPI.models.district.Result;
import com.github.sadiker.IstanbulAPI.service.DistrictService;

@RestController
public class DistrictApiController {

    @Autowired
    DistrictService districtService;

    @GetMapping("/districts")
    // @ResponseBody
    public Result getDistricts() {
        return new Result(true, "Başarılı!", districtService.getAll());
    }
    
    @GetMapping("/districts/{id}")
    public ReplyDistrict getById(@PathVariable("id") Long id) {
        return districtService.getById(id);
    }

    @GetMapping("/districtsByContinent")
    public Result getDisrictByContinent(@RequestParam("continent") String continent){
        return  districtService.getDistrictByContinent(continent);
    }

    @GetMapping("/districtsByName")
    public ReplyDistrict  getDistrictByName(@RequestParam("name") String name){
        return districtService.getByName(name);
    }

    @GetMapping("/districtsByDescPopulation") 
    public Result getDistrictByDescPopulation(@RequestParam("population") Long population) {

        return districtService.getDistrictByDescPopulation(population);

    }



}
