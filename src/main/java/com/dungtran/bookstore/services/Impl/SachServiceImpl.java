package com.dungtran.bookstore.services.Impl;

import java.util.Optional;
import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dungtran.bookstore.dao.SachDao;
import com.dungtran.bookstore.dto.SachDto;
import com.dungtran.bookstore.entities.Sach;
import com.dungtran.bookstore.services.SachService;

@Service
@Transactional
public class SachServiceImpl implements SachService {
	
	@Autowired
	SachDao sd;

	@Override
	public Optional<Sach> finById(int idSach) {
		return sd.findById(idSach);
	}

	@Override
	public Page<Sach> getAllSach(Pageable pageable) {
		return sd.findAll(pageable);
	}
	
	@Override
	public Page<SachDto> convertPageDtos(Pageable pageable){
		Page<Sach> sachPage = sd.findAll(pageable);
		Page<SachDto> dtoPage = sachPage.map(new Function<Sach, SachDto>() {
			@Override
			public SachDto apply(Sach s) {
				SachDto sDto = new SachDto();
				sDto.setId(s.getId());
				sDto.setTenSach(s.getTenSach());
				sDto.setTacGia(s.getTacGia().getNgheDanh());
				sDto.setNamXuatBan(s.getNamXuatBan());
				sDto.setNhaXuatBan(s.getNhaXuatBan().getTen());
				sDto.setTheLoai(s.getTheLoai().getTheLoai());
				sDto.setGia(s.getGia());
				sDto.setIdNguoiBan(s.getNguoiDung().getId());
				sDto.setSoLuongTonKho(s.getSoLuongTonKho());
				return sDto;
			}
		});
		return dtoPage;		
	}

	@Override
	public void saveGia(int idSach,long gia) {
		sd.saveGia(idSach,gia);		
	}

}
