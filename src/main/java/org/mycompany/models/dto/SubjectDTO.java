package org.mycompany.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by konstantinamp on 7/9/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO implements GenericDTO {

    private String firstName;
    private String lastName;
    private String age;
}
