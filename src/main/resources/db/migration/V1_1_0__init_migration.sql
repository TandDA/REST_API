CREATE TABLE File(
	id int primary key not null,
    name varchar(50),
    filePath varchar(200)
);
CREATE TABLE User(
	id int primary key not null,
    name varchar(100)
);
CREATE TABLE Event(
	id int primary key not null,
    userId int,
    fileId int,
    FOREIGN KEY (userId)  REFERENCES User (id),
    FOREIGN KEY (fileId)  REFERENCES File (id)
);