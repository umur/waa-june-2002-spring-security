package com.cs545waa.lab06.controller;

import com.cs545waa.lab06.dto.AddressDTO;
import com.cs545waa.lab06.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressController {
    private final AddressService service;
    @GetMapping
    public List<AddressDTO> read(){
        return service.readAll();
    }
    @PostMapping
    public void create(@RequestBody AddressDTO dto){
        service.create(dto);
    }
    @PatchMapping
    public void update(@RequestBody AddressDTO dto){
        service.update(dto);
    }
    @DeleteMapping
    public void delete(@RequestParam int id){
        service.delete(id);
    }
}
