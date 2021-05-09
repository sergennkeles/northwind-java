package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
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
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return this.productDao.findAll();
	}

}
