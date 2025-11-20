package org.example.backend.services.base_services;

@FunctionalInterface
public interface FindById<T, Tid> {
    T findById(Tid id);
}
