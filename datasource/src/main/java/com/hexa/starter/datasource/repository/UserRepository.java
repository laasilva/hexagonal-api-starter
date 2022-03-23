package com.hexa.starter.datasource.repository;

import com.hexa.starter.datasource.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
