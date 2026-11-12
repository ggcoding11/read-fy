package com.read_fy.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_users")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
}
