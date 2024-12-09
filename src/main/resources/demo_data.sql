INSERT INTO users (name, username, password)
VALUES ('John Doe', 'john_doe@gmail.com', '$2a$10$u92NFxQYnw596x3eKxjvrOfG5O5bBu6Dzn6IgwlH1Vc2MB8lW3C6e'),
       ('Mike Smith', 'mike_sm@yahoo.com', '$2a$10$u92NFxQYnw596x3eKxjvrOfG5O5bBu6Dzn6IgwlH1Vc2MB8lW3C6e')
ON CONFLICT (username) DO NOTHING;

INSERT INTO tasks (title, description, status, expiration_date, user_id)
VALUES ('Buy Cheese', null, 'CREATED', '2024-12-13 00:00:00', 2),
       ('Do homework', 'Math, Physics, Literature', 'IN_PROGRESS', '2024-12-13 00:00:00', 2),
       ('Clean rooms', null, 'COMPLETED', null, 2),
       ('Call Mike', 'Ask about meeting', 'CREATED', '2024-12-14 00:00:00', 1);

INSERT INTO user_roles (user_id, role)
VALUES (1, 'ROLE_ADMIN'),
       (1, 'ROLE_USER'),
       (2, 'ROLE_USER');