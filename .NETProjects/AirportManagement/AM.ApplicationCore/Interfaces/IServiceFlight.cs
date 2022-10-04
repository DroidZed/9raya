using AM.ApplicationCore.Domain;

namespace AM.ApplicationCore.Interfaces
{
    public interface IServiceFlight
    {
        List<DateTime>? GetFlightDates(string destination);

        void GetFlights(string filterType, string filterValue);

        void ShowFlightDetails(Plane plane);

        int ProgrammedFlightNumber(DateTime startDate);

        int DurationAverage(string destination);

        List<Flight> OrderedDurationFlights();
        List<Passenger> SeniorTravellers(Flight flight);

        Dictionary<string, List<DateTime?>> DestinationGroupedFlights();
    }
}
