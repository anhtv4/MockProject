package com.rik.MockProject_N1.repository;

import com.rik.MockProject_N1.model.Promotions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
public interface PromotionsRepository extends JpaRepository<Promotions , Integer> {
    @Modifying
    @Transactional
    @Query(value = "update promotions set start_date, end_date = :str where id = :id", nativeQuery = true)
    void updateNameUser(@Param("str") String str, Integer id);

}
