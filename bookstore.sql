CREATE DATABASE bookstore CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE bookstore;


create table authorities (id integer not null auto_increment, vai_tro varchar(255), id_nguoi_dung integer, primary key (id)) engine=InnoDB;
create table chi_muc_gio_hang (id integer not null auto_increment, don_gia bigint not null, so_luong integer not null, id_nguoi_mua integer, id_sach integer, ma_don_hang integer, primary key (id)) engine=InnoDB;
create table dia_chi (id integer not null auto_increment, huyen varchar(255), so_nha varchar(255), thanh_pho varchar(255), xa varchar(255), id_nguoi_dung integer, primary key (id)) engine=InnoDB;
create table don_hang (id integer not null auto_increment, ngay_dat datetime(6), ngay_giao datetime(6), phone varchar(255), tong_gia bigint, id_dia_chi integer, id_nguoi_mua integer, primary key (id)) engine=InnoDB;
create table nguoi_dung (id integer not null auto_increment, email varchar(255), ngay_tao datetime(6), password varchar(255), phone varchar(255), primary key (id)) engine=InnoDB;
create table nha_xuat_ban (id integer not null auto_increment, ten varchar(255), primary key (id)) engine=InnoDB;
create table sach (id integer not null auto_increment, gia bigint not null, nam_xuat_ban integer not null, so_luong_ton_kho integer not null, ten_sach varchar(255), id_nha_xuat_ban integer, id_tac_gia integer, nguoi_ban integer, id_the_loai integer, primary key (id)) engine=InnoDB;
create table tac_gia (id integer not null auto_increment, nghe_danh varchar(255), primary key (id)) engine=InnoDB;
create table the_loai (id integer not null auto_increment, the_loai varchar(255), primary key (id)) engine=InnoDB;


alter table authorities add constraint FKqu7yetvgax34ilyyfvwsc7u1q foreign key (id_nguoi_dung) references nguoi_dung (id);
alter table chi_muc_gio_hang add constraint FKpym330tn0ifi5yml37w66squw foreign key (id_nguoi_mua) references nguoi_dung (id);
alter table chi_muc_gio_hang add constraint FK4401q8c63tq67bpq60481jvhb foreign key (id_sach) references sach (id);
alter table chi_muc_gio_hang add constraint FKk2geg6wbackeosk3omykyebk0 foreign key (ma_don_hang) references don_hang (id);
alter table dia_chi add constraint FKjtsbl7g79kr7g0rnqa73bypxf foreign key (id_nguoi_dung) references nguoi_dung (id);
alter table don_hang add constraint FKdx4p28qlg10nik653xp7a3m09 foreign key (id_dia_chi) references dia_chi (id);
alter table don_hang add constraint FKm4jdpqpxkegh797cu25fr0em8 foreign key (id_nguoi_mua) references nguoi_dung (id);
alter table sach add constraint FKgx1pa746uwaj3llgmrk46njig foreign key (id_nha_xuat_ban) references nha_xuat_ban (id);
alter table sach add constraint FK35h8yppjqjtf6w3xafk861cgt foreign key (id_tac_gia) references tac_gia (id);
alter table sach add constraint FKoa8of26qqslrkg0uf9ic3wdbv foreign key (nguoi_ban) references nguoi_dung (id);
alter table sach add constraint FKlfh1kolvxqoibfa7rxnnk4bva foreign key (id_the_loai) references the_loai (id);

