package com.rik.MockProject_N1.service.impl;

import com.rik.MockProject_N1.model.Review;
import com.rik.MockProject_N1.repository.ReviewRepository;
import com.rik.MockProject_N1.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Review> listReviewByProductId(Integer productId) {
        return reviewRepository.listAllReviewByProductId(productId);
    }

    @Override
    public Review getRiviewById(Integer reviewId) {
        return reviewRepository.updateReviewById(reviewId);
    }

    @Override
    public void deleteById(Integer reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public List<Review> findAllReview() {
        return reviewRepository.findAll();
    }

    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
    }

}
