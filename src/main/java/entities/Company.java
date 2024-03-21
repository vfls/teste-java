package entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "company_name")
    private String companyName;

    @CNPJ(message = "CNPJ Inválido!")
    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "balance")
    private BigDecimal balance;
}
