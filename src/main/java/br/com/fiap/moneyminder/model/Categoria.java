package br.com.fiap.moneyminder.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

//no recod nós não precisamos colocar getter e setter e ele é IMUNATAVEL portanto ja garnte o encapsulamento
@Entity
@Data
public class Categoria {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String icone;
}
