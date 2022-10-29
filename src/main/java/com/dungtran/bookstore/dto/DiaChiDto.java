package com.dungtran.bookstore.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;

import com.dungtran.bookstore.entities.DiaChi;
import com.dungtran.bookstore.entities.NguoiDung;
import com.dungtran.bookstore.services.NguoiDungService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiaChiDto {
	
	private int id;
	
	@NotBlank(message="Không được để trống xã")
	private String xa;
	
	@NotBlank(message="Không được để trống huyện")
	private String huyen;
	
	@NotBlank(message="Không được để trống thành phố")
	private String thanhPho;
	
	@NotEmpty(message="Không được để trống số nhà")
	private String soNha;
	
	private int idNguoiDung;
	
	


}
