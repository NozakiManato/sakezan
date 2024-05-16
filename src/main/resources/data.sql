--1件目
INSERT INTO items (drink, code, price, stock, ideal_stock_weekday, ideal_stock_weekend, order_date, drink_category) VALUES
('アサヒ瓶ビール', '00001', 750, 0, 8, 8, CURRENT_TIMESTAMP, 'ALCOHOL');

--2件目
INSERT INTO items (drink, code, price, stock, ideal_stock_weekday, ideal_stock_weekend, order_date, drink_category) VALUES
('コカ・コーラ瓶', '10000', 88, 0, 12, 21, CURRENT_TIMESTAMP, 'SOFT_DRINK');

--認証テーブルへのダミーデータの追加
INSERT INTO authentications (username, password, authority,displayname) VALUES 
--password:adminpass
('admin', '$2a$10$c2eycd4Nt0EH9.htq4pHZ.BgBCD0NMlyY6A5JywtBQ0whfNka76P.','ADMIN', '野崎愛斗');
--password:userpass
INSERT INTO authentications (username, password, authority, displayname) VALUES
('user', '$2a$10$XrWWAkTwHNYmwv.n9FSmM.iXcvP5CxNmOZVP./mU/QNHD0dc2qgRO','USER', '一般花子');