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

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Modifying
    @Transactional
    @Query(value = "update users set firstname, lastname = :str where id = :id", nativeQuery = true)
    void updateNameUser(@Param("str") String str, Integer id);

//    @Query(name = "find_most_user", nativeQuery = true)
//    List<UserDTO> mostOrder();
}
