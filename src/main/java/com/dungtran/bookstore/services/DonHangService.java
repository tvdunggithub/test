package com.dungtran.bookstore.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dungtran.bookstore.dto.DonHangDto;
import com.dungtran.bookstore.entities.DonHang;

@Service
@Transactional
public interface DonHangService {
	
	public int save(DonHang donHang);

	 public DonHang convertDonHangDto(DonHangDto dhDto);
	 
	 public List<DonHang> getDonHang(int idNguoiMua);

	public List<DonHangDto> convertDonHang(List<DonHang> donHang);

}
