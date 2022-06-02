package org.gs.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import static org.gs.config.Values.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "CLIENTS")
public class Person extends PanacheEntity {

    @Column(name = "first_name")
    @NotBlank(message=INVALID_FIRST_NAME)
    private String firstName;

    @NotBlank(message=INVALID_SECOND_NAME)
    @Column(name = "second_name")
    private String secondName;

    @NotBlank(message=INVALID_EMAIL)
    private String mail;

    @NotBlank(message=INVALID_PASSWORD)
    private String password;

}
