package com.dungtran.bookstore.services.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dungtran.bookstore.dao.DiaChiDao;
import com.dungtran.bookstore.dto.DiaChiDto;
import com.dungtran.bookstore.entities.DiaChi;
import com.dungtran.bookstore.entities.NguoiDung;
import com.dungtran.bookstore.services.DiaChiService;

@Service
@Transactional
public class DiaChiServiceImpl implements DiaChiService {
	
	@Autowired
	DiaChiDao dd;

	@Override
	public List<DiaChi> getDiaChi(int idNguoiDung) {
		return dd.getDiaChi(idNguoiDung);
	}

	@Override
	public void save(DiaChi dc) {
		dd.save(dc);		
	}

	@Override
	public void delete(int idDiaChi) {
		dd.deleteById(idDiaChi);
		
	}
	
	@Override
	public List<DiaChiDto> convertDiaChi(List<DiaChi> dcs){
		List<DiaChiDto> dcDtos = new ArrayList<DiaChiDto>();
		if(dcs!=null) {
			for(DiaChi dc:dcs) {
				DiaChiDto dcDto = new DiaChiDto();
				dcDto.setId(dc.getId());
				dcDto.setXa(dc.getXa());
				dcDto.setHuyen(dc.getHuyen());
				dcDto.setThanhPho(dc.getThanhPho());
				dcDto.setSoNha(dc.getSoNha());
				dcDto.setIdNguoiDung(dc.getNguoiDung().getId());
				dcDtos.add(dcDto);
			}
			return dcDtos;
		}	
		return null;
	}
	
	@Override
	public DiaChi convertDiaChiDto(DiaChiDto dcDto,NguoiDung nguoiDung){
		DiaChi dc = new DiaChi();
		if(dcDto!=null) {
			dc.setId(dcDto.getId());
			dc.setXa(dcDto.getXa());
			dc.setHuyen(dcDto.getHuyen());
			dc.setThanhPho(dcDto.getThanhPho());
			dc.setSoNha(dcDto.getSoNha());
			dc.setNguoiDung(nguoiDung);
			return dc;
		}	
		return null;
	}


}
