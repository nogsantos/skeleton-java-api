#!/bin/bash

echo Setting up

export DB_URL="localhost:5432/--pkg-name'"
export DB_TEST="localhost:5432/--pkg-name"
export DB_USER="postgres"
export DB_PASSWORD="123456"
export APPLICATION_NAME="--pkg-name"
export SERVER_PORT="8090"

echo Done!

echo Database: $DB_URL
echo Database Teste:  $DB_TEST
echo Database User: $DB_USER
echo Database Password: $DB_PASSWORD
echo Database Application: $APPLICATION_NAME
echo Database Port: $SERVER_PORT
