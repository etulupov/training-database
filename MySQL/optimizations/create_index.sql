-- Book by title
ALTER TABLE Book ADD INDEX i_title (title);

-- Author by name
ALTER TABLE Author ADD INDEX i_name (`name`);

-- Publisher by name
ALTER TABLE Publisher ADD INDEX i_name (`name`);

