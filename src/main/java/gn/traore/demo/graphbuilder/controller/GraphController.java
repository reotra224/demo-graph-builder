package gn.traore.demo.graphbuilder.controller;

import com.google.gson.JsonObject;
import gn.traore.demo.graphbuilder.model.Graph;
import gn.traore.demo.graphbuilder.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GraphController {

    @Autowired
    private GraphService graphService;

    @GetMapping("/list/{label}")
    public List<Object> listAdjVertices(@PathVariable String label) {
        Graph graph = graphService.createGraph("debit", 1L, 2L);
        return graph.getNoeudPrincipal().get(label);
    }

    @GetMapping("/transfert")
    public String transfert(@RequestParam String operation, @RequestParam Long idDebiteur, @RequestParam Long idCrediteur) {
        Graph graph = graphService.createGraph(operation, idDebiteur, idCrediteur);
        return graphService.createJsonOfGraph(graph).toString();
    }
}
