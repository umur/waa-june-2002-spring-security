package edu.miu.spring_security.service.impl;

import edu.miu.spring_security.dto.UserDto;
import edu.miu.spring_security.entity.User;
import edu.miu.spring_security.repo.RoleRepo;
import edu.miu.spring_security.repo.UserRepo;
import edu.miu.spring_security.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    private ModelMapper mapper;

    @Override
    public void save(UserDto userDto) {
        userRepo.save(dtoToEntity(userDto));
    }

    @Override
    public void updateUser(UserDto userDto, Integer id){
        User user = getById(id);
        user.setAddress(userDto.getAddress());
        user.setEmail(userDto.getEmail());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setProducts(userDto.getProducts());
        user.setReviews(userDto.getReviews());
        user.setRoles(userDto.getRoles());

        userRepo.save(user);
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public User getById(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<UserDto> getAll() {
        var users = userRepo.findAll();
        var result = new ArrayList<UserDto>();

        for(User user: users){
            UserDto dto = new UserDto();
            var userDto = toDto(user);
            result.add(userDto);
        }
        return result;
    }

    private UserDto toDto(User user){
        UserDto dto = mapper.map(user, UserDto.class);
        return dto;
    }
    public User dtoToEntity(UserDto userDto){
        User user = mapper.map(userDto, User.class);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        });
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}
