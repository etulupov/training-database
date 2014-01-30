-- CR2 Please reformat all sql files (at least idents which are not identical)

-- CR2 It doesn't work if this role doesn't exists in rdbs already. 
-- You have to check it. For eg you can create the temp procedure for this. (You have already done the same thing)

DROP DATABASE IF EXISTS Library
;

CREATE DATABASE IF NOT EXISTS Library
;

DROP PROCEDURE IF EXISTS Library.DROP_USER_IF_EXISTS
;
CREATE PROCEDURE Library.DROP_USER_IF_EXISTS()
BEGIN
  DECLARE usersCount BIGINT DEFAULT 0 ;
  SELECT COUNT(*) INTO usersCount FROM mysql.user WHERE User = 'library' and  Host = 'localhost';
  IF usersCount > 0 THEN
    DROP USER 'library'@'localhost' ;
  END IF;
END
;

CALL Library.DROP_USER_IF_EXISTS()
;

DROP PROCEDURE IF EXISTS Library.DROP_USER_IF_EXISTS
;

CREATE USER 'library'@'localhost' IDENTIFIED BY 'password'
;

GRANT ALL PRIVILEGES ON Library.* TO 'library'@'localhost' IDENTIFIED BY 'password'
;