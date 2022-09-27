namespace AM.ApplicationCore.Domain
{
    public static class TestData
    {


        public static Plane Boing = new() { PlaneType = PlaneType.Boing, Capacity = 150, ManufactureDate = new DateTime(2015, 2, 3) };
        public static Plane Airbus = new() { PlaneType = PlaneType.Airbus, Capacity = 250, ManufactureDate = new DateTime(2020, 11, 11) };

        public static List<Staff> Staff = new()
        {
            new() {
                FirstName = "captain",
                LastName = "captain",
                EmailAddress = "Captain.captain@gmail.com",
                BirthDate = new DateTime(1965,1,1),
                EmploymentDate = new DateTime(1999,1,1),
                Salary=99999
            },
            new() {
                FirstName = "hostess1",
                LastName = "hostess1",
                EmailAddress = "hostess1.hostess1@gmail.com",
                BirthDate = new DateTime(1995,1,1),
                EmploymentDate = new DateTime(2020,1,1),
                Salary=999
            },
            new() {
                FirstName = "hostess2",
                LastName = "hostess2",
                EmailAddress = "hostess2.hostess2@gmail.com",
                BirthDate = new DateTime(1996,1,1),
                EmploymentDate = new DateTime(2020,1,1),
                Salary=999
            },
        };

        public static List<Traveller> Travellers = new()
        {
            new()
            {
                FirstName = "Traveller1",
                LastName  = "Traveller1",
                EmailAddress = "Traveller1.Traveller1@gmail.com",
                BirthDate = new DateTime(1980,1,1),
                HealthInformation = "No troubles",
                Nationality = "American"
            },

            new()
            {
                FirstName = "Traveller2",
                LastName  = "Traveller2",
                EmailAddress = "Traveller2.Traveller2@gmail.com",
                BirthDate = new DateTime(1981,1,1),
                HealthInformation = "Some troubles",
                Nationality = "French"
            },

            new()
            {
                FirstName = "Traveller3",
                LastName  = "Traveller3",
                EmailAddress = "Traveller3.Traveller3@gmail.com",
                BirthDate = new DateTime(1982,1,1),
                HealthInformation = "No troubles",
                Nationality = "Tunisian"
            },

            new()
            {
                FirstName = "Traveller4",
                LastName  = "Traveller4",
                EmailAddress = "Traveller4.Traveller4@gmail.com",
                BirthDate = new DateTime(1983,1,1),
                HealthInformation = "Some troubles",
                Nationality = "American"
            },

            new()
            {
                FirstName = "Traveller5",
                LastName  = "Traveller5",
                EmailAddress = "Traveller5.Traveller5@gmail.com",
                BirthDate = new DateTime(1984,1,1),
                HealthInformation = "Some troubles",
                Nationality = "Spanish"
            }
        };

        public static List<Flight> Flights = new()
        {
            new()
            {
                FlightDate = new DateTime(2022,1,1,15,10,10),
                Destination = "Paris",
                EffectiveArrival = new DateTime(2022,1,1,17,10,10),
                Plane = Airbus,
                EstimatedDuration = 110,
                Passengers = new List<Passenger> () { Travellers }
            }
        };
    }
}
