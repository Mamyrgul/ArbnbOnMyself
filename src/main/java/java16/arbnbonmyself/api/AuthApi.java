package java16.arbnbonmyself.api;

import jakarta.validation.Valid;
import java16.arbnbonmyself.dto.request.SignInRequest;
import java16.arbnbonmyself.dto.request.SignUpRequest;
import java16.arbnbonmyself.dto.response.AuthResponse;
import java16.arbnbonmyself.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthApi {
    private final AuthService authService;

    @PostMapping("/signUp")
    public AuthResponse signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        return authService.signUp(signUpRequest);
    }
    @PostMapping("/singIn")
    public AuthResponse signIn(@Valid @RequestBody SignInRequest signInRequest){
        return authService.signIn(signInRequest);
    }
}
