using AM.ApplicationCore.Domain;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;


namespace AM.Infrastructure.Configurations
{
    public class PassengerConfiguration : IEntityTypeConfiguration<Passenger>
    {
        public void Configure(EntityTypeBuilder<Passenger> builder)
        {
            builder.OwnsOne(p => p.FullName);
        /*    builder.Property(p => p.FullName.FirstName) // TODO: fix your code :p
                .HasMaxLength(30);
        */
        }
    }
}
