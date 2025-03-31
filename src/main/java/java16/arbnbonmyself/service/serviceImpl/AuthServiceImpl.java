package java16.arbnbonmyself.service.serviceImpl;

import java16.arbnbonmyself.config.jwt.JwtService;
import java16.arbnbonmyself.dto.request.SignInRequest;
import java16.arbnbonmyself.dto.request.SignUpRequest;
import java16.arbnbonmyself.dto.response.AuthResponse;
import java16.arbnbonmyself.entities.User;
import java16.arbnbonmyself.enums.Role;
import java16.arbnbonmyself.exception.AlreadyExist;
import java16.arbnbonmyself.exception.UserNotFoundException;
import java16.arbnbonmyself.repo.UserRepo;
import java16.arbnbonmyself.service.AuthService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Builder
@Transactional
public class AuthServiceImpl implements AuthService {
    private final JwtService jwtService;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse signUp(SignUpRequest signUpRequest) {
        if (userRepo.existsByEmail(signUpRequest.email())) {
            throw new AlreadyExist("Email already exists");
        }
        User user = User
                .builder()
                .fullName(signUpRequest.firstName() + " " + signUpRequest.lastName())
                .email(signUpRequest.email())
                .password(passwordEncoder.encode(signUpRequest.password()))
                .role(Role.USER)
                .build();
        userRepo.save(user);
        return AuthResponse
                .builder()
                .id(user.getId())
                .email(user.getEmail())
                .token(jwtService.generateToken(user))
                .build();
    }

    @Override
    public AuthResponse signIn(SignInRequest signInRequest) {
        User user = userRepo.findByEmail(signInRequest.email())
                .orElseThrow(() -> new UserNotFoundException("User with email " + signInRequest.email() + " not found!"));
        if (!passwordEncoder.matches(signInRequest.password(), user.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }
        return AuthResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .token(jwtService.generateToken(user))
                .build();
    }
}
