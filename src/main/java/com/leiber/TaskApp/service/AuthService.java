package com.leiber.TaskApp.service;

import com.leiber.TaskApp.auth.dto.AuthResponse;
import com.leiber.TaskApp.auth.dto.LoginRequest;
import com.leiber.TaskApp.auth.dto.RegisterRequest;
import com.leiber.TaskApp.auth.jwt.JwtService;
import com.leiber.TaskApp.persistence.entity.Role;
import com.leiber.TaskApp.persistence.entity.UserEntity;
import com.leiber.TaskApp.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserEntity userEntity = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String userId = String.valueOf(userEntity.getId());
        String token = jwtService.getToken(userEntity, userId);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public void register(RegisterRequest request) {
        UserEntity user = UserEntity.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role(Role.ADMIN)
                .build();

        userRepository.save(user);
    }
}
