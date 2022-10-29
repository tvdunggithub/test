package com.dungtran.bookstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dungtran.bookstore.entities.NguoiDung;

@Repository
public interface NguoiDungDao extends JpaRepository<NguoiDung, Integer>  {

	List<NguoiDung> findByEmail(String email);
	

}
