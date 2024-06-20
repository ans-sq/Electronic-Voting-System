package com.project.voting_system.controller;

import com.project.voting_system.models.Constituency;
import com.project.voting_system.requests.AddConstituencyRequest;
import com.project.voting_system.services.ConstituencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/evs")
public class ConstituencyController {

    private final ConstituencyService constituencyService;

    @Autowired
    public ConstituencyController(ConstituencyService constituencyService) {
        this.constituencyService = constituencyService;
    }

    @GetMapping("/constituencies")
    public ResponseEntity<?> getAllConstituency() {
        return ResponseEntity.ok(constituencyService.getAllConstituencies());
    }

    @GetMapping("/constituencies/{type}")
    public ResponseEntity<?> getConstituencyByType(@PathVariable String type) {
        return ResponseEntity.ok(constituencyService.getConstituenciesByType(type));
    }

    @PostMapping("/constituency")
    public ResponseEntity<?> addConstituency(@RequestBody AddConstituencyRequest addConstituencyRequest) {
        if (constituencyService.constituencyExists(addConstituencyRequest.getName(),
                addConstituencyRequest.getType())) {
            return ResponseEntity.badRequest().body("Constituency already exists");
        }

        Constituency constituency = new Constituency();
        constituency.setName(addConstituencyRequest.getName());
        constituency.setType(addConstituencyRequest.getType());
        constituency = constituencyService.createConstituency(constituency);

        return ResponseEntity.ok(constituency);
    }
}
