package com.rik.MockProject_N1.repository;

import com.rik.MockProject_N1.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

    @Modifying
    @Transactional
    @Query(value = "update categories c  set c.title = :str where c.id = :id", nativeQuery = true)
    void updateCategory(@Param("str") String str, Integer id);
}
