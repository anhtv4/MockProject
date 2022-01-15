package com.rik.MockProject_N1.repository;

import com.rik.MockProject_N1.dto.UserDTO;
import com.rik.MockProject_N1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsernameOrPhoneOrEmail(String username, String phone, String email);

    Optional<User> findByUsernameAndPassword(String username, String password);
}
