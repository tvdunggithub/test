package com.dungtran.bookstore.controllers;

import java.sql.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dungtran.bookstore.entities.NguoiDung;
import com.dungtran.bookstore.services.NguoiDungService;

@RestController
public class NguoiDungController {
	
	@Autowired
    private NguoiDungService ns;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    //password data trong db là 12345
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid NguoiDung nguoiDung) {
        NguoiDung savedNguoiDung = null;
        ResponseEntity response = null;
        try {
            String hashPwd = passwordEncoder.encode(nguoiDung.getPassword());
            nguoiDung.setPassword(hashPwd);
            nguoiDung.setNgayTao(new Date(System.currentTimeMillis()));
            savedNguoiDung = ns.save(nguoiDung);
            if (savedNguoiDung.getId() > 0) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Đăng ký thành công");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Xảy ra lỗi: " + ex.getMessage());
        }
        return response;
    }
}
