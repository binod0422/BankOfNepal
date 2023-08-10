package com.example.bankOfNepal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.bankOfNepal.entities.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}

