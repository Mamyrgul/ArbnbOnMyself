package java16.arbnbonmyself.service;


import java16.arbnbonmyself.dto.request.UserRequest;
import java16.arbnbonmyself.dto.response.SimpleResponse;
import java16.arbnbonmyself.dto.response.UserResponse;

public interface UserService  {
SimpleResponse createUser(UserRequest userRequest);
SimpleResponse updateUser(Long id,UserRequest userRequest);
SimpleResponse deleteUser(Long id);
UserResponse getUserById(Long id);
UserResponse getUserByUsername(String username);
}
