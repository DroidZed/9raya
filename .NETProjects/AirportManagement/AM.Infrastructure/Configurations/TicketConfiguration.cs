using AM.ApplicationCore.Domain;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace AM.Infrastructure.Configurations
{
    internal class TicketConfiguration : IEntityTypeConfiguration<Ticket>
    {
        public void Configure(EntityTypeBuilder<Ticket> builder)
        {
            builder.HasKey(t => new
            {
                t.PassengerFk,
                t.FlightFk
            });

            builder.HasOne(t => t.Flight).WithMany(F => F.Tickets).HasForeignKey(t => t.FlightFk);

            builder.HasOne(t => t.Passenger).WithMany(P => P.Tickets).HasForeignKey(t => t.PassengerFk);
        }
    }
}
