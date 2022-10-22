using System.ComponentModel.DataAnnotations;

namespace AM.ApplicationCore.Domain
{
    public class FullName
    {
        [
            MinLength(3, ErrorMessage = "Longeure minimale 3")
        ]
        public string FirstName { get; set; }
        public string LastName { get; set; }

        public FullName(string firstName, string lastName)
        {
            this.FirstName = firstName;
            this.LastName = lastName;
        }

        public override string ToString()
        {
            return $"{LastName} {FirstName}";
        }
    }
}
