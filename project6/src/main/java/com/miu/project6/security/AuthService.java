package com.miu.project6.security;

@Service()
@Transactional
public class AuthService implements UserDetailsService {

    private final UserRepo userRepo;

    public AuthService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepo.findByUserName(username);
        var userDetails = new AuthUser(user);
        return userDetails;
    }
}
