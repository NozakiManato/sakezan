--1件目
INSERT INTO Items (item_code, drink_name, specification, price, stock, ideal_stock_weekday, ideal_stock_weekend, drink_category)
VALUES ('000001', '商品A', '500ml', 500, 10, 15, 20, 'ALCOHOL');

--認証テーブルへのダミーデータの追加
INSERT INTO authentications (username, password, authority,displayname) VALUES 
--password:adminpass
('admin', '$2a$10$c2eycd4Nt0EH9.htq4pHZ.BgBCD0NMlyY6A5JywtBQ0whfNka76P.','ADMIN', '野崎愛斗');
--password:userpass
INSERT INTO authentications (username, password, authority, displayname) VALUES
('user', '$2a$10$XrWWAkTwHNYmwv.n9FSmM.iXcvP5CxNmOZVP./mU/QNHD0dc2qgRO','USER', '一般花子');