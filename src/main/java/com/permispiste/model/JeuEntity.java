package com.permispiste.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Lucas on 19/06/2017.
 */
@Entity
@Table(name = "jeu", schema = "permispiste", catalog = "")
public class JeuEntity {
    private int numjeu;
    private String libellejeu;
    private Collection<AppartientEntity> appartientsByNumjeu;
    private Collection<InscriptionEntity> inscriptionsByNumjeu;
    private Collection<MissionEntity> missionsByNumjeu;

    @Id
    @Column(name = "NUMJEU")
    public int getNumjeu() {
        return numjeu;
    }

    public void setNumjeu(int numjeu) {
        this.numjeu = numjeu;
    }

    @Basic
    @Column(name = "LIBELLEJEU")
    public String getLibellejeu() {
        return libellejeu;
    }

    public void setLibellejeu(String libellejeu) {
        this.libellejeu = libellejeu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JeuEntity jeuEntity = (JeuEntity) o;

        if (numjeu != jeuEntity.numjeu) return false;
        if (libellejeu != null ? !libellejeu.equals(jeuEntity.libellejeu) : jeuEntity.libellejeu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numjeu;
        result = 31 * result + (libellejeu != null ? libellejeu.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "jeuByNumjeu")
    public Collection<AppartientEntity> getAppartientsByNumjeu() {
        return appartientsByNumjeu;
    }

    public void setAppartientsByNumjeu(Collection<AppartientEntity> appartientsByNumjeu) {
        this.appartientsByNumjeu = appartientsByNumjeu;
    }

    @OneToMany(mappedBy = "jeuByNumjeu")
    public Collection<InscriptionEntity> getInscriptionsByNumjeu() {
        return inscriptionsByNumjeu;
    }

    public void setInscriptionsByNumjeu(Collection<InscriptionEntity> inscriptionsByNumjeu) {
        this.inscriptionsByNumjeu = inscriptionsByNumjeu;
    }

    @OneToMany(mappedBy = "jeuByNumjeu")
    public Collection<MissionEntity> getMissionsByNumjeu() {
        return missionsByNumjeu;
    }

    public void setMissionsByNumjeu(Collection<MissionEntity> missionsByNumjeu) {
        this.missionsByNumjeu = missionsByNumjeu;
    }
}
