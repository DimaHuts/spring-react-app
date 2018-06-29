package notebook.controller;

import java.util.List;

import notebook.controller.wrappers.DeleteByIdRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import notebook.entity.Product;
import notebook.service.ProductService;

@RestController
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/api/products/get")
	public List<Product> getAllProducts() {
		return productService.findAll();
	}
	
	@PostMapping("/api/product/create")
	public Product createPatient(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@PostMapping("/api/product/update")
	public Product updatePatient(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@PostMapping("/api/product/delete")
	public long updatePatient(@RequestBody DeleteByIdRequestWrapper requestWrapper) {
		return productService.deleteProduct(requestWrapper.getId());
	}
}
