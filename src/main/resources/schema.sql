--テーブルが存在したら削除する
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS authentications;
DROP TYPE IF EXISTS role;
DROP TYPE IF EXISTS drink_category;

--お酒の種類のENUM型
CREATE TYPE drink_category AS ENUM ('ALCOHOL', 'SOFT_DRINK');

--お酒の商品を格納するテーブル
CREATE TABLE items (
	--id(お酒ID):主キー
    id SERIAL PRIMARY KEY,
    --name(お酒の名前):NULL不許可
    drink VARCHAR(100) NOT NULL,
    --code(お酒の商品コード)
    code VARCHAR(50) UNIQUE NOT NULL,
    --price(お酒の値段)
    price INT NOT NULL,
    --stock(お酒の在庫)
    stock NUMERIC(10,1) NOT NULL,
    --ideal_stock_weekday(平日の理想的な在庫数)
    ideal_stock_weekday NUMERIC(10, 1) NOT NULL,
    --ideal_stock_weekend(週末の理想的な在庫数)
    ideal_stock_weekend NUMERIC(10, 1) NOT NULL,
    --order_date(発注が行われた日時)
    order_date TIMESTAMP,
    --category(商品のカテゴリー)
    drink_category drink_category
);

--権限用のENUM型
CREATE TYPE role AS ENUM ('ADMIN', 'USER');

--認証情報を格納するテーブル
CREATE TABLE authentications (
	-- ユーザー名: 主キー
	username VARCHAR(50) PRIMARY KEY,
	--パスワード
	password VARCHAR(255) NOT NULL,
	--権限
	authority role NOT NULL,
	--表示名	
	displayname VARCHAR(50) NOT NULL
);