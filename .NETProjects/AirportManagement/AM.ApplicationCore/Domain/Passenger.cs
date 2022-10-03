namespace AM.ApplicationCore.Domain
{
    public class Passenger
    {
        public DateTime? BirthDate { get; set; }

        public string? FirstName { get; set; }

        public string? LastName { get; set; }

        public int? PassportNumber { get; set; }

        public string? EmailAddress { get; set; }

        public int? TelNumber { get; set; }

        public ICollection<Flight>? Flights { get; set; }

        public bool CheckProfile(string fName, string lName)
        {
            return this.FirstName == fName && this.LastName == lName;
        }

        public bool CheckProfile(string fName, string lName, string? email = null)
        {
            return email != null ? 
                this.FirstName == fName
                && this.LastName == lName
                && this.EmailAddress == email : CheckProfile(fName, lName);
        }

        public virtual void PassengerType()
        {
            Console.Write("I am a passenger");
        }

        public override string ToString()
        {
            return $"[Passenger]: Name: {FirstName} {LastName}\nTel: {TelNumber}\nEmail: {EmailAddress}\n";
        }
    }
}
