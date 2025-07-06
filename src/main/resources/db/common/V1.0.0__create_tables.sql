CREATE TABLE risk_treatment (
    risk_treatment_id BIGSERIAL NOT NULL,
    title VARCHAR(255),
	description VARCHAR(1000),
	cost VARCHAR(255),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT risk_treatment_pk PRIMARY KEY (risk_treatment_id)
);

CREATE TABLE control (
    control_id BIGSERIAL NOT NULL,
	relevance BIGINT,
	implementation INT,
	cost VARCHAR(255),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT control_pk PRIMARY KEY (control_id)
);

CREATE TABLE control_strength (
    control_strength_id BIGSERIAL NOT NULL,
    score FLOAT,
    calculated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT control_strength_pk PRIMARY KEY (control_strength_id)
);