package com.dungtran.bookstore.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dungtran.bookstore.dto.ChiMucGioHangDto;
import com.dungtran.bookstore.entities.ChiMucGioHang;

@Service
@Transactional
public interface ChiMucGioHangService {
	
	public List<ChiMucGioHang> findGioHang(int idNguoiDung);

	public void save(ChiMucGioHang chiMuc,int idNguoiMua, int idSach);
	
	public void update(int idNguoiMua,int idSach,int soLuong);

	public void delete(int idChiMuc);
	
	public List<ChiMucGioHangDto> convertChiMuc(List<ChiMucGioHang> cms);

	public long tinhTongGia(int idNguoiDung);
	
	public void updateMaDonHang(int maDonHang,int idNguoiMua);

}
