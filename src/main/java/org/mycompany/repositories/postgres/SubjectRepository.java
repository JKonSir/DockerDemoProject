package org.mycompany.repositories.postgres;

import org.mycompany.models.postgres.Subject;
import org.mycompany.repositories.EntityRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by konstantinamp on 7/9/17.
 */
@Repository
@Transactional
public class SubjectRepository implements EntityRepository<Subject, BigInteger> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Subject findOne(BigInteger subjectId) {
        return entityManager.find(Subject.class, subjectId);
    }

    @Override
    public List<Subject> findAll() {
        return entityManager.createNamedQuery("findAllSubjects").getResultList();
    }

    @Override
    public Subject save(Subject subject) {
        if (subject.getId() != null) {
            entityManager.merge(subject);
        } else {
            entityManager.persist(subject);
        }

        return subject;
    }

    @Override
    public void delete(BigInteger subjectId) {
        Subject subject = findOne(subjectId);

        entityManager.remove(subject);
    }
}
