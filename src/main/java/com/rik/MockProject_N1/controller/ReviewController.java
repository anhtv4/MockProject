package com.rik.MockProject_N1.controller;

import com.rik.MockProject_N1.model.Review;
import com.rik.MockProject_N1.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @GetMapping("/listAll_byProductId")
    public ResponseEntity<List<Review>> getAllReviewByProductId(Integer productId){
        List<Review> reviewList = reviewService.listReviewByProductId(productId);
        return new ResponseEntity<List<Review>>(reviewList, HttpStatus.OK);
    }
    @GetMapping("/listAll_Review")
    public ResponseEntity<List<Review>> listAllReview(){
        List<Review> reviewList = reviewService.findAllReview();
        return new ResponseEntity<>(reviewList,HttpStatus.OK);
    }
    @GetMapping("/edit")
    public ResponseEntity<Review> editReview( Integer reviewId){
        Review review = reviewService.getRiviewById(reviewId);
        return new ResponseEntity<Review>(review,HttpStatus.OK);
    }

    @PostMapping("/add_review")
    public ResponseEntity<String> addReview(@RequestBody Review review){
        reviewService.addReview(review);
        return new ResponseEntity<>("Add review ok",HttpStatus.OK);
    }
    @DeleteMapping("/delete_by_id")
    public ResponseEntity<String> deleteReview(@RequestParam Integer id) {

        reviewService.deleteById(id);
        return new ResponseEntity<String>("review: " + id + " delete oki", HttpStatus.OK);
    }

    }

