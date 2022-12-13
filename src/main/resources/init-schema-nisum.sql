CREATE TABLE USERS (
	id varchar(255) NOT NULL,
	created date,
	email varchar(255),
	is_active boolean,
	last_login date,
	modified date,
	"password" varchar(255) NULL,
	role varchar(255),
	token varchar(255),

	CONSTRAINT credential_pk PRIMARY KEY (id)
);


CREATE TABLE PHONE (
	id varchar(255) NOT NULL,
	city_code varchar(255) NULL,
	country_code varchar(255) NULL,
	number varchar(255) NULL,
	user_id varchar(255) NULL,

	CONSTRAINT phone_pk PRIMARY KEY (id)
);

ALTER TABLE PHONE ADD CONSTRAINT pk_phone_user_id FOREIGN KEY (user_id) REFERENCES users (id);

