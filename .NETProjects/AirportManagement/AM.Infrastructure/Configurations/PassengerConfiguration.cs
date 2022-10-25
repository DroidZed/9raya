using AM.ApplicationCore.Domain;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;


namespace AM.Infrastructure.Configurations
{
    public class PassengerConfiguration : IEntityTypeConfiguration<Passenger>
    {
        public void Configure(EntityTypeBuilder<Passenger> builder)
        {
            builder.OwnsOne(p => p.FullName, full =>
            {
                full.Property(x => x.FirstName).HasColumnName("PassFirstName").HasMaxLength(30);
                full.Property(f => f.LastName).HasColumnName("PassLastName").IsRequired(true);
            });
            /*
                        builder.HasDiscriminator<string>("isTraveller")
                            .HasValue<Passenger>("0")
                            .HasValue<Traveller>("1")
                            .HasValue<Staff>("2");
            */
        }
    }
}
