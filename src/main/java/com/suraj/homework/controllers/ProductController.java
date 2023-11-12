package com.suraj.homework.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.homework.dtos.GenericProductDto;
import com.suraj.homework.dtos.ResponseProductDto;
import com.suraj.homework.exceptions.NotFoundException;
import com.suraj.homework.services.ProductService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        super();
        this.productService = productService;
    }

    // GET REQUEST: --------------------------------------------
    @GetMapping
    public ResponseEntity<List<ResponseProductDto>> getAllProducts() {
        return new ResponseEntity<List<ResponseProductDto>>(productService.getAllProducts(), HttpStatus.OK);
    }

    // @GetMapping("{id}")
    // public ResponseEntity<ResponseProductDto> getProductById(@PathVariable String id) throws NotFoundException{
    //     return new ResponseEntity<ResponseProductDto>(productService.getProductById(UUID.fromString(id)), HttpStatus.OK);
    // }
    @GetMapping("{id}")
    public ResponseEntity<ResponseProductDto> getProductById(@PathVariable UUID id) throws NotFoundException{
        return new ResponseEntity<ResponseProductDto>(productService.getProductById(id), HttpStatus.OK);
    }

    // PUT REQUEST: --------------------------------------------
    // @PutMapping("{id}")
    // public ResponseEntity<ResponseProductDto> updateProductByStringId(@PathVariable String id, @RequestBody GenericProductDto updatedProduct) throws NotFoundException {
    //     return new ResponseEntity<ResponseProductDto>(productService.updateProductById(UUID.fromString(id), updatedProduct), HttpStatus.OK);
    // }
    @PutMapping("{uuid}")
    public ResponseEntity<ResponseProductDto> updateProductById(@PathVariable UUID uuid, @RequestBody GenericProductDto updatedProduct) throws NotFoundException {
        return new ResponseEntity<ResponseProductDto>(productService.updateProductById(uuid, updatedProduct), HttpStatus.OK);
    }

    // DELETE REQUEST: ------------------------------------------
    // @DeleteMapping("{id}")
    // public ResponseEntity<ResponseProductDto> deleteProductById(@PathVariable String id) throws NotFoundException{
    //     return new ResponseEntity<ResponseProductDto>(productService.getProductById(UUID.fromString(id)), HttpStatus.OK);
    // }
    @DeleteMapping("{uuid}")
    public ResponseEntity<ResponseProductDto> deleteProductByUUId(@PathVariable UUID uuid) throws NotFoundException{
        return new ResponseEntity<ResponseProductDto>(productService.deleteProductById(uuid), HttpStatus.OK);
    }
    
    // POST REQUEST: --------------------------------------------
    @PostMapping
    public ResponseEntity<ResponseProductDto> addProduct(@RequestBody GenericProductDto product) {
        return new ResponseEntity<ResponseProductDto>(productService.addProduct(product), HttpStatus.OK);
    }

}
