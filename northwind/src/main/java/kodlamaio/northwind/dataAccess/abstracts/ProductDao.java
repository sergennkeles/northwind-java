package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

	// JpaRepository CRUD işlemlerini otomatik olarak yapan bir yapı. C sharpta bizim yazdığımız EfEntityRepositoryBase'le aynı işlemi yapıyor.
	// burada generic olarak <Product, Integer> nesnelerini alıyor. Product zaten bizim CRUD işlemlerinde kullanacağımız nesnemiz. Integer ise
	// Product nesnemizde Id alanın veritipini belirtmek için kullanılıyor. Çünkü veritabanı işlemlerini Id alanına göre yapacağız.
	// NOT: JpaRepository spring ile birlikte hazır olarak geldiği için bizi CRUD işlemlerini tek tek yazmaktan kurtarıyor :)
}
