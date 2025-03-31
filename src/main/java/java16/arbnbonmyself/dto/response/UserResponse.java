package java16.arbnbonmyself.dto.response;

import java16.arbnbonmyself.enums.Role;

public record UserResponse(
        String fullName,
        String email,
        Role role
) {
}
