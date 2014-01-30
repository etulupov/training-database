#!/bin/sh

sqlite3 -init src/main/resources/sql/sqlite/library-schema.sql /tmp/library.sqlite .exit