package br.com.fiap.mvcagrocaretech.user;

import jakarta.validation.constraints.Min;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends DefaultOAuth2UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(OAuth2User principal) {
        if(userRepository.findByEmail(principal.getAttribute("email")).isEmpty())
            userRepository.save(new User(principal));

    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        var principal = super.loadUser(userRequest);
        var email = principal.getAttribute("email").toString();
        return userRepository.findByEmail(email).orElseGet(() -> new User(principal));
    }
}
