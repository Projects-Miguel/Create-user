package com.create.user.models.implement;

import com.create.user.models.entity.dao.IUsernameDao;
import com.create.user.models.entity.Phone;
import com.create.user.models.entity.Username;
import com.create.user.models.services.IUsernameServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsernameServiceImplement implements IUsernameServices, UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UsernameServiceImplement.class);

    @Autowired
    private IUsernameDao usernameDao;

    @Override
    @Transactional(readOnly = true)
    public List<Username> findAll() {
        return (List<Username>) usernameDao.findAll();
    }

    @Override
    @Transactional(readOnly = true )
    public Username findById(Long id) {
        return usernameDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Username save(Username username) {
        return usernameDao.save(username);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        usernameDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true )
    public List<Phone> findAllPhones() {
        return usernameDao.findAllPhones();
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Username usuario = usernameDao.findByName(username);

        if (usuario == null){
            logger.error("Error en el login: no existe el usuario '" +username+"' en el sistema");
            throw new UsernameNotFoundException("Error en el login: No existe el usuario'"+username+"' en el sistema!");
        }

        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .peek(authority -> logger.info("Role: "+ authority.getAuthority()))
                .collect(Collectors.toList());

        return new User(usuario.getName(), usuario.getPassword(), usuario.getEnabled(),true,true,true,authorities);
    }

}
