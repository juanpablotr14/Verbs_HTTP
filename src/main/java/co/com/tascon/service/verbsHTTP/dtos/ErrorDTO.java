package co.com.tascon.service.verbsHTTP.dtos;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ErrorDTO {
	private String error;
}
