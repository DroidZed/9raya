using AM.ApplicationCore.Domain;

namespace AM.ApplicationCore.Services
{
    public static class PassengerExtension
    {
        public static void UpperFullName(this Passenger p)
        {
            p.FirstName = string.Concat(p.FirstName![0].ToString().ToUpper(), p.FirstName.AsSpan(1));
            
            p.LastName = string.Concat(p.LastName![0].ToString().ToUpper(), p.LastName.AsSpan(1));
        }
    }
}
