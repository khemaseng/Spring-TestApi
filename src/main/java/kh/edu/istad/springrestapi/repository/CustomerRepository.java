package kh.edu.istad.springrestapi.repository;

import kh.edu.istad.springrestapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
