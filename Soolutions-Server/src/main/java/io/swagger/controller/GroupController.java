package io.swagger.controller;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import io.swagger.model.Bug;
import io.swagger.model.Soolution;
import io.swagger.model.SoolutionRepository;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/soolution")
public class GroupController {

    @Autowired
    private SoolutionRepository soolutionRepository;


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/import", produces = MediaType.APPLICATION_JSON_VALUE)
    public void importFromJira() throws Exception {
        JiraRestClient clientImportJira = new AsynchronousJiraRestClientFactory()
                .createWithBasicHttpAuthentication(URI.create("https://testedeutilizacao.atlassian.net:443"), "anna.franca91@gmail.com",
                        "anna1991");
        SearchResult claim = clientImportJira.getSearchClient().searchJql("TYPE=BUG").claim();
        for (Issue issue: claim.getIssues()) {
            Soolution s = new Soolution();
            String id = issue.getId() + "";
            String causa = issue.getDescription();
            String status = issue.getStatus().getDescription();
            String solucao = issue.getField("solution").toString();

            s.setCausa(causa);
            s.setId(id);
            s.solution(solucao);
            s.status(status);
            soolutionRepository.save(s);
        }

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/search/{causa}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Soolution> list(@PathVariable String causa) throws Exception {
        //Busca todas da base
        List<Soolution> allSolutions = soolutionRepository.findAll();

        //Aplica filtro por causa
        Stream<Soolution> soolutionsFiltered = allSolutions.stream().filter(s -> s.getCausa().toUpperCase().contains(causa.toUpperCase()));
        List<Soolution> filtered = soolutionsFiltered.collect(Collectors.toList());
        //Caso não haja nenhuma
        if (filtered.isEmpty()) {
            //Importa do Jira mais Bugs
            this.importFromJira();
        }
        //Busca todos novamente
        allSolutions = soolutionRepository.findAll();

        //Aplica filtro
        soolutionsFiltered = allSolutions.stream().filter(s -> s.getCausa().toUpperCase().contains(causa.toUpperCase()));
        filtered = soolutionsFiltered.collect(Collectors.toList());
        //Retorna as ocorrencias.
        return filtered;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Soolution save(@ModelAttribute("soolution") Soolution soolution) throws Exception {
        if (soolution.getId() == null
                || soolution.getId().isEmpty()) {
            String id = System.currentTimeMillis()  + "";
            soolution.setId(id.substring(id.length() - 3, id.length()));
        }
        soolutionRepository.save(soolution);
        return soolution;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        soolutionRepository.delete(id + "");
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/update/{id}")
    public Soolution update(@ModelAttribute("soolution") Soolution soolution) {
        Soolution registro = soolutionRepository.findOne(soolution.getId());
        registro.setDescription(soolution.getDescription());
        registro.setCausa(soolution.getCausa());
        registro.setSolution(soolution.getSolution());
        registro.setStatus(soolution.getStatus());
        Soolution updated = soolutionRepository.save(registro);
        return updated;
    }
}
