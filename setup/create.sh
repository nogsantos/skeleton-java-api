#!/bin/bash

function create_default_app_env() {
cat > .env <<EOF
DB_URL=localhost:5432/$1
DB_TEST=localhost:5432/$1_test
DB_USER=postgres
DB_PASSWORD=$(uuidgen)
APPLICATION_NAME=$1
SERVER_PORT=8090
JWT_CLIENT_ID=oauth-token_$1
JWT_CLIENT_SECRET=$(uuidgen)
EOF
	printf ".env file created. \n\n"
}
