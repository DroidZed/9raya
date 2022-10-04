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
   
        public int ProgrammedFlightNumber(DateTime startDate)
        {
            int q =
                (from flight in Flights
                 where !flight.FlightDate.Equals(startDate)
                 && (flight.FlightDate - startDate).TotalDays < 7
                 select flight).Count();

            return q;
        }

        public double? DurationAverage(string destination)
        {
            double? avg = (
                    from flight in Flights
                    where flight.Destination!.Equals(destination)
                    select flight.EstimatedDuration
                ).Average();

            return avg;
        }

        public List<Flight> OrderedDurationFlights()
        {
            IEnumerable<Flight> q =
                    from flight in Flights
                    orderby flight.EstimatedDuration
                    descending
                    select flight;

            return q.ToList();
        }

        public List<Passenger> SeniorTravellers(Flight flight)
        {
            IEnumerable<Passenger> q = (
                    from passenger in flight.Passengers.OfType<Traveller>()
                    orderby passenger.BirthDate
                    select passenger
                ).Take(3);

            return q.ToList();
        }

        public void DestinationGroupedFlights()
        {
            var q = 
                    from flight in Flights
                    group flight by flight.Destination;

            foreach (var g in q)
            {
                Console.WriteLine(g.Key);
                foreach(Flight f in g)
                {
                    Console.WriteLine($"Decollage: {f.FlightDate}");
                }
                Console.WriteLine();
            }
            
        }

        public Action<Plane> FlightDetailsDel;
        public Func<string, double?> DurationAverageDel;

        public ServiceFlight()
        {
            // FlightDetailsDel = ShowFlightDetails;
            // DurationAverageDel = DurationAverage;
            FlightDetailsDel = (plane) => ShowFlightDetails(plane);
            DurationAverageDel = (dest) =>
            {
                double? avg = (
                 from flight in Flights
                 where flight.Destination!.Equals(dest)
                 select flight.EstimatedDuration
             ).Average();

                return avg;
            };
        }
    }
}
