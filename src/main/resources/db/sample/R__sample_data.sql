INSERT INTO risk_treatment (risk_treatment_id, title, description,cost, created_at)
VALUES
  (nextval('risk_treatment_id_seq'), 'Mitigate', 'Actions taken to reduce the likelihood or impact of a risk.',100, CURRENT_TIMESTAMP),
  (nextval('risk_treatment_id_seq'), 'Transfer', 'Shifting the risk to a third party (e.g. insurance).', 1200, CURRENT_TIMESTAMP),
  (nextval('risk_treatment_id_seq'), 'Accept', 'Acknowledging the risk and choosing to accept it.',0,  CURRENT_TIMESTAMP),
  (nextval('risk_treatment_id_seq'), 'Avoid', 'Eliminating the risk by discontinuing the activity.', 2400, CURRENT_TIMESTAMP);



INSERT INTO control (control_id, strength, relevance, implementation, cost, created_at)
VALUES
  (nextval('control_id_seq'), 'H', 'H', 'H',100, CURRENT_TIMESTAMP),
  (nextval('control_id_seq'), 'M', 'M', 'M',200, CURRENT_TIMESTAMP),
  (nextval('control_id_seq'), 'L', 'L', 'L',300, CURRENT_TIMESTAMP),
  (nextval('control_id_seq'), 'VL', 'VL', 'VL',10, CURRENT_TIMESTAMP);