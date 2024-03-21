package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
@Entity
@Data
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "user_id")
    @ManyToOne
    @JoinColumn(referencedColumnName = "customer_id")
    private Long customerId;

    @Column(name = "company_id")
    @ManyToOne
    @JoinColumn(referencedColumnName = "company_id")
    private Long companyId;

    @Column(name = "transaction_value")
    private BigDecimal transactionValue;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "transaction_tax")
    private BigDecimal transactionTax;
}
