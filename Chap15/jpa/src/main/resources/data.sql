insert into UserDTO (login, name)
    values (' JLC ', ' Lechien '),
    (' MCD ', ' Codutti ');

insert into SchoolAddress (name, street, number,  city, post_code)
    values ('ESI', ' Rue Royale ', 67, ' Bruxelles ', ' 1000 '),
    ('IPL', ' Clos Chapelle-aux-Champs ', 43, ' Woluwe-Saint-Lambert ', ' 1200 ');

insert into InternshipAddress (name, street, number,  city, post_code)
    values ('Colruyt', ' Jen sais rien ', 123, ' Bruxelles ', ' 1000 '),
    ('ChristianDior', ' Moi non plus ', 456, ' Bruxelles ', ' 2000 ');

insert into Course (id, title, ECTS)
    values ('ERPG5', 'Erp Gestion Q5', 5);
insert into Course (id, title, ECTS)
    values ('WEBG5', 'Web Gestion Q5', 5);

ALTER TABLE Student ADD COLUMN internship_address VARCHAR(255);
ALTER TABLE Student ADD COLUMN courses text;

insert into Student (matricule, name, genre, section, school_address, internship_address, courses)
    values (53212, 'Mols', 'M', 'GESTION', 'ESI', 'Colruyt', ARRAY['ERPG5', 'WEBG5']),
    (56080, 'Ballesteros', 'M', 'GESTION', 'IPL', 'ChristianDior', ARRAY['ERPG5']);

INSERT INTO STUDENT_COURSE (student_id, course_id)
    VALUES (53212, 'ERPG5'), (53212, 'WEBG5'), (56080, 'ERPG5');