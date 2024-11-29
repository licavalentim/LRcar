package com.exemple.LRcar.LRcarDTO;

public record LRcarDTO(String nome, String email, int cpf, int telefone) {
    // O record já cria automaticamente os métodos getter: nome(), email(), cpf(), telefone()
}
