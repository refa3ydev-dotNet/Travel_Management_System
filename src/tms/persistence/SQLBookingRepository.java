package tms.persistence;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import tms.model.Booking;

/**
 *
 * @author 3mora
 */
public class SQLBookingRepository implements IBookingRepository {
    private final String connectionString;

    public SQLBookingRepository(String connectioString) {
        this.connectionString = connectioString;
    }

    private Connection GetConnection() throws SQLException {
        return DriverManager.getConnection(connectionString);
    }


   @Override
public void save(Booking booking) {
    String sql = """
        INSERT INTO dbo.Bookings(booking_date, status, total_price, package_desc, package_price)
        OUTPUT INSERTED.Id
        VALUES (?,?,?,?,?)
    """;

    try (Connection c = GetConnection();
         PreparedStatement ps = c.prepareStatement(sql)) {

        Timestamp ts = (booking.getBookingDate() != null)
                ? new Timestamp(booking.getBookingDate().getTime())
                : null;

        ps.setTimestamp(1, ts);
        ps.setString(2, booking.getStatus());
        ps.setBigDecimal(3, BigDecimal.valueOf(booking.getTotalPrice()));

        String desc = (booking.getComponent() != null) ? booking.getComponent().getDescription() : null;
        double pkgPrice = (booking.getComponent() != null) ? booking.getComponent().getPrice() : 0.0;

        ps.setString(4, desc);
        ps.setBigDecimal(5, BigDecimal.valueOf(pkgPrice));

        try (ResultSet rs = ps.executeQuery()) { // ✅ OUTPUT يرجّع ResultSet
            if (rs.next()) booking.setId(rs.getInt(1));
        }

    } catch (SQLException e) {
        throw new RuntimeException("DB insert failed: " + e.getMessage(), e);
    }
}


    @Override
    public Booking getById(int id) {
        String sql = "SELECT Id, booking_date, status, total_price FROM dbo.Bookings WHERE Id = ?";
        try (Connection c = GetConnection();
            PreparedStatement prestate = c.prepareStatement(sql);
                ) {
            prestate.setInt(1, id);
            try (ResultSet rs = prestate.executeQuery()) {
                if (!rs.next()) return null;
                    Booking booking = new Booking();
                    booking.setId(rs.getInt("Id"));
                    Timestamp ts = rs.getTimestamp("booking_date");
                    if (ts != null) {
                        booking.setBookingDate(new java.util.Date(ts.getTime()));
                    }
                    booking.setStatus(rs.getString("status"));
                    booking.setTotalPrice(rs.getBigDecimal("total_price").doubleValue());
                    // Note: Component reconstruction is omitted for brevity
                    return booking;
            }
        } catch (SQLException e) {
            throw new RuntimeException("DB query failed: " + e.getMessage(), e);
        }
    }
    @Override
    public List<Booking> getAll(){
        String sql = "SELECT Id, booking_date, status, total_price, package_desc, package_price " +
             "FROM dbo.Bookings ORDER BY Id";
        List<Booking> bookings =new ArrayList<>();
        
        try (Connection c =GetConnection();
                PreparedStatement preState =c.prepareStatement(sql);
                ResultSet rs = preState.executeQuery()){
            while (rs.next()) {
                bookings.add(mapResultSetToBookings(rs));
            }
            System.out.println("Louded "+bookings.size()+" bookings from database");
            return bookings;
        } catch (SQLException e) {
            System.out.println("failed to loud message "+ e.getMessage());
            throw new RuntimeException("DB quary failed " + e.getMessage() , e);
            
        }
    }
    private Booking mapResultSetToBookings(ResultSet rs) throws SQLException{
        Booking booking =new Booking();
        booking.setId(rs.getInt("Id"));
        Timestamp ts = rs.getTimestamp("booking_date");
        if(ts != null ){
            booking.setBookingDate(new java.util.Date(ts.getTime()));
        }
        booking.setStatus(rs.getString("status"));
        BigDecimal totalPrice= rs.getBigDecimal("total_price");
        if (totalPrice != null) {
            booking.setTotalPrice(totalPrice.doubleValue());
        }
        return booking;
    }

}
