using AM.ApplicationCore.Domain;

namespace AM.ApplicationCore.Services
{
    public static class PassengerExtension
    {
        public static void UpperFullName(this Passenger p)
        {
            p.FullName.FirstName = string.Concat(p.FullName.FirstName![0].ToString().ToUpper(), p.FullName.FirstName.AsSpan(1));
            
            p.FullName.LastName = string.Concat(p.FullName.LastName![0].ToString().ToUpper(), p.FullName.LastName.AsSpan(1));
        }
    }
}
