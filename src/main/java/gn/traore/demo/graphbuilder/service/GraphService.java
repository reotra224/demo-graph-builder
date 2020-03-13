package gn.traore.demo.graphbuilder.service;

import com.google.gson.JsonObject;
import gn.traore.demo.graphbuilder.model.Dependance;
import gn.traore.demo.graphbuilder.model.Graph;
import gn.traore.demo.graphbuilder.model.InitOperation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class GraphService {

    public static final String NOEUD_PRINCIPAL = "Transfert";
    public static final String NOEUD_DEPENDANCE = "Dependances";
    public static final String NOEUD_INIT_OP = "InitOperation";

    public GraphService() {
    }

    public Graph createGraph(String operation, Long idDebiteur, Long idCrediteur) {
        Graph graphService = new Graph(new HashMap<>());
        // Création des noeuds du Graph
        graphService.createNoeud(NOEUD_PRINCIPAL);
        graphService.createNoeud(NOEUD_DEPENDANCE);
        graphService.createNoeud(NOEUD_INIT_OP);

        //Création des relations
        graphService.createRelation(NOEUD_PRINCIPAL, new Dependance(operation, idDebiteur, idCrediteur));
        boolean op = (operation.equalsIgnoreCase("debit")); // On définit le type d'opération
        graphService.createRelation(NOEUD_PRINCIPAL, new InitOperation(op, !op, "Traore", "KABA"));
        return graphService;
    }

    public JsonObject createJsonOfGraph(Graph graph) {
        JsonObject root = new JsonObject();

        JsonObject jsonElementDep = new JsonObject();
        Dependance dep = ((Dependance) graph.getNoeudPrincipal().get("Transfert")
                .stream()
                .filter(o -> o instanceof Dependance)
                .collect(Collectors.toList()).get(0));
        jsonElementDep.addProperty("TypeOp", dep.getTypeOperation());
        jsonElementDep.addProperty("idDebiteur", dep.getIdDebiteur());
        jsonElementDep.addProperty("idCrediteur", dep.getIdCrediteur());

        JsonObject jsonElementOpeartion = new JsonObject();
        InitOperation operation = ((InitOperation) graph.getNoeudPrincipal().get("Transfert")
                .stream()
                .filter(o -> o instanceof InitOperation)
                .collect(Collectors.toList()).get(0));
        jsonElementOpeartion.addProperty("Debit", operation.getDebit());
        jsonElementOpeartion.addProperty("Credit", operation.getCredit());
        jsonElementOpeartion.addProperty("CompteDebiteur", operation.getCompteDebiteur());
        jsonElementOpeartion.addProperty("CompteCrediteur", operation.getCompteCrediteur());

        JsonObject jsonTransfert = new JsonObject();
        jsonTransfert.add("Dependance", jsonElementDep);
        jsonTransfert.add("InitOperation", jsonElementOpeartion);

        root.add("Transfert", jsonTransfert);

        return root;
    }
}
