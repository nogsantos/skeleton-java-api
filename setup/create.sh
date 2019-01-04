#!/bin/bash

function create_default_app_env() {
cat > .env <<EOF
DB_URL=localhost:5432/$1
DB_TEST=localhost:5432/$1_test
DB_USER=postgres
DB_PASSWORD=$(uuidgen)
APPLICATION_NAME=$1
APPLICATION_CODE_VERSION=0.1.0
SERVER_PORT=8090
JWT_CLIENT_ID=oauth-token_$1
JWT_CLIENT_SECRET=$(uuidgen)
APPLICATION_DESCRIPTION=$1 API
APPLICATION_VERSION=v1
CONTACT_NAME=Fabricio Nogueira
CONTACT_SITE=http://fabricionogueira.me
CONTACT_EMAIL=nogsantos@gmail.com
EOF
	printf ".env file created. \n\n"
}
