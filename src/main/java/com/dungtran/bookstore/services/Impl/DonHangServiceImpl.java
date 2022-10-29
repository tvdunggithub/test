package com.dungtran.bookstore.services.Impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dungtran.bookstore.dao.ChiMucGioHangDao;
import com.dungtran.bookstore.dao.DiaChiDao;
import com.dungtran.bookstore.dao.DonHangDao;
import com.dungtran.bookstore.dao.NguoiDungDao;
import com.dungtran.bookstore.dto.DonHangDto;
import com.dungtran.bookstore.entities.DonHang;
import com.dungtran.bookstore.services.DonHangService;

@Service
@Transactional
public class DonHangServiceImpl implements DonHangService {

	@Autowired
	DonHangDao dhd;

	@Autowired
	DiaChiDao dd;

	@Autowired
	NguoiDungDao nd;
	
	@Autowired
	ChiMucGioHangDao cd;

	@Override
	public int save(DonHang donHang) {
		dhd.save(donHang);	
		int idDonHang = dhd.getIdDonHang(donHang.getNgayDat(), donHang.getNguoiDung().getId());
		return idDonHang;
	}

	@Override
	public DonHang convertDonHangDto(DonHangDto dhDto) {
		if (dhDto != null) {
			DonHang dh = new DonHang();
			dh.setDiaChi(dd.findById(dhDto.getIdDiaChi()).get());
			dh.setNguoiDung(nd.findById(dhDto.getIdNguoiMua()).get());
			dh.setPhone(dhDto.getPhone());
			Date dt = new Date();
			dh.setNgayDat(dt);
			dh.setNgayGiao(new Date(dt.getTime() + (1000 * 60 * 60 * 48)));
			dh.setTongGia(cd.tinhTongGia(dhDto.getIdNguoiMua()));
			return dh;
		} else
			return null;

	}

	@Override
	public List<DonHang> getDonHang(int idNguoiMua) {
		return dhd.getDonHang(idNguoiMua);
	}

	@Override
	public List<DonHangDto> convertDonHang(List<DonHang> donHang) {
		if(donHang!=null) {
			List<DonHangDto> dhDtos = new ArrayList<DonHangDto>();
			for(DonHang dh:donHang) {
				DonHangDto dhDto = new DonHangDto();
				dhDto.setIdDiaChi(dh.getDiaChi().getId());
				dhDto.setIdNguoiMua(dh.getNguoiDung().getId());
				dhDto.setPhone(dh.getPhone());
				dhDto.setTongGia(dh.getTongGia());
				dhDto.setNgayDat(dh.getNgayDat());
				dhDto.setNgayGiao(dh.getNgayGiao());
				dhDtos.add(dhDto);
			}
			return dhDtos;
		}else
			return null;
	}

}
