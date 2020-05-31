package com.cg.wishlist.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.cg.entity.User;

@Repository
public interface Userdao  extends JpaRepository<User, Integer> {

}
