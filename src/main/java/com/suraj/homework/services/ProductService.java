package com.suraj.homework.services;

import java.util.List;
import java.util.UUID;

import com.suraj.homework.dtos.GenericProductDto;
import com.suraj.homework.dtos.ResponseProductDto;
import com.suraj.homework.exceptions.NotFoundException;

public interface ProductService {

    List<ResponseProductDto> getAllProducts();

    ResponseProductDto getProductById(UUID id) throws NotFoundException;

    ResponseProductDto updateProductById(UUID id, GenericProductDto productDto) throws NotFoundException;

	ResponseProductDto addProduct(GenericProductDto product);

    ResponseProductDto deleteProductById(UUID uuid) throws NotFoundException;

    
}