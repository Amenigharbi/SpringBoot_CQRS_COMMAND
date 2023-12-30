package com.enseignats.enseignement.service;


import com.enseignats.enseignement.dto.EnsEvent;
import com.enseignats.enseignement.entity.Enseignant;
import com.enseignats.enseignement.repository.EnseignantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EnseignantCommandService {
    @Autowired
     private EnseignantRepo repo;
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;


    public Enseignant createEns(EnsEvent ens)
    {
        Enseignant enseign= repo.save(ens.getEns());
        EnsEvent event=new EnsEvent("createEnseignant",enseign);
        kafkaTemplate.send("enseignant-event-topic",event);
        return enseign;
    }

    public Enseignant UpdateEns(Long id,EnsEvent ens)
    {
        Enseignant existEns= repo.findById(id).get();
        Enseignant newEns=ens.getEns();
        existEns.setFirstname(newEns.getFirstname());
        existEns.setLastname(newEns.getLastname());
        existEns.setAge(newEns.getAge());
        Enseignant enseign=repo.save(existEns);
        EnsEvent event=new EnsEvent("update enseignant",enseign);
        kafkaTemplate.send("enseignant-event-topic",event);
        return enseign;

    }

    public void delete(Long id){
         repo.deleteById(id);
        String deleteEventMessage = "deleteEnseignant:" + id;
        kafkaTemplate.send("enseignant-event-topic", deleteEventMessage);
    }

}
