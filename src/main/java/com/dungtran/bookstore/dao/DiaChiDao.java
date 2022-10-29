package com.dungtran.bookstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dungtran.bookstore.entities.DiaChi;

@Repository
public interface DiaChiDao extends JpaRepository<DiaChi, Integer> {
	
	@Query(value="SELECT * FROM bookstore.dia_chi WHERE id_nguoi_dung=:idNguoiDung",nativeQuery = true)
	public List<DiaChi> getDiaChi(int idNguoiDung);
	

}
