#!/bin/bash

function export_env() {
	clear

	printf "Setting up environment system... \n\n"

	export DB_URL="localhost:5432/--pkg-name"
	export DB_TEST="localhost:5432/--pkg-name_test"
	export DB_USER="postgres"
	export DB_PASSWORD=$(uuidgen)
	export APPLICATION_NAME="--pkg-name"
	export SERVER_PORT="8090"
	export JWT_CLIENT_ID="oauth-token_--pkg-name"
	export JWT_CLIENT_SECRET=$(uuidgen)
}

function show_created_env() {
	printf "Environment values: \n\n"
	echo DB_URL=${DB_URL}
	echo DB_TEST=${DB_TEST}
	echo DB_USER=${DB_USER}
	echo DB_PASSWORD=${DB_PASSWORD}
	echo APPLICATION_NAME=${APPLICATION_NAME}
	echo SERVER_PORT=${SERVER_PORT}
	echo JWT_CLIENT_ID=${JWT_CLIENT_ID}
	echo JWT_CLIENT_SECRET=${JWT_CLIENT_SECRET}
}

function create_env_file() {
cat > .env <<EOF
DB_URL=${DB_URL}
DB_TEST=${DB_TEST}
DB_USER=${DB_USER}
DB_PASSWORD=${DB_PASSWORD}
APPLICATION_NAME=${APPLICATION_NAME}
SERVER_PORT=${SERVER_PORT}
JWT_CLIENT_ID=${JWT_CLIENT_ID}
JWT_CLIENT_SECRET=${JWT_CLIENT_SECRET}
EOF
	printf ".env file created. \n\n"
}

function check_env_file() {
	if [[ -e ".env" ]]; then
		rm .env
		printf "\n\nCurrent .env file deleted. \n\n"
	fi

	create_env_file

	printf "Done! \n\n"
}

export_env

show_created_env

check_env_file
