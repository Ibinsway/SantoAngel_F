package scouts;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author flamenquim
 */
@Entity
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private String nombreGrupo;
    
    @Column(nullable = false)
    private String rangoEdad;

    
    //! Claves foraneas
    
    
    @OneToMany(mappedBy = "grupoScouts")
    @JoinColumn(nullable = false)
    private List<Scouts> scouts;
    
    @OneToMany(mappedBy = "grupoEducandos")
    @JoinColumn(nullable = false)
    private List<Educandos> educandos;
    
    @OneToMany(mappedBy = "grupoEventos")
    @JoinColumn(nullable = true)
    private List<Eventos> eventos;
    
    
    //! Getters y Setters
    
    
    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public String getRangoEdad() {
        return rangoEdad;
    }

    public void setRangoEdad(String rangoEdad) {
        this.rangoEdad = rangoEdad;
    }
    
    public List<Scouts> getScouts() {
        return scouts;
    }

    public void setScouts(List<Scouts> scouts) {
        this.scouts = scouts;
    }

    public List<Educandos> getEducando() {
        return educandos;
    }

    public void setEducando(List<Educandos> educandos) {
        this.educandos = educandos;
    }

    public List<Eventos> getEventos() {
        return eventos;
    }

    public void setEventos(List<Eventos> eventos) {
        this.eventos = eventos;
    }
    
    
    //! Metodos sobreescritos
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreGrupo != null ? nombreGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.nombreGrupo == null && other.nombreGrupo != null) || (this.nombreGrupo != null && !this.nombreGrupo.equals(other.nombreGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "scouts.Grupo[ id=" + nombreGrupo + " ]";
    }
    
}
