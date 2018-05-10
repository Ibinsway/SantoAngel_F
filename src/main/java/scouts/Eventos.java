package scouts;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jesus Sanchez Leal
 * rev 1.1 by Joaquin Terrasa Moya
 */
@Entity
public class Eventos implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, length = 20)
    private Long idEventos;
    
    @Column(nullable = false)
    private String nombreEventos;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEvento;
    
    @Column(nullable = false)
    private String categoriaEvento;
    
    @Column(nullable = false)
    private String grupoNombreGrupo;
    
    
    //! Claves foraneas
    
    
    @OneToMany(mappedBy = "EventosIdEventos")
    @JoinColumn(nullable = true)
    private List<Comentario> comentarios;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Grupo grupoEventos;
    
    
    //! Setters y getters

    
    public Long getId() {
        return idEventos;
    }

    public void setId(Long idEventos) {
        this.idEventos = idEventos;
    }

    public String getNombreEventos() {
        return nombreEventos;
    }

    public void setNombreEventos(String nombreEventos) {
        this.nombreEventos = nombreEventos;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getCategoriaEvento() {
        return categoriaEvento;
    }

    public void setCategoriaEvento(String categoriaEvento) {
        this.categoriaEvento = categoriaEvento;
    }
	
    public String getGrupoNombreGrupo() {
        return grupoNombreGrupo;
    }

    public void setGrupoNombreGrupo(String grupoNombreGrupo) {
        this.grupoNombreGrupo = grupoNombreGrupo;
    }

 
    //! Metodos sobreescritos
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEventos != null ? idEventos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventos)) {
            return false;
        }
        Eventos other = (Eventos) object;
        if ((this.idEventos == null && other.idEventos != null) || (this.idEventos != null && !this.idEventos.equals(other.idEventos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eventos[ id=" + idEventos + " ]";
    }
}
