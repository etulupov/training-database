#!/bin/sh

# you can create database schema using maven
# mvn sql:execute

mysql -uroot -proot < src/main/resources/mysql/create-user.sql
mysql -ulibrary -ppassword < src/main/resources/sql/mysql/mysql-cmd/create_database.sql
mysql -ulibrary -ppassword < src/main/resources/sql/mysql/insert-data.sql

