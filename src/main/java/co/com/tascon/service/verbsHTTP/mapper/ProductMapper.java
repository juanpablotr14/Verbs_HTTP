package co.com.tascon.service.verbsHTTP.mapper;

import co.com.tascon.service.verbsHTTP.dtos.CreateProductDTO;
import co.com.tascon.service.verbsHTTP.dtos.ProductDTO;
import co.com.tascon.service.verbsHTTP.dtos.UpdateProductDTO;
import co.com.tascon.service.verbsHTTP.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static List<ProductDTO> domainToDtoList(List<Product> products) {
        return products.stream().map(product -> domainToDto(product)).collect(Collectors.toList());
    }

    public static Product updateProductDtoToDomain(UpdateProductDTO updateProductDTO) {
        return Product.builder()
                .id(updateProductDTO.getId())
                .id(updateProductDTO.getId())
                .name(updateProductDTO.getName())
                .descripcion(updateProductDTO.getDescripcion())
                .marca(updateProductDTO.getMarca())
                .cantidad(updateProductDTO.getCantidad())
                .precio(updateProductDTO.getPrecio())
                .build();
    }

    public static Product createProductDtoToDomain(CreateProductDTO createProductDTO) {
        return Product.builder()
                .name(createProductDTO.getName())
                .descripcion(createProductDTO.getDescripcion())
                .marca(createProductDTO.getMarca())
                .cantidad(createProductDTO.getCantidad())
                .precio(createProductDTO.getPrecio())
                .build();
    }

	public static ProductDTO domainToDto(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .descripcion(product.getDescripcion())
                .marca(product.getMarca())
                .cantidad(product.getCantidad())
                .precio(product.getPrecio())
                .build();
    }

}
