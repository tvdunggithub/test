package com.dungtran.bookstore.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DiaChi {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="Không được để trống xã")
	private String xa;
	
	@NotBlank(message="Không được để trống huyện")
	private String huyen;
	
	@NotBlank(message="Không được để trống thành phố")
	private String thanhPho;
	
	@NotEmpty(message="Không được để trống số nhà")
	private String soNha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_nguoi_dung")
	private NguoiDung nguoiDung;

}
