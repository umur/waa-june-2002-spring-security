package com.cs545waa.lab06.controller;

import com.cs545waa.lab06.dto.AppUserDTO;
import com.cs545waa.lab06.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/app-users")
@AllArgsConstructor
public class AppUserController {
    private final AppUserService service;
    @GetMapping
    public List<AppUserDTO> read(){
        return service.readAll();
    }
    @PostMapping
    public void create(@RequestBody AppUserDTO dto){
        service.create(dto);
    }
    @PatchMapping
    public void update(@RequestBody AppUserDTO dto){
        service.update(dto);
    }
    @DeleteMapping
    public void delete(@RequestParam int id){
        service.delete(id);
    }
}
