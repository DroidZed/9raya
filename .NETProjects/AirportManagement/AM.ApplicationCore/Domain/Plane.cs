using System.ComponentModel.DataAnnotations;

namespace AM.ApplicationCore.Domain
{
    public class Plane
    {
        public Plane() { }

        public int PlaneId { get; set; }
     
        [Range(0, int.MaxValue)]
        public int Capacity { get; set; }
        
        public DateTime? ManufactureDate { get; set; }

        public PlaneType PlaneType { get; set; }

        public virtual IList<Flight>? Flights { get; set; }

        public override string ToString()
        {
            return $"[Plane / {PlaneType}]: Capacity: {Capacity}, Manufactured at {ManufactureDate}";
        }
    }
}
