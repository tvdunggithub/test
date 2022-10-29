package com.dungtran.bookstore.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.dungtran.bookstore.entities.ChiMucGioHang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChiMucGioHangDto {

	private int id;

	private int idNguoiDung;

	private int maDonHang;

	private int idSach;

	@NotNull(message = "Vui Lòng thêm số lượng")
	@Min(value=1,message="Số lượng phải lớn hơn 0")
	private int soLuong;

	private Long donGia;


}
