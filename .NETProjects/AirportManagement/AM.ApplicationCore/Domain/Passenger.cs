using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace AM.ApplicationCore.Domain
{
    public class Passenger
    {
        [DisplayName("Date of Birth"), DataType(DataType.Date)]
        public DateTime? BirthDate { get; set; }

        
         [
            MaxLength(25, ErrorMessage = "Longeure maximale 25"),
            MinLength(3, ErrorMessage = "Longeure minimale 3")
         ]
        public FullName FullName { get; set; }

        //public string? FirstName { get; set; }

        //public string? LastName { get; set; }

        [Key, StringLength(7)]
        public string PassportNumber { get; set; }

        [DataType(DataType.EmailAddress)]
        public string? EmailAddress { get; set; }

        [RegularExpression(@"^[0-9]{8}$")]
        public string TelNumber { get; set; }

        public ICollection<Flight> Flights { get; set; }

        public bool CheckProfile(string fName, string lName)
        {
            return this.FullName.FirstName == fName && this.FullName.LastName == lName;
        }

        public bool CheckProfile(string fName, string lName, string? email = null)
        {
            return email != null ? 
                this.FullName.FirstName == fName
                && this.FullName.LastName == lName
                && this.EmailAddress == email : CheckProfile(fName, lName);
        }

        public virtual void PassengerType()
        {
            Console.Write("I am a passenger");
        }

        public override string ToString()
        {
            return $"[Passenger]: Name: {FullName.FirstName} {FullName.LastName}\nTel: {TelNumber}\nEmail: {EmailAddress}\n";
        }
    }
}
