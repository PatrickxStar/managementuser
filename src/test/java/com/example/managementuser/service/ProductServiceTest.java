package com.example.managementuser.service;

import com.example.managementuser.services.ProductService;
import com.example.managementuser.Entities.Product; // Correct package name: entities
import com.example.managementuser.Repositories.ProductRepository; // Correct package name: repositories
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProduct() {
        Product product = new Product();
        product.setName("Laptop");
        product.setPrice(1000.0);

        when(productRepository.save(product)).thenReturn(product);

        Product createdProduct = productService.createProduct(product);
        assertNotNull(createdProduct);
        assertEquals("Laptop", createdProduct.getName());
        assertEquals(1000.0, createdProduct.getPrice());
    }

    @Test
    void testUpdateProduct() {
        Product existingProduct = new Product();
        existingProduct.setId(1L);
        existingProduct.setName("Laptop");
        existingProduct.setPrice(1000.0);

        when(productRepository.findById(1L)).thenReturn(Optional.of(existingProduct));
        when(productRepository.save(existingProduct)).thenReturn(existingProduct);

        existingProduct.setPrice(1200.0);
        Product updatedProduct = productService.updateProduct(existingProduct);

        assertNotNull(updatedProduct);
        assertEquals(1200.0, updatedProduct.getPrice());
    }

    @Test
    void testDeleteProduct() {
        Long productId = 1L;
        doNothing().when(productRepository).deleteById(productId);

        productService.deleteProduct(productId);

        verify(productRepository, times(1)).deleteById(productId);
    }

    @Test
    void testGetAllProducts() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setName("Laptop");
        products.add(product1);

        when(productRepository.findAll()).thenReturn(products);

        List<Product> allProducts = productService.getAllProducts();
        assertEquals(1, allProducts.size());
        assertEquals("Laptop", allProducts.get(0).getName());
    }

    @Test
    void testGetProductById() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Laptop");

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Product foundProduct = productService.getProductById(1L);
        assertNotNull(foundProduct);
        assertEquals("Laptop", foundProduct.getName());
    }
}
