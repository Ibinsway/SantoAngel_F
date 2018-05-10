package scouts;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Jesus Sanchez Leal, Joaquin Terrasa Moya
 */
@Entity
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, length = 10)
    private Long idComentario;
    
    @Column(nullable = false, length = 250)
    private String texto;
    
    
    //! Claves foraneas
    
    @ManyToOne
    @JoinColumn(name = "comentario_usuario_fk", nullable = true)
    private Usuario UsuarioIdUsuarioComentario;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Eventos EventosIdEventos;
    
    
    //! Setters y getters
    

    public Long getId() {
        return idComentario;
    }

    public void setId(Long idComentario) {
        this.idComentario = idComentario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentario != null ? idComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.idComentario == null && other.idComentario != null) || (this.idComentario != null && !this.idComentario.equals(other.idComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comentario[ id=" + idComentario + " ]";
    }

    public String gettexto() {
        return texto;
    }

    public void settexto(String texto) {
        this.texto = texto;
    }

    public Usuario getUsuarioIdUsuarioComentario() {
        return UsuarioIdUsuarioComentario;
    }

    public void setUsuarioIdUsuarioComentario(Usuario UsuarioIdUsuarioComentario) {
        this.UsuarioIdUsuarioComentario = UsuarioIdUsuarioComentario;
    }


    public Eventos getEventosIdEventos() {
        return EventosIdEventos;
    }

    public void setEventosIdEventos(Eventos EventosIdEventos) {
        this.EventosIdEventos = EventosIdEventos;
    }

    
}
