package com.enseignats.enseignement.dto;

import com.enseignats.enseignement.entity.Enseignant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnsEvent {

    private String eventType;
    private Enseignant ens ;

}
