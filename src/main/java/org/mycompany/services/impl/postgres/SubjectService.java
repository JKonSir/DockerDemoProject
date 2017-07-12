package org.mycompany.services.impl.postgres;

import org.mycompany.converters.postgres.SubjectMapper;
import org.mycompany.models.dto.SubjectDTO;
import org.mycompany.models.postgres.Subject;
import org.mycompany.repositories.EntityRepository;
import org.mycompany.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by konstantinamp on 7/9/17.
 */
@Service("postgresSubjectService")
public class SubjectService implements EntityService<SubjectDTO, BigInteger> {

    private final SubjectMapper subjectMapper;
    private final EntityRepository<Subject, BigInteger> subjectRepository;

    @Autowired
    public SubjectService(SubjectMapper subjectMapper,
                          EntityRepository<Subject, BigInteger> subjectRepository) {
        this.subjectMapper = subjectMapper;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public SubjectDTO getOne(BigInteger subjectId) {
        Subject subject = subjectRepository.findOne(subjectId);

        return subjectMapper.subjectToSubjectDTO(subject);
    }

    @Override
    public List<SubjectDTO> getAll() {
        List<Subject> subjects = subjectRepository.findAll();

        return subjects.stream()
                .map(subjectMapper::subjectToSubjectDTO).collect(Collectors.toList());
    }

    @Override
    public SubjectDTO add(SubjectDTO subjectDTO) {
        Subject subject = subjectMapper.subjectDTOToSubject(subjectDTO);
        subjectRepository.save(subject);

        return subjectDTO;
    }

    @Override
    public void remove(BigInteger subjectId) {
        subjectRepository.delete(subjectId);
    }

    @Override
    public SubjectDTO patch(BigInteger subjectId, SubjectDTO subjectDTO) {
        Subject subject = subjectMapper.subjectDTOToSubject(subjectDTO);
        subject.setId(subjectId);
        subjectRepository.save(subject);

        return subjectDTO;
    }
}
