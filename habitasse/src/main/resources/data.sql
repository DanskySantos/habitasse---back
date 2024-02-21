INSERT INTO tb_user_role (id, creation_date, update_date, uuid, role_name)
VALUES (1, '2023-10-19 09:29:36.565155', '2023-10-19 09:29:36.565155', '2350d6ae-5273-4416-bee4-956c88f1af54', 'CUSTOMER_OFFER'),
       (2, '2023-10-19 09:29:36.565155', '2023-10-19 09:29:36.565155', '2350d6ae-5273-4416-bee4-956c88f1af55', 'CUSTOMER_DEMAND');

INSERT INTO tb_person (id, creation_date, update_date, uuid, name, birthday, phone, user_id)
VALUES (1, '2023-10-19 09:29:36.565155', '2023-10-19 09:29:36.565155', '2350d6ae-5273-4416-bee4-956c88f1af71', 'dansky', '1996-02-07 09:29:36.565155', '(62)982167889', 1);

INSERT INTO tb_user (id, creation_date, update_date, uuid, username, password, email, person_id, user_role_id)
VALUES (1, '2023-10-19 09:29:36.565155', '2023-10-19 09:29:36.565155', '2350d6ae-5273-4416-bee4-956c88f1af71', 'dansky', '$2a$10$e3J0ZWT./UieYvSN8hyOeu4LRyW0qxmLioXgtpxvJZPxOmsbWjAmO', 'dansky123@hotmail.com', 1, 1);
