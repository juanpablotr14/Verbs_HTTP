package co.com.tascon.service.verbsHTTP.services.Interface;

import java.util.List;

import org.springframework.http.HttpHeaders;

import co.com.tascon.service.verbsHTTP.dtos.CreateProductDTO;
import co.com.tascon.service.verbsHTTP.dtos.ProductDTO;
import co.com.tascon.service.verbsHTTP.dtos.UpdateProductDTO;
import co.com.tascon.service.verbsHTTP.utilities.ProductException;

public interface IProductService {
	
	List<ProductDTO> getAllProducts();
	ProductDTO getProductById(String id) throws ProductException;
	HttpHeaders getProductHeader(String id);
	HttpHeaders optionsProduct();
	ProductDTO createProduct(CreateProductDTO createProductDTO) throws ProductException;
	ProductDTO updateProduct(UpdateProductDTO updateProductDTO) throws ProductException;
	ProductDTO patchProduct(String id, UpdateProductDTO updateProductDTO) throws ProductException;
    String deleteProduct(String id) throws ProductException;
}
