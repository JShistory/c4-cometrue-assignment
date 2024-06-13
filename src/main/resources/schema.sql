-- Cart 초기값 삽입
INSERT INTO cart (id, count, cart_price)
VALUES (1, 0, 0);

-- User 초기값 삽입
INSERT INTO user_table (id, account_id, password, name, nick_name, phone_number, email, money, role, created, modified, cart_id)
VALUES (1, 'admin', '$2a$10$EMGaJ8Pzq/ARLKR2CxSjd.uOkH7xzaNl4c2VlmhZ8q6Q1tevRMs5O', 'admin', 'admin', '010-1111-1111', 'user1@example.com', 10000, 'ROLE_ADMIN', NOW(), NOW(), 1);

-- Item 초기값 삽입
INSERT INTO item (id, name, price, amount, description, picture, user_id, cart_id)
VALUES (1, 'JPA', 10000, 10, 'JPA', 'picture1.jpg', 1, 1);

