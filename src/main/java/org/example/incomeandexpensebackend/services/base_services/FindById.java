package org.example.incomeandexpensebackend.services.base_services;

@FunctionalInterface
public interface FindById<T, Tid> {
    T findById(Tid id);
}
