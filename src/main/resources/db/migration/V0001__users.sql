CREATE TABLE users (
  id      bigserial NOT NULL,
  name    varchar(99) NOT NULL,
  email   varchar(99) NOT NULL,
  password   varchar(99) NOT NULL,
  active   BOOLEAN DEFAULT TRUE,
  CONSTRAINT user_pk PRIMARY KEY (id)
);
