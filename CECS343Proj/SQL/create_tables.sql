
CREATE TABLE user(
	userName VARCHAR(50) not null,
	password VARCHAR(50) NOT NULL,
	emailAddress VARCHAR(50) NOT NULL,
	PRIMARY KEY(userName),
	unique (emailAddress)
);

CREATE TABLE restaurant (
   
	restaurantID int NOT NULL AUTO_INCREMENT,
	
	restaurantName varchar(45) NOT NULL,
   
	restaurantAddress varchar(45) not NULL,
   
	restaurantType varchar(45) not NULL,

   	PRIMARY KEY (restaurantID)

); 


create table restaurant_hours(
	restaurantID INT NOT NULL,
    Sunday VARCHAR(50) not null,
    Monday VARCHAR(50) NOT NULL,
    Tuesday VARCHAR(50) not null,
    Wednesday VARCHAR(50) NOT NULL,
    Thursday VARCHAR(50) NOT NULL,
    Friday VARCHAR(50) NOT NULL,
    Saturday VARCHAR(50) NOT NULL,
	PRIMARY KEY(restaurantID),
	FOREIGN KEY(restaurantID) references restaurant(restaurantID)
);


	CREATE TABLE review(
		userName VARCHAR(50) NOT NULL,
		restaurantID INT NOT NULL,
		reviewNumber INT NOT NULL,
		reviewContent VARCHAR(2000),
		starRating INT NOT NULL,
        PRIMARY KEY(restaurantID, reviewNumber),
		FOREIGN KEY(userName) REFERENCES user(userName),
		FOREIGN KEY(restaurantID) REFERENCES restaurant(restaurantID)
		
	);
    
		
	CREATE TABLE review_stats(
			restaurantID INT not null,
			reviewNumber INT not null,
			thumbedBy VARCHAR(50) not null,
			likeOrDislike BOOLEAN not null,
			primary key(restaurantID, reviewNumber, thumbedBy),
			foreign key(thumbedBy) references user(userName),
			foreign key(restaurantID, reviewNumber) references review(restaurantID, reviewNumber)
	)