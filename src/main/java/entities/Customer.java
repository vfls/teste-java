package entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Data
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    String email;

    @CPF(message = "CPF Inválido!")
    @Column(name = "cpf")
    private String cpf;

}
