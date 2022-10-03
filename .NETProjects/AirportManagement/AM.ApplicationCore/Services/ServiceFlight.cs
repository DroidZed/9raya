using AM.ApplicationCore.Domain;
using AM.ApplicationCore.Interfaces;

namespace AM.ApplicationCore.Services
{
    public class ServiceFlight : IServiceFlight
    {
        public List<Flight>? Flights { get; set; } = new List<Flight>();

        public List<DateTime?>? GetFlightDates(string destination)
        {

            if (Flights == null) return null;

            List<DateTime?>? Dates = new List<DateTime?>();
            /*
            for (int i = 0; i < Flights?.Count; i++)
            {
                if (Flights[i].Destination.Equals(destination))
                    Dates.Add(Flights[i].FlightDate);
            }
            */

            foreach (var flight in Flights)
            {
                if (flight.Destination!.Equals(destination))
                    Dates.Add(flight.FlightDate);
            }

            return Dates;
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
    }
}
