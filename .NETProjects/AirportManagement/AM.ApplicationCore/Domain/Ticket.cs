namespace AM.ApplicationCore.Domain
{
    public class Ticket
    {
        public double Prix { get; set; }

        public int Siege { get; set; }

        public bool VIP { get; set; }

        public int FlightFk { get; set; }

        public string PassengerFk { get; set; }

        public Passenger Passenger { get; set; }

        public Flight Flight { get; set; }
    }
}
