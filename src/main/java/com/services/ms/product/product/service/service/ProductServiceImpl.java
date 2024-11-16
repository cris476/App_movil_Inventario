package com.services.ms.product.product.service.service;
import  com.services.ms.product.product.service.Modelo.dto.CreateProductRequest;
import com.services.ms.product.product.service.Modelo.dto.ProductResponse;
import com.services.ms.product.product.service.Modelo.entity.Category;
import com.services.ms.product.product.service.Modelo.entity.Product;
import com.services.ms.product.product.service.exceptions.CategoryNotFoundException;
import com.services.ms.product.product.service.exceptions.ProductNotFoundException;
import com.services.ms.product.product.service.mapper.ProductMapper;
import com.services.ms.product.product.service.repository.CategoryRepository;
import com.services.ms.product.product.service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService  {



    private  final CategoryRepository  categoryRepository;
    private  final ProductRepository productRepository;
    private  final ProductMapper productMapper;

    @Override
    public ProductResponse findByid(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toProductResponse)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream().map(productMapper::toProductResponse).collect(Collectors.toList());
    }

//    @Override
//    public List<ProductResponse> findAllByCategoryId(Long Categoryid) {
//
//      Category category =    categoryRepository.findById(Categoryid).orElseThrow(
//              () -> new RuntimeException("Category not found")
//      );
//
//       List<Product>  listaproduct  =  productRepository.findAllByCategory(category);
//
//        return listaproduct.stream().map(productMapper::toProductResponse).collect(Collectors.toList());
//    }

    @Override
    public List<ProductResponse> findAllByCategoryId(Long Categoryid) {

        return categoryRepository.findById(Categoryid)
                .map(productRepository::findAllByCategory)
                .map(products -> products.stream()
                        .map(productMapper::toProductResponse)
                        .collect(Collectors.toList()))
                .orElseThrow(CategoryNotFoundException::new);

    }


    @Override
    public ProductResponse update(Long id, CreateProductRequest request) {

        // Buscar el producto por su ID, lanzar excepción si no existe
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Buscar la categoría por su ID, lanzar excepción si no existe
        Category category = categoryRepository.findById(request.getCategoryid())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Actualizar los datos del producto
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setCategory(category);

        // Guardar el producto actualizado en la base de datos
        Product updatedProduct = productRepository.save(product);

        // Convertir el producto actualizado a ProductResponse y devolverlo
        return productMapper.toProductResponse(updatedProduct);
    }


    @Override
    public ProductResponse save(CreateProductRequest request) {
        // Buscar la categoría correspondiente al categoryid
        Category category = categoryRepository.findById(request.getCategoryid())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Crear el nuevo producto usando los datos del request
        Product productnew = new Product();
        productnew.setName(request.getName());
        productnew.setCategory(category);  // Asignar la categoría encontrada
        productnew.setPrice(request.getPrice());
        productnew.setDescription(request.getDescription());
        productnew.setStatus(Boolean.TRUE);

        // Guardar el producto en la base de datos
        Product savedProduct = productRepository.save(productnew);

        // Convertir el producto guardado en un DTO ProductResponse
        return productMapper.toProductResponse(savedProduct);
    }



    @Override
    public void deletedByid(Long id) {
         if(productRepository.findById(id).isEmpty()){
             throw  new RuntimeException("Category not found");
         }
         productRepository.deleteById(id);
    }
}
