package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

	// JpaRepository CRUD işlemlerini otomatik olarak yapan bir yapı. C sharpta bizim yazdığımız EfEntityRepositoryBase'le aynı işlemi yapıyor.
	// burada generic olarak <Product, Integer> nesnelerini alıyor. Product zaten bizim CRUD işlemlerinde kullanacağımız nesnemiz. Integer ise
	// Product nesnemizde Id alanın veritipini belirtmek için kullanılıyor. Çünkü veritabanı işlemlerini Id alanına göre yapacağız.
	// NOT: JpaRepository spring ile birlikte hazır olarak geldiği için bizi CRUD işlemlerini tek tek yazmaktan kurtarıyor :)
	
	Product getByProductName(String productName);// Bu methodlar'ın sql sorgusu jparespository tarafından otomatik olarak
	// yazılıyor. Burada getBy kısmını gören jparepository,	devamında gelen ProductName kısmını entitydeki alan adıyla eşleştirip 
	// buna göre where ile ilgili alan için sql sorgusunu otomatik hazırlıyor.
	
	Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);
	
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	//NOT: isimlendirmelere dikkat. getBy, And, Or, In, Contains, StartsWith jparepository'nin izleyip Alan adına göre sql sorguları oluşturmasını sağlayan keywordlerdir.
	
	@Query("From Product where productName=:productName and category.categoryId=:categoryId") 
	// bu annotation ile sql sorgusunu (jpql) kendimiz de yazabiliriz. : işaretinden sonra gelen productName parametreden gelen productNamedir. Yani burada sorguyu parametreden gelen productName'e göre yap demek.
	List<Product> getByNameAndCategory_CategoryId(String productName,int categoryId);
	
}
