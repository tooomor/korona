create table DELIVERIES (
    DELIVERY_ID int primary key auto_increment,
    ROUTE_LENGTH int
);

CREATE TABLE ORDER_ITEMS (
    ORDER_ITEM_ID int primary key auto_increment,
    DELIVERY_ID int,
    PRODUCT_ID VARCHAR(36),
    QUANTITY INTEGER,
    WAYPOINT_NO INTEGER,
    WAREHOUSE_ID VARCHAR(36),
    foreign key (DELIVERY_ID) REFERENCES DELIVERIES(DELIVERY_ID)
);