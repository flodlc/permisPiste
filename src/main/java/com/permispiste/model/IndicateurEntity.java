package com.permispiste.model;

import javax.persistence.*;

/**
 * Created by Lucas on 19/06/2017.
 */
@Entity
@Table(name = "indicateur", schema = "permispiste", catalog = "")
public class IndicateurEntity {
    private int numindic;
    private int numaction;
    private Integer poids;
    private ActionEntity actionByNumaction;

    @Id
    @Column(name = "NUMINDIC")
    public int getNumindic() {
        return numindic;
    }

    public void setNumindic(int numindic) {
        this.numindic = numindic;
    }

    @Basic
    @Column(name = "NUMACTION", insertable = false, updatable = false)
    public int getNumaction() {
        return numaction;
    }

    public void setNumaction(int numaction) {
        this.numaction = numaction;
    }

    @Basic
    @Column(name = "POIDS")
    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IndicateurEntity that = (IndicateurEntity) o;

        if (numindic != that.numindic) return false;
        if (numaction != that.numaction) return false;
        if (poids != null ? !poids.equals(that.poids) : that.poids != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numindic;
        result = 31 * result + numaction;
        result = 31 * result + (poids != null ? poids.hashCode() : 0);
        return result;
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
