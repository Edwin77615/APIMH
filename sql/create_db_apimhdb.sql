-- create_db_apimhdb.sql
-- Ejecutar como superuser o usuario con permisos en PostgreSQL

CREATE DATABASE apimhdb WITH ENCODING 'UTF8' TEMPLATE=template0;

CREATE USER fesv_user WITH PASSWORD 'fesv_pass';
GRANT ALL PRIVILEGES ON DATABASE apimhdb TO fesv_user;

\c apimhdb

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(200) NOT NULL,
  role_code VARCHAR(50)
);

CREATE TABLE dte_document (
  id SERIAL PRIMARY KEY,
  codigo_generacion VARCHAR(200) UNIQUE,
  nit_emisor VARCHAR(14),
  raw_json TEXT,
  estado VARCHAR(50),
  fh_procesamiento TIMESTAMP
);

CREATE TABLE lote_envio (
  id SERIAL PRIMARY KEY,
  codigo_lote VARCHAR(200) UNIQUE,
  estado VARCHAR(50),
  id_envio VARCHAR(200),
  nit_emi VARCHAR(14),
  documentos_json TEXT,
  fh_registro TIMESTAMP
);

-- Datos de prueba
INSERT INTO users(username,password,role_code) VALUES ('facturador01','Password', 'ROLE_USER');
