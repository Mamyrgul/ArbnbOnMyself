package java16.arbnbonmyself.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "favoriteHouses")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FavoriteHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "favoriteHouse_gen")
    @SequenceGenerator(sequenceName = "favoriteHouse_seq,", name = "favoriteHouse_gen", allocationSize = 1)
    Long id;
    Long houseId;
    LocalDate addedAt;
    @ManyToOne
    User user;
}
