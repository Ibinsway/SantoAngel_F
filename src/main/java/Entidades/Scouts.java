package Entidades;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Rafael Martin Carrion, Joaquin Terrasa Moya
 */
@Entity
@DiscriminatorValue("Scout")
public class Scouts extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    //! Claves foraneas
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Grupo grupoScouts;

    
    //! Setters y getters
    
    
    public Grupo getGrupo() {
        return grupoScouts;
    }

    public void setGrupo(Grupo grupoScouts) {
        this.grupoScouts = grupoScouts;
    }
    
}
