package com.mh.apifacturacion.service;

import com.mh.apifacturacion.dto.AuthRequest;
import com.mh.apifacturacion.dto.AuthResponse;

public interface AuthService {
    AuthResponse authenticate(AuthRequest req);
}
