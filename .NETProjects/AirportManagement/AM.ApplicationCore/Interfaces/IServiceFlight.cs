using AM.ApplicationCore.Domain;

namespace AM.ApplicationCore.Interfaces
{
    public interface IServiceFlight
    {
        public List<DateTime?>? GetFlightDates(string destination);

        public void GetFlights(string filterType, string filterValue);
    }
}
