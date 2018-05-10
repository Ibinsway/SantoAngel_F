package scouts;

import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 *
 * @author Rafael Martin Carrion, Joaquin Terrasa Moya
 */
@Entity
@DiscriminatorValue("Edu")
public class Educandos extends Usuario implements Serializable {
        
    private static final long serialVersionUID = 1L;

    //! Claves foraneas
    
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Grupo grupoEducandos;

    @OneToMany(mappedBy = "Educando")
    @JoinColumn(nullable = false)
    private List<Facturas_Clientes> facturas;
    
    
    //! Getters y Setters
    
    
    public Grupo getGrupo() {
        return grupoEducandos;
    }

    public void setGrupo(Grupo grupoEducandos) {
        this.grupoEducandos = grupoEducandos;
    }
        
}
