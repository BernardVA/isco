INSERT INTO risk_treatment (risk_treatment_id, title, description,cost, created_at)
VALUES
  (nextval('risk_treatment_id_seq'), 'Mitigate', 'Actions taken to reduce the likelihood or impact of a risk.',100, CURRENT_TIMESTAMP),
  (nextval('risk_treatment_id_seq'), 'Transfer', 'Shifting the risk to a third party (e.g. insurance).', 1200, CURRENT_TIMESTAMP),
  (nextval('risk_treatment_id_seq'), 'Accept', 'Acknowledging the risk and choosing to accept it.',0,  CURRENT_TIMESTAMP),
  (nextval('risk_treatment_id_seq'), 'Avoid', 'Eliminating the risk by discontinuing the activity.', 2400, CURRENT_TIMESTAMP);



INSERT INTO control_implementation (control_id, relevance, implementation, cost, created_at)
VALUES
  (nextval('control_id_seq'), 100,  100,100, CURRENT_TIMESTAMP),
  (nextval('control_id_seq'), 200,  200,200, CURRENT_TIMESTAMP),
  (nextval('control_id_seq'), 300,  300,300, CURRENT_TIMESTAMP),
  (nextval('control_id_seq'), 10,  10,10, CURRENT_TIMESTAMP);


  INSERT INTO threat_events (threat_event_id, threat_event_descr, likelihood_of_inititation, threat_strength)
VALUES
  (nextval('threat_event_id_seq'), 'Unauthorized access to admin interface', 0.60, 7.5),
  (nextval('threat_event_id_seq'), 'Phishing campaign targeting users', 0.40, 5.0),
  (nextval('threat_event_id_seq'), 'Ransomware via email attachment', 0.25, 9.0),
  (nextval('threat_event_id_seq'), 'Insider data leak', 0.15, 6.0),
  (nextval('threat_event_id_seq'), 'DDoS attack on public API', 0.20, 4.0);