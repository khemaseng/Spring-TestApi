package kh.edu.istad.springrestapi.init;

import jakarta.annotation.PostConstruct;
import kh.edu.istad.springrestapi.model.User;
import kh.edu.istad.springrestapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Slf4j
@RequiredArgsConstructor
public class UserInitialization {

    private final UserRepository userRepository;

    @PostConstruct
    void init() {
        log.info("Initializing user data...");

        if (userRepository.count() > 0) {
            log.info("Users already exist, skipping initialization.");
            return;
        }
        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword("admin123");
        user1.setEmail("admin@istad.edu.kh");
        user1.setIsActive(true);

        User user2 = new User();
        user2.setUsername("student");
        user2.setPassword("student123");
        user2.setEmail("student@istad.edu.kh");
        user2.setIsActive(true);

        User user3 = new User();
        user3.setUsername("instructor");
        user3.setPassword("instructor123");
        user3.setEmail("instructor@istad.edu.kh");
        user3.setIsActive(true);

        User user4 = new User();
        user4.setUsername("moderator");
        user4.setPassword("moderator123");
        user4.setEmail("moderator@istad.edu.kh");
        user4.setIsActive(true);

        User user5 = new User();
        user5.setUsername("guest");
        user5.setPassword("guest123");
        user5.setEmail("guest@istad.edu.kh");
        user5.setIsActive(false);

        userRepository.saveAll(List.of(user1, user2, user3, user4, user5));
        log.info("User data initialized successfully with 5 users.");
    }
}