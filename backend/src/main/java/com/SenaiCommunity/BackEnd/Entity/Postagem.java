package com.SenaiCommunity.BackEnd.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Postagem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Usuario autor;

    @Lob
    private String conteudo;

    private LocalDateTime dataPostagem = LocalDateTime.now();

    @Transient
    private String autorUsername;

    @OneToMany(mappedBy = "postagem", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude // FIX: Evita loop infinito
    private List<ArquivoMidia> arquivos = new ArrayList<>();

    @OneToMany(mappedBy = "postagem", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("dataCriacao ASC")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude // FIX: Evita loop infinito
    private List<Comentario> comentarios = new ArrayList<>();

    @OneToMany(mappedBy = "postagem", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude // FIX: Evita loop infinito
    private Set<Curtida> curtidas;
}