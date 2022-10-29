package com.dungtran.bookstore.dto;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DonHangDto {
	
	@Min(value=1,message="Id Người mua phải lớn hơn 0")
	private int idNguoiMua;
	
	@Min(value=1,message="Id Người mua phải lớn hơn 0")
	private int idDiaChi;
	
	@NotBlank(message="Số điện thoại không được để trống")
	private String phone;
	
	private long tongGia;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date ngayDat;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date ngayGiao;
	
}
