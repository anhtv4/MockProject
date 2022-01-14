package com.rik.MockProject_N1.repository;

import com.rik.MockProject_N1.model.Product;
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
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Modifying
    @Query(value = "update products set status = 0 where id = :id", nativeQuery = true)
    void deleteById(@Param("id") Integer id);


    /* @Query(value = "select * from product where category_id = :categoryId and price >= :price", nativeQuery = true)*/
    List<Product> findAllByCategoryIdAndPriceGreaterThanEqual(@Param("categoryId") Integer categoryId, @Param("price") Double price);

    @Modifying
    @Query(value = "update products set quantity = :quantity where  id = :id and status = 1", nativeQuery = true)
    void updateProductQuantityById(@Param("quantity") Integer quantity, @Param("id") Integer id);

    @Modifying
    @Query(value = "select * from products where category_id = :categoryId and status = 1 ", nativeQuery = true)
    List<Product> findAllByCategoryIdOrderByName(@Param("categoryId") Integer categoryId);

    @Modifying
    @Query(value = "select * from products where status = 1 order by asc ", nativeQuery = true)
    List<Product> listProductByPrice();
}
