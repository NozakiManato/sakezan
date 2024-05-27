-- テーブルが存在したら削除する
DROP TABLE IF EXISTS items CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS authentications CASCADE;
DROP TYPE IF EXISTS role CASCADE;
DROP TYPE IF EXISTS drink_category CASCADE;

-- ドリンクの種類のENUM型
CREATE TYPE drink_category AS ENUM ('ALCOHOL', 'SOFT_DRINK');

-- ドリンクの商品を格納するテーブル
CREATE TABLE items (
    -- item_code(ドリンクの商品コード)
    item_code CHAR(6) PRIMARY KEY NOT NULL,
    -- drink_name(ドリンクの名前):NULL不許可
    drink_name VARCHAR(100) NOT NULL,
    -- specification(ドリンクのサイズ)
    specification VARCHAR(100) NOT NULL,
    -- price(ドリンクの値段)
    price INT NOT NULL,
    -- stock(ドリンクの在庫)
    stock NUMERIC(10,1) NOT NULL, 
    -- ideal_stock_weekday(平日の理想的な在庫数)
    ideal_stock_weekday INT NOT NULL,
    -- ideal_stock_weekend(週末の理想的な在庫数)
    ideal_stock_weekend INT NOT NULL,
    -- drink_category(ドリンクのカテゴリー)
    drink_category drink_category 
);

-- お酒の発注データを格納するテーブル
CREATE TABLE orders (
    -- id(発注ID)
    id SERIAL PRIMARY KEY,
    -- item_code(ドリンクの商品コード)
    item_code CHAR(6),
    -- stock(お酒の在庫)
    stock NUMERIC(10, 1) NOT NULL,
    -- order_quantity(お酒の発注数)
    order_quantity INT NOT NULL,
    -- order_date(発注日)
    order_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- 権限用のENUM型
CREATE TYPE role AS ENUM ('ADMIN', 'USER');

-- 認証情報を格納するテーブル
CREATE TABLE authentications (
    -- ユーザー名: 主キー
    username VARCHAR(50) PRIMARY KEY,
    -- パスワード
    password VARCHAR(255) NOT NULL,
    -- 権限
    authority role NOT NULL,
    -- 表示名
    displayname VARCHAR(50) NOT NULL
);
