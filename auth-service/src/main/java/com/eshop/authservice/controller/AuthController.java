package com.eshop.authservice.controller;

import com.eshop.authservice.dto.LoginDto;
import com.eshop.authservice.dto.RegisterDto;
import com.eshop.authservice.dto.SuccessResponse;
import com.eshop.authservice.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Auth Controller", description = "This url for Authenticate Users.")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<SuccessResponse> login(@RequestBody LoginDto loginDto){
        return  new ResponseEntity<>(authService.login(loginDto),HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<SuccessResponse> signUp(@RequestBody RegisterDto registerDto) {
        return new ResponseEntity<>(authService.register(registerDto), HttpStatus.ACCEPTED);
    }
}
