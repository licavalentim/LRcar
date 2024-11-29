package com.exemple.LRcar.LRcar.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.LRcar.LRcar.Model.LRcarModel;

public interface LRcarRepository extends JpaRepository<LRcarModel, UUID> {
}
