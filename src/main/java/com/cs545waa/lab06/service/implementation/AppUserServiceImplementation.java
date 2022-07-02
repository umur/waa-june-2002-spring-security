package com.cs545waa.lab06.service.implementation;

import com.cs545waa.lab06.dto.AppUserDTO;
import com.cs545waa.lab06.entity.AppUser;
import com.cs545waa.lab06.repository.AppUserRepo;
import com.cs545waa.lab06.service.AppUserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
@Data
@Transactional
public class AppUserServiceImplementation implements AppUserService {
    private final ModelMapper mapper;
    private final AppUserRepo repository;
    @Override
    public void create(AppUserDTO dto) {
        repository.save(mapper.map(dto, AppUser.class));
    }

    @Override
    public void update(AppUserDTO dto) {
        repository.save(mapper.map(dto, AppUser.class));
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public AppUserDTO read(int id) {
        return mapper.map(repository.findById(id).get(),AppUserDTO.class);
    }

    public List<AppUserDTO> readAll() {
        List<AppUserDTO> users=new ArrayList<>();
        repository.findAll().forEach(user -> users.add( mapper.map(user,AppUserDTO.class)));
        return users;
    }
}
