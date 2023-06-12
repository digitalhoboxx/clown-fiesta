package dev.dhb.clownfiesta.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

//from Lombok: generates getters, setters, toString method, hashCode, equals, constructor
@Data
//helps build the object
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
/*postgreSQL has some built in functionalities for the user table;
this sets table name to _user to prevent ambiguity
 */
@Table(name = "_user")
public class User implements UserDetails {
    //sets variable as primary get
    @Id
    //automatically decides and sets id
    @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
