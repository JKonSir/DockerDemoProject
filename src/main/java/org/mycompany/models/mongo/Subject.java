package org.mycompany.models.mongo;

import org.mycompany.models.GenericEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by konstantinamp on 7/9/17.
 */
@Data
@Document(collection = "subject-catalog")
@NoArgsConstructor
@AllArgsConstructor
public class Subject implements GenericEntity {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String age;
}
