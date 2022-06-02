package org.gs.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Date;

import static org.gs.config.Values.INVALID_NOTE;

@Entity
@Getter
@Setter
@ToString
@Table(name = "NOTES")
public class ListNote extends PanacheEntity {
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @NotBlank(message=INVALID_NOTE)
    private String note;

    private Date data = new Date();

}
