package com.eshop.authservice.service;

import com.eshop.authservice.exception.ServiceException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;

import java.security.Key;
import java.util.Date;

public interface JwtService {
    public String generateToken(Authentication authentication);
    public String getPhoneOrEmail(String token);
    public boolean validateToken(String token);
}
