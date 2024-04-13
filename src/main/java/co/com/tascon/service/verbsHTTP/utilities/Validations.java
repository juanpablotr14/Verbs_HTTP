package co.com.tascon.service.verbsHTTP.utilities;

public class Validations {
	
	public final static String PRODUCT_ID_NOT_NULL = "ID del Producto no puede ser nulo";
	public final static String PRODUCT_ID_NOT_EMPTY = "ID del Producto no puede ser vacio";
	
	public final static String PRODUCT_NAME_NOT_NULL = "Nombre del Producto no puede ser nulo";
	public final static String PRODUCT_NAME_NOT_EMPTY = "Nombre del Producto no puede ser vacio";
	public final static String PRODUCT_NAME_NOT_VALID = "Nombre del Producto es invalido";
    public final static String PRODUCT_NAME_REGEX = "^[\\p{L}\\s'-]+$";
    
    public final static String PRODUCT_DESCRIPTION_NOT_NULL = "Descripcion del Producto no puede ser nulo";
    public final static String PRODUCT_DESCRIPTION_NOT_EMPTY = "Descripcion del Producto no puede ser vacio";
    public final static String PRODUCT_DESCRIPTION_SIZE = "La descripción debe tener como máximo 200 caracteres";
    
    public final static String PRODUCT_MARCA_NOT_NULL = "Marca del Producto no puede ser nulo";
    public final static String PRODUCT_MARCA_NOT_EMPTY = "Marca del Producto no puede ser vacio";
    public final static String PRODUCT_MARCA_NOT_VALID = "mARCA del Producto es invalido";
    public final static String PRODUCT_MARCA_REGEX = "^[\\p{L}\\s'-]+$";
    
    public final static String PRODUCT_PRECIO_NOT_NULL = "Precio del Producto no puede ser nulo";
	public final static String PRODUCT_PRECIO_NOT_EMPTY = "Precio del Producto no puede ser vacio";
	public final static String PRODUCT_PRECIO_MIN = "El precio debe ser mayor o igual a cero";
	public final static String PRODUCT_PRECIO_MAX = "El precio del producto no puede ser mayor a $300.000,00";

    public final static String PRODUCT_CANTIDAD_NOT_NULL = "Cantidad del Producto no puede ser nulo";
    public final static String PRODUCT_CANTIDAD_NOT_EMPTY = "Cantidad del Producto no puede ser vacio";
    public final static String PRODUCT_CANTIDAD_MIN = "La cantidad debe ser mayor a cero";
    public final static String PRODUCT_CANTIDAD_MAX = "La cantidad debe de ser menor a 100";
	
	public final static String PRODUCT_NOT_FOUND = "El producto con id %s no se ha encontrado";
    public final static String PRODUCT_DELETED = "Producto con id %s eliminado exitosamente!";
}
