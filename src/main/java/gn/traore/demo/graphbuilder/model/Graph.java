package gn.traore.demo.graphbuilder.model;

import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Graph {

    private Map<String, List<Object>> noeudPrincipal;

    public Graph() {
    }

    public Graph(Map<String, List<Object>> noeudPrincipal) {
        this.noeudPrincipal = noeudPrincipal;
    }

    public Map<String, List<Object>> getNoeudPrincipal() {
        return noeudPrincipal;
    }

    public void setNoeudPrincipal(Map<String, List<Object>> noeudPrincipal) {
        this.noeudPrincipal = noeudPrincipal;
    }

    public void createNoeud(String label) {
        noeudPrincipal.putIfAbsent(label, new ArrayList<>());
    }

    public void createRelation(String noeud, Object v2) {
        noeudPrincipal.get(noeud).add(v2);
    }
}
