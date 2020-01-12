INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE, REMAINING_HOLIDAY) VALUES(TRUE, 'Admin', 'Istrator', '$2y$10$0/S37i4blxIF88Kgl4PldeJL/OrVLm0vr9Z6/.ztgQu83BNvFwEF.', 'admin', 'admin', '2016-01-01 00:00:00','35')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('admin', 'ADMIN')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('admin', 'EMPLOYEE')
INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE,REMAINING_HOLIDAY) VALUES(TRUE, 'Susi', 'Kaufgern', '$2y$10$0/S37i4blxIF88Kgl4PldeJL/OrVLm0vr9Z6/.ztgQu83BNvFwEF.', 'user1', 'admin', '2016-01-01 00:00:00','35')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user1', 'MANAGER')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user1', 'EMPLOYEE')
INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE, JOB_TITLE,REMAINING_HOLIDAY) VALUES(TRUE, 'Max', 'Mustermann', '$2y$10$0/S37i4blxIF88Kgl4PldeJL/OrVLm0vr9Z6/.ztgQu83BNvFwEF.', 'user2', 'admin', '2016-01-01 00:00:00','Pilot','35')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user2', 'EMPLOYEE')
INSERT INTO AIRCRAFT(AIRCRAFT_ID, AIRCRAFT_TYPE, REQUIRED_PILOTS_AIRCRAFT, CAPACITY_AIRCRAFT, CREATE_DATE, REQUIRED_BOARDPERSONAL_AIRCRAFT) VALUES ('123A','BOEING','23', '200','2016-01-01 00:00:00', '2')
INSERT INTO AIRCRAFT(AIRCRAFT_ID, AIRCRAFT_TYPE, REQUIRED_PILOTS_AIRCRAFT, CAPACITY_AIRCRAFT, CREATE_DATE, REQUIRED_BOARDPERSONAL_AIRCRAFT) VALUES ('123B','AIRBUS','23', '100','2016-01-01 00:00:00', '2')
INSERT INTO AIRCRAFT(AIRCRAFT_ID, AIRCRAFT_TYPE, REQUIRED_PILOTS_AIRCRAFT, CAPACITY_AIRCRAFT, CREATE_DATE, REQUIRED_BOARDPERSONAL_AIRCRAFT) VALUES ('123C','AIRBUS','23', '125','2016-01-01 00:00:00', '2')
INSERT INTO AIRCRAFT(AIRCRAFT_ID, AIRCRAFT_TYPE, REQUIRED_PILOTS_AIRCRAFT, CAPACITY_AIRCRAFT, CREATE_DATE, REQUIRED_BOARDPERSONAL_AIRCRAFT) VALUES ('123D','AIRBUS','23', '325','2016-01-01 00:00:00', '2')
INSERT INTO AIRCRAFT(AIRCRAFT_ID, AIRCRAFT_TYPE, REQUIRED_PILOTS_AIRCRAFT, CAPACITY_AIRCRAFT, CREATE_DATE, REQUIRED_BOARDPERSONAL_AIRCRAFT) VALUES ('123E','BOEING','23', '55','2016-01-01 00:00:00', '2')
INSERT INTO AIRCRAFT(AIRCRAFT_ID, AIRCRAFT_TYPE, REQUIRED_PILOTS_AIRCRAFT, CAPACITY_AIRCRAFT, CREATE_DATE, REQUIRED_BOARDPERSONAL_AIRCRAFT) VALUES ('123F','BOEING','23', '15','2016-01-01 00:00:00', '2')
INSERT INTO FLIGHT(FLIGHT_ID, IATA_FROM, IATA_TO, CREATE_DATE, NUMBER_OF_PASSENGERS, DEPARTURE_TIME, ARRIVAL_TIME, AIRCRAFT_ID) VALUES('A120913' ,'MUC', 'IBK', '2016-01-01 00:00:00', '200', '2019-12-01 09:30:00', '2019-12-01 11:30:00','123A')
INSERT INTO FLIGHT(FLIGHT_ID, IATA_FROM, IATA_TO, CREATE_DATE, NUMBER_OF_PASSENGERS, DEPARTURE_TIME, ARRIVAL_TIME, AIRCRAFT_ID) VALUES('A120912' ,'MUC', 'IBK', '2016-01-01 00:00:00', '125', '2019-12-01 09:30:00', '2019-12-01 11:30:00','123B')
INSERT INTO FLIGHT(FLIGHT_ID, IATA_FROM, IATA_TO, CREATE_DATE, NUMBER_OF_PASSENGERS, DEPARTURE_TIME, ARRIVAL_TIME, AIRCRAFT_ID) VALUES('A120911' ,'MUC', 'IBK', '2016-01-01 00:00:00', '100', '2019-12-01 09:30:00', '2019-12-01 11:30:00','123C')
INSERT INTO FLIGHT(FLIGHT_ID, IATA_FROM, IATA_TO, CREATE_DATE, NUMBER_OF_PASSENGERS, DEPARTURE_TIME, ARRIVAL_TIME, AIRCRAFT_ID) VALUES('A120910' ,'MUC', 'IBK', '2016-01-01 00:00:00', '45', '2019-12-01 09:30:00', '2019-12-01 11:30:00','123D')
INSERT INTO FLIGHT(FLIGHT_ID, IATA_FROM, IATA_TO, CREATE_DATE, NUMBER_OF_PASSENGERS, DEPARTURE_TIME, ARRIVAL_TIME, AIRCRAFT_ID) VALUES('A120909' ,'MUC', 'IBK', '2016-01-01 00:00:00', '13', '2019-12-01 09:30:00', '2019-12-01 11:30:00','123E')
INSERT INTO FLIGHT(FLIGHT_ID, IATA_FROM, IATA_TO, CREATE_DATE, NUMBER_OF_PASSENGERS, DEPARTURE_TIME, ARRIVAL_TIME, AIRCRAFT_ID) VALUES('A120908' ,'MUC', 'IBK', '2016-01-01 00:00:00', '75', '2019-12-01 09:30:00', '2019-12-01 11:30:00','123F')
INSERT INTO FLIGHT(FLIGHT_ID, IATA_FROM, IATA_TO, CREATE_DATE, NUMBER_OF_PASSENGERS, DEPARTURE_TIME, ARRIVAL_TIME) VALUES('A120907' ,'MUC', 'IBK', '2016-01-01 00:00:00', '75', '2019-12-01 09:30:00', '2019-12-01 11:30:00')
INSERT INTO HOLIDAY(CREATE_DATE, HOLIDAY_FROM, HOLIDAY_UNTIL, USERNAME, HOLIDAY_DAYS) VALUES('2016-01-01 00:00:00', '2019-01-01', '2019-01-02', 'user2', '1')