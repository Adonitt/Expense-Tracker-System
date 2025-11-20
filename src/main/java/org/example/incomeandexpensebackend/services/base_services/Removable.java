package org.example.incomeandexpensebackend.services.base_services;

@FunctionalInterface
public interface Removable<Tid> {
    void remove(Tid id);
}
