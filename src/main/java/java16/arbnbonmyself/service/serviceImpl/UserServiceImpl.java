package java16.arbnbonmyself.service.serviceImpl;

import jakarta.transaction.Transactional;
import java16.arbnbonmyself.dto.request.UserRequest;
import java16.arbnbonmyself.dto.response.SimpleResponse;
import java16.arbnbonmyself.dto.response.UserResponse;
import java16.arbnbonmyself.entities.User;
import java16.arbnbonmyself.repo.UserRepo;
import java16.arbnbonmyself.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public SimpleResponse createUser(UserRequest userRequest) {
        String sql = """
                insert into user (firstName, lastName, email,password,imageUrl) values (?, ?, ?, ?, ?)
                """;
        jdbcTemplate.update(sql,
                userRequest.firstName());
        userRequest.lastName();
        userRequest.email();
        userRequest.password();
        userRequest.imageUrl();

        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Success")
                .build();
    }

    @Override
    public SimpleResponse updateUser(Long id,UserRequest userRequest) {
        // Получаем email текущего пользователя из SecurityContextHolder
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("User updated successfully!")
                .build();
    }

    @Override
    public SimpleResponse deleteUser(Long id) {
        return null;
    }

    @Override
    public UserResponse getUserById(Long id) {
        return null;
    }

    @Override
    public UserResponse getUserByUsername(String username) {
        return null;
    }
}
