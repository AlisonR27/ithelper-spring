package br.ufrn.imd.ITHelper.security;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

import br.ufrn.imd.ITHelper.service.UserDetailsServiceImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.ufrn.imd.ITHelper.model.User;

@Service
public class TokenService {
    UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl();
    public String gerarToken(User user) {
        List<String> roles = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        String avatarUrl;
        if (user.getProfilePicture() != null) {
            avatarUrl = user.getProfilePicture().getPhotoPath();
        } else {
            avatarUrl = "";
        }
        return JWT.create()
                .withIssuer("User")
                .withSubject(user.getNomeUsuario())
                .withClaim("id", user.getId())
                .withClaim("name", user.getNomeCompleto())
                .withClaim("avatar", avatarUrl)
                .withExpiresAt(LocalDateTime.now()
                        .plusMinutes(240)
                        .toInstant(ZoneOffset.of("-03:00"))

                ).sign(Algorithm.HMAC512("Secreta"));
    }

    public Object getSubject(String token) {
        // TODO Auto-generated method stub
        return JWT.require(Algorithm.HMAC512("Secreta"))
                .withIssuer("User")
                .build().verify(token)
                .getSubject();
    }
}