package com.springProjects.libararyManagementSystem.repository;

import com.springProjects.libararyManagementSystem.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

}
