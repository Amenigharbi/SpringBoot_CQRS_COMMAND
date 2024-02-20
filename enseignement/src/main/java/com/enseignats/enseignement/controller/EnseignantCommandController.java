package com.enseignats.enseignement.controller;


import com.enseignats.enseignement.dto.EnsEvent;
import com.enseignats.enseignement.entity.Enseignant;
import com.enseignats.enseignement.service.EnseignantCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enseignants")
public class EnseignantCommandController {

        @Autowired
        private EnseignantCommandService commandService;

        @PostMapping
        public Enseignant createEns(@RequestBody EnsEvent ens) {
            return commandService.createEns(ens);
        }

        @PutMapping("/{id}")
        public Enseignant updateEns(@PathVariable Long id, @RequestBody EnsEvent ens) {
            return commandService.updateEns(id, ens);
        }

//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        commandService.delete(id);
//    }
    }