package com.dungtran.bookstore.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dungtran.bookstore.dto.SachDto;
import com.dungtran.bookstore.entities.Sach;
import com.dungtran.bookstore.services.SachService;

@RestController
public class SachController {
	
	@Autowired
	SachService ss;
	
	@Value("${web.page.size}")
	private int webPage;
	
	@GetMapping("/sach")
	public Page<SachDto> getSach(@RequestParam(name = "page", required = false) Optional<Integer> page){
		Page<SachDto> sDtos = ss.convertPageDtos(PageRequest.of(page.orElse(0), webPage));
		return sDtos;
	}
	
	//sửa giá, body chỉ bao gồm giá(gia)
	@PutMapping("/giaSach/edit")
	public String editGiaSach(@RequestParam(name = "idSach", required = true)int idSach,
			@RequestBody @Valid Sach sach) {
		ss.saveGia(idSach, sach.getGia());
		return "Sửa thành công";
	}
	
	@GetMapping("/sach/sortByGia")
	public Page<SachDto> getSachSortByGia(@RequestParam(name = "page", required = false) Optional<Integer> page){
		Page<SachDto> sDtos = ss.convertPageDtos(PageRequest.of(page.orElse(0), webPage, Sort.by("gia").descending()));
		return sDtos;
	}

}
