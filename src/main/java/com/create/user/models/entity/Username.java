package com.create.user.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usernames")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Username implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean enabled;
    
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "El correo es obligatorio")
    @Email(message = "No cumple con el formato de correo")
    @Column(nullable = false,unique = true)
    private String email;

    private String password;

/*    @NotNull(message="el phone no puede ser vacio")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="phone_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Phone phones;*/

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Role> roles;

    @NotNull(message="el phone no puede ser vacio")
    @Column(name = "phones_id")
    //@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Phone> phones;

    @Column(name ="create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @PrePersist
    public void prePersist(){
        createAt = new Date();
    }

    @Column(name ="update_at")
    @UpdateTimestamp
    private Date updatedAt;

    @Column(name ="last_login")
    private Date lastLogin;

    private String token;




}
