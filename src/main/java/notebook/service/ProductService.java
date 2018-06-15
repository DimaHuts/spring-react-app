package notebook.service;

import java.util.List;

import notebook.entity.Product;

public interface ProductService {
	List<Product> findAll();
	Product saveProduct(Product product);
}
