INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE, REMAINING_HOLIDAY) VALUES(TRUE, 'Admin', 'Istrator', '$2y$10$0/S37i4blxIF88Kgl4PldeJL/OrVLm0vr9Z6/.ztgQu83BNvFwEF.', 'admin', 'admin', '2016-01-01 00:00:00','35')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('admin', 'ADMIN')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('admin', 'EMPLOYEE')
INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE,REMAINING_HOLIDAY) VALUES(TRUE, 'Susi', 'Kaufgern', '$2y$10$0/S37i4blxIF88Kgl4PldeJL/OrVLm0vr9Z6/.ztgQu83BNvFwEF.', 'user1', 'admin', '2016-01-01 00:00:00','35')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user1', 'MANAGER')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user1', 'EMPLOYEE')
INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE, JOB_TITLE,REMAINING_HOLIDAY) VALUES(TRUE, 'Max', 'Mustermann', '$2y$10$0/S37i4blxIF88Kgl4PldeJL/OrVLm0vr9Z6/.ztgQu83BNvFwEF.', 'user2', 'admin', '2016-01-01 00:00:00','Pilot','35')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user2', 'EMPLOYEE')
INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE, JOB_TITLE,REMAINING_HOLIDAY) VALUES(TRUE, 'Mike', 'Tyson', '$2y$10$0/S37i4blxIF88Kgl4PldeJL/OrVLm0vr9Z6/.ztgQu83BNvFwEF.', 'user3', 'admin', '2016-01-01 00:00:00','Pilot','35')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user3', 'EMPLOYEE')
INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE, JOB_TITLE,REMAINING_HOLIDAY) VALUES(TRUE, 'Mike', 'Tysonfury', '$2y$10$0/S37i4blxIF88Kgl4PldeJL/OrVLm0vr9Z6/.ztgQu83BNvFwEF.', 'user4', 'admin', '2016-01-01 00:00:00','Pilot','35')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user4', 'EMPLOYEE')
INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE, JOB_TITLE,REMAINING_HOLIDAY) VALUES(TRUE, 'Mike', 'Tysongroup', '$2y$10$0/S37i4blxIF88Kgl4PldeJL/OrVLm0vr9Z6/.ztgQu83BNvFwEF.', 'user5', 'admin', '2016-01-01 00:00:00','Pilot','35')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user5', 'EMPLOYEE')
INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE, JOB_TITLE,REMAINING_HOLIDAY) VALUES(TRUE, 'Sha', 'Que', '$2y$10$0/S37i4blxIF88Kgl4PldeJL/OrVLm0vr9Z6/.ztgQu83BNvFwEF.', 'user6', 'admin', '2016-01-01 00:00:00','Board Crew','35')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user6', 'EMPLOYEE')
INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE, JOB_TITLE,REMAINING_HOLIDAY) VALUES(TRUE, 'Mala', 'Ka', '$2y$10$0/S37i4blxIF88Kgl4PldeJL/OrVLm0vr9Z6/.ztgQu83BNvFwEF.', 'user7', 'admin', '2016-01-01 00:00:00','Board Crew','35')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user7', 'EMPLOYEE')
INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE, JOB_TITLE,REMAINING_HOLIDAY) VALUES(TRUE, 'Pier', 'Sie', '$2y$10$0/S37i4blxIF88Kgl4PldeJL/OrVLm0vr9Z6/.ztgQu83BNvFwEF.', 'user8', 'admin', '2016-01-01 00:00:00','Board Crew','35')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user8', 'EMPLOYEE')
INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE, JOB_TITLE,REMAINING_HOLIDAY) VALUES(TRUE, 'French', 'Samoa', '$2y$10$0/S37i4blxIF88Kgl4PldeJL/OrVLm0vr9Z6/.ztgQu83BNvFwEF.', 'user9', 'admin', '2016-01-01 00:00:00','Board Crew','35')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user9', 'EMPLOYEE')
INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE, JOB_TITLE,REMAINING_HOLIDAY) VALUES(TRUE, 'Anda', 'Lusia', '$2y$10$0/S37i4blxIF88Kgl4PldeJL/OrVLm0vr9Z6/.ztgQu83BNvFwEF.', 'user10', 'admin', '2016-01-01 00:00:00','Board Crew','35')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user10', 'EMPLOYEE')
INSERT INTO AIRCRAFT(AIRCRAFT_ID, AIRCRAFT_TYPE, REQUIRED_PILOTS_AIRCRAFT, CAPACITY_AIRCRAFT, CREATE_DATE, REQUIRED_BOARDPERSONAL_AIRCRAFT) VALUES ('123A','BOEING','2', '200','2016-01-01 00:00:00', '2')
INSERT INTO AIRCRAFT(AIRCRAFT_ID, AIRCRAFT_TYPE, REQUIRED_PILOTS_AIRCRAFT, CAPACITY_AIRCRAFT, CREATE_DATE, REQUIRED_BOARDPERSONAL_AIRCRAFT) VALUES ('123B','AIRBUS','1', '100','2016-01-01 00:00:00', '2')
INSERT INTO AIRCRAFT(AIRCRAFT_ID, AIRCRAFT_TYPE, REQUIRED_PILOTS_AIRCRAFT, CAPACITY_AIRCRAFT, CREATE_DATE, REQUIRED_BOARDPERSONAL_AIRCRAFT) VALUES ('123C','AIRBUS','1', '125','2016-01-01 00:00:00', '2')
INSERT INTO AIRCRAFT(AIRCRAFT_ID, AIRCRAFT_TYPE, REQUIRED_PILOTS_AIRCRAFT, CAPACITY_AIRCRAFT, CREATE_DATE, REQUIRED_BOARDPERSONAL_AIRCRAFT) VALUES ('123D','AIRBUS','1', '325','2016-01-01 00:00:00', '2')
INSERT INTO AIRCRAFT(AIRCRAFT_ID, AIRCRAFT_TYPE, REQUIRED_PILOTS_AIRCRAFT, CAPACITY_AIRCRAFT, CREATE_DATE, REQUIRED_BOARDPERSONAL_AIRCRAFT) VALUES ('123E','BOEING','1', '55','2016-01-01 00:00:00', '1')
INSERT INTO AIRCRAFT(AIRCRAFT_ID, AIRCRAFT_TYPE, REQUIRED_PILOTS_AIRCRAFT, CAPACITY_AIRCRAFT, CREATE_DATE, REQUIRED_BOARDPERSONAL_AIRCRAFT) VALUES ('123F','BOEING','1', '15','2016-01-01 00:00:00', '1')
INSERT INTO AIRCRAFT(AIRCRAFT_ID, AIRCRAFT_TYPE, IS_SCHEDULED, REQUIRED_PILOTS_AIRCRAFT, CAPACITY_AIRCRAFT, CREATE_DATE, REQUIRED_BOARDPERSONAL_AIRCRAFT) VALUES ('123KKK','BOEING', 'true','2', '15','2016-01-01 00:00:00', '2')
INSERT INTO HOLIDAY(CREATE_DATE, HOLIDAY_FROM, HOLIDAY_UNTIL, USERNAME, HOLIDAY_DAYS) VALUES('2016-01-01 00:00:00', '2019-01-01', '2019-01-02', 'user2', '1')
