package kodlamaio.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //lombakdan geliyor. Bizim için getter ve setterları otomatik oluşturuyor.
@Entity //çıplak class kalmasın mantığı. Bu annotation ile class'ın referansını tutuyoruz. C sharptaki IEntity gibi
@Table(name="products") // Product nesnemizin veritabanındaki hangi tabloya karşılıl geldiğini belirtiyoruz.
@NoArgsConstructor //Parametresiz Constructor üretir.
@AllArgsConstructor //Sınıfın Constructorını üretir.Bu Constructor sınıftaki tüm fieldleri parametre olarak almıştır.
public class Product {

	
	@Id // Bu annotation ile de product nesnemizdeki Id alanın hangisi olduğunu belirtiyoruz. Veritabanı işlemlerini bu annotation ile belirtilen alana göre yapıyoruz
	@GeneratedValue // Bu annotation ile Id alanını birer birer otomatik artacağını belirtiyoruz. C sharp tarafında daha doğrusu Sql server da identity özelliğine denk geliyor.
	@Column(name = "product_id") // Bu annotation ile product nesnemizdeki alanlar ile tablomuzdaki alanları eşleştiriyoruz.
	private int id;				// burada eşleştirme yaparken büyük-küçük harfe dikkat ediyoruz.
	
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "unit_price")
	private double unitPrice;
	
	@Column(name = "units_in_stock")
	private short unitsInStock;
	
	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;
	
}
