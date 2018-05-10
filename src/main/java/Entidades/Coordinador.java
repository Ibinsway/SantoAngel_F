package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Rafael Martin Carrion, Joaquin Terrasa Moya
 */
@Entity
@DiscriminatorValue("Coord")
public class Coordinador extends Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Column(nullable = false, length = 40)
    private String CorreoContacto;
    
    @Column(nullable = false, length = 9)
    private String DNI;
    
    @Column(nullable = false, length = 12)
    private Long TelefonoContacto;

    //! Getters y Setters
    
    public Long getTelefonoContacto() {
        return TelefonoContacto;
    }

    public void setTelefonoContacto(Long TelefonoContacto) {
        this.TelefonoContacto = TelefonoContacto;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getCorreoContacto() {
        return CorreoContacto;
    }

    public void setCorreoContacto(String CorreoContacto) {
        this.CorreoContacto = CorreoContacto;
    }
}
