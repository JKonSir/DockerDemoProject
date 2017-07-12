package org.mycompany.models.postgres;

import org.mycompany.models.GenericEntity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by konstantinamp on 6/11/17.
 */
@Data
@Entity
@Table(name = "subjects")
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "findAllSubjects",
        query = "select s from Subject s")
public class Subject implements GenericEntity {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "generate_id", sequenceName = "generate_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generate_id")
    private BigInteger id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "age", nullable = false)
    private Integer age;
}
