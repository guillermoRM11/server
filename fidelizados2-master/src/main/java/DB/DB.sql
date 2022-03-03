
DROP TABLE IF EXISTS logins CASCADE;
CREATE TABLE logins (
    "id" integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    "email" character varying(100) UNIQUE CHECK ( "email" ~ '^[a-zA-Z0-9.!#$%&''*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$' ),
    "pass" character varying(256),
    "email_code" character varying(6) default 'VC',
    "expiration_code" timestamp
);

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (
    "id" integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    "name" character varying(100),
    "gender" integer,
    "birth_date" timestamp,
    "code" character varying(6),
    "login_id" integer,
    CONSTRAINT fk_logins
          FOREIGN KEY(login_id) 
              REFERENCES logins(id)
              ON DELETE CASCADE
);

DROP TABLE IF EXISTS business CASCADE;
CREATE TABLE business (
    "id" integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    "name" character varying(100),
    "address" character varying(300),
    "phone" character varying(50),
    "vat" character varying(50),
    "ratio_euro_point" integer,
    "free_prizes" integer default 5,
    "login_id" integer,
    CONSTRAINT fk_logins
          FOREIGN KEY(login_id) 
              REFERENCES logins(id)
              ON DELETE CASCADE
);

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (
    "id" integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    "name" character varying(100),
    "barcode" character varying(50),
    "price" integer,
    "photo_path" character varying(300),
    "business_id" integer,
    CONSTRAINT fk_business
          FOREIGN KEY(business_id) 
              REFERENCES business(id)
              ON DELETE CASCADE
);

DROP TABLE IF EXISTS prizes CASCADE;
CREATE TABLE prizes (
    "id" integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    "name" character varying(100),
    "points" integer,
    "photo_path" character varying(300),
    "business_id" integer,
    CONSTRAINT fk_business
          FOREIGN KEY(business_id) 
              REFERENCES business(id)
              ON DELETE CASCADE
);

DROP TABLE IF EXISTS bills CASCADE;
CREATE TABLE bills (
    "id" integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    "price" integer,
    "points" integer,
    "date" timestamp,
    "business_id" integer,
    CONSTRAINT fk_business
          FOREIGN KEY(business_id) 
              REFERENCES business(id)
              ON DELETE CASCADE,
    "user_id" integer,
    CONSTRAINT fk_users
          FOREIGN KEY(user_id) 
              REFERENCES users(id)
              ON DELETE CASCADE 
);

DROP TABLE IF EXISTS bill_lines CASCADE;
CREATE TABLE bill_lines (
    "id" integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    "quantity" integer,
    "bill_id" integer,
    "price_unity" integer,
    CONSTRAINT fk_bill
          FOREIGN KEY(bill_id) 
              REFERENCES bills(id)
              ON DELETE CASCADE,
    "product_id" integer,
    CONSTRAINT fk_product
          FOREIGN KEY(product_id) 
              REFERENCES products(id)
              ON DELETE CASCADE 
);

DROP TABLE IF EXISTS wallets CASCADE;
CREATE TABLE wallets (
    "id" integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    "points" integer,
    "business_id" integer,
    CONSTRAINT fk_business
          FOREIGN KEY(business_id) 
              REFERENCES business(id)
              ON DELETE CASCADE,
    "user_id" integer,
    CONSTRAINT fk_users
          FOREIGN KEY(user_id) 
              REFERENCES users(id)
              ON DELETE CASCADE 
);

DROP TABLE IF EXISTS prize_exchanges CASCADE;
CREATE TABLE prize_exchanges (
    "id" integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    "date" timestamp,
    "business_id" integer,
    CONSTRAINT fk_business
          FOREIGN KEY(business_id) 
              REFERENCES business(id)
              ON DELETE CASCADE,
    "user_id" integer,
    CONSTRAINT fk_users
          FOREIGN KEY(user_id) 
              REFERENCES users(id)
              ON DELETE CASCADE, 
    "prize_id" integer,
    CONSTRAINT fk_prizes
          FOREIGN KEY(prize_id) 
              REFERENCES prizes(id)
              ON DELETE CASCADE 
);


REVOKE ALL ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO fidelizados_user;

REVOKE ALL ON logins FROM public;
GRANT ALL ON logins TO fidelizados_user;

REVOKE ALL ON users FROM public;
GRANT ALL ON users TO fidelizados_user;

REVOKE ALL ON business FROM public;
GRANT ALL ON business TO fidelizados_user;

REVOKE ALL ON products FROM public;
GRANT ALL ON products TO fidelizados_user;

REVOKE ALL ON prizes FROM public;
GRANT ALL ON prizes TO fidelizados_user;

REVOKE ALL ON bills FROM public;
GRANT ALL ON bills TO fidelizados_user;

REVOKE ALL ON bill_lines FROM public;
GRANT ALL ON bill_lines TO fidelizados_user;

REVOKE ALL ON wallets FROM public;
GRANT ALL ON wallets TO fidelizados_user;

REVOKE ALL ON prize_exchanges FROM public;
GRANT ALL ON prize_exchanges TO fidelizados_user;