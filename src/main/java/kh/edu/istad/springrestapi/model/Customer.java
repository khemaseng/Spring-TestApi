package kh.edu.istad.springrestapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="m2_customers")
public class Customer {
    @Id
    private UUID id;
    @Column(unique = true, nullable = false, length=12)
    private String phoneNumber;
    @Column(unique = true, nullable = true, length=60)
    private String address;
    private String email;
    private Boolean isDeleted;

    @OneToOne
    private User user;
}
