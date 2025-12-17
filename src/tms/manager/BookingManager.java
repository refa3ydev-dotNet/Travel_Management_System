package tms.manager;
import java.util.ArrayList;
import java.util.List;
import tms.model.Booking;
import tms.persistence.BookingRepositoryProxy;
import tms.persistence.IBookingRepository;
import tms.persistence.SQLBookingRepository;

public class BookingManager {
    private static BookingManager instance;
    private List<Booking> bookings;
    
    private IBookingRepository repository;
    
    private BookingManager(){
        // الحل: استخدم SQL Authentication بدل Windows Authentication
        String url = 
            "jdbc:sqlserver://WIN-41K15A4QA5A:1433;" +
            "databaseName=TMS;" +
            "user=3mar;" +
            "password=123456;" +
            "encrypt=true;" +
            "trustServerCertificate=true;";
        try {
            repository=new BookingRepositoryProxy(new SQLBookingRepository(url));
            this.bookings= new ArrayList<>(repository.getAll());
            System.out.println("Booking manager initialized with "+ bookings.size()+" booking");
            
        } catch (Exception e) {
            System.err.println("Failed to initialize bookingManager "+ e.getMessage());
            this.bookings= new ArrayList<>();
            throw new RuntimeException("BookingManager Initialization failed ",e);
            
        }
    }
    
    public static BookingManager getInstance(){
        if(instance == null){
            instance = new BookingManager();
        }
        return instance;
    }
    
    public Booking createBooking(Booking b){
        if (b == null){
            System.err.println("can't create null booking");
            return null;
        }
        try {
            repository.save(b);
            bookings.add(b);
            System.out.println("booking created successfully with Id "+ b.getId());
            return b;
        } catch (Exception e) {
            System.err.println("Failed to create booking "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    public Booking getBookingById(int id){
        return repository.getById(id);
    }
    
    public List<Booking> getBookings(){
        return bookings;
    }
    public void refreshBooking(){
        try {
        this.bookings=new ArrayList<>(repository.getAll());
            System.out.println("refreshed successfully");
        } catch (Exception e) {
            System.err.println("Failed to refreshed Bookings " + e.getMessage());
        }
    }
}