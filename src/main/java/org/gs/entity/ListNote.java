package org.gs.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
//заметки
@Entity
@Getter
@Setter
@ToString
public class ListNote extends PanacheEntity {
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    private String note;

    private Date data = new Date();

}
