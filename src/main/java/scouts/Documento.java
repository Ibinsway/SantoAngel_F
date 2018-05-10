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
 * @author Jesus Sanchez Leal
 * rev 1.1 by Joaquin Terrasa Moya
 */
@Entity
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDoc;
    
    @Column(nullable = false, length = 20)
    private String nombre;
    
    @Column(nullable = false, length = 10)
    private Long tamaño;
    
    @Column(nullable = false, length = 10)
    private String tipo;
    
    @Column(nullable = false, length = 10)
    private String ficheroDocumento;
    
    
    //! Claves foraneas
    
    
    @ManyToOne
    @JoinColumn(name="documento_usuario_fk", nullable = false)
    private Usuario UsuarioIdUsuario;
    
    
    //! Setters y getters

    
    public Long getId() {
        return idDoc;
    }

    public void setId(Long idDoc) {
        this.idDoc = idDoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTamaño() {
        return tamaño;
    }

    public void setTamaño(Long tamaño) {
        this.tamaño = tamaño;
    }

    public Usuario getUsuarioIdUsuario() {
        return UsuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Usuario UsuarioIdUsuario) {
        this.UsuarioIdUsuario = UsuarioIdUsuario;
    }

    public String getFicheroDocumento() {
       return ficheroDocumento;
    }
    
    public void setFicheroDocumento(String ficheroDocumento) {
        this.ficheroDocumento = ficheroDocumento;
    }
    
    
    //! Metodos sobreescritos
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDoc != null ? idDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.idDoc == null && other.idDoc != null) || (this.idDoc != null && !this.idDoc.equals(other.idDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "documento[ id=" + idDoc + " ]";
    }
}
