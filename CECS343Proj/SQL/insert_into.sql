
insert into user(userName, password, emailAddress)
	values('mtomeh', 'sweetum123', 'mtomeh@att.net'),
	      ('daBestFeeder', 'mdsfdsnR8', 'darthblue27@gmail.com'),
	      ('ilovelucy', 'ilovelucy456', 'lucy@hotmail.com'),
	      ('shawnSpencer', 'pine@PPlE$', 's.spencer@yahoo.com'),
	      ('AdrianMonk', '420cleanAll', 'adrianm@gmail.com');
	      
	  
insert into restaurant(restaurantID, restaurantName, restaurantAddress, restaurantType)
	  values(1, 'Nomad Bistro', '2nd Street Long Beach, CA', 'Chinese Restaurant' ),
	        (2, 'Hatem Cuisine', 'Brookhurst Street Anaheim, CA', 'Persian Restaurant'),
		(3, 'HomeTown Buffet', 'Chapman Avenue Garden Grove,CA', 'Buffet'),
		(4, 'HomeTown Buffet', 'State College Blvd Anaheim,CA', 'Buffet'),
		(5, "Portillo's", "La Palma Avenue, Buena Park,CA", 'Chicago Style'),
		(6, "Outpost Grill", "7th Streeet Long Beach, CA", "Diner"),
		(7, "Nugget Grill and Pub", "7th Street Long Beach, CA","Restaurant/Pub"),
		(8, "The Chatroom ", "6049 E 7th St, Long Beach, CA 90840","Restaurant"),
		(9, "Panda Express ", " CSU LONG BEACH PX, 6049 E 7th St,Long Beach,CA","Fast food/ Chinese restaurant"),
		(10, "Beach Walk", "6049 E 7th St, Long Beach, CA 90840", "Restaurant"),
		(11, "Subway", "1212 N Bellflower Blvd, Long Beach, CA 90815", "Restaurant"),
		(12, "Sapporo Sushi", "5735 Pacific Coast Hwy, Long Beach, CA 90803", "Sushi"),
		(13, "Thiptara Thai Restaurant", "5630 Pacific Coast Hwy, Long Beach, CA 90814", "Thai restaurant"),
		(14, "zpizza", " 5718 E 7th St, Long Beach, CA 90803", "Pizza restaurant"),
		(15, "CHA FOR TEA", " 5720 E 7th St, Long Beach, CA 90803", "Tea House"),
		(16, "El Pollo Loco", "1212 N Bellflower Blvd, Long Beach, CA 90815", "Mexican restaurant"),
		(17, "Starbucks", " 6049 E 7th St, Long Beach, CA 90840", "Coffee/ Beverage "),
		(18, "Great Mex Grill Long Beach", "5530 E Atherton St, Long Beach, CA 90815", "Mexican restaurant"),
		(19, "Denny's", "5570 Pacific Coast Hwy, Long Beach, CA 90804", "Diner "),
		(20, "Pho Hong Phat", " 3243 E Anaheim St, Long Beach, CA 90804", "Vietnamese restaurant");

insert into review(userName, restaurantID, reviewNumber, reviewContent, starRating)
	VALUES('mtomeh', '1', '1', 'This place is the best and amazing place I have dined at', '4'),
	      ('mtomeh', '1', '2', 'This place is the best and amazing place I have dined at', '3');


insert into review_stats(restaurantID, reviewNumber, thumbedBy, likeOrDislike)
	VALUES(1,1, 'daBestFeeder', TRUE),
	      (1,1, 'mtomeh', TRUE);


