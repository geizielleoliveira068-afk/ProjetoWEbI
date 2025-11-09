package br.edu.ifs.projetowebi.model;



import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "programas_pontos")
public class ProgramaDePontosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome; // Smiles | Azul | Latam Pass

    @OneToMany(mappedBy = "programaPontos", cascade = CascadeType.ALL)
    private List<CartaoModel> cartoes;
}



