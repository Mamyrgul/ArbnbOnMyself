package java16.arbnbonmyself.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_gen")
    @SequenceGenerator(sequenceName = "booking_seq,", name = "booking_gen", allocationSize = 1)
    Long id;
    LocalDate checkin;
    LocalDate checkout;
    @ManyToOne
    User user;
    @ManyToOne
    House house;
}
