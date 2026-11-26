package kh.edu.istad.springrestapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
// @ToString
@Table(name="m2_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length=50, nullable=false)
    private String username;
    @Column(length=32, nullable=false, unique=true)
    private String password;
    @Column(nullable=false)
    private String email;
    @Column(nullable=false)
    private Boolean isActive;

    @OneToOne
    private Customer customer;
}