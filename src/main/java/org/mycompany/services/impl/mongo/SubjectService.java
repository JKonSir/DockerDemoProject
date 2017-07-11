package org.mycompany.services.impl.mongo;

import org.mycompany.converters.mongo.SubjectMongoMapper;
import org.mycompany.models.dto.SubjectDTO;
import org.mycompany.models.mongo.Subject;
import org.mycompany.repositories.EntityRepository;
import org.mycompany.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by konstantinamp on 7/9/17.
 */
@Service("mongoSubjectService")
public class SubjectService implements EntityService<SubjectDTO, String> {

    private final SubjectMongoMapper subjectMongoMapper;
    private final EntityRepository<Subject, String> subjectRepository;

    @Autowired
    public SubjectService(SubjectMongoMapper subjectMongoMapper,
                          EntityRepository<Subject, String> subjectRepository) {
        this.subjectMongoMapper = subjectMongoMapper;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public SubjectDTO getOne(String subjectId) {
        Subject subject = subjectRepository.findOne(subjectId);

        return subjectMongoMapper.subjectToSubjectDTO(subject) ;
    }

    @Override
    public List<SubjectDTO> getAll() {
        return subjectRepository.findAll().stream()
                .map(subjectMongoMapper::subjectToSubjectDTO).collect(Collectors.toList());
    }

    @Override
    public SubjectDTO add(SubjectDTO subjectDTO) {
        Subject subject = subjectMongoMapper.subjectDTOToSubject(subjectDTO);
        subjectRepository.save(subject);

        return subjectDTO;
    }

    @Override
    public void remove(String subjectId) {
        subjectRepository.delete(subjectId);
    }

    @Override
    public SubjectDTO patch(String subjectId, SubjectDTO subjectDTO) {
        Subject subject = subjectMongoMapper.subjectDTOToSubject(subjectDTO);
        subject.setId(subjectId);
        subjectRepository.save(subject);

        return subjectDTO;
    }
}
