package com.restapi.restapi.authentication;

import com.restapi.restapi.config.JwtService;
import com.restapi.restapi.models.user.Role;
import com.restapi.restapi.models.user.User;
import com.restapi.restapi.models.user.UserInfo;
import com.restapi.restapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .info(UserInfo.builder()
                        .firstName(request.getFirstname())
                        .lastName(request.getLastname())
                        .birthDate(request.getBirthDate())
                        .build())
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken();
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        //Kollar om pw och email är korrekt
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
//        var user = repository.findByEmail(request.getEmail())
//                .orElseThrow();
//        if(repository.existsByEmail(request.getEmail())){
        var jwtToken = jwtService.generateToken();
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
