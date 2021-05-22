package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;

@RestController // Bu annotation ile ProductsController classımızın controller olduğunu belirttik.
@RequestMapping("api/products") // Bu annotation ile dış dünyadan istekte bulunulduğunda ProductsController'ın  cevap vereceğini belirttik.
public class ProductsController {

	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall") // Bu annotation ile istek attığımız methodların çalışmasını sağlıyoruz. C Sharptaki [HttpGet("getall")] ile aynı görevi görüyor.
	public  DataResult <List<Product>> getAll()
	{
		return this.productService.getAll();
	}
	
	@PostMapping("/add") // Bu annotation ile istek attığımız methodların çalışmasını sağlıyoruz. C Sharptaki [HttpPost("add")] ile aynı görevi görüyor.
	public Result  add(@RequestBody Product product)
	{
		return this.productService.add(product);
	}
	
	
}