insert into restaurant_hours(restaurantID, Sunday, Monday, Tuesday, Wednesday,  Thursday, Friday, Saturday)
    values(1, "11:30 AM - 9:30 PM", "11:30 AM - 9:30 PM", "11:30 AM - 9:30 PM", "11:30 AM - 9:30 PM", "11:30 AM - 9:30 PM", "11:30 AM - 9:30 PM", "11:30 AM - 9:30 PM"),
	      (2, "11:00 AM - 10:00 PM", "11:00 AM - 10:00 PM", "11:00 AM - 10:00 PM", "11:00 AM - 10:00 PM", "11:00 AM - 10:00 PM", "11:00 AM - 10:00 PM", "11:00 AM - 10:00 PM"),
	      (3, "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM"),
	      (4, "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM", "9:00 AM - 9:00 PM"),
	      (5, "10:30 AM - 10:30 PM", "10:30 AM - 10:30 PM", "10:30 AM - 10:30 PM", "10:30 AM - 10:30 PM", "10:30 AM - 10:30 PM", "10:30 AM - 11:00 PM", "10:30 AM - 11:00 PM"),
	      (6, "Closed", "7:30 AM - 7:30 PM", "7:30 AM - 7:30 PM", "7:30 AM - 7:30 PM", "7:30 AM - 7:30 PM", "7:30 AM - 2:00 PM", "Closed"),
	      (7, "Closed", "7:30 AM - 7:30 PM", "7:30 AM - 7:30 PM", "7:30 AM - 7:30 PM", "7:30 AM - 7:30 PM", "7:30 AM - 2:00 PM", "Closed"),
	      (8, "Closed", "11:00 AM - 2PM", "11:00 AM - 2PM", "11:00 AM - 2PM", "11:00 AM - 2PM", "11:00 AM - 2PM", "Closed"),
	      (9, "Closed", "10:00 AM - 7:00 PM", "10:00 AM - 7:00 PM", "10:00 AM - 7:00 PM", "10:00 AM - 7:00 PM", "10:00 AM - 2PM", "Closed"),
	      (10, "Closed", "9:00 AM - 7:00 PM", "9:00 AM - 7:00 PM", "9:00 AM - 7:00 PM", "9:00 AM - 7:00 PM", "9:00 AM - 2PM", "Closed"),
	      (11, "Closed", "7:00 AM - 9:00 PM", "7:00 AM - 9:00 PM", "7:00 AM - 9:00 PM", "7:00 AM - 9:00 PM", "10:00 AM - 2PM", "Closed"),
	      (12, "11:30 AM- 10:00 PM", "11:30 AM- 10:00 PM", "11:30 AM- 10:00 PM", "11:30 AM- 10:00 PM", "11:30 AM- 10:00 PM", "11:30 AM- 10:30 PM", "11:30 AM- 10:00 PM"),
	      (13, "10:00 AM - 10:00 PM", "11:00 AM - 3:00 PM & 5:00 PM - 10:00 PM", "11:00 AM - 3:00 PM & 5:00 PM - 10:00 PM", "11:00 AM - 3:00 PM & 5:00 PM - 10:00 PM", "11:00 AM - 3:00 PM & 5:00 PM - 10:00 PM", "11:00 AM - 3:00 PM & 5:00 PM - 10:00 PM", "11:00 AM - 11:00 PM"),
	      (14, "11:00 AM - 8:30 PM", "11:00 AM - 8:30 PM", "11:00 AM - 8:30 PM", "11:00 AM - 8:30 PM", "11:00 AM - 8:30 PM", "11:00 AM - 9:00 PM", "11:00 AM - 9:00 PM"),
	      (15, "10:00 AM - 12:00 AM", "10:00 AM - 12:00 AM", "10:00 AM - 12:00 AM", "10:00 AM - 12:00 AM", "10:00 AM - 12:00 AM", "10:00 AM - 12:00 AM", "10:00 AM - 12:00 AM"),
	      (16, "7- 7:30 AM", "10:00 AM - 9:00 PM", "10:00 AM - 9:00 PM", "10:00 AM - 9:00 PM",  "10:00 AM - 9:00 PM" , "10:00 AM - 3:00 PM" , "7-7:30 AM"),
	      (17, "12:30 PM - 9:00 PM", "7:00 AM - 9:00 PM", " 7:00 AM - 9:00 PM ", "7:00 AM - 9:00 PM",  "7:00 AM - 9:00 PM" , "7:00 AM - 2:00 PM" , "10:00 Am - 2:00 PM"),
	      (18, "8:30 AM - 8:00 PM", "7AM - 9PM", "7AM - 10:30 PM", "7AM - 9PM",  "7AM - 9PM" , "7AM - 9PM" , "7:30 AM - 9:00 PM"),
	      (19, "Open 24 hours", "Open 24 hours", "Open 24 hours", "Open 24 hours",  "Open 24 hours" , "Open 24 hours" , "Open 24 hours"),
	      (20, "8:00 AM - 5:00 PM", "8:00 AM - 5:00 PM", "8:00 AM - 5:00 PM", "Closed",  "8:00 AM - 5:00 PM" , "8:00 AM - 5:00 PM" , "8:00 AM - 5:00 PM"); 
