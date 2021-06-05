package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@CrossOrigin
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
	
	@GetMapping("/getByProductName") 
	public  DataResult <Product> getByProductName(@RequestParam String productName) //  @RequestParam businessdaki method da olan parametreyi okumak için kullandık.
	{
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getByProductNameAndCategoryId") 
	public  DataResult <Product> getByProductNameAndCategory(@RequestParam("productName")  String productName, @RequestParam("categoryId") int categoryId)
	{
		return this.productService.getByProductNameAndCategory(productName,categoryId);
	}
	
	@GetMapping("/getByProductNameOrCategoryId") 
	public  DataResult <List<Product>> getByProductNameOrCategory(@RequestParam  String productName, @RequestParam int categoryId)
	{
		return this.productService.getByProductNameOrCategory(productName,categoryId);
	}
	
	@GetMapping("/getByCategoryIdIn") 
	public  DataResult <List<Product>> getByCategoryIn(@RequestParam  List<Integer> categories)
	{
		return this.productService.getByCategoryIn(categories);
	}
	
	@GetMapping("/getByProductNameContains") 
	public  DataResult <List<Product>> getByProductNameContains(@RequestParam  String productName)
	{
		return this.productService.getByProductNameContains(productName);
	}
	
	@GetMapping("/getByProductNameStartsWith") 
	public  DataResult <List<Product>> getByProductNameStartsWith(@RequestParam  String productName)
	{
		return this.productService.getByProductNameStartsWith(productName);
	}
	
	@GetMapping("/getByNameAndCategory") 
	public  DataResult <List<Product>> getByNameAndCategory(@RequestParam  String productName, @RequestParam int categoryId)
	{
		return this.productService.getByNameAndCategory(productName,categoryId);
	}
	
	@GetMapping("/getAllByPage") 
	public  DataResult <List<Product>> getAllByPage(int pageNo,int pageSize)
	{
		return this.productService.getAll(pageNo-1,pageSize); // index 0 dan başladığı için pageNo-1 yaptık.
	}
	
	@GetMapping("/getAllSortedAsc") 
	public  DataResult <List<Product>> getAllSorted()
	{
		return this.productService.getAllSorted(); // index 0 dan başladığı için pageNo-1 yaptık.
	}
	
	@GetMapping("/getProductWithCategoryDetails") 
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails()
	{
		return productService.getProductWithCategoryDetails();
	}
}
