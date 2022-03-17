package de.denktmit.tam.persistence.security;

import de.denktmit.tam.persistence.model.UserEntity;
import de.denktmit.tam.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public MyUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(final String name) throws UsernameNotFoundException {
        UserEntity user = this.userRepository.findByLoginName(name.toLowerCase()).orElseThrow(() -> new UsernameNotFoundException(name));
        return new MyUserDetails(user);
    }
}
