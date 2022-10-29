package com.dungtran.bookstore.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dungtran.bookstore.dto.DiaChiDto;
import com.dungtran.bookstore.entities.DiaChi;
import com.dungtran.bookstore.entities.NguoiDung;

@Service
@Transactional
public interface DiaChiService {
	
	public List<DiaChi> getDiaChi(int idNguoiDung);

	public void save(DiaChi dc);

	public void delete(int idDiaChi);
	
	public List<DiaChiDto> convertDiaChi(List<DiaChi> dcs);
	
	public DiaChi convertDiaChiDto(DiaChiDto dcDto,NguoiDung nguoiDung);


}
