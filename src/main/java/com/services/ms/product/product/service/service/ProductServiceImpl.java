package com.services.ms.product.product.service.service;
import com.services.ms.product.product.service.Modelo.dto.*;
import com.services.ms.product.product.service.Modelo.entity.Category;
import com.services.ms.product.product.service.Modelo.entity.dtoEntityAplication.Products;
import com.services.ms.product.product.service.Modelo.entity.dtoEntityAplication.Users;
import com.services.ms.product.product.service.exceptions.CategoryNotFoundException;
import com.services.ms.product.product.service.exceptions.ProductNotFoundException;
import com.services.ms.product.product.service.mapper.ProductMapper;
import com.services.ms.product.product.service.mapper.UserMapper;
import com.services.ms.product.product.service.repository.CategoryRepository;
import com.services.ms.product.product.service.repository.ProductRepository;
import com.services.ms.product.product.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService  {



    private  final CategoryRepository  categoryRepository;
    private  final ProductRepository productRepository;
    private  final UserRepository userRepository ;
    private  final ProductMapper productMapper;
    private  final UserMapper userMapper ;

    @Override
    public ProductResponse findByid(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toProductResponse)
                .orElseThrow(ProductNotFoundException::new);
    }



    public void UpdateUserResponse(Long id,UpdateUserRequestDTO request){
        userRepository.findById(id).map(users -> {
            users.setName(request.getName());
            users.setPassword(request.getPassword());
            users.setLevel(request.getLevel());
            String dateString = request.getDateOfAccountCreation(); // Ejemplo: "2023-11-17"
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            // Parsear el String a java.util.Date
            Date date = null;
            try {
                date = formatter.parse(dateString);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            users.setDate_of_account_creation(date);
            users.setIsApproved(request.getIsApproved() == 0 ?  Boolean.TRUE : Boolean.FALSE); ;
            users.setBlock(request.getIsApproved() == 0 ?  Boolean.TRUE : Boolean.FALSE);
            users.setAddress(request.getAddress());
            users.setEmail(request.getEmail());
            users.setPhone_number(request.getNumber());
            users.setPinCode(request.getPinCode());
            users.setUserId(request.getUserId());
            return userRepository.save(users);
        });
    }


    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream().map(productMapper::toProductResponse).collect(Collectors.toList());
    }

    @Override
    public List<GetUserResponse> findAllUser() {
        return userRepository.findAll().stream().map(userMapper::toUserResponse2).collect(Collectors.toList()) ;
    }

//    @Override
//    public List<GetUserResponse> findAllUser() {
//        return userRepository.findAll().stream().map()
//    }


//    public List<Cre>

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


//    @Override
//    public ProductResponse update(Long id, CreateProductRequest request) {
//        return productRepository.findById(id)
//                .map(product -> categoryRepository
//                        .findById(request.getCategoryid())
//                        .map(category -> {
//                            product.setName(request.getName());
//                            product.setDescription(request.getDescription());
//                            product.setPrice(request.getPrice());
//                            product.setCategory(category);
//                            return productRepository.save(product);
//                        })
//                        .orElseThrow(CategoryNotFoundException::new))
//                .map(productMapper::toProductResponse)
//                .orElseThrow(ProductNotFoundException::new);
//    }



    @Override
    public ProductResponse save(CreateProductRequest request) {
        // Buscar la categoría correspondiente al categoryid

        Category category = categoryRepository.findById(request.)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Products productnew = new Products();
        productnew.setName(request.getName());
        productnew.setCategory(category);  // Asignar la categoría encontrada
//        productnew.setPrice(request.getPrice());
//        productnew.setDescription(request.getDescription());
//        productnew.setStatus(Boolean.TRUE);

        Products savedProduct = productRepository.save(productnew);

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


//    public UserResponseDTO AddUser(CreatedUserResquestDTO resquest) {
//
//    }

    @Override
    public CreatedUserResponseDTO addUser(CreatedUserResquestDTO resquest) {
        try {
            Users user = new Users();
            user.setName(resquest.getName());
            user.setPassword(resquest.getPassword());
            user.setPhone_info(resquest.getPhone_info());
            user.setAddress(resquest.getAddress());
            user.setPhone_number(resquest.getPhone_number());
            user.setDate_of_account_creation(new Date());
            user.setPinCode(resquest.getPincod());
            user.setIsApproved(Boolean.FALSE);
            user.setBlock(Boolean.FALSE);
            user.setLevel(0);
            user.setEmail(resquest.getEmail());
            userRepository.save(user);
            CreatedUserResponseDTO userResponseDTO = new CreatedUserResponseDTO();
            userResponseDTO.setStatus(Boolean.TRUE);
            userResponseDTO.setMessage("Usuario creado correctamente");
            return userResponseDTO;
        } catch (Exception e) {

            CreatedUserResponseDTO userResponseDTO = new CreatedUserResponseDTO();
            userResponseDTO.setStatus(Boolean.FALSE);
            userResponseDTO.setMessage("Usuario  no creado correctamente");
            return userResponseDTO;
        }
    }
}
