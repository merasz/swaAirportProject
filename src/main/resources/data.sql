INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE) VALUES(TRUE, 'Admin', 'Istrator', '$2y$10$0/S37i4blxIF88Kgl4PldeJL/OrVLm0vr9Z6/.ztgQu83BNvFwEF.', 'admin', 'admin', '2016-01-01 00:00:00')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('admin', 'ADMIN')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('admin', 'EMPLOYEE')
INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE) VALUES(TRUE, 'Susi', 'Kaufgern', '$2y$10$0/S37i4blxIF88Kgl4PldeJL/OrVLm0vr9Z6/.ztgQu83BNvFwEF.', 'user1', 'admin', '2016-01-01 00:00:00')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user1', 'MANAGER')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user1', 'EMPLOYEE')
INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE) VALUES(TRUE, 'Max', 'Mustermann', '$2y$10$0/S37i4blxIF88Kgl4PldeJL/OrVLm0vr9Z6/.ztgQu83BNvFwEF.', 'user2', 'admin', '2016-01-01 00:00:00')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user2', 'EMPLOYEE')
INSERT INTO AIRCRAFT(AIRCRAFT_ID, AIRCRAFT_TYPE, REQUIRED_PILOTS_AIRCRAFT, CAPACITY_AIRCRAFT, CREATE_DATE, REQUIRED_BOARDPERSONAL_AIRCRAFT) VALUES ('123A','BOEING','23', '21','2016-01-01 00:00:00', '2')