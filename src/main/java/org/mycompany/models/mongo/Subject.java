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
//@Data
@Document(collection = "subject-catalog")
@NoArgsConstructor
@AllArgsConstructor
public class Subject implements GenericEntity {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
