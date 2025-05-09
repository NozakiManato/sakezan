# ドリンク在庫管理システム

## 概要
平日と休日で理想的な在庫数を定義し、ドリンクの在庫を入力するだけで、発注数と発注合計金額を自動で算出するシステムを構築しました。

## サービスへの想い
このサービスは、人として育ててくれたアルバイト先への感謝の気持ちから、ドリンク在庫管理システムを自ら企画立案し、開発しました。
現在のサービスはお酒の発注数と合計金額を算出する機能のみですが、段階的な機能追加を積み重ね、発注業務をこのサービスだけで完結できるようにすることを目指しています。

## 使用技術
- Java
- Springフレームワーク
- MyBatis
- PostgreSQL
- Bootstrap
- AWS
  - VPC
  - EC2
  - RDS
  - Route53
- Docker

## 機能一覧
- ログイン機能(Spring Security)
- ユーザーのCRUD処理
- ドリンクのCRUD処理
- 発注数、合計金額の算出機能

## TODOリスト

- [ ] **変数名のリファクタリング:** `item`を`drink`に、`item_code`を`itemCode`に変更する。
- [-] **夜中の在庫レベル参照問題:** 夜12時以降に休日用ではなく平日用の在庫レベルを参照する問題を解決する。
- [-] **特別な日の対応:** 祭りの平日など特別な日に対応できるようにシステムを調整する。
- [ ] **駅前店用の適応:** システムを駅前店で使用できるように適応させる。
- [ ] **特定のドリンクのはチェックにする:** 鳥ハイや料理酒、炭酸ガスはチェック項目にする。
- [ ] **CI/CDパイプラインの構築：**　Cirlce CIを使って実現する

## 長期的な目標

- [ ] **Fax機能の統合:** システムが信用を得た後に、Fax機能を統合する。
