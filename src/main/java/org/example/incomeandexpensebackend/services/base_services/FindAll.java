package org.example.incomeandexpensebackend.services.base_services;

import java.util.List;

@FunctionalInterface
public interface FindAll<T> {
    List<T> findAll();
}
