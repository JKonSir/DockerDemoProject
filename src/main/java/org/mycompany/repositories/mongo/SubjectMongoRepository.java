package org.mycompany.repositories.mongo;

import org.mycompany.models.mongo.Subject;
import org.mycompany.repositories.EntityRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by konstantinamp on 7/9/17.
 */
public interface SubjectMongoRepository extends CrudRepository<Subject, String>, EntityRepository<Subject, String> {}
