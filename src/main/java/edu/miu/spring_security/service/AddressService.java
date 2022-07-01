package edu.miu.spring_security.service;

import edu.miu.spring_security.dto.AddressDto;
import edu.miu.spring_security.entity.Address;

import java.util.List;

public interface AddressService {

    void save(AddressDto arddress);

    public void updateAddress(AddressDto arddress, Integer id);
    void delete(int id);

    Address getById(int id);

    List<AddressDto> getAll();
}