-- password:12345 
INSERT INTO `nguoi_dung` (`email`,`phone`, `password`, `ngay_tao`)
VALUES ('john@gmail.com','9876548337', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2',CURDATE());
INSERT INTO `nguoi_dung` (`email`,`phone`, `password`, `ngay_tao`)
VALUES ('user@abc.com','213009563', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2',CURDATE()-1);
INSERT INTO `nguoi_dung` (`email`,`phone`, `password`, `ngay_tao`)
VALUES ('trump@xyz.com','123545468', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2',CURDATE()-2);
INSERT INTO `bookstore`.`dia_chi` (`huyen`, `so_nha`, `thanh_pho`, `xa`, `id_nguoi_dung`) VALUES ('Quận Ba Đình', '512', 'Hà Nội', 'Phường Ngọc Hà', '1');
INSERT INTO `bookstore`.`dia_chi` (`huyen`, `so_nha`, `thanh_pho`, `xa`, `id_nguoi_dung`) VALUES ('Quận Ba Đình', '114', 'Hà Nội', 'Phường Quán Thánh', '2');
INSERT INTO `bookstore`.`dia_chi` (`huyen`, `so_nha`, `thanh_pho`, `xa`, `id_nguoi_dung`) VALUES ('Huyện Tứ Kỳ', '123', 'Hải Dương', 'An Thanh', '3');
INSERT INTO `bookstore`.`authorities` (`vai_tro`, `id_nguoi_dung`) VALUES ('ROLE_USER', '1');
INSERT INTO `bookstore`.`authorities` (`vai_tro`, `id_nguoi_dung`) VALUES ('ROLE_SELLER', '1');
INSERT INTO `bookstore`.`authorities` (`vai_tro`, `id_nguoi_dung`) VALUES ('ROLE_SELLER', '2');
INSERT INTO `bookstore`.`authorities` (`vai_tro`, `id_nguoi_dung`) VALUES ('ROLE_USER', '2');
INSERT INTO `bookstore`.`authorities` (`vai_tro`, `id_nguoi_dung`) VALUES ('ROLE_USER', '3');
INSERT INTO `bookstore`.`nha_xuat_ban` (`ten`) VALUES ('Kim Đồng');
INSERT INTO `bookstore`.`nha_xuat_ban` (`ten`) VALUES ('Dân Trí');
INSERT INTO `bookstore`.`nha_xuat_ban` (`ten`) VALUES ('Cánh Diều');
INSERT INTO `bookstore`.`nha_xuat_ban` (`ten`) VALUES ('Hồng Đức');
INSERT INTO `bookstore`.`nha_xuat_ban` (`ten`) VALUES ('Đại Học Sư Phạm');
INSERT INTO `bookstore`.`tac_gia` (`nghe_danh`) VALUES ('Hoài Nguyên');
INSERT INTO `bookstore`.`tac_gia` (`nghe_danh`) VALUES ('Tô Hoài');
INSERT INTO `bookstore`.`tac_gia` (`nghe_danh`) VALUES ('Vũ Trọng Phụng');
INSERT INTO `bookstore`.`tac_gia` (`nghe_danh`) VALUES ('Hồ Chí Minh');
INSERT INTO `bookstore`.`tac_gia` (`nghe_danh`) VALUES ('Hồ Quỳnh Hương');
INSERT INTO `bookstore`.`tac_gia` (`nghe_danh`) VALUES ('Nguyễn Khuyến');
INSERT INTO `bookstore`.`the_loai` (`the_loai`) VALUES ('Chiến Tranh');
INSERT INTO `bookstore`.`the_loai` (`the_loai`) VALUES ('Trinh Thám');
INSERT INTO `bookstore`.`the_loai` (`the_loai`) VALUES ('Kinh Dị');
INSERT INTO `bookstore`.`the_loai` (`the_loai`) VALUES ('Hành Động');
INSERT INTO `bookstore`.`the_loai` (`the_loai`) VALUES ('Phưu Lưu');
INSERT INTO `bookstore`.`the_loai` (`the_loai`) VALUES ('Cổ Điển');
INSERT INTO `bookstore`.`sach` (`gia`, `nam_xuat_ban`, `so_luong_ton_kho`, `ten_sach`, `id_nha_xuat_ban`, `id_tac_gia`, `nguoi_ban`, `id_the_loai`) VALUES ('50000', '1993', '12', 'Thao Túng Tâm Lý', '1', '2', '1', '3');
INSERT INTO `bookstore`.`sach` (`gia`, `nam_xuat_ban`, `so_luong_ton_kho`, `ten_sach`, `id_nha_xuat_ban`, `id_tac_gia`, `nguoi_ban`, `id_the_loai`) VALUES ('120000', '2005', '4', 'Bí Kíp Trường Sinh', '2', '1', '1', '4');
INSERT INTO `bookstore`.`sach` (`gia`, `nam_xuat_ban`, `so_luong_ton_kho`, `ten_sach`, `id_nha_xuat_ban`, `id_tac_gia`, `nguoi_ban`, `id_the_loai`) VALUES ('200000', '2010', '50', 'Tây Du Ký', '3', '3', '2', '1');
INSERT INTO `bookstore`.`sach` (`gia`, `nam_xuat_ban`, `so_luong_ton_kho`, `ten_sach`, `id_nha_xuat_ban`, `id_tac_gia`, `nguoi_ban`, `id_the_loai`) VALUES ('40000', '2019', '43', 'Dế mèn phưu lư ký', '4', '4', '2', '2');
INSERT INTO `bookstore`.`sach` (`gia`, `nam_xuat_ban`, `so_luong_ton_kho`, `ten_sach`, `id_nha_xuat_ban`, `id_tac_gia`, `nguoi_ban`, `id_the_loai`) VALUES ('70000', '1992', '7', 'Java Head First', '5', '6', '1', '6');
INSERT INTO `bookstore`.`sach` (`gia`, `nam_xuat_ban`, `so_luong_ton_kho`, `ten_sach`, `id_nha_xuat_ban`, `id_tac_gia`, `nguoi_ban`, `id_the_loai`) VALUES ('110000', '1999', '19', 'Spring In Action', '2', '5', '2', '5');
INSERT INTO `bookstore`.`don_hang` (`ngay_dat`, `ngay_giao`, `phone`, `tong_gia`, `id_dia_chi`, `id_nguoi_mua`) VALUES (CURDATE(), CURDATE()+3, '1232321', '290000', '1', '1');
INSERT INTO `bookstore`.`chi_muc_gio_hang` (`don_gia`, `so_luong`, `id_nguoi_mua`, `id_sach`, `ma_don_hang`) VALUES ('50000', '1', '1', '1', '1');
INSERT INTO `bookstore`.`chi_muc_gio_hang` (`don_gia`, `so_luong`, `id_nguoi_mua`, `id_sach`, `ma_don_hang`) VALUES ('240000', '2', '1', '2', '1');
INSERT INTO `bookstore`.`chi_muc_gio_hang` (`id`, `don_gia`, `so_luong`, `id_nguoi_mua`, `id_sach`) VALUES ('3', '120000', '1', '1', '2');
