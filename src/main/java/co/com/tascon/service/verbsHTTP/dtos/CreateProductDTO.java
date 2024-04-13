package co.com.tascon.service.verbsHTTP.dtos;

import co.com.tascon.service.verbsHTTP.utilities.Validations;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Data
@ToString
public class CreateProductDTO {
	
	@NotNull(message = Validations.PRODUCT_NAME_NOT_NULL)
    @NotBlank(message = Validations.PRODUCT_NAME_NOT_EMPTY)
    @Pattern(regexp = Validations.PRODUCT_NAME_REGEX, message = Validations.PRODUCT_NAME_NOT_VALID)
    private String name;

    @NotNull(message = Validations.PRODUCT_DESCRIPTION_NOT_NULL)
    @NotBlank(message = Validations.PRODUCT_DESCRIPTION_NOT_EMPTY)
    @Size(max = 200, message = Validations.PRODUCT_DESCRIPTION_SIZE)
    private String descripcion;

    @NotNull(message = Validations.PRODUCT_MARCA_NOT_NULL)
    @NotBlank(message = Validations.PRODUCT_MARCA_NOT_EMPTY)
    @Pattern(regexp = Validations.PRODUCT_MARCA_REGEX, message = Validations.PRODUCT_MARCA_NOT_VALID)
    private String marca;

    @NotNull(message = Validations.PRODUCT_CANTIDAD_NOT_NULL)
    @NotBlank(message = Validations.PRODUCT_CANTIDAD_NOT_EMPTY)
    @Min(value = 1, message = Validations.PRODUCT_CANTIDAD_MIN)
    @Max(value = 100, message = Validations.PRODUCT_CANTIDAD_MAX)
    private Integer cantidad;
    
    @NotNull(message = Validations.PRODUCT_PRECIO_NOT_NULL)
    @NotBlank(message = Validations.PRODUCT_PRECIO_NOT_EMPTY)
    @Min(value = 0, message = Validations.PRODUCT_PRECIO_MIN)
    @DecimalMax(value = "300000", inclusive = false, message = Validations.PRODUCT_PRECIO_MAX)
    private Float precio;
	
}
