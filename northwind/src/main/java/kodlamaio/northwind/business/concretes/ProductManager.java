package kodlamaio.northwind.business.concretes;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;

@Service // Bu annotation ile ProductManager classımızın service göre göreceğini belirtiyoruz.
public class ProductManager implements ProductService {

	private ProductDao productDao;
	
	@Autowired // Bu annotation ile otomatik instance oluşturmayı sağlıyoruz. Bunun bize avantajı şudur. instance oluşturulurken gerekli olan bağımlılıkları
	public ProductManager(ProductDao productDao) { // otomatik yapıyor. C sharptaki AutofacBusinessModule yapısı ile aynı görevi görüyor. Yani senden 
		super();									// ProductService istersem bana ProductManager ver buna bağlı olarak senden ProductDao istersem bana ProductDoa ver gibi
		this.productDao = productDao;
	}


	@Override
	public  DataResult<List<Product>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Ürünler Listelendi.") ;
	}


	@Override
	public Result add(Product product) {
		
		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi.");
	}


	@Override
	public DataResult<Product> getByProductName(String productName) {

		return new SuccessDataResult<Product>(productDao.getByProductName(productName),"Ürün ismine göre listelendi.");
	}


	@Override
	public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
		
		return new SuccessDataResult<Product>(productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Kategori İd'ye göre Ürün ismi listelendi.");
	}


	@Override
	public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),
				"Kategori id veya ürün ismine göre listelendi.");
	}


	@Override
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		
		return new SuccessDataResult<List<Product>>(productDao.getByCategoryIn(categories),
				"Kategori id  göre listelendi.");
	}


	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {

		return new SuccessDataResult<List<Product>>(productDao.getByProductNameContains(productName),
				"Ürün ismine göre filtrelendi.");
	}


	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {

		return new SuccessDataResult<List<Product>>(productDao.getByProductNameStartsWith(productName),
				" "+productName+" içeren ürünler listelendi.");
	}


	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(productDao.getByNameAndCategory_CategoryId(productName,categoryId),
				"Kategori Id ve Ürün adına göre listelendi.");
	}


	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {

		Pageable pageable=PageRequest.of(pageNo, pageSize);
		return new SuccessDataResult<List<Product>>(productDao.findAll(pageable).getContent());
	}


	@Override
	public DataResult<List<Product>> getAllSorted() {
		
		Sort sort=Sort.by(Sort.Direction.ASC,"productName");
		return new SuccessDataResult<List<Product>>(productDao.findAll(sort),"A-Z sıralandı.");
	}

}
