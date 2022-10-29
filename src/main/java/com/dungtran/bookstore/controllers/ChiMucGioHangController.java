package com.dungtran.bookstore.controllers;

import java.util.List;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dungtran.bookstore.dto.ChiMucGioHangDto;
import com.dungtran.bookstore.entities.ChiMucGioHang;
import com.dungtran.bookstore.entities.NguoiDung;
import com.dungtran.bookstore.entities.Sach;
import com.dungtran.bookstore.services.ChiMucGioHangService;
import com.dungtran.bookstore.services.NguoiDungService;
import com.dungtran.bookstore.services.SachService;

@RestController
public class ChiMucGioHangController {
	
		@Autowired
		ChiMucGioHangService cs;
		
		@Autowired
		NguoiDungService ns;
		
		@Autowired
		SachService ss;
		
		//Chưa thanh toán thì mã đơn hàng = 0 với dto, với bảng dưới db = null
		@GetMapping("/gioHang")
		public List<ChiMucGioHangDto> getGioHang(@RequestParam int idNguoiDung){
			List<ChiMucGioHangDto> cmDtos = cs.convertChiMuc(cs.findGioHang(idNguoiDung));
			return cmDtos;
		}
		
		//add số lượng và đơn giá, thông tin chỉ mục truyền vào body chỉ bao gồm số lượng(soLuong)
		@PostMapping("/gioHang/add")
		public ResponseEntity<String> addGioHang(@RequestBody @Valid ChiMucGioHang chiMuc,
				@RequestParam int idNguoiDung,
				@RequestParam int idSach) {
			cs.save(chiMuc, idNguoiDung, idSach);
			return ResponseEntity.ok("Thêm thành công");
		}
		
		
		@DeleteMapping("/gioHang/delete")
		public ResponseEntity<String> deleteGioHang(@RequestParam int idChiMuc){
			cs.delete(idChiMuc);
			return ResponseEntity.ok("Xóa thành công");
		}
		
		//update số lượng và đơn giá, thông tin chỉ mục truyền vào body chỉ bao gồm số lượng(soLuong)
		@PutMapping("/gioHang/edit")
		public ResponseEntity<String> editGioHang(@RequestBody @Valid ChiMucGioHangDto chiMuc,
				@RequestParam int idNguoiDung,
				@RequestParam int idSach){
			cs.update(idNguoiDung,idSach, chiMuc.getSoLuong());
			return ResponseEntity.ok("Sửa thành công");
		}
}
