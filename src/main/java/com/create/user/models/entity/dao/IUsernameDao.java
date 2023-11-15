package com.create.user.models.entity.dao;

import com.create.user.models.entity.Phone;
import com.create.user.models.entity.Username;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IUsernameDao extends CrudRepository<Username, Long> {

    @Query("from Phone")
    public List<Phone> findAllPhones();

    public Username findByName(String nombre);


}
