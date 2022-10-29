package com.dungtran.bookstore.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class DonHang {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private Date ngayDat;
	
	private Date ngayGiao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_nguoi_mua")
	private NguoiDung nguoiDung;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_dia_chi")
	private DiaChi diaChi;
	
	private String phone;
	
	private Long tongGia;
	
	@OneToMany(mappedBy="donHang")
	@JsonIgnore
	private List<ChiMucGioHang> gioHang;
	
}
