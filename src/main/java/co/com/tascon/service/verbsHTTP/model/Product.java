package co.com.tascon.service.verbsHTTP.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Document(collection = "Products")
public class Product {

	@Id
    private String id;
	private String name;
	private String descripcion;
	private String marca;
	private Integer cantidad;
	private Float precio;
	
}