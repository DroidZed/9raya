namespace AM.ApplicationCore.Domain
{
    public class Staff: Passenger
    {
        public DateTime? EmploymentDate { get; set; }

        public string? Function { get; set; }

        public float Salary { get; set; }

        public override void PassengerType()
        {
            base.PassengerType();
            Console.WriteLine(" I am a Staff Member");
        }

        public override string ToString()
        {
            return $"{base.ToString()}[Staff]: Function: {Function} - Salary: {Salary}";
        }
    }
}
