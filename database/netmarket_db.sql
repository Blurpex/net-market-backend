CREATE TABLE customer
(
    username       VARCHAR(25),
    name           VARCHAR(255),
    email          VARCHAR(255) NOT NULL,
    password       BINARY(32)   NOT NULL,
    phone_number   BIGINT,
    street_address TEXT,
    city           VARCHAR(255),
    country        CHAR(2),
    PRIMARY KEY (username)
);

CREATE TABLE product
(
    upc         BIGINT,
    name        VARCHAR(255)   NOT NULL,
    description TEXT,
    category    VARCHAR(255),
    price       DECIMAL(10, 2) NOT NULL,
    inventory   INT            NOT NULL,
    PRIMARY KEY (upc)
);

CREATE TABLE order_details
(
    id                BIGINT AUTO_INCREMENT,
    customer_username VARCHAR(25),
    total             DECIMAL(25, 2) NOT NULL,
    time_ordered      TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_username) REFERENCES customer (username) ON DELETE CASCADE
);

CREATE TABLE order_items
(
    id          BIGINT,
    product_upc BIGINT,
    order_id    BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (product_upc) REFERENCES product (upc) ON DELETE SET NULL,
    FOREIGN KEY (order_id) REFERENCES order_details (id) ON DELETE CASCADE
);