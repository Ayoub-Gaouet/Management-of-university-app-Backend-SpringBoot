package org.isetn.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Matiere matiere;

    @ManyToOne
    private Etudiant etudiant;

    @Temporal(TemporalType.DATE)
    private Date date;

    private int nha;
}