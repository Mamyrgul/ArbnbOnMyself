package java16.arbnbonmyself.entities;

import jakarta.persistence.*;
import java16.arbnbonmyself.enums.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(sequenceName = "user_seq,", name = "user_gen", allocationSize = 1)
    Long id;
    String fullName;
    String email;
    String password;
    String imageUrl;
    @Enumerated(EnumType.STRING)
    Role role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<FavoriteHouse> favoriteHouses;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Like> likes;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Booking> bookings;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<House> houses;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Feedback> feedbacks;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
