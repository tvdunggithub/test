package com.dungtran.bookstore.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dungtran.bookstore.dao.SachDao;
import com.dungtran.bookstore.dto.SachDto;
import com.dungtran.bookstore.entities.Sach;

@Service
@Transactional
public interface SachService {

	public Optional<Sach> finById(int idSach);
	
	public Page<Sach> getAllSach(Pageable pageable);
	
	public Page<SachDto> convertPageDtos(Pageable pageable);
	
	public void saveGia(int idSach,long gia);
	
	

}
