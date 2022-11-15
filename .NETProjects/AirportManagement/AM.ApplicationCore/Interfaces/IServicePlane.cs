using AM.ApplicationCore.Domain;

namespace AM.ApplicationCore.Interfaces
{
    public interface IServicePlane: IServices<Plane>
    {
        public IEnumerable<Passenger> GetPassengersByPlane(Plane p);

        public IEnumerable<Flight> GetFlights(int n);

        public Boolean IsAvailablePlane(Flight f, int n);

        public void DeletePlanes();
    }
}
