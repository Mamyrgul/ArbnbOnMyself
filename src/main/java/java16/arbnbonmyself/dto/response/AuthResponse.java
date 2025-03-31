package java16.arbnbonmyself.dto.response;

import lombok.Builder;

@Builder
public record AuthResponse(
        Long id,
        String email,
        String token
) {
}
