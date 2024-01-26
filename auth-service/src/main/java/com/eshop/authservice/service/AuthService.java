package com.eshop.authservice.service;

import com.eshop.authservice.dto.*;

public interface AuthService {
    SuccessResponse login(LoginDto loginDto);

    SuccessResponse register(RegisterDto registerDto);

    SuccessResponse forgotPassword(ForgotPasswordDto forgotPasswordDto);

    SuccessResponse resetPassword(String passwordResetToken, ResetPasswordDto resetPasswordDto);
}
