package com.suraj.homework.services.implementations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.suraj.homework.dtos.GenericProductDto;
import com.suraj.homework.dtos.ResponseProductDto;
import com.suraj.homework.exceptions.NotFoundException;
import com.suraj.homework.models.Product;
import com.suraj.homework.repositories.ProductRepository;
import com.suraj.homework.services.ProductService;

@Service
@Primary
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        super();
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ResponseProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> modelMapper.map(product, ResponseProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseProductDto getProductById(UUID id) throws NotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new NotFoundException("The Product with Id " + id + " not found");
        }
        return modelMapper.map(optionalProduct.get(), ResponseProductDto.class);

    }

    @Override
    public ResponseProductDto updateProductById(UUID id, GenericProductDto updatedProduct) throws NotFoundException{

        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("The Product with Id " + id + " not found"));
        
        if(!updatedProduct.getTitle().isBlank()) product.setTitle(updatedProduct.getTitle());
        if(!updatedProduct.getCompany().isBlank()) product.setCompany(updatedProduct.getCompany());
        if(!updatedProduct.getDescription().isBlank()) product.setDescription(updatedProduct.getDescription());
        if(updatedProduct.getPrice()!=null) product.setPrice(updatedProduct.getPrice());
        
        return modelMapper.map(updatedProduct, ResponseProductDto.class);
    }

    @Override
    public ResponseProductDto addProduct(GenericProductDto product) {
        Product savedProduct = productRepository.save(modelMapper.map(product, Product.class));
        return modelMapper.map(savedProduct, ResponseProductDto.class);
    }

    @Override
    public ResponseProductDto deleteProductById(UUID id) throws NotFoundException {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found or already deleted for id "+id));
        productRepository.deleteById(id);
        return modelMapper.map(product, ResponseProductDto.class);
    }
}
