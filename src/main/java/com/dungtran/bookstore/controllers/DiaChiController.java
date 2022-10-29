package com.dungtran.bookstore.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dungtran.bookstore.dto.DiaChiDto;
import com.dungtran.bookstore.entities.DiaChi;
import com.dungtran.bookstore.entities.NguoiDung;
import com.dungtran.bookstore.services.DiaChiService;
import com.dungtran.bookstore.services.NguoiDungService;

@RestController
public class DiaChiController {
	
	@Autowired
	DiaChiService ds;
	
	@Autowired
	NguoiDungService ns;
	
	@GetMapping("/diaChi")
	public List<DiaChiDto> getDiaChi(@RequestParam int idNguoiDung) {
		List<DiaChiDto> dcDtos = ds.convertDiaChi(ds.getDiaChi(idNguoiDung));
		return dcDtos;	
	}
	
	//thêm địa chỉ body bao gồm (xa,huyen,thanhPho,soNha)
	@PostMapping("/diaChi/add")
	public String addDiaChi(@RequestParam int idNguoiDung,
			@RequestBody @Valid DiaChiDto dcDto) {
		DiaChi dc = ds.convertDiaChiDto(dcDto, ns.findById(idNguoiDung).get());
		ds.save(dc);
		return "Thêm thành công";
	}
	
	@DeleteMapping("/diaChi/delete")
	public String deleteDiaChi(@RequestParam int idDiaChi) {
		ds.delete(idDiaChi);
		return "Xóa Thành Công";
	}
	

}
