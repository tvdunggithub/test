package com.dungtran.bookstore.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dungtran.bookstore.entities.NguoiDung;

@Service
@Transactional
public interface NguoiDungService {

	Optional<NguoiDung> findById(int idNguoiDung);

	List<NguoiDung> findByEmail(String email);

	NguoiDung save(NguoiDung nguoiDung);

}
