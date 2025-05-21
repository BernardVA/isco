CREATE SEQUENCE IF NOT EXISTS risk_treatment_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    OWNED BY risk_treatment.risk_treatment_id;