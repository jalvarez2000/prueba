package com.example.prueba.domain.componenta;

import org.springframework.stereotype.Component;

@Component
public class ComponentAService {
    ComponentARepository componentARepository;
    
    public ComponentAService(ComponentARepository componentARepository) {
        this.componentARepository = componentARepository;
    }
    
    public void saveComponentA(ComponentAModel componentAModel) {
        componentARepository.save(componentAModel);
    }
}
