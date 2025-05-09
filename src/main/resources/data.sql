create sequence user_id_seq start with 1 increment by 1;
create sequence project_id_seq start with 1 increment by 1;
create sequence task_id_seq start with 1 increment by 1;

-- id, name, email
INSERT INTO user VALUES -- user je napisany ako user lebo je to reserved keyword
(next value for user_id_seq, 'Matt Donovan', 'matt.donovan@gmail.com'),
(next value for user_id_seq, 'Caroline Forbes', 'caroline.forbes@gmail.com');
-- id, user_id, name, description, created_at
INSERT INTO project VALUES
(next value for project_id_seq, 1, 'Mattov projekt', 'Tasky v praci', CURRENT_TIMESTAMP),
(next value for project_id_seq, 2, 'Projekt Caroline Forbes', 'Moj Todolist', CURRENT_TIMESTAMP);
-- id, user_id, project_id, name, description, status, created_at
INSERT INTO task VALUES
(next value for task_id_seq, 1, 1, 'Spravit API', 'API ma byt pre noveho klienta', 'DONE', CURRENT_TIMESTAMP),
(next value for task_id_seq, 1, 1, 'Otestovat API', 'Unit testy + integracne testy', 'NEW', CURRENT_TIMESTAMP),
(next value for task_id_seq, 2, 2, 'Mame kupit darcek', null, 'NEW', CURRENT_TIMESTAMP),
(next value for task_id_seq, 2, null, 'Zavolat do skoly', 'Cislo mam na vizitke riaditelky', 'NEW', CURRENT_TIMESTAMP);