package org.mycompany.controllers.mongo;

import org.mycompany.controllers.RestApi;
import org.mycompany.models.dto.SubjectDTO;
import org.mycompany.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * Created by kosi0715 on 12.07.2017.
 */
@RestController("v2")
@RequestMapping(value = RestApi.API_ROOT_V2)
public class SubjectController {

    private final EntityService<SubjectDTO, String> subjectService;

    @Autowired
    public SubjectController(EntityService<SubjectDTO, String> subjectService) {
        this.subjectService = subjectService;
    }

    @RequestMapping(value = RestApi.SUBJECT, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public SubjectDTO getSubject(@PathVariable("subjectId") @NotNull String subjectId) {
        return subjectService.getOne(subjectId);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<SubjectDTO> getSubjects() {
        return subjectService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public SubjectDTO createSubject(@RequestBody SubjectDTO subjectDTO) {
        return subjectService.add(subjectDTO);
    }

    @RequestMapping(value = RestApi.SUBJECT, method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteSubject(@PathVariable("subjectId") String subjectId) {
        subjectService.remove(subjectId);
    }

    @RequestMapping(value = RestApi.SUBJECT,
            method = RequestMethod.PATCH,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public SubjectDTO patchSubject(@PathVariable("subjectId") String subjectId,
                                   @RequestBody SubjectDTO subjectDTO) {
        return subjectService.patch(subjectId, subjectDTO);
    }
}

