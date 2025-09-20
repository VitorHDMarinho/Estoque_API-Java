CREATE TABLE Products(
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(250),
    stockquantity INTEGER,
    registerdate DATE NOT NULL,
    categoryid INTEGER
);

CREATE TABLE Categories(
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(250) NOT NULL
);

ALTER TABLE Product
ADD CONSTRAINT category_key
FOREIGN KEY (categoryid) REFERENCES Category (id);


INSERT INTO Categories (name,description) VALUES ('Eletrônicos','Aparelhos eletrônicos');

INSERT INTO Products (name,description, stockquantity, registerdate, categoryid)
VALUES ('Tablet','O mais novo do mercado', 100, '2025-09-19', 1);