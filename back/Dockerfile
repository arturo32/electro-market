FROM postgres:15.2-alpine as db-img

COPY create_db.sql /docker-entrypoint-initdb.d/create_db.sql

ENV PGDATA=/data
ENV POSTGRES_PASSWORD=postgres
