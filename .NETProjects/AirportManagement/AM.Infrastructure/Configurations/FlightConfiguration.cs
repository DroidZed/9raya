using AM.ApplicationCore.Domain;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace AM.Infrastructure.Configurations
{
    public class FlightConfiguration : IEntityTypeConfiguration<Flight>
    {
        public void Configure(EntityTypeBuilder<Flight> builder)
        {

            builder
                .HasMany(f => f.Passengers)
                .WithMany(p => p.Flights)
                .UsingEntity(e => e.ToTable("Reservation"));

            builder.HasOne(f => f.MyPlane)
                    .WithMany(p => p.Flights)
                    .HasForeignKey(f => f.PlaneFK)
                   .OnDelete(DeleteBehavior.ClientSetNull);
        }
    }
}
