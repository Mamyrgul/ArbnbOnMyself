package java16.arbnbonmyself.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java16.arbnbonmyself.entities.User;
import java16.arbnbonmyself.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
@RequiredArgsConstructor
public class JwtService {
    @Value("java16theBest")
    private String secretKey;
    private final UserRepo userRepo;

    public String generateToken(User user) {
        ZonedDateTime now = ZonedDateTime.now();
        return JWT.create()
                .withClaim("id", user.getId())
                .withClaim("email", user.getEmail())
                .withClaim("role", user.getRole().name())
                .withIssuedAt(now.toInstant())
                .withExpiresAt(now.plusSeconds(100000).toInstant())
                .sign(getAlgorithm());
    }

    public User verifyToken(String token) {
        Algorithm algorithm = getAlgorithm();
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        String email = jwt.getClaim("email").asString();
        return userRepo.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email not found"));
    }

    public Algorithm getAlgorithm() {
        return Algorithm.HMAC256(secretKey);
    }
}
