package org.gs.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@ToString
public class Person extends PanacheEntity {

    @Column(name = "first_name")
    @NotBlank(message="{firstName is invalid}")
    private String firstName;

    @NotBlank(message="{firstName is invalid}")
    @Column(name = "second_name")
    private String secondName;

    @NotBlank(message="{email is invalid}")
    private String mail;

    @NotBlank(message="{password is invalid}")
    private String password;


}
