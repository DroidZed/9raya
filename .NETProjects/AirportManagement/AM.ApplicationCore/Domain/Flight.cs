using System.ComponentModel.DataAnnotations.Schema;

namespace AM.ApplicationCore.Domain
{
    public class Flight
    {
        public int FlightId { get; set; }

        public string? Destination { get; set; }

        public DateTime FlightDate { get; set; }

        public string? Departure { get; set; }

        public DateTime? EffectiveArrival { get; set; }

        public int? EstimatedDuration { get; set; }

        public int? PlaneFK { get; set; }

        public virtual Plane? MyPlane { get; set; }

        public string? Airline { get; set; }

        // public ICollection<Passenger> Passengers { get; set; }

        public virtual IList<Ticket> Tickets { get; set; }

        public override string ToString()
        {
            return $"[Flight on {MyPlane!.PlaneType}]: {Departure} - {Destination} * ETA: {EstimatedDuration}";
        }
    }
}
