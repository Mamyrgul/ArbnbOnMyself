package java16.arbnbonmyself.entities;

import jakarta.persistence.*;
import java16.arbnbonmyself.enums.HouseState;
import java16.arbnbonmyself.enums.HouseType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "houses")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "house_gen")
    @SequenceGenerator(sequenceName = "house_seq,", name = "house_gen", allocationSize = 1)
    Long id;
    String name;
    @Enumerated(EnumType.STRING)
    HouseType type;
    double price;
    @Column(length = 500)
    String description;
    @Enumerated(EnumType.STRING)
    HouseState state;
    boolean isBlocked;
    int maxGuests;
    @Column(length = 400)
    String rejectInfo;
    @ElementCollection
    List<String> imageUrls;
    @ManyToOne
    User user;
    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
    List<Feedback> feedBacks;
    @OneToOne(cascade = CascadeType.ALL)
    AddressDetail addressDetail;
    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
    List<Booking> bookings;
}
