package com.dungtran.bookstore.dto;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dungtran.bookstore.dao.SachDao;
import com.dungtran.bookstore.entities.Sach;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SachDto {
	
	private int id;
	
	private String tenSach;
	
	private String tacGia;
	
	private String nhaXuatBan;
	
	private int namXuatBan;
	
	private String theLoai;
	
	private long gia;
	
	private int idNguoiBan;
	
	private int soLuongTonKho;
	
	
}
