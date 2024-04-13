package co.com.tascon.service.verbsHTTP.controllers;

import co.com.tascon.service.verbsHTTP.dtos.CreateProductDTO;
import co.com.tascon.service.verbsHTTP.dtos.ErrorDTO;
import co.com.tascon.service.verbsHTTP.dtos.MessageDTO;
import co.com.tascon.service.verbsHTTP.dtos.UpdateProductDTO;
import co.com.tascon.service.verbsHTTP.services.ProductService;
import co.com.tascon.service.verbsHTTP.utilities.ProductException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", methods     = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PATCH })
@Slf4j
public class ProductController {

    private final ProductService productService;

    @GetMapping(path = "/getProducts")
    public ResponseEntity getAllProducts() {
        return new ResponseEntity(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping(path = "/getProduct/{id}")
    public ResponseEntity getProductById(@PathVariable String id) {
        try {
            return new ResponseEntity(productService.getProductById(id), HttpStatus.OK);
        } catch (ProductException ex) {
            return new ResponseEntity(ErrorDTO.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/createProduct")
    public ResponseEntity createUser(@RequestBody CreateProductDTO createProductDTO) {
        try {
            return new ResponseEntity(productService.createProduct(createProductDTO), HttpStatus.CREATED);
        } catch (ProductException ex) {
            return new ResponseEntity(ErrorDTO.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/updateProduct")
    public ResponseEntity updateProduct(@RequestBody UpdateProductDTO updateProductDTO) {
        try {
            return new ResponseEntity(productService.updateProduct(updateProductDTO), HttpStatus.OK);
        } catch (ProductException ex) {
            return new ResponseEntity(ErrorDTO.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/deleteProduct/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id) {
        try {
            return new ResponseEntity(MessageDTO.builder().message(productService.deleteProduct(id)).build(), HttpStatus.OK);
        } catch (ProductException ex) {
            return new ResponseEntity(ErrorDTO.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(path = "/patchProduct/{id}")
    public ResponseEntity patchProduct(@PathVariable String id,@RequestBody UpdateProductDTO updateProductDTO) {
        try {
            return new ResponseEntity(productService.patchProduct(id, updateProductDTO), HttpStatus.OK);
        } catch (ProductException ex) {
            return new ResponseEntity(ErrorDTO.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/optionsProduct", method = RequestMethod.OPTIONS)
    public ResponseEntity optionsProduct() {
        return new ResponseEntity(productService.optionsProduct(), HttpStatus.OK);
    }

    @RequestMapping(path = "/headerProduct/{id}", method = RequestMethod.HEAD)
    public ResponseEntity headerProduct(@PathVariable String id) {
        return new ResponseEntity(productService.getProductHeader(id), HttpStatus.OK);
    }

}
