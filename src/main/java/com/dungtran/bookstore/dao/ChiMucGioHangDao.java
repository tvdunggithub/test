package com.dungtran.bookstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dungtran.bookstore.entities.ChiMucGioHang;

@Repository
public interface ChiMucGioHangDao extends JpaRepository<ChiMucGioHang, Integer> {
	
	@Query(value="SELECT * FROM bookstore.chi_muc_gio_hang WHERE id_nguoi_mua=:id AND ma_don_hang is null", nativeQuery=true)
	public List<ChiMucGioHang> layGioHang(int id);
	
	@Query(value="SELECT * FROM bookstore.chi_muc_gio_hang WHERE id_nguoi_mua=:idNguoiMua AND id_sach=:idSach And ma_don_hang is null", nativeQuery=true)
	public ChiMucGioHang layChiMuc(int idNguoiMua,int idSach);
	
	@Modifying
	@Query(value="UPDATE bookstore.chi_muc_gio_hang SET don_gia=:donGia,so_luong=:soLuong WHERE id=:id ", nativeQuery=true)
	public void updateChiMuc(int id,int soLuong,long donGia);
	
	@Query(value="SELECT SUM(don_gia) FROM bookstore.chi_muc_gio_hang WHERE id_nguoi_mua=:idNguoiMua AND ma_don_hang is null",nativeQuery = true)
	public long tinhTongGia(int idNguoiMua);
	
	@Modifying
	@Query(value="UPDATE bookstore.chi_muc_gio_hang SET ma_don_hang=:maDonHang WHERE id_nguoi_mua=:idNguoiMua AND ma_don_hang is null", nativeQuery=true)
	public void updateMaDonHang(int maDonHang,int idNguoiMua);

}
