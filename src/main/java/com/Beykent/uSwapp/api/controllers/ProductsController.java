package com.Beykent.uSwapp.api.controllers;

import com.Beykent.uSwapp.business.abstracts.ProductService;
import com.Beykent.uSwapp.core.utilities.results.DataResult;
import com.Beykent.uSwapp.core.utilities.results.Result;
import com.Beykent.uSwapp.entities.concretes.Product;
import com.Beykent.uSwapp.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        super();
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
        return productService.getAll();
    }

    @GetMapping("/getallByName")
    public DataResult<Product> getallByName(String productName){
        return productService.getByProductName(productName);
    }

    @GetMapping("/getallByPage")
    public DataResult<List<Product>> getallByPage(int pageNo, int pageSize){
        return productService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getallDesc")
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }

    @GetMapping("/getProductWithCategoryDetails")
    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
        return this.productService.getProductWithCategoryDetails();
    }

    @PostMapping("/add")
    public Result getAll(@RequestBody Product product){
        return productService.add(product);
    }
}
