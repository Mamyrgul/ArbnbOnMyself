package java16.arbnbonmyself.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record UserRequest(
        @NotBlank(message = "Full name cannot be blank")
        @Size(max = 100, message = "First name cannot exceed 100 characters")
        String firstName,
        @Size(max = 100,message = "Last name cannot exceed 100 characters")
        String lastName,
        @NotBlank(message = "Email cannot be blank")
        @Size(max = 320, message = "Email cannot exceed 320 characters")
        @Email(message = "Invalid email format")
        String email,
        @NotBlank(message = "Password cannot be blank")
        @Size(min = 6, max = 12, message = "Password must be between 6 and 12 characters long")
        String password,
        String imageUrl
) {
}
