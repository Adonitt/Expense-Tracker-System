package org.example.backend.services.base_services;

@FunctionalInterface
public interface Modifiable<T, Tid> {
    T update(Tid id, T dto);
}
