using AM.ApplicationCore.Domain;

namespace AM.ApplicationCore.Interfaces
{
    public interface IServiceFlight: IServices<Flight>
    {
        List<DateTime>? GetFlightDates(string destination);

        void GetFlights(string filterType, string filterValue);

        void ShowFlightDetails(Plane plane);

        int ProgrammedFlightNumber(DateTime startDate);

        double? DurationAverage(string destination);

        List<Flight> OrderedDurationFlights();

        void DestinationGroupedFlights();
    }
}
