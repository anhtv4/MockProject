package com.rik.MockProject_N1.service.impl;

import com.rik.MockProject_N1.model.Promotions;
import com.rik.MockProject_N1.repository.PromotionsRepository;
import com.rik.MockProject_N1.service.PromotionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PromotionsImpl implements PromotionsService {
    @Autowired
    PromotionsRepository promotionsRepository;


    @Override
    public List<Promotions> fillAllPromotions() {
        return promotionsRepository.findAll();
    }

    @Override
    public void addPromotions(Promotions promotions) {
        promotionsRepository.save(promotions);
    }

    @Override
    public void deletePromotion(Integer id) {
    promotionsRepository.deleteById(id);
    }

    @Override
    public void updatePromotion(String str, Integer id) {
        promotionsRepository.updateNameUser(str,id);
    }
}
