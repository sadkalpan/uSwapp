package com.Beykent.uSwapp.business.concretes;

import com.Beykent.uSwapp.business.abstracts.ProductService;
import com.Beykent.uSwapp.core.utilities.results.DataResult;
import com.Beykent.uSwapp.core.utilities.results.Result;
import com.Beykent.uSwapp.core.utilities.results.SuccessDataResult;
import com.Beykent.uSwapp.core.utilities.results.SuccessResult;
import com.Beykent.uSwapp.dataAccess.abstracts.ProductDao;
import com.Beykent.uSwapp.entities.concretes.Product;
import com.Beykent.uSwapp.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;
    @Autowired
    public ProductManager(ProductDao productDao){
        super();
        this.productDao=productDao;
    }
    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(productDao.findAll(), "Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "productName");
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort), "Başarılı");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Ürün eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(productDao.getByProductName(productName), "Mesaj getirildi");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(), "Data Listelendi");
    }
}
