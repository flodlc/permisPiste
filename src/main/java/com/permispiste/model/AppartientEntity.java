package com.permispiste.model;

import javax.persistence.*;

/**
 * Created by Lucas on 19/06/2017.
 */
@Entity
@Table(name = "appartient", schema = "permispiste", catalog = "")
@IdClass(AppartientEntityPK.class)
public class AppartientEntity {
    private int numjeu;
    private int numaction;
    private JeuEntity jeuByNumjeu;
    private ActionEntity actionByNumaction;

    @Id
    @Column(name = "NUMJEU", insertable = false, updatable = false)
    public int getNumjeu() {
        return numjeu;
    }

    public void setNumjeu(int numjeu) {
        this.numjeu = numjeu;
    }

    @Id
    @Column(name = "NUMACTION", insertable = false, updatable = false)
    public int getNumaction() {
        return numaction;
    }

    public void setNumaction(int numaction) {
        this.numaction = numaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppartientEntity that = (AppartientEntity) o;

        if (numjeu != that.numjeu) return false;
        if (numaction != that.numaction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numjeu;
        result = 31 * result + numaction;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "NUMJEU", referencedColumnName = "NUMJEU", nullable = false)
    public JeuEntity getJeuByNumjeu() {
        return jeuByNumjeu;
    }

    public void setJeuByNumjeu(JeuEntity jeuByNumjeu) {
        this.jeuByNumjeu = jeuByNumjeu;
    }

    @ManyToOne
    @JoinColumn(name = "NUMACTION", referencedColumnName = "NUMACTION", nullable = false)
    public ActionEntity getActionByNumaction() {
        return actionByNumaction;
    }

    public void setActionByNumaction(ActionEntity actionByNumaction) {
        this.actionByNumaction = actionByNumaction;
    }
}
