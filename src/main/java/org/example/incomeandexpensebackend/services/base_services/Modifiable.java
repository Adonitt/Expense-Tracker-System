package org.example.incomeandexpensebackend.services.base_services;

@FunctionalInterface
public interface Modifiable<T, Tid> {
    T update(Tid id, T dto);
}
