package com.cg.wishlist.service;

import java.util.List;

import com.cg.entity.Login;
import com.cg.entity.Product;

import com.cg.entity.Wishlist;
import com.cg.wishlist.exception.WishlistException;


public interface WishlistService  {
	public Product findProductrById(int productId) throws WishlistException;
	public List<Product>  findAllProducts() throws WishlistException;
	public Product createProduct(Product product);
	public List<Wishlist>  findAllWishlists() throws WishlistException;
	public Wishlist createWishlist(Wishlist wishlist);
	public Login findUser(String username , String password) throws WishlistException;
	
	

}
