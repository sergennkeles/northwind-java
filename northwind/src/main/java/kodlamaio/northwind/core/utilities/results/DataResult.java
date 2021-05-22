package kodlamaio.northwind.core.utilities.results;

public class DataResult<TEntity> extends Result {

	private TEntity data;
	public DataResult(TEntity data, boolean success, String message) {
		super(success, message); // bu kullanım ise superclassdaki (Result yani) constructorı tetikleyerek ilgili alanlara veriyi set eder
		this.data=data;
		
	}
	public DataResult(TEntity data, boolean success) {
		super(success);
		this.data=data;
		
	}

	public TEntity getData() {
		return this.data;
	}

}
