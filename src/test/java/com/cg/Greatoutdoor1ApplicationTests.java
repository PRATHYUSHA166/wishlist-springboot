package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entity.Product;
import com.cg.entity.Wishlist;
import com.cg.wishlist.dao.ProductDao;
import com.cg.wishlist.dao.Userdao;
import com.cg.wishlist.dao.WishlistDao;
import com.cg.wishlist.exception.WishlistException;
import com.cg.wishlist.service.WishlistService;

@SpringBootTest
class Greatoutdoor1ApplicationTests {
   
   @Autowired
   private WishlistService wishlistservice;
   
   @MockBean
   private WishlistDao wishlistdao;
    
   @MockBean
   private ProductDao productdao;
   
   @MockBean
   private Userdao userdao;
   
	@Test
	void contextLoads() {
	}
 
	@Test
	public void getProductsTest() throws WishlistException{
		when(productdao.findAll()).thenReturn(Stream.of(new Product()).collect(Collectors.toList()));
		assertEquals(1,wishlistservice.findAllProducts().size());
		
	}
	@Test
	public void getWishlistsTest() throws WishlistException{
	when(wishlistdao.findAll()).thenReturn(Stream.of(new Wishlist()).collect(Collectors.toList()));
	assertEquals(1,wishlistservice.findAllWishlists().size());
		
	}
}
