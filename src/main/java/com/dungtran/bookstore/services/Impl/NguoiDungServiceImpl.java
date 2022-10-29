package com.dungtran.bookstore.services.Impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dungtran.bookstore.dao.NguoiDungDao;
import com.dungtran.bookstore.entities.NguoiDung;
import com.dungtran.bookstore.services.NguoiDungService;

@Service
@Transactional
public class NguoiDungServiceImpl implements NguoiDungService {
	
	@Autowired
	NguoiDungDao ndd;

	@Override
	public Optional<NguoiDung> findById(int idNguoiDung) {
		return ndd.findById(idNguoiDung);
	}

	@Override
	public List<NguoiDung> findByEmail(String email) {
		return ndd.findByEmail(email);
	}

	@Override
	public NguoiDung save(NguoiDung nguoiDung) {
		return ndd.save(nguoiDung);
	}

}
