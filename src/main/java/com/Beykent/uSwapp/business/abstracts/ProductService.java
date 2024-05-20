package com.Beykent.uSwapp.business.abstracts;

import java.util.List;

import com.Beykent.uSwapp.core.utilities.results.DataResult;
import com.Beykent.uSwapp.core.utilities.results.Result;
import com.Beykent.uSwapp.entities.concretes.Product;
import com.Beykent.uSwapp.entities.dtos.ProductWithCategoryDto;

public interface ProductService {

    DataResult<List<Product>> getAll();
    DataResult<List<Product>> getAll(int pageNo, int pageSize);
    DataResult<List<Product>> getAllSorted();
    Result add(Product product);
    DataResult<Product> getByProductName(String productName);
    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
