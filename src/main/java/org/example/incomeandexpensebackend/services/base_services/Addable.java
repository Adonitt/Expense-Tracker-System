package org.example.incomeandexpensebackend.services.base_services;

@FunctionalInterface
public interface Addable<T> {
    T create(T dto);
}
