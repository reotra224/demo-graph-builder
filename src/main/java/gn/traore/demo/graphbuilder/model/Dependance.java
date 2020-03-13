package gn.traore.demo.graphbuilder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dependance {
    private String typeOperation;
    private Long idDebiteur;
    private Long idCrediteur;
}
