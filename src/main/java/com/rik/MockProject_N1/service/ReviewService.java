package com.rik.MockProject_N1.service;

import com.rik.MockProject_N1.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ReviewService {
    List<Review> listReviewByProductId(Integer productId);

    Review getRiviewById(Integer reviewId);

    void deleteById(Integer reviewId);

    List<Review> findAllReview();
    void addReview(Review review);
}
