package am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.service.impl;


import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.entities.User;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.repository.UserRepository;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; // Assuming you have a UserRepository interface

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username); // Assuming you have a User entity with a username field

        User user = optionalUser.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));


        // Assuming you have a custom UserDetails implementation, replace UserPrincipal with your custom UserDetails implementation
        return new UserPrincipal(user);
    }
}
