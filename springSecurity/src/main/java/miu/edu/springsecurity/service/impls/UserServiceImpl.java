package miu.edu.springsecurity.service.impls;

import miu.edu.springsecurity.domain.LoginRequest;
import miu.edu.springsecurity.domain.LoginResponse;
import miu.edu.springsecurity.domain.User;
import miu.edu.springsecurity.dto.UserDto;
import miu.edu.springsecurity.dto.UserDtoResponse;
import miu.edu.springsecurity.repository.UserRepository;
import miu.edu.springsecurity.security.JwtHelper;
import miu.edu.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtHelper jwtHelper;

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        var users = userRepository.findAll();
        Type listType = new TypeToken<List<UserDto>>(){}.getType();
        return modelMapper.map(users,listType);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("User does not exist %s",id)));
        return modelMapper.map(userRepository.save(user),UserDto.class);
    }

    @Override
    public UserDtoResponse save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user = userRepository.save(user);
        return modelMapper.map(user, UserDtoResponse.class);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Bad Credentials");
        }
        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail());
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;

    }
}
