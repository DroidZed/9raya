using AM.ApplicationCore.Domain;
using AM.ApplicationCore.Services;

/* 
Plane p1 = new();

p1.Capacity = 720;
p1.ManufactureDate = DateTime.Now;
p1.PlaneType = PlaneType.Boing;
p1.PlaneId = 2;

Plane p2 = new Plane(PlaneType.Airbus, 200, new DateTime(2022, 5, 17));

*/

Plane p3 = new Plane { 
    PlaneType = PlaneType.Airbus,
    Capacity = 200, 
    ManufactureDate = DateTime.Now
};

Passenger pass = new Passenger { 
    FirstName = "Passenger1",
    LastName = "Passenger1",
    BirthDate = new DateTime(1970, 1, 10),
    EmailAddress = "passenger1.passenger1@example.com",
    PassportNumber = 125465,
    TelNumber = 12345678
};

Staff s = new Staff();
Traveller t = new();

Console.WriteLine(p3);

pass.PassengerType();

Console.WriteLine();

s.PassengerType();

t.PassengerType();

Console.WriteLine($"The profile of passanger {pass.FirstName} is: {(pass.CheckProfile("Passenger1", "Passenger1") ? "verified" : "unverified")}");

ServiceFlight sf = new ServiceFlight();

sf.Flights = TestData.ListFlights;

