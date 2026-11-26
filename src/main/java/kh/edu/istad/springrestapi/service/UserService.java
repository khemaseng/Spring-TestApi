package kh.edu.istad.springrestapi.service;

import kh.edu.istad.springrestapi.dto.UserResponse;
import kh.edu.istad.springrestapi.model.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserResponse> getAll();
    Page<UserResponse> getAllWithPaging(int pageNumber, int pageSize);
    UserResponse getById(UUID id);
    User create(User user);
    void delete(UUID id);
}