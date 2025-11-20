package org.example.backend.services.base_services;

@FunctionalInterface
public interface Removable<Tid> {
    void remove(Tid id);
}
