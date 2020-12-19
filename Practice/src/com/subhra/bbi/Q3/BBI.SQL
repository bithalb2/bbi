-- 1. How many Female and how many male passengers travelled for a minimum distance of 600 KM s?

SELECT Gender, count(Gender) AS Total_Number FROM Passenger GROUP BY Gender;

-- 2. Find the minimum ticket price for AC compartment

SELECT min(Price) AS Min_Ticket_Price FROM Price WHERE Compartment = 'AC';

-- 3. Select passenger names whose names start with character 'S'

SELECT Passenger_Name FROM Passenger WHERE Passenger_Name LIKE 'S%';

-- 4. Calculate price charged for each passenger displaying Passenger name, Boarding station, Destination station, Compartment, Price in the output

SELECT Passenger.Passenger_Name, Passenger.Boarding_Station, Passenger.Destination_Station, Passenger.Compartment,  Price.Price FROM Passenger INNER JOIN Price ON  Passenger.Distance = Price.Distance AND Passenger.Compartment = Price.Compartment;

-- 5. What is the passenger name and his/her ticket price who travelled in Non-AC compartment for a distance of 1000 KM s

SELECT Passenger.Passenger_Name, Price.Price FROM Passenger INNER JOIN Price ON Passenger.Distance >= 1000 AND Passenger.Compartment = 'Non-AC' AND Passenger.Distance = Price.Distance AND Passenger.Compartment = Price.Compartment;

-- 6. Linda Travelled from Mumbai to Goa, if she had travelled from Mumbai to Chennai calculate how much extra cost does she need to pay (distance should not be hardcoded in the query)

SELECT Passenger_Name, ((SELECT Price FROM Price WHERE Distance = (SELECT Distance FROM Passenger WHERE Boarding_Station = 'Mumbai' AND Destination_Station = 'Chennai') AND Compartment = (SELECT Compartment FROM Passenger WHERE Passenger_Name = 'Linda')) - (SELECT Price FROM Price WHERE Distance = (SELECT Distance FROM Passenger WHERE Passenger_Name = 'Linda') AND Compartment = (SELECT Compartment FROM Passenger WHERE Passenger_Name = 'Linda'))) AS Extra_Cost FROM Passenger Where Passenger_Name = 'Linda';

-- 7. What will be the AC and Non-AC charge for Tina to travel from Bangalore to Goa?

SELECT Compartment, Price FROM Price WHERE Distance = (SELECT Distance FROM Passenger WHERE Passenger_Name = 'Tina');

-- 8. List the distances from "Passenger" table which are unique (non-repeated distances)

SELECT DISTINCT(Distance) FROM Passenger;

-- 9. Display the passenger name and percentage of distance travelled by that passenger from the total distance travelled by all passengers without using user variables

SELECT Passenger_Name, (Distance/temp.sum*100) AS Percentage_Of_Distance_Travel FROM Passenger CROSS JOIN (SELECT sum(Distance) AS sum FROM Passenger) temp;

-- 10. How many times did character 'a' appear in the column passenger name of "Passenger" table

SELECT Passenger_Name, (length(Passenger_Name) - length(replace(Passenger_Name, 'a', ''))) As "No_Of_A's" FROM Passenger;