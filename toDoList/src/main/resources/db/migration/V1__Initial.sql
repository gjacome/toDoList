CREATE SCHEMA IF NOT EXISTS todolist
  AUTHORIZATION todolist;

CREATE TABLE IF NOT EXISTS todolist.task
(
  id smallserial NOT NULL,
  id_user smallint NOT NULL,
  description character varying(100) COLLATE pg_catalog."default" NOT NULL,
  status character varying(3) COLLATE pg_catalog."default" NOT NULL,
  CONSTRAINT task_pkey PRIMARY KEY (id)
);

