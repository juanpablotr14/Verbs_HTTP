package co.com.tascon.service.verbsHTTP.dtos;

import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Data
@ToString
public class ProductDTO {
	private String id;
	private String name;
	private String descripcion;
	private String marca;
	private Integer cantidad;
	private Float precio;
}
