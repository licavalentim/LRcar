package com.exemple.LRcar.LRcar.Model;

import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LRcar")
public class LRcarModel {

    @Id
    private UUID id = UUID.randomUUID(); // Gerar UUID manualmente

    private String nome;
    private String email;
    private int cpf; // Alterado para String para evitar problemas com CPF
    private int telefone; // Alterado para String para evitar problemas com telefone

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int i) {
        this.cpf = i;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int i) {
        this.telefone = i;
    }
}

