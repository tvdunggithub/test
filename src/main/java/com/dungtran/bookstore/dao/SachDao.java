package com.dungtran.bookstore.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dungtran.bookstore.entities.Sach;

@Repository
public interface SachDao extends PagingAndSortingRepository<Sach, Integer> {

	public Optional<Sach> findById(int idSach);
	
	public Page<Sach> findAll(Pageable pageable);
	
	@Modifying
	@Query(value="UPDATE bookstore.sach SET gia=:gia WHERE id=:idSach",nativeQuery=true)
	public void saveGia(int idSach, long gia);


}
