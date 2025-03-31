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

        // Проверяем, существует ли текущий пользователь в базе
        User currentUser = userRepo.findByEmail(email)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException(String.format("User with email %s not found!", email)));

        // Получаем данные пользователя, которого хотим обновить
        User updateUser = userRepo.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException(String.format("User with ID %d not found!", id)));

        // Проверяем, что текущий пользователь обновляет только свои данные
        if (!currentUser.getEmail().equals(updateUser.getEmail())) {
            throw new BadRequestException("Вы не можете обновлять чужие данные!");
        }

        // Проверяем, что новый email не занят другим пользователем
        if (!updateUser.getEmail().equals(userRequest.email()) && userRepo.existsByEmail(userRequest.email())) {
            throw new BadRequestException("Этот email уже используется!");
        }

        // SQL-запрос для обновления информации о пользователе
        String sql = """
                UPDATE users 
                SET first_name = ?, last_name = ?, email = ?, image_url = ? 
                WHERE id = ?
                """;

        // Выполняем обновление через JdbcTemplate
        jdbcTemplate.update(sql,
                userRequest.firstName(),
                userRequest.lastName(),
                userRequest.email(),
                userRequest.imageUrl(),
                id);

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
