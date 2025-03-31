package java16.arbnbonmyself.service;

import java16.arbnbonmyself.dto.request.SignInRequest;
import java16.arbnbonmyself.dto.request.SignUpRequest;
import java16.arbnbonmyself.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse signUp(SignUpRequest signUpRequest);
    AuthResponse signIn(SignInRequest signInRequest);
}
