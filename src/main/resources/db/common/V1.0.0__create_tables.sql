CREATE TABLE risk_treatment (
    risk_treatment_id BIGSERIAL NOT NULL,
    title VARCHAR(255),
	description VARCHAR(1000),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT risk_treatment_pk PRIMARY KEY (risk_treatment_id)
);