
INSERT INTO tbl_customer(customer_address,customer_city,customer_mail,customer_name,customer_phone)
VALUES ('Nevzat sk. No:12','Hatay','hakanyılmaz@gmail.com','Hakan Yılmaz','05641237895'),
       ('Menekşe sk. No:15','Eskişehir','cemreyşm@gmail.com','Cemre Yeşim','05641231264'),
       ('Nevzat sk. No:12','Manisa','akınyaşar@gmail.com','Akın Yaşar','05154687595');

INSERT INTO tbl_animal(animal_breed,animal_colour,animal_birth_date,animal_gender,animal_name,animal_species,customer_id)
VALUES ('Cat','White','2023-10-05','Male','Thor','Cat',1),
       ('Dog','Black','2018-06-11','Male','Karabaş','Dog',2),
       ('Cat','Orange','2020-08-06','Female','Hela','Cat',1);

INSERT INTO tbl_doctor(doctor_address,doctor_city,doctor_mail,doctor_name,doctor_phone)
VALUES ('Nilüfer mah. Avcılar sk No:45','İzmir','mustafaşimşek@gmail.com','Mustafa Şimşek','05324597861'),
       ('Menekşe mah. Baglar sk No:45','İzmir','hllşimşek@gmail.com','Halil Şimşek','05324597861'),
       ('Nilüfer mah. Avcılar sk No:45','İzmir','özgürdgn@gmail.com','Özgür Dogan','05324597861');

INSERT INTO tbl_available_date(available_date,doctor_id)
VALUES ('2023-05-10',2),
       ('2023-08-20',1),
       ('2023-05-10',3);

INSERT INTO tbl_appointment(appointment_date,animal_id,doctor_id)
VALUES ('2023-05-10 12:00:00',1,2),
       ('2023-08-20 13:00:00',2,1),
       ('2023-05-10 13:00:00',3,2);

INSERT INTO tbl_vaccine(vaccine_code,vaccine_name,vaccine_protection_end,vaccine_protection_start,animal_id)
VALUES ('A12','A','2023-06-10','2023-05-10',1),
       ('JH3','JH','2023-09-20','2023-08-20',2),
       ('HB1','HB','2023-06-10','2023-05-10',3);