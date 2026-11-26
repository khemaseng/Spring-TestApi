package kh.edu.istad.springrestapi.service.impl;

import kh.edu.istad.springrestapi.dto.UserResponse;
import kh.edu.istad.springrestapi.mapper.UserMapper;
import kh.edu.istad.springrestapi.model.User;
import kh.edu.istad.springrestapi.repository.UserRepository;
import kh.edu.istad.springrestapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private UserResponse toUserResponse(User user) {
        return user == null ? null : userMapper.mapUserToUserResponse(user);
    }
    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(this::toUserResponse)
                .toList();
    }
    @Override
    public Page<UserResponse> getAllWithPaging(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return userRepository.findAll(pageable)
                .map(userMapper::mapUserToUserResponse);
    }
    @Override
    public UserResponse getById(UUID id) {
        return userRepository.findById(id)
                .map(this::toUserResponse)
                .orElse(null);
    }
    @Override
    public User create(User user) {
        user.setId(null);
        return userRepository.save(user);
    }
    @Override
    public void delete(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not found: " + id);
        }
        userRepository.deleteById(id);
    }
}