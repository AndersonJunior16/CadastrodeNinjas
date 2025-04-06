package juninho16.Java10X.CadastroDeNinjas.Ninjas;

import jakarta.persistence.*;
import juninho16.Java10X.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.*;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "idade")
    private int idade;

    @Column(name = "rank")
    private String rank;

    //@ManyToOne: um ninja tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") //foreing Key
    private MissoesModel missoes;


}