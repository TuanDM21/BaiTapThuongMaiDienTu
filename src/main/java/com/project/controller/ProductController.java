package com.project.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.project.model.Category;
import com.project.model.Product;
import com.project.service.ProductService;

@RestController
@RequestMapping(value = "/api/product")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {

	@Autowired
	ProductService<Product> ProductS;

	@GetMapping("/get-all")
	public List<Product> getAllProduct() {
		List<Product> listProduct = ProductS.getAllProduct();
		return listProduct;
	}

	@GetMapping("/search-product")
	public List<Product> searchProduct(@RequestParam("name") String name, @RequestParam("price") Double price) {
		List<Product> listProduct = ProductS.searchProduct(name, price);
		return listProduct;
	}

	@PostMapping(value = "/add-product", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Product> addProduct(@RequestParam("name") String name, @RequestParam("price") Double price,
			@RequestParam("image") MultipartFile file) throws IOException {
		Map config = new HashMap();
		config.put("cloud_name", "dievwugng");
		config.put("api_key", "545288197387692");
		config.put("api_secret", "SEGV-RhGf3vr7I9LehlifNGnJ4E");
		Cloudinary cloudinary = new Cloudinary(config);
		Product product = new Product();

		File myfile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(myfile);
		fos.write(file.getBytes());
		fos.close();

		// Upload
		try {
			var url = cloudinary.uploader().upload(myfile, ObjectUtils.emptyMap());
			product.setImage(url.get("secure_url").toString());
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		}
		Category category = new Category();
		category.setId((long) 1);
		product.setCategory(category);
		product.setPrice(price);
		product.setName(name);
		return new ResponseEntity<Product>(ProductS.SaveOrUpdate(product), HttpStatus.OK);
	}

}
