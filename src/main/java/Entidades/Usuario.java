package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Rafael Martin Carrion
 * rev1.1 by Joaquin Terrasa Moya
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, length = 10, updatable = false)
    private Long idUsuario;
    
    @Column(nullable = false, length = 20, updatable = false)
    private String nombreUsuario;
    
    @Column(nullable = false, length = 40)
    private String contraseñaUsuario;
    
    @Column(nullable = false, length = 20)
    private String nombreReal;
    
    @Column(nullable = false, length = 40)
    private String apellidosReales;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaNacimiento;
    
    @Transient
    private Long edad;
    
    @Column(nullable = false, length = 30)
    private String email;
    
    //! Foto_Perfil es una la direccion URL del archivo JPEG
    @Column(nullable = false)
    private String fotoPerfil;

    
    //! Claves foraneas
    @OneToMany(mappedBy = "UsuarioIdUsuario")
    @JoinColumn(nullable = true)
    private List<Documento> docs;
    
    @OneToMany(mappedBy = "UsuarioIdUsuarioComentario")
    @JoinColumn(nullable = true)
    private List<Comentario> comentarios;
    
    
    //! Constructor
    
    public Usuario() {
        
    }

    //! Getters and setters
    
    public Long getID_Usuario() {
        return idUsuario;
    }

    public void setID_Usuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Documento> getDocs() {
        return docs;
    }
    
    public void setDocs() {
        
    }
    
    public List<Comentario> getComentarios() {
        return comentarios;
    }
    
    public void setComentarios() {
        
    }
    
    public String getNombre_Usuario() {
        return nombreUsuario;
    }

    public void setNombre_Usuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña_Usuario() {
        return contraseñaUsuario;
    }

    public void setContraseña_Usuario(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }

    public String getNombre_Real() {
        return nombreReal;
    }

    public void setNombre_Real(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public String getApellidos_Reales() {
        return apellidosReales;
    }

    public void setApellidos_Reales(String apellidosReales) {
        this.apellidosReales = apellidosReales;
    }

    public Date getFecha_Nacimiento() {
        return fechaNacimiento;
    }

    public void setFecha_Nacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getEdad() {
        return edad;
    }

    public void setEdad(Long edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto_Perfil() {
        return fotoPerfil;
    }

    public void setFoto_Perfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    //! Overrided methods
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idUsuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) obj;
        if(!this.idUsuario.equals(other.idUsuario)) {
            return false;
        }
        return true;
    }
  
    @Override
    public String toString() {
        return "[username= "+ nombreUsuario +", id="+ idUsuario +"]";
    }
}
