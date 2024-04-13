package co.com.tascon.service.verbsHTTP.services;

import java.util.List;

import co.com.tascon.service.verbsHTTP.model.Product;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import co.com.tascon.service.verbsHTTP.dtos.CreateProductDTO;
import co.com.tascon.service.verbsHTTP.dtos.ProductDTO;
import co.com.tascon.service.verbsHTTP.dtos.UpdateProductDTO;
import co.com.tascon.service.verbsHTTP.mapper.ProductMapper;
import co.com.tascon.service.verbsHTTP.repository.ProductRepository;
import co.com.tascon.service.verbsHTTP.services.Interface.IProductService;
import co.com.tascon.service.verbsHTTP.utilities.ProductException;
import co.com.tascon.service.verbsHTTP.utilities.Validations;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
	
	private final ProductRepository productRepository;
	
	@Override
	public List<ProductDTO> getAllProducts() {
        return ProductMapper.domainToDtoList(productRepository.findAll());
	}

	@Override
	public ProductDTO getProductById(String id) throws ProductException {
		if (!productRepository.existsById(id)) throw new ProductException(Validations.PRODUCT_NOT_FOUND);
		return ProductMapper.domainToDto(productRepository.findById(id).get());
	}

	@Override
	public HttpHeaders getProductHeader(String id) {
		HttpHeaders httpHeaders = new HttpHeaders();

		if (productRepository.existsById(id)) {
			Product product = productRepository.findById(id).get();
			httpHeaders.add("Nombre_Product", product.getName());
			httpHeaders.add("Precio_Product", product.getPrecio().toString());
		}
		return httpHeaders;
	}

	@Override
	public HttpHeaders optionsProduct() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("HTTPS", "GETTERS, POST, UPDATE, PATCH, DELETE, HEAD, OPTIONS");
		httpHeaders.add("Permitidos", "GETTERS, POST, UPDATE, PATCH, DELETE, HEAD, OPTIONS");
		return httpHeaders;
	}

	@Override
	public ProductDTO createProduct(CreateProductDTO createProductDTO) throws ProductException {
		return ProductMapper.domainToDto(productRepository.save(ProductMapper.createProductDtoToDomain(createProductDTO)));
	}

	@Override
	public ProductDTO updateProduct(UpdateProductDTO updateProductDTO) throws ProductException {
		if (!productRepository.existsById(updateProductDTO.getId())) throw new ProductException(Validations.PRODUCT_NOT_FOUND);
		return ProductMapper.domainToDto(productRepository.save(ProductMapper.updateProductDtoToDomain(updateProductDTO)));
	}

	@Override
	public ProductDTO patchProduct(String id, UpdateProductDTO updateProductDTO) throws ProductException {
		if (!productRepository.existsById(id)) throw new ProductException(Validations.PRODUCT_NOT_FOUND);

		Product product = productRepository.findById(id).orElseThrow(() -> new ProductException(Validations.PRODUCT_NOT_FOUND));

		if (updateProductDTO.getName() != null) {
			product.setName(updateProductDTO.getName());
		}
		if (updateProductDTO.getDescripcion() != null){
			product.setDescripcion(updateProductDTO.getDescripcion());
		}
		if (updateProductDTO.getMarca() != null){
			product.setMarca(updateProductDTO.getMarca());
		}
		if (updateProductDTO.getCantidad() != null){
			product.setCantidad(updateProductDTO.getCantidad());
		}
		if (updateProductDTO.getPrecio() != null){
			product.setPrecio(updateProductDTO.getPrecio());
		}

		productRepository.save(product);
		return ProductMapper.domainToDto(product);
	}


	@Override
	public String deleteProduct(String id) throws ProductException {
		if (!productRepository.existsById(id)) throw new ProductException(String.format(Validations.PRODUCT_NOT_FOUND, id));

		productRepository.delete(productRepository.findById(id).get());

        return String.format(Validations.PRODUCT_DELETED, id);
	}
	
}


