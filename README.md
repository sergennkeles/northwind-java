# northwind-java

Swagger'ı projeye dahil etmek için 

1- pom.xlm dosyasında dependencies altına aşağıdaki bağımlılıkları ekliyoruz ve kaydediyoruz.

		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
		</dependency>
   
 2- application dosyasında @EnableSwagger2 annotation'ı ekleyip kaydediyoruz.
    ![Adsız](https://user-images.githubusercontent.com/65495192/117571456-570f2680-b0d7-11eb-8bb1-be1d81ce8adc.png)

    
 3- application dosyasında sağ tık/ Run A Java Aplication deyip projeyi çalıştırıyoruz. Ardından tarayıcıya aşağıdaki url'i giriyoruz.
 http://localhost:8080/swagger-ui.html#/products-controller/getAllUsingGET

![image](https://user-images.githubusercontent.com/65495192/117571406-11eaf480-b0d7-11eb-965d-62cbecacf8c8.png)

    
    
