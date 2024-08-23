# ベースイメージとして eclipse-temurin を使用
FROM eclipse-temurin:21-jdk-alpine

# アプリケーションJARファイルをコンテナ内にコピー
COPY build/libs/sakezan-1.0.0-SNAPSHOT.jar /app/sakezan.jar

# JARファイルを実行する
CMD ["java", "-jar", "/app/sakezan.jar"]

