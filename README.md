# Spring project with MongoDB

Api rest application with mongoDB, in which a CRUD with Products is made.

## Methods GET

The method type Get, consists of 2 API's, get all the products and get a product by its ID, these will return simply the JSON of the products or the product.

You can access them through these URL's:

```bash
GET localhost:8080/products/getProducts
GET localhost:8080/products/getProduct/:id
```

## Method POST

The post method is used to create a new product and store it in the database. 

You can access them through these URL:

```bash
POST localhost:8080/products/createProduct
```

This method receives the following JSON structure in the body:

```bash
  {
    "name": "Botella de Agüa",
    "descripcion": "Botella de agua de 350ml",
    "marca": "Cristal",
    "cantidad": 12,
    "precio": 2500
  }
```
    
## Method UPDATE

The put method is used to update an existing product in the database.

You can access them through these URL:

```bash
PUT localhost:8080/products/updateProduct
```
This method receives the following JSON structure in the body:

```bash
{
    "id": "661b143fffec3c75b6f47ae7",
    "name": "Botella de Agüa Update",
    "descripcion": "Botella de agua de 350ml",
    "marca": "Cristal",
    "cantidad": 16,
    "precio": 3500
}
```
  
## Method PATCH

The PATCH method is used to apply partial modifications to a resource.

You can access them through these URL:

```bash
PATCH localhost:8080/products/patchProduct/:id
```

This method receives the following JSON structure in the body:

```bash
{
    "cantidad": 68
}
```

## Method DELETE

The DELETE method is used to delete a specified resource, which receives the id of the product in path

You can access them through these URL:

```bash
DELETE localhost:8080/products/deleteProduct/:id
```

## Method  OPTIONS

The OPTIONS method is used to describe the communication options for the target resource.

You can access them through these URL:

```bash
OPTIONS localhost:8080/products/optionsProduct
```

## Method HEAD

The HEAD method asks for a response identical to that of a GET request, but without the response body. It's useful for retrieving metadata.

You can access them through these URL:

```bash
HEAD localhost:8080/products/headerProduct/:ID
```

