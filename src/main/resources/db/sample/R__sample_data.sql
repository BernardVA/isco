INSERT INTO risk_treatment (risk_treatment_id, title, description, created_at)
VALUES
  (nextval('risk_treatment_id_seq'), 'Mitigate', 'Actions taken to reduce the likelihood or impact of a risk.', CURRENT_TIMESTAMP),
  (nextval('risk_treatment_id_seq'), 'Transfer', 'Shifting the risk to a third party (e.g., insurance).', CURRENT_TIMESTAMP),
  (nextval('risk_treatment_id_seq'), 'Accept', 'Acknowledging the risk and choosing to accept it.', CURRENT_TIMESTAMP),
  (nextval('risk_treatment_id_seq'), 'Avoid', 'Eliminating the risk by discontinuing the activity.', CURRENT_TIMESTAMP);