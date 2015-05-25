-- Table: blog

-- DROP TABLE blog;

CREATE TABLE blog
(
  id serial  NOT NULL, 
  title character varying(255),
  "content" character varying(2000)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE blog OWNER TO blog;
