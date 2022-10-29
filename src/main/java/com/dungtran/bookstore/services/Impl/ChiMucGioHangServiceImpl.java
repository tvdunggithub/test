package com.dungtran.bookstore.services.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dungtran.bookstore.dao.ChiMucGioHangDao;
import com.dungtran.bookstore.dao.NguoiDungDao;
import com.dungtran.bookstore.dao.SachDao;
import com.dungtran.bookstore.dto.ChiMucGioHangDto;
import com.dungtran.bookstore.entities.ChiMucGioHang;
import com.dungtran.bookstore.entities.NguoiDung;
import com.dungtran.bookstore.entities.Sach;
import com.dungtran.bookstore.services.ChiMucGioHangService;

@Service
@Transactional
public class ChiMucGioHangServiceImpl implements ChiMucGioHangService {

	@Autowired
	ChiMucGioHangDao cd;

	@Autowired
	SachDao sd;

	@Autowired
	NguoiDungDao nd;

	@Override
	public List<ChiMucGioHang> findGioHang(int idNguoiDung) {
		return cd.layGioHang(idNguoiDung);
	}

	@Override
	public void save(ChiMucGioHang chiMuc, int idNguoiMua, int idSach) {
		ChiMucGioHang cm = cd.layChiMuc(idNguoiMua, idSach);
		//nếu chỉ mục có trong giỏ hàng (cm!=null) + thêm số lượng, ko thì thêm mới vào
		NguoiDung nguoiMua = nd.findById(idNguoiMua).get();
		Sach sach = sd.findById(idSach).get();
		if (cm == null) {
			chiMuc.setNguoiDung(nguoiMua);
			chiMuc.setSach(sach);
			chiMuc.setDonGia(sach.getGia() * chiMuc.getSoLuong());
			cd.save(chiMuc);
		} else {
			int soLuong = chiMuc.getSoLuong() + cm.getSoLuong();
			long donGia = soLuong*sach.getGia();
			cd.updateChiMuc(cm.getId(), soLuong, donGia);
		}

	}

	@Override
	public void delete(int idChiMuc) {
		cd.deleteById(idChiMuc);

	}

	@Override
	public void update(int idNguoiMua, int idSach,int soLuong) {
		//lấy id chỉ mục bằng idNguoiMua, idSach và maDonHang=null sau đó update số lượng và giá
		ChiMucGioHang cm = cd.layChiMuc(idNguoiMua, idSach);
		Sach sach = sd.findById(idSach).get();
		Long donGia = sach.getGia()*soLuong;
		cd.updateChiMuc(cm.getId(),soLuong ,donGia);
	}
	
	@Override
	public List<ChiMucGioHangDto> convertChiMuc(List<ChiMucGioHang> cms) {
		List<ChiMucGioHangDto> cmDtos = new ArrayList<ChiMucGioHangDto>();
		if (cms != null) {
			for (ChiMucGioHang cm : cms) {
				ChiMucGioHangDto cmDto = new ChiMucGioHangDto();
				cmDto.setId(cm.getId());
				cmDto.setIdNguoiDung(cm.getNguoiDung().getId());
				cmDto.setIdSach(cm.getSach().getId());
				cmDto.setSoLuong(cm.getSoLuong());
				cmDto.setDonGia(cm.getDonGia());
				cmDtos.add(cmDto);
			}
			return cmDtos;
		} else
			return null;
	}
	
	@Override
	public long tinhTongGia(int idNguoiDung) {
		long tongGia = cd.tinhTongGia(idNguoiDung);
		return tongGia;
	}

	@Override
	public void updateMaDonHang(int maDonHang, int idNguoiMua) {
		cd.updateMaDonHang(maDonHang, idNguoiMua);		
	}

}
