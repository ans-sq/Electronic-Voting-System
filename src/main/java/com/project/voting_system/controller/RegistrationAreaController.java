package com.project.voting_system.controller;

import com.project.voting_system.models.Constituency;
import com.project.voting_system.models.RegistrationArea;
import com.project.voting_system.requests.AddRegistrationAreaRequest;
import com.project.voting_system.services.ConstituencyService;
import com.project.voting_system.services.RegistrationAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/evs")
public class RegistrationAreaController {

    private final RegistrationAreaService registrationAreaService;
    private final ConstituencyService constituencyService;


    @Autowired
    public RegistrationAreaController(RegistrationAreaService registrationAreaService,
                                      ConstituencyService constituencyService) {
        this.registrationAreaService = registrationAreaService;
        this.constituencyService = constituencyService;
    }

    @GetMapping("/registrationAreas")
    public ResponseEntity<?> getAllRegistrationAreas() {
        return ResponseEntity.ok(registrationAreaService.getAllRegistrationAreas());
    }

    @PostMapping("/{constituencyId}/registrationArea")
    public ResponseEntity<?> registerRegistrationArea(@PathVariable Long constituencyId,
                                                      @RequestBody AddRegistrationAreaRequest addRegistrationAreaRequest) {
        if (registrationAreaService.registrationAreaExists(addRegistrationAreaRequest.getName())) {
            return ResponseEntity.badRequest().body("Registration Area already exists");
        }

        Constituency constituency = constituencyService.getConstituencyById(constituencyId);

        if (constituency == null) {
            return ResponseEntity.badRequest().body("Constituency does not exist");
        }

        RegistrationArea registrationArea = new RegistrationArea();
        registrationArea.setName(addRegistrationAreaRequest.getName());
        registrationArea.setConstituency(constituency);
        registrationArea = registrationAreaService.createRegistrationArea(registrationArea);

        return ResponseEntity.ok(registrationArea);
    }
}
