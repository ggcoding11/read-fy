package com.read_fy.api.models;

import com.read_fy.api.enums.StatusLeitura;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "tb_book_users")
public class LivroUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    private String openLibraryId;

    private StatusLeitura status;
}
