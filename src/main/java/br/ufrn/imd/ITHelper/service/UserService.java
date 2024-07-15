package br.ufrn.imd.ITHelper.service;

import br.ufrn.imd.ITHelper.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//import br.ufrn.imd.ITHelper.exception.UserNotFoundException;
import br.ufrn.imd.ITHelper.model.User;
import br.ufrn.imd.ITHelper.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User createUser(User user) {
        // Criptografar a senha antes de salvar no banco de dados
        String encryptedPassword = passwordEncoder.encode(user.getPass());
        user.setPass(encryptedPassword);

        return userRepository.save(user);
    }

    public User updateUser(String userId, User updatedUser) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        user.setNomeUsuario(updatedUser.getNomeUsuario());
        // Criptografar a nova senha antes de atualizar no banco de dados
        String encryptedPassword = passwordEncoder.encode(updatedUser.getPass());
        user.setPass(encryptedPassword);

        return userRepository.save(user);
    }


    public ResponseEntity<Boolean> validatePass(User user, String password) {
        boolean valid = passwordEncoder.matches(password, user.getPass());
        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;

        return ResponseEntity.status(status).body(valid);
    }



}


