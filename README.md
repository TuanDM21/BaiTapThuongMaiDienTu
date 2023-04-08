- Giải thích ngắn gọn về các nguyên tắc, mẫu và thực hành phát triển phần mềm đang
được áp dụng. 

 1. Sử dụng các công cụ và framework phù hợp: Sử dụng các công cụ và framework như Spring boot, Hibernate, JPA,... để giúp quản lý và triển khai dự án một cách hiệu quả.
 2. Mô hình MVC: Tách biệt dữ liệu, hiển thị và xử lý logic.
 
 
 -  Giải thích ngắn gọn về cấu trúc mã.
 
 	Bao gồm folde resource và java
 	
resource: có file application.properties: chứa cấu hình kết nối database 
java : sẽ bao gồm package model : chứa mã nguồn thực thể
						  repository: dùng để làm việc trực tiếp với database
						  service: thực hiện nhiệm vụ xử lý chức năng
						  controller : hứng các ánh xạ mapping và điều hướng xử lý 
 - Các bước chạy trên máy cục bộ:
 	- Cài đặt java
 	- Cài đặt maven
 	- Cài đặt spring tool suice
 	- Tạo project Spring với spring tool suice
 	- Add dependency vào pom.xml để lấy thư viện cần dùng
 	
 	- Các api postman
 	
 	- Lấy tất cả sản phẩm:
 	*GET
 	http://localhost:8080/api/product/get-all
 	- Thêm mới một sản phẩm 
 	*POST
 	sử dụng form data với các param
    name: string
    price:double
    image: file ảnh 
   http://localhost:8080/api/product/add-product
   
   - Tìm kiếm sản phẩm 
    *GET 
   http://localhost:8080/api/product/search-product

   sử dụng param 
   *
   name:
   price: 
Tạo giỏ hàng cho một user mới:
POST http://localhost:8080/carts
Body:
{
“id": 1
}

Lấy thông tin giỏ hàng theo ID:
GET http://localhost:8080/carts/1

Lấy danh sách sản phẩm trong giỏ hàng theo ID giỏ hàng:
GET http://localhost:8080/carts/1/products

Thêm sản phẩm vào giỏ hàng:
POST http://localhost:8080/carts/1/products
Body:
{
"productId": 1,
"quantity": 2
}

Xóa sản phẩm khỏi giỏ hàng:
DELETE http://localhost:8080/carts/products/1

   
   
   
   
    
 	