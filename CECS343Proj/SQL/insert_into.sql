insert into review_stats(restaurantID, reviewNumber, thumbedBy, likeOrDislike)
	VALUES(1,1, 'daBestFeeder', TRUE),
	      (1,1, 'mtomeh', TRUE);

insert into review(userName, restaurantID, reviewNumber, reviewContent, starRating)
	VALUES('mtomeh', '1', '1', 'This place is the best and amazing place I have dined at', '4'),
	      ('mtomeh', '1', '2', 'This place is the best and amazing place I have dined at', '3');

)

insert into restaurant(restaurantID, restaurantName, restaurantAddress, restaurantType)
	  values(1, 'Nomad Bistro', '2nd Street Long Beach, CA', 'Chinese Restaurant' ),
	        (2, 'Hatem Cuisine', 'Brookhurst Street Anaheim, CA', 'Persian Restaurant'),
		(3, 'HomeTown Buffet', 'Chapman Avenue Garden Grove,CA', 'Buffet'),
		(4, 'HomeTown Buffet', 'State College Blvd Anaheim,CA', 'Buffet'),
		(5, "Portillo's", "La Palma Avenue, Buena Park,CA", 'Chicago Style'),
		(6, "Outpost Grill", "7th Streeet Long Beach, CA", "Diner"),

		(7, "Nugget Grill and Pub", "7th Street Long Beach, CA","Restaurant/Pub");

insert into user(userName, password, emailAddress)
	values('mtomeh', 'mnr123', 'mtomeh@att.net'),
	      ('daBestFeeder', 'mdsfdsnR8', 'darthblue27@gmail.com'),
	      ('ilovelucy', 'ilovelucy456', 'lucy@hotmail.com'),
	      ('shawnSpencer', 'pine@PPlE$', 's.spencer@yahoo.com'),
	      ('AdrianMonk', '420cleanAll', 'adrianm@gmail.com');
		 

insert into restaurant_hours(restaurantID, Sunday, Monday, Tuesday, Wednesday,  Thursday, Friday, Saturday)
    values(1, "11:30 AM - 9:30 PM", "11:30 AM - 9:30 PM", "11:30 AM - 9:30 PM", "11:30 AM - 9:30 PM", "11:30 AM - 9:30 PM", "11:30 AM - 9:30 PM", "11:30 AM - 9:30 PM"),
	      (2, "11:00 AM - 10:00 PM", "11:00 AM - 10:00 PM", "11:00 AM - 10:00 PM", "11:00 AM - 10:00 PM", "11:00 AM - 10:00 PM", "11:00 AM - 10:00 PM", "11:00 AM - 10:00 PM"),
	      (3, "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM"),
	      (4, "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM"),
	      (5, "10:30 AM - 10:30 PM", "10:30 AM - 10:30 PM", "10:30 AM - 10:30 PM", "10:30 AM - 10:30 PM", "10:30 AM - 10:30 PM", "10:30 AM - 11:00 PM", "10:30 AM - 11:00 PM"),
	      (6, "Closed", "7:30 AM - 7:30 PM", "7:30 AM - 7:30 PM", "7:30 AM - 7:30 PM", "7:30 AM - 7:30 PM", "7:30 AM - 2:00 PM", "Closed"),
	      (7, "Closed", "7:30 AM - 7:30 PM", "7:30 AM - 7:30 PM", "7:30 AM - 7:30 PM", "7:30 AM - 7:30 PM", "7:30 AM - 2:00 PM", "Closed"); 