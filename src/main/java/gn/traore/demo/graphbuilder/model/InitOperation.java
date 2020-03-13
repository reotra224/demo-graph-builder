package gn.traore.demo.graphbuilder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InitOperation {
    private Boolean debit;
    private Boolean credit;
    private String compteDebiteur;
    private String compteCrediteur;
}
