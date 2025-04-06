package juninho16.Java10X.CadastroDeNinjas.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import juninho16.Java10X.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private  String dificuldade;

    //Um ninja só pode ter uma missão
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel> ninjas;


}