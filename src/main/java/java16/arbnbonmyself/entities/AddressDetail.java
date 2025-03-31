package java16.arbnbonmyself.entities;
import jakarta.persistence.*;
import java16.arbnbonmyself.enums.Region;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "addressDetails")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressDetail_gen")
    @SequenceGenerator(sequenceName = "addressDetail_seq,", name = "addressDetail_gen", allocationSize = 1)
    Long id;
    @Enumerated(EnumType.STRING)
    Region region;
    String city;
    String address;
}
