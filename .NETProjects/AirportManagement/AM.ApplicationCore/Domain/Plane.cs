namespace AM.ApplicationCore.Domain
{
    public class Plane
    {
        public int? Capacity { get; set; }
        
        public DateTime? ManufactureDate { get; set; }

        public int? PlaneId { get; set; }

        public PlaneType PlaneType { get; set; }

        public ICollection<Flight>? Flights { get; set; }

        public override string ToString()
        {
            return $"[Plane / {PlaneType}]: Capacity: {Capacity}, Manufactured at {ManufactureDate}";
        }
    }
}
