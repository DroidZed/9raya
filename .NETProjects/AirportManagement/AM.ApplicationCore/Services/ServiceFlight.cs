using AM.ApplicationCore.Domain;
using AM.ApplicationCore.Interfaces;

namespace AM.ApplicationCore.Services
{
    public class ServiceFlight : IServiceFlight
    {
        public List<Flight>? Flights { get; set; } = new List<Flight>();

        public List<DateTime>? GetFlightDates(string destination)
        {

            if (Flights == null) return null;

            IEnumerable<DateTime> flightsQuery =
                from flight in Flights
                where flight.Destination!.Equals(destination)
                select flight.FlightDate;

            return flightsQuery.ToList();
        }

        public void GetFlights(string filterType, string filterValue)
        {
            switch(filterType)
            {
                case "Destination":
                    {

                        foreach (Flight f in Flights!)
                        {
                            if (f.Destination!.Equals(filterValue))
                                Console.WriteLine(f);
                        }
                    }
                        break;
                case "FlightDate":
                    {
                        foreach (Flight f in Flights!)
                        {
                            if (f.FlightDate.Equals(DateTime.Parse(filterValue)))
                                Console.WriteLine(f);
                        }
                    }
                    break;

                case "Departure":
                    {
                        foreach (Flight f in Flights!)
                        {
                            if (f.Departure!.Equals(filterValue))
                                Console.WriteLine(f);
                        }
                    }
                    break;

                default:
                    break;
            }
        }

        public void ShowFlightDetails(Plane plane)
        {
            var flightsQuery = 
                from flight in Flights
                where flight.Plane!.Equals(plane)
                select new { flight.FlightDate, flight.Destination };

            foreach (var info in flightsQuery) 
            {
                Console.WriteLine($"Flight date: {info.FlightDate}\nFlight destination: {info.Destination}");
            }
        }

        Dictionary<string, List<DateTime?>> DestinationGroupedFlights()
        {
            
        }

        int DurationAverage(string destination)
        {
            
        }

        List<DateTime>? GetFlightDates(string destination)
        {
            
        }

        void GetFlights(string filterType, string filterValue)
        {
            
        }

        List<Flight> OrderedDurationFlights()
        {
            
        }

        int ProgrammedFlightNumber(DateTime startDate)
        {

        }

        List<Passenger> SeniorTravellers(Flight flight)
        {
            
        }

        void ShowFlightDetails(Plane plane)
        {
            
        }
    }
}
