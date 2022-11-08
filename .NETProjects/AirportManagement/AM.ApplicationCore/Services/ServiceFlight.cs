using AM.ApplicationCore.Domain;
using AM.ApplicationCore.Interfaces;

namespace AM.ApplicationCore.Services
{
    public class ServiceFlight : IServiceFlight
    {
        public List<Flight> Flights { get; set; } = new List<Flight>();

        public List<DateTime>? GetFlightDates(string destination)
        {
            return Flights
                .Where(f => f.Destination == destination)
                .Select(f => f.FlightDate)
                .ToList();
        }

        public void GetFlights(string filterType, string filterValue)
        {
            switch(filterType)
            {
                case "Destination":
                    {
                        Flights.Where((f) => f.Destination!.Equals(filterValue)).ToList().ForEach(Console.WriteLine);
                    }
                        break;
                case "FlightDate":
                    {
                        Flights.Where(f => f.FlightDate.Equals(DateTime.Parse(filterValue))).ToList().ForEach(Console.WriteLine);
                    }
                    break;

                case "Departure":
                    {
                        Flights.Where(f => f.Departure!.Equals(filterValue)).ToList().ForEach(Console.WriteLine);
                    }
                    break;

                case "EffectiveArrival":
                    {
                        Flights.Where(f => f.EffectiveArrival.Equals(DateTime.Parse(filterValue))).ToList().ForEach(Console.WriteLine);
                    }
                    break;

                case "EstimatedDuration":
                    {
                        Flights.Where(f => f.EstimatedDuration.Equals(Int32.Parse(filterValue))).ToList().ForEach(Console.WriteLine);
                    }
                    break;

                default:
                    break;
            }

        }

        // Q 19...
        public void ShowFlightDetails(Plane plane)
        {
            var queryLambda = Flights
                .Where(f => f.MyPlane!.Equals(plane))
                .Select(f => new { f.FlightDate, f.Destination });

            foreach (var info in queryLambda)
            {
                Console.WriteLine($"Flight date: {info.FlightDate}\nFlight destination: {info.Destination}");
            }
        }
   
        public int ProgrammedFlightNumber(DateTime startDate)
        {
           
             return Flights.
                 Where( f => !f.FlightDate.Equals(startDate) && (f.FlightDate - startDate).TotalDays < 7)
                 .Count();
        }

        public double? DurationAverage(string destination)
        {
            
            return  Flights.
                    Where (flight => flight.Destination!.Equals(destination)).
                    Select (flight => flight.EstimatedDuration)
                .Average();
        }

        public List<Flight> OrderedDurationFlights()
        {
            return Flights.
                    OrderByDescending(flight => flight.EstimatedDuration)
                    .ToList();
        }

        /*
         * public List<Passenger> SeniorTravellers(Flight flight)
        {
            IEnumerable<Passenger> q = 
                    flight.Passengers!.OfType<Traveller>().OrderBy(p => p.BirthDate).Take(3);

            return q.ToList();
        }
        */

        public void DestinationGroupedFlights()
        {
            var query =  Flights.GroupBy(f => f.Destination);

            foreach (var g in query)
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
