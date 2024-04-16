CREATE SCHEMA IF NOT EXISTS KEYCLOAK;
COPY KEYCLOAK FROM '/docker-entrypoint-initdb.d/init-schema.sql';;