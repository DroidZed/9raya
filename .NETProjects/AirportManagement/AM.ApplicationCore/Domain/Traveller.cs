namespace AM.ApplicationCore.Domain
{
    public class Traveller: Passenger
    {
        public string? HealthInformation { get; set; }

        public string? Nationality { get; set; }

        public override void PassengerType()
        {
            base.PassengerType();
            Console.WriteLine(" I am a traveller");
        }

        public override string ToString()
        {
            return $"{base.ToString()}[Traveller]: Nationality: {Nationality}";
        }
    }
}
