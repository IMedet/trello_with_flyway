INSERT INTO permission (permission)
VALUES ('ROLE_USER'),
       ('ROLE_MANAGER'),
       ('ROLE_ADMIN');

INSERT INTO t_users (email, full_name, password)
VALUES ('zhansaya@gmail.com','Zhansaya K','$2a$10$CTAIxdU/cnNYz4U5O.NGDu0s0xTu21XE0VoskUy43EeXBOVP/WOGO'),
       ('medet@gmail.com','Medet', '$2a$10$HnrzNoD6LMLV19tWsrNfu.dkd7EyzaVi447E4qOywhQPFfSjuBhu6'),
       ('mimi@gmail.com', 'mimi', '$2a$10$UiUDj2Kmo7Z0rCbbzTZm4O1yRQI3OfnrmKWhZJqo/tQ8OLkxSr.iW');

INSERT INTO task_categories (name)
VALUES ('Spring'),
       ('JS'),
       ('Make Rainbow drible'),
       ('C++'),
       ('Python');

INSERT INTO folders (name, user_id)
VALUES ('FootBall', 1),
       ('Gaming', 3);

INSERT INTO t_users_permissions (user_id, permissions_id)
VALUES (1,1),
       (1,2),
       (1,3);

INSERT INTO tasks (description, status, title , folder_id)
VALUES ('I have to learn about how to score the ball so accurately', 1, 'Learn how to Score a Ball', 1 ),
       ('playing for 5 min', 0, 'GTA V', 2 );


INSERT into comments (comment)
VALUES ('Nice)))' ),
       ('Cool');


