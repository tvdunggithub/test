package com.dungtran.bookstore.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sach {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String tenSach;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_tac_gia")
	private TacGia tacGia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_nha_xuat_ban")
	private NhaXuatBan nhaXuatBan;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_the_loai")
	private TheLoai theLoai;
	
	private int namXuatBan;
	
	@Min(value=1000,message="Gía sách phải lớn hơn 1000")
	private long gia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="nguoi_ban")
	private NguoiDung nguoiDung;
	
	@OneToMany(mappedBy="sach")
	@JsonIgnore
	private List<ChiMucGioHang> chiMuc;	
	
	private int soLuongTonKho;

}
