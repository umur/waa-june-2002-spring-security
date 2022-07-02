package com.waa.lab5;

import com.waa.lab5.entity.Address;
import com.waa.lab5.entity.Role;
import com.waa.lab5.entity.User;
import com.waa.lab5.repo.AddressRepository;
import com.waa.lab5.repo.RoleRepository;
import com.waa.lab5.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class Lab3Application {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AddressRepository addressRepository;

    public static void main(String[] args) {
        SpringApplication.run(Lab3Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {

			var adminRole = roleRepository.save(new Role(null, "ADMIN", null));
			var userRole = roleRepository.save(new Role(null, "USER", null));

            var address = addressRepository.save(new Address(null, "4th N. S.", "52557", "Fairfield"));

            var adminUser = new User(null,
                    "mhasanat@gmail.com",
                    "123",
                    "Muztaba",
                    "Hasanat",
                    address,
                    List.of(adminRole));

            var userUser = new User(null,
                    "mhasanat@gmail.com",
                    "123",
                    "Muztaba",
                    "Hasanat",
                    address,
                    List.of(userRole));

            userRepository.save(adminUser);
            userRepository.save(userUser);

            adminRole.setUsers(List.of(adminUser));
            userRole.setUsers(List.of(userUser));

            roleRepository.save(adminRole);
            roleRepository.save(userRole);



        };
    }

}
