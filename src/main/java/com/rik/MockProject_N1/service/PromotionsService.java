package com.rik.MockProject_N1.service;

import com.rik.MockProject_N1.model.Promotions;

import java.util.List;

public interface PromotionsService {
    List<Promotions> fillAllPromotions();
    void addPromotions(Promotions promotions);
    void deletePromotion (Integer id);
    void updatePromotion  (String str , Integer id);
}
