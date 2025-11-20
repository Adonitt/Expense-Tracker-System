package org.example.backend.services.base_services;

import java.util.List;

@FunctionalInterface
public interface FindAll<T> {
    List<T> findAll();
}
