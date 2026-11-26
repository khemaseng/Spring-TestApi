package kh.edu.istad.springrestapi.repository;

import kh.edu.istad.springrestapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
