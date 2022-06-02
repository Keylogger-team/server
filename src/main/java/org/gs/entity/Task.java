package org.gs.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.gs.config.Values.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "TO_DO_LISTS")
public class Task extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @NotBlank(message=INVALID_TASK)
    private String task;

    private String status;

}
