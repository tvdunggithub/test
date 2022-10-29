package com.dungtran.bookstore.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dungtran.bookstore.dao.ChiMucGioHangDao;
import com.dungtran.bookstore.dto.DonHangDto;
import com.dungtran.bookstore.entities.DonHang;
import com.dungtran.bookstore.services.ChiMucGioHangService;
import com.dungtran.bookstore.services.DonHangService;

@RestController
public class DonHangController {
	
	@Autowired
	DonHangService dhs;
	
	@Autowired
	ChiMucGioHangService cs;
	
	//body bao gồm idNguoiMua, idDiaChi, phone
	//lưu thông tin đơn hàng xuống db sau đó set mã đơn hàng(chưa thanh toán mã đơn hàng = null)
	@PostMapping("/donHang/thanhToan")
	public ResponseEntity<String> thanhToan(@RequestBody @Valid DonHangDto dhDto){
		DonHang dh = dhs.convertDonHangDto(dhDto);
		int idDonHang = dhs.save(dh);
		cs.updateMaDonHang(idDonHang, dhDto.getIdNguoiMua());
		return ResponseEntity.ok("Đơn hàng của bạn đang được giao");		
	}
	
	//lấy toàn bộ đơn hàng của người dùng
	@GetMapping("/donHang")
	public List<DonHangDto> getDonHang(@RequestParam int idNguoiDung){
		return dhs.convertDonHang(dhs.getDonHang(idNguoiDung));
	}
	

}
