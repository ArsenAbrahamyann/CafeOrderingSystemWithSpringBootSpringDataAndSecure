package am.picsartacademy.springboot.cafeorderingsystem.service.impl;


import am.picsartacademy.springboot.cafeorderingsystem.entities.User;
import am.picsartacademy.springboot.cafeorderingsystem.repository.UserRepository;
import am.picsartacademy.springboot.cafeorderingsystem.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        User user = optionalUser.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));


        return new UserPrincipal(user);
    }
}
