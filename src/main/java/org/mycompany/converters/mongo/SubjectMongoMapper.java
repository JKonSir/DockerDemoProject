package org.mycompany.converters.mongo;

import org.mapstruct.Mapper;
import org.mycompany.models.dto.SubjectDTO;
import org.mycompany.models.mongo.Subject;

/**
 * Created by konstantinamp on 7/10/17.
 */
@Mapper(componentModel = "spring")
public interface SubjectMongoMapper {

    SubjectDTO subjectToSubjectDTO(Subject subject);

    Subject subjectDTOToSubject(SubjectDTO subjectDTO);
}
