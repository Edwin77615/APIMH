package com.mh.apifacturacion.service;

import com.mh.apifacturacion.config.JwtUtil;
import com.mh.apifacturacion.dto.AuthRequest;
import com.mh.apifacturacion.dto.AuthResponse;
import com.mh.apifacturacion.model.User;
import com.mh.apifacturacion.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public AuthResponse authenticate(AuthRequest req) {
        Optional<User> u = userRepository.findByUsername(req.getUser());
        AuthResponse r = new AuthResponse();
        if (u.isEmpty() || !u.get().getPassword().equals(req.getPwd())) {
            r.setStatus("ERROR");
            return r;
        }
        String token = jwtUtil.generateToken(u.get().getUsername(), u.get().getRoleCode());
        AuthResponse.Body b = new AuthResponse.Body();
        b.setUser(u.get().getUsername());
        b.setToken(token);
        b.setRol(u.get().getRoleCode());
        r.setStatus("OK");
        r.setBody(b);
        return r;
    }
}
