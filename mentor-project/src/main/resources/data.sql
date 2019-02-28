INSERT INTO APP_USERS (EMAIL, PASSWORD, FIRST_NAME, LAST_NAME, CONTACT_NO, REG_DATE, REG_CODE, ACTIVE, USER_TYPE) VALUES ('ABC@ABC.COM', 'password', 'ABC', 'DEF', '0000', NULL, 'CODE', 1, 'USER');
INSERT INTO APP_USERS (EMAIL, PASSWORD, FIRST_NAME, LAST_NAME, CONTACT_NO, REG_DATE, REG_CODE, ACTIVE, USER_TYPE, LINKEDIN_URL, YEARS_EXP) VALUES ('ABD@ABC.COM', 'password', 'ABC', 'DEF', '0000', NULL, 'CODE', 1, 'MENTOR', 'http://', 2);
INSERT INTO APP_USERS (EMAIL, PASSWORD, FIRST_NAME, LAST_NAME, CONTACT_NO, REG_DATE, REG_CODE, ACTIVE, USER_TYPE) VALUES ('ABE@ABC.COM', 'password', 'ABC', 'DEF', '0000', NULL, 'CODE', 1, 'ADMIN');

INSERT INTO MENTOR_WORKING_TIMES (MENTOR_EMAIL, FROM_HOUR, TO_HOUR, DAY_OF_WEEK) VALUES ('ABD@ABC.COM', PARSEDATETIME('13:00', 'HH:MM'), PARSEDATETIME('15:00', 'HH:MM'), '1');
INSERT INTO MENTOR_WORKING_TIMES (MENTOR_EMAIL, FROM_HOUR, TO_HOUR, DAY_OF_WEEK) VALUES ('ABD@ABC.COM', PARSEDATETIME('13:00', 'HH:MM'), PARSEDATETIME('15:00', 'HH:MM'), '2');
INSERT INTO MENTOR_WORKING_TIMES (MENTOR_EMAIL, FROM_HOUR, TO_HOUR, DAY_OF_WEEK) VALUES ('ABD@ABC.COM', PARSEDATETIME('13:00', 'HH:MM'), PARSEDATETIME('15:00', 'HH:MM'), '3');

INSERT INTO TECHNOLOGIES (EMAIL, TECHNOLOGY) VALUES ('ABD@ABC.COM', 'JAVA8');

INSERT INTO TRAININGS (ID, NAME, COST, MENTOR_ID) values  ('asdjkal-fdfs', 'First Training', 44, 'ABD@ABC.COM');
INSERT INTO TRAININGS (ID, NAME, COST, MENTOR_ID) values  ('asdjkal-fdfd', 'Second Training', 500, 'ABD@ABC.COM');