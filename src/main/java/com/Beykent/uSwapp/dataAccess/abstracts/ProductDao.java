package com.Beykent.uSwapp.dataAccess.abstracts;

import com.Beykent.uSwapp.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Beykent.uSwapp.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer>{

    Product getByProductName(String productName);
//    List<Product> getByProductNameAndCategory_Id(String productName, int categoryId);
//    List<Product> getByCategory_Id(int categoryId);
//    List<Product>

    @Query("Select new com.Beykent.uSwapp.entities.dtos.ProductWithCategoryDto" +
            "(p.id, p.productName, c.categoryName)" +
            " From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
}
