using AM.ApplicationCore.Domain;
using AM.Infrastructure.Configurations;
using Microsoft.EntityFrameworkCore;


namespace AM.Infrastructure
{
    public class AMContext : DbContext
    {

        public DbSet<Flight> Flights { get; set; }
        public DbSet<Plane> Planes { get; set; }
        public DbSet<Passenger> Passengers { get; set; }
        public DbSet<Staff> Staff { get; set; }
        public DbSet<Traveller> Travellers { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(@"Data Source=(localdb)\mssqllocaldb;
Initial Catalog=AymenDhahriDB;Integrated Security=true");
            base.OnConfiguring(optionsBuilder);
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder
                .ApplyConfiguration(new PlaneConfiguration())
                .ApplyConfiguration(new FlightConfiguration())
                .ApplyConfiguration(new PassengerConfiguration())
                .ApplyConfiguration(new TicketConfiguration());

            modelBuilder.Entity<Staff>().ToTable("Staff");
            modelBuilder.Entity<Traveller>().ToTable("Traveller");
            modelBuilder.Entity<Passenger>().ToTable("Passenger");
        }

        protected override void ConfigureConventions(ModelConfigurationBuilder configurationBuilder)
        {
            configurationBuilder.Properties<DateTime>().HaveColumnType("date");
        }
    }
}
