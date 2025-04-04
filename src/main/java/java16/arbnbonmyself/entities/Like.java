package java16.arbnbonmyself.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "likes")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "like_gen")
    @SequenceGenerator(sequenceName = "like_seq,", name = "like_gen", allocationSize = 1)
    Long id;
    Boolean isLike;
    @ManyToOne
    User user;
    @ManyToOne
    Feedback feedback;
}
