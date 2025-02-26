package dev.Juninho16.CadastroDeNinjas.Ninjas;

import dev.Juninho16.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    //@ManyToOne: um ninja tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") //foreing Key
    private MissoesModel missoes;


}
