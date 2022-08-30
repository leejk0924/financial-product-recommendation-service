package com.fastcampus.miniproject.controller;

import com.fastcampus.miniproject.dto.*;
import com.fastcampus.miniproject.dto.response.ProductDetailResponse;
import com.fastcampus.miniproject.dto.response.ProductListCustomizedResponse;
import com.fastcampus.miniproject.dto.response.ProductListWisdomResponse;
import com.fastcampus.miniproject.dto.response.ProductResponse;
import com.fastcampus.miniproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseWrapper<List<ProductResponse>> getProductList() {
        return new ResponseWrapper<>(productService.getProductList()).ok();
    }

    @GetMapping(value = "/products", params = {"query", "tag", "tagContent"})
    public ResponseWrapper<List<ProductResponse>> getProductListWithQuery(
            @RequestParam String query,
            @RequestParam String tag,
            @RequestParam String tagContent) {

        return new ResponseWrapper<>(productService.getProductList(query, tag, tagContent)).ok();
    }

    @GetMapping("/products/{id}")
    public ResponseWrapper<ProductDetailResponse> getProduct(@PathVariable Long id) {
        return new ResponseWrapper<>(productService.getProduct(id)).ok();
    }

    @GetMapping("/products/customized")
    public ResponseWrapper<ProductListCustomizedResponse> getCustomizedProductList() {
        return new ResponseWrapper<>(productService.getProductListCustomized()).ok();
    }

    @GetMapping("/products/wisdom")
    public ResponseWrapper<ProductListWisdomResponse> getWisdomProductList() {
        return new ResponseWrapper<>(productService.getProductListWisdom()).ok();
    }
}