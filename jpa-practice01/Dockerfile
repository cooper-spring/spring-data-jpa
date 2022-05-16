# base-image
FROM openjdk:11

# 변수설정 (빌드파일 경로)
VOLUME /tmp

ARG JAR_FILE=./build/libs/*.jar

COPY ${JAR_FILE} app.jar

# jar 파일 실행
ENTRYPOINT ["java", "-jar", "app.jar"]