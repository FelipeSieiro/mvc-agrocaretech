package br.com.fiap.mvcagrocaretech.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "epicuser")
@Data
public class User extends DefaultOAuth2User {

    @Id
    UUID id = UUID.randomUUID();

    String name;

    @Column(unique = true)
    String email;

    String avatar;

    int score = 0;

    public User(OAuth2User principal){
        super(
                List.of(new SimpleGrantedAuthority("USER")),
                principal.getAttributes(),
                "email"
        );
        this.name = principal.getAttribute("name");
        this.avatar = principal.getAttribute("avatar_url");
        this.email = principal.getAttribute("email");
    }

    public User(){
        super(
                List.of(new SimpleGrantedAuthority("USER")),
                Map.of("email", "anonymous@email.com"),
                "email"
        );

        this.avatar = this.getAttribute("https://avatar.iran.liara.run/public/job/farmer/male");
        this.email = this.getAttribute("email");
    }

}
