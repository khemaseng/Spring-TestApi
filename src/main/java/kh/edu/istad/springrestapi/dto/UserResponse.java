package kh.edu.istad.springrestapi.dto;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String username,
        String email,
        Boolean isActive
) {
}