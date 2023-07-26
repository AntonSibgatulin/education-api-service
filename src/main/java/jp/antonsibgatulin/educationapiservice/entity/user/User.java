package jp.antonsibgatulin.educationapiservice.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(16)")
    private String name;

    @Column(nullable = false, columnDefinition = "VARCHAR(16)")
    private String surname;

    @Column(unique = true)
    private String email;

    private Long timeReg;
    private Long online;
    private String phone;

    private Long profileImageId;


    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }


    public void create() {
        timeReg = System.currentTimeMillis();
        online = timeReg;
        role = Role.USER;
    }
    //likes


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
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
        return true;
    }

}
