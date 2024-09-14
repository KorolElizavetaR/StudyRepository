CREATE TYPE "role" AS ENUM ('ROLE_ADMIN', 'ROLE_USER');

CREATE TABLE "user"
(
	"id" int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	username varchar (50) NOT NULL,
	"password" varchar NOT NULL,
	user_role "role" NOT NULL
);
Select * from person; 


