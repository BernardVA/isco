create table risk_treatment (
   risk_treatment_id bigserial not null,
   title             varchar(255),
   description       varchar(1000),
   cost              varchar(255),
   created_at        timestamp default current_timestamp,
   constraint risk_treatment_pk primary key ( risk_treatment_id )
);

create table control_implementation (
   control_id     bigserial not null,
   relevance      bigint,
   implementation int,
   cost           varchar(255),
   created_at     timestamp default current_timestamp,
   constraint control_implementation_pk primary key ( control_id )
);

create table control_strength (
   control_strength_id bigserial not null,
   score               float,
   calculated_at       timestamp default current_timestamp,
   constraint control_strength_pk primary key ( control_strength_id )
);

create table threat_events (
   threat_event_id           bigserial not null,
   threat_event_descr        varchar(255),
   likelihood_of_inititation float,
   threat_strength           float,
   constraint threat_event_id_pk primary key ( threat_event_id )
);