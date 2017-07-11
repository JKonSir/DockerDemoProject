package org.mycompany.converters.postgres;

import org.mapstruct.Mapper;
import org.mycompany.models.dto.SubjectDTO;
import org.mycompany.models.postgres.Subject;

/**
 * Created by konstantinamp on 7/9/17.
 */
@Mapper(componentModel = "spring")
public interface SubjectPostgresMapper {

    SubjectDTO subjectToSubjectDTO(Subject subject);

    Subject subjectDTOToSubject(SubjectDTO subjectDTO);
}
