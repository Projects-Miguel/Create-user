package com.create.user.models.services;

import com.create.user.models.entity.Phone;
import com.create.user.models.entity.Username;


import java.util.List;


public interface IUsernameServices {

    public List<Username> findAll();

    public Username findById(Long id);

    public Username save(Username username);

    public void delete(Long id);

    public List<Phone> findAllPhones();



}
