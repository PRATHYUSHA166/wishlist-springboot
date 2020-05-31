package com.cg.wishlist.dao;



import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.cg.entity.Wishlist;

@Repository
public interface WishlistDao extends JpaRepository<Wishlist, Integer> {

	

}
