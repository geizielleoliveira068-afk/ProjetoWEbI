package br.edu.ifs.projetowebi.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    private String senha;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<CartaoModel> cartoes;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<CompraModel> compras;
}



