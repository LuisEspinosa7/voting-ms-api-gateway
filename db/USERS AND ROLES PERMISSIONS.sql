-- USERS AND ROLES PERMISSIONS
psql postgres postgres

\c postgres postgres
CREATE USER votingadmin WITH PASSWORD '123456';
CREATE DATABASE voting WITH OWNER votingadmin;
\c voting postgres
DROP SCHEMA public;

CREATE SCHEMA app AUTHORIZATION votingadmin;

\c voting votingadmin;


ALTER DEFAULT PRIVILEGES FOR ROLE votingadmin
   REVOKE EXECUTE ON FUNCTIONS FROM PUBLIC;

\c voting postgres

