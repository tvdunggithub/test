package com.dungtran.bookstore.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dungtran.bookstore.entities.DonHang;

@Repository
public interface DonHangDao extends JpaRepository<DonHang, Integer> {
	
	@Query(value="SELECT id FROM bookstore.don_hang WHERE ngay_dat=:ngayDat AND id_nguoi_mua=:idNguoiMua",nativeQuery = true)
	public int getIdDonHang(Date ngayDat,int idNguoiMua);
	
	@Query(value="SELECT * FROM bookstore.don_hang WHERE id_nguoi_mua=:idNguoiMua",nativeQuery = true)
	public List<DonHang> getDonHang(int idNguoiMua);

}
