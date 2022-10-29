package com.dungtran.bookstore.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class NguoiDung {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Email(message="Vui lòng nhập email chính xác")
	@NotBlank(message="Không được để trống email")
	private String email;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NotBlank(message="Không được để trống password")
	private String password;
	
	@OneToMany(mappedBy="nguoiDung")
	@JsonIgnore
	private List<DiaChi> diachi;
	
	@NotBlank(message="Vui lòng nhập số phone")
	private String phone;
	
	private Date ngayTao;
	
    @OneToMany(mappedBy="nguoiDung",fetch=FetchType.EAGER)
    @JsonIgnore
	private Set<Authorities> vaiTro;
	
	@OneToMany(mappedBy="nguoiDung")
	@JsonIgnore
	private List<DonHang> donHang;
	
	@OneToMany(mappedBy="nguoiDung")
	@JsonIgnore
	private List<ChiMucGioHang> gioHang;
	
	@OneToMany(mappedBy="nguoiDung")
	@JsonIgnore
	private List<Sach> sachDangBan;

}
