package org.example.incomeandexpensebackend.controllers;

import lombok.RequiredArgsConstructor;
import org.example.incomeandexpensebackend.dtos.debt.DebtDto;
import org.example.incomeandexpensebackend.services.interfaces.DebtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/debts")
@RequiredArgsConstructor
public class DebtsController {
    private final DebtService service;

    @GetMapping
    public ResponseEntity<List<DebtDto>> getAllDebts() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DebtDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<DebtDto> add(@RequestBody DebtDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<DebtDto> editById(@PathVariable Long id, @RequestBody DebtDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeById(@PathVariable Long id) {
        service.removeById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/default/objs")
    public DebtDto defaultCreate() {
        return new DebtDto();
    }


}
