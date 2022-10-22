namespace AM.ApplicationCore.Domain
{
    public static class TestData
    {
        public static Plane PlaneB= new Plane { 
            PlaneType= PlaneType.Boing,
            Capacity= 150,
            ManufactureDate= new DateTime(2015, 02, 03)
        };

        public static Plane PlaneA= new Plane
        {
            PlaneType= PlaneType.Airbus,
            Capacity= 250,
            ManufactureDate= new DateTime(2020, 11, 11)
        };

        public static Staff Staff1= new Staff {
          
            FullName= new FullName("captain","captain"),
            EmailAddress= "Captain.captain@gmail.com",
            BirthDate= new DateTime(1965,01,01),
            EmploymentDate= new DateTime(1999,01,01),
            Salary= 99999
        };

        public static Staff Staff2= new Staff
        {
            FullName= new FullName("hostess1", "hostess1"),
            EmailAddress= "hostess1.hostess1@gmail.com",
            BirthDate= new DateTime(1995, 01, 01),
            EmploymentDate= new DateTime(2020, 01, 01),
            Salary= 999
        };

        public static Staff Staff3= new Staff
        {
            FullName= new FullName("hostess2", "hostess2"),
            EmailAddress= "hostess2.hostess2@gmail.com",
            BirthDate= new DateTime(1996, 01, 01),
            EmploymentDate= new DateTime(2020, 01, 01),
            Salary= 999
        };

        public static Traveller Traveller1= new Traveller
        {
            FullName= new FullName("Traveller1","Traveller1"),
            EmailAddress= "Traveller1.Traveller1@gmail.com",
            BirthDate= new DateTime(1980, 01, 01),
            HealthInformation= "No troubles",
            Nationality= "American"
        };

        public static Traveller Traveller2= new Traveller
        {
            FullName= new FullName("Traveller2", "Travelle2"),
            EmailAddress= "Traveller2.Traveller2@gmail.com",
            BirthDate= new DateTime(1981, 01, 01),
            HealthInformation= "Some troubles",
            Nationality= "French"
        };

        public static Traveller Traveller3= new Traveller
        {
            FullName= new FullName("Traveller3", "Traveller3"),
            EmailAddress= "Traveller3.Traveller3@gmail.com",
            BirthDate= new DateTime(1983, 01, 01),
            HealthInformation= "No troubles",
            Nationality= "Tunisian"
        };

        public static Traveller Traveller4= new Traveller
        {
            FullName= new FullName("Traveller4", "Traveller4"),
            EmailAddress= "Traveller4.Traveller4@gmail.com",
            BirthDate= new DateTime(1984, 01, 01),
            HealthInformation= "Some troubles",
            Nationality= "American"
        };

        public static Traveller Traveller5= new Traveller
        {
            FullName= new FullName("Traveller5", "Traveller5"),
            EmailAddress= "Traveller5.Traveller5@gmail.com",
            BirthDate= new DateTime(1985, 01, 01),
            HealthInformation= "Some troubles",
            Nationality= "Spanish"
        };

        public static Flight Flight1= new Flight { 
            FlightDate= new DateTime(2020, 01, 01, 15, 10, 10),
            EffectiveArrival= new DateTime(2020, 01, 01, 17, 10, 10),
            Destination= "Paris",
            MyPlane= PlaneA,
            EstimatedDuration=110,
            Passengers= new List<Passenger> { Traveller1,
                Traveller2, 
                Traveller3, 
                Traveller4,
                Traveller5
            }
        };

        public static Flight Flight2= new Flight
        {
            FlightDate= new DateTime(2020, 02, 01, 21, 10, 10),
            EffectiveArrival= new DateTime(2020, 02, 01, 23, 10, 10),
            Destination= "Paris",
            MyPlane= PlaneB,
            EstimatedDuration= 105,
        };

        public static Flight Flight3= new Flight
        {
            FlightDate= new DateTime(2020, 03, 01, 05, 10, 10),
            EffectiveArrival= new DateTime(2020, 03, 01, 06, 40, 10),
            Destination= "Paris",
            MyPlane= PlaneB,
            EstimatedDuration= 100,
        };

        public static Flight Flight4= new Flight
        {
            FlightDate= new DateTime(2020, 04, 01, 06, 10, 10),
            EffectiveArrival= new DateTime(2020, 04, 01, 08, 10, 10),
            Destination= "Madrid",
            MyPlane= PlaneB,
            EstimatedDuration= 130,
        };

        public static Flight Flight5= new Flight
        {
            FlightDate= new DateTime(2020, 05, 01, 17, 10, 10),
            EffectiveArrival= new DateTime(2020, 05, 01, 16, 50, 10),
            Destination= "Madrid",
            MyPlane= PlaneB,
            EstimatedDuration= 105,
        };

        public static Flight Flight6= new Flight
        {
            FlightDate= new DateTime(2020, 06, 01, 20, 10, 10),
            EffectiveArrival= new DateTime(2020, 04, 01, 22, 30, 10),
            Destination= "Lisbonne",
            MyPlane= PlaneA,
            EstimatedDuration= 200,
        };

        public static List<Flight> ListFlights= new List<Flight> {
            Flight1,
            Flight2,
            Flight3,
            Flight4,
            Flight5,
            Flight6,
        };
    }
}
