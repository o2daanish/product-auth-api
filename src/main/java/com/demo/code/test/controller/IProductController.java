package com.demo.code.test.controller;

import com.demo.code.test.entity.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface IProductController {
    @Operation(summary = "Create a new product", description = "Allows an admin to create a new product.", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Product created successfully"), @ApiResponse(responseCode = "400", description = "Invalid input data")})
    @PostMapping()
//    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Product> createProduct(@RequestBody Product product);

    @Operation(summary = "Get all products", description = "Fetches all products. Accessible by users and admins.", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Fetched products successfully")})
    @GetMapping
//    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ADMIN')")
    ResponseEntity<List<Product>> getAllProducts();

    @Operation(summary = "Delete a product by ID", description = "Allows an admin to delete a product by its ID.", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Product deleted successfully"), @ApiResponse(responseCode = "404", description = "Product not found")})
    @DeleteMapping("/admin/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Void> deleteProduct(@PathVariable Long id);

    @Operation(summary = "Update a product", description = "Allows an admin to update a product.", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Product updated successfully"), @ApiResponse(responseCode = "404", description = "Product not found")})
    @PutMapping("/admin/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product);
}
