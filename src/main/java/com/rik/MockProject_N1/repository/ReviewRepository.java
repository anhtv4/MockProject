package com.rik.MockProject_N1.repository;

import com.rik.MockProject_N1.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Modifying
    @Query(value = "select * from reviews join products on reviews.product_id = products.id where product_id =:productId and products.status = 1", nativeQuery = true)
    List<Review> listAllReviewByProductId(Integer productId);


    @Query(value = "select * from reviews join products on reviews.product_id = products.id where  reviews.id = :id", nativeQuery = true)
    Review updateReviewById( Integer id);



}
