using AM.ApplicationCore.Domain;
using AM.ApplicationCore.Interfaces;

namespace AM.ApplicationCore.Services
{
    public class ServicePlane : Services<Plane>, IServicePlane
    {
        private IUnitOfWork _unitOfWork;

        public ServicePlane(IUnitOfWork unitOfWork): base(unitOfWork)
        {
            _unitOfWork = unitOfWork;
        }

        public void DeletePlanes()
        {
            // it does not work :(
        }

        public IEnumerable<Flight> GetFlights(int n)
        {
            return GetAll()
                    .OrderByDescending(p => p.PlaneId)
                    .Take(n)
                    .SelectMany(p => p.Flights)
                    .OrderBy(f => f.Departure);
        }

        public IEnumerable<Passenger> GetPassengersByPlane(Plane p)
        {
            return GetById(p.PlaneId)
                .Flights
                .SelectMany(f => f.Tickets)
                .Select(t => t.Passenger);
        }

        public bool IsAvailablePlane(Flight f, int n)
        {
            int capacity = Get(p => p.Flights.Contains(f) == true).Capacity;

            int numOfTickets = f.Tickets.Count;

            return capacity >= numOfTickets + n;
        }
    }
}
