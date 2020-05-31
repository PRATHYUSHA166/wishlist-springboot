package com.cg.wishlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Login;
import com.cg.entity.Product;

import com.cg.entity.Wishlist;

import com.cg.wishlist.exception.WishlistException;
import com.cg.wishlist.service.WishlistService;

@RestController
@CrossOrigin("*")
public class WishlistController {
	@Autowired
	WishlistService wishlistService;
	
	@GetMapping("product/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable("id")int id) throws WishlistException
	{
		Product product=wishlistService.findProductrById(id);
		ResponseEntity<Product> wl=new ResponseEntity<>(product,HttpStatus.OK);
		return wl;
	}
		
	@GetMapping("product")
	public ResponseEntity<List<Product>> findAllProducts() throws WishlistException
	{
		List<Product> list = wishlistService.findAllProducts();
		ResponseEntity<List<Product>>  rt = new ResponseEntity<List<Product>>(list,HttpStatus.OK);
		return rt;
	}
	
	
	@PostMapping("product")
	public ResponseEntity<Product> createProduct(@RequestBody Product product)
	{
		Product t=wishlistService.createProduct(product);
		ResponseEntity<Product> tr=new ResponseEntity<Product>(t,HttpStatus.OK);
		return tr;
		

     }
	
		
	@GetMapping("wishlist")
	public ResponseEntity<List<Wishlist>> findAllWishlists() throws WishlistException
	{
		List<Wishlist> list = wishlistService.findAllWishlists();
		ResponseEntity<List<Wishlist>>  rt = new ResponseEntity<List<Wishlist>>(list,HttpStatus.OK);
		return rt;
	}
	
	
	@PostMapping("wishlist")
	public ResponseEntity<Wishlist> createWishlist(@RequestBody Wishlist wishlist)
	{
		Wishlist t=wishlistService.createWishlist(wishlist);
		
		ResponseEntity<Wishlist> wl=new ResponseEntity<Wishlist>(t,HttpStatus.OK);
		
		return wl;
	}
	@GetMapping("admin/login/{user}/{pass}")
	public ResponseEntity<Login>  findUserLogin(@PathVariable("user") String username, @PathVariable("pass") String password) throws WishlistException
	{
	  
		 Login log = wishlistService.findUser(username,password);
		 if(log==null) {
			 throw new WishlistException("Login not successful");
		 }
		 return new ResponseEntity<>(log,HttpStatus.OK);
		
		
	}
	}
		

    
	
	
 
	



