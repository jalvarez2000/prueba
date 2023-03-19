package com.example.prueba.domain.componenta;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComponentAController {
    ComponentAService componentAService;
    
    public ComponentAController(ComponentAService componentAService) {
        this.componentAService = componentAService;
    }

    @PostMapping("/componentA")
    public ComponentAModel saveComponentA(@RequestBody ComponentAModel componentAModel) {
        componentAService.saveComponentA(componentAModel);
        return componentAModel;
    }
}
