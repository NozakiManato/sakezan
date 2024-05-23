--1件目
INSERT INTO Items (item_code, drink_name, specification, price, stock, ideal_stock_weekday, ideal_stock_weekend, drink_category)
VALUES ('000001', '商品A', '500ml', 500, 10, 15, 20, 'ALCOHOL');

--認証テーブルへのダミーデータの追加
INSERT INTO authentications (username, password, authority,displayname) VALUES 
--password:adminpass
('admin', '$2a$10$gwsIpmbGRWQv2dC1PrYRjOoDF0FeDjes13bHa.aAhQBm6/p6f5i4q','ADMIN', '野崎愛斗');
--password:userpass
INSERT INTO authentications (username, password, authority, displayname) VALUES
('user', '$2a$10$hPiKtyD0HiuGdiEpHS8ZmuNJICzXjLvAaSzAf/Ayul2.uviS4PT.6','USER', '一般花子');