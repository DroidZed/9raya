namespace AM.ApplicationCore.Domain
{
    public class Ticket
    {
        public double Prix { get; set; }

        public int Siege { get; set; }

        public bool VIP { get; set; }

        public int FlightFk { get; set; }

        public string PassengerFk { get; set; }

        public virtual Passenger Passenger { get; set; }

        public virtual Flight Flight { get; set; }
    }
}
