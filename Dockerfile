FROM alpine:3.19.0 AS rest-api
LABEL authors="pictari"

RUN apk --no-cache add openjdk17