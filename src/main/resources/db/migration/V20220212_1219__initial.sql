CREATE SEQUENCE seq_hibernate START WITH 1 INCREMENT BY 50 NO CYCLE;

CREATE  TABLE cost_centre (
                              id                   bigint  NOT NULL  ,
                              code                 varchar(100)  NOT NULL  ,
                              name_on_invoice      varchar(100)  NOT NULL  ,
                              description          varchar    ,
                              CONSTRAINT pk_cost_centre PRIMARY KEY ( id ),
                              CONSTRAINT unq_cost_centre_code UNIQUE ( code )
);

CREATE  TABLE customer (
                           id                   bigint  NOT NULL  ,
                           company_name         varchar(100)  NOT NULL  ,
                           contact_name         varchar(100)  NOT NULL  ,
                           adress_country_iso_code varchar(5)  NOT NULL  ,
                           adress_zip           varchar(10)  NOT NULL  ,
                           adress_city          varchar(100)  NOT NULL  ,
                           adress_street        varchar(100)  NOT NULL  ,
                           CONSTRAINT pk_kunde PRIMARY KEY ( id ),
                           CONSTRAINT unq_customer_company UNIQUE ( company_name )
);

CREATE  TABLE document (
                           id                   bigint  NOT NULL  ,
                           doc_uuid             uuid  NOT NULL  ,
                           name                 varchar(100)  NOT NULL  ,
                           "type"               varchar(100)  NOT NULL  ,
                           external_identifier  varchar(100)  NOT NULL  ,
                           file_type            varchar(10)  NOT NULL  ,
                           content              bytea  NOT NULL  ,
                           created_at           timestamptz  NOT NULL  ,
                           created_by           varchar(100)  NOT NULL  ,
                           updated_at           timestamptz  NOT NULL  ,
                           updated_by           varchar(100)  NOT NULL  ,
                           CONSTRAINT pk_document PRIMARY KEY ( id ),
                           CONSTRAINT unq_document_doc_uuid UNIQUE ( doc_uuid )
);

CREATE  TABLE project (
                          id                   bigint  NOT NULL  ,
                          name                 varchar(100)  NOT NULL  ,
                          fk_customer_id       bigint  NOT NULL  ,
                          CONSTRAINT pk_project PRIMARY KEY ( id ),
                          CONSTRAINT unq_project UNIQUE ( name )
);

CREATE  TABLE "user" (
                         id                   bigint  NOT NULL  ,
                         login_name           varchar(100)  NOT NULL  ,
                         login_password       varchar(100)  NOT NULL  ,
                         "role"               varchar(100)  NOT NULL  ,
                         company_name         varchar(100)    ,
                         surname              varchar(100)    ,
                         name                 varchar(100)    ,
                         adress_country_iso_code varchar(5)    ,
                         adress_zip           varchar(10)    ,
                         adress_city          varchar(100)    ,
                         adress_street        varchar(100)    ,
                         CONSTRAINT pk_tbl PRIMARY KEY ( id ),
                         CONSTRAINT unq_user_login_name UNIQUE ( login_name )
);

CREATE  TABLE contract (
                           id                   bigint  NOT NULL  ,
                           code                 varchar(100)  NOT NULL  ,
                           fk_cost_centre_id    bigint  NOT NULL  ,
                           fk_project_id        bigint  NOT NULL  ,
                           fk_contractor_id     bigint  NOT NULL  ,
                           rate_per_hour        numeric(18,2)  NOT NULL  ,
                           CONSTRAINT pk_contract PRIMARY KEY ( id ),
                           CONSTRAINT unq_contract_code UNIQUE ( code )
);

CREATE  TABLE work_record (
                              id                   bigint  NOT NULL  ,
                              fk_contract_id       bigint  NOT NULL  ,
                              billing_year         smallint  NOT NULL  ,
                              billing_month        smallint  NOT NULL  ,
                              upload_date          timestamptz  NOT NULL  ,
                              work_record_upload_id integer  NOT NULL  ,
                              credit_note_id       integer    ,
                              invoice_id           integer    ,
                              CONSTRAINT pk_work_record PRIMARY KEY ( id ),
                              CONSTRAINT unq_work_record UNIQUE ( fk_contract_id, billing_year, billing_month, upload_date )
);

CREATE  TABLE time_sheet_record (
                                    id                   bigint  NOT NULL  ,
                                    work_record_id       bigint  NOT NULL  ,
                                    "position"           smallint  NOT NULL  ,
                                    "begin"              timestamptz  NOT NULL  ,
                                    "end"                timestamptz  NOT NULL  ,
                                    description          varchar(4000)  NOT NULL  ,
                                    duration_in_minutes  integer  NOT NULL  ,
                                    CONSTRAINT pk_time_sheet_record PRIMARY KEY ( id ),
                                    CONSTRAINT unq_time_sheet_record_work_record_id UNIQUE ( work_record_id, "position" )
);

ALTER TABLE contract ADD CONSTRAINT fk_contract_cost_centre FOREIGN KEY ( fk_cost_centre_id ) REFERENCES cost_centre( id );

ALTER TABLE contract ADD CONSTRAINT fk_contract_project FOREIGN KEY ( fk_project_id ) REFERENCES project( id );

ALTER TABLE contract ADD CONSTRAINT fk_contract_user FOREIGN KEY ( fk_contractor_id ) REFERENCES "user"( id );

ALTER TABLE project ADD CONSTRAINT fk_project_customer FOREIGN KEY ( fk_customer_id ) REFERENCES customer( id );

ALTER TABLE time_sheet_record ADD CONSTRAINT fk_time_sheet_record_work_record FOREIGN KEY ( work_record_id ) REFERENCES work_record( id );

ALTER TABLE work_record ADD CONSTRAINT fk_work_record_contract FOREIGN KEY ( fk_contract_id ) REFERENCES contract( id );

ALTER TABLE work_record ADD CONSTRAINT fk_work_record_upload FOREIGN KEY ( work_record_upload_id ) REFERENCES document( id );

ALTER TABLE work_record ADD CONSTRAINT fk_work_record_credit_note FOREIGN KEY ( credit_note_id ) REFERENCES document( id );

ALTER TABLE work_record ADD CONSTRAINT fk_work_record_invoice FOREIGN KEY ( invoice_id ) REFERENCES document( id );

COMMENT ON COLUMN customer.adress_country_iso_code IS 'alpha 3 code';

COMMENT ON COLUMN "user".adress_country_iso_code IS 'alpha 3 code';
