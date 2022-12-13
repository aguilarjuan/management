package com.nisum.management.service.impl;

import com.nisum.management.model.UserModel;
import com.nisum.management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserModel> optional = userRepository.findByEmail(email);
        if(optional.isEmpty()){
            throw new UsernameNotFoundException("user not found");
        }
        UserModel model = optional.get();
        return userBuilder(email, new BCryptPasswordEncoder().encode(model.getPassword()), model.getRole());
    }

    private User userBuilder(String username, String password, String... roles){
        boolean enable = true;
        boolean accountNonExpired = true;
        boolean credentialsNonLocked = true;
        boolean accountNonLocked = true;
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (String role: roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }

        return new User(username, password, enable, accountNonExpired, credentialsNonLocked, accountNonLocked, authorities);
    }
}
