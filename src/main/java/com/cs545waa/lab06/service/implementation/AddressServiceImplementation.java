package com.cs545waa.lab06.service.implementation;

import com.cs545waa.lab06.dto.AddressDTO;
import com.cs545waa.lab06.entity.Address;
import com.cs545waa.lab06.repository.AddressRepo;
import com.cs545waa.lab06.service.AddressService;
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
public class AddressServiceImplementation implements AddressService {
    private final ModelMapper mapper;
    private final AddressRepo repository;
    @Override
    public void create(AddressDTO dto) {
        repository.save(mapper.map(dto, Address.class));
    }

    @Override
    public void update(AddressDTO dto) {
        repository.save(mapper.map(dto, Address.class));
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public AddressDTO read(int id) {
        return mapper.map(repository.findById(id).get(),AddressDTO.class);
    }

    public List<AddressDTO> readAll() {
        List<AddressDTO> addresses=new ArrayList<>();
        repository.findAll().forEach(address -> addresses.add( mapper.map(address,AddressDTO.class)));
        return addresses;
    }
}
