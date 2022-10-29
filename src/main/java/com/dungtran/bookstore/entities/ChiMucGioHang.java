package com.dungtran.bookstore.entities;

import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ChiMucGioHang {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_nguoi_mua")
	private NguoiDung nguoiDung;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ma_don_hang")
	private DonHang donHang;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_sach")
	private Sach sach;
	
	@NotNull(message = "Vui Lòng thêm số lượng")
	@Min(value=1,message="Số lượng phải lớn hơn 0")
	private Integer soLuong;
	
	private Long donGia;
}
