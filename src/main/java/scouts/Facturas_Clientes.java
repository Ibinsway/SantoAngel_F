package scouts;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author flamenquim
 */
@Entity
public class Facturas_Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFactura;

    @Column(nullable = false)
    private String concepto;
    
    @Column(nullable = false)
    private Long cantidad;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date FechaFaptura;
    
    @Column(nullable = false)
    private Boolean pagado;
    
    
    //! Claves foraneas

    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Educandos Educando;
    
    
    //! Getters y Setters
    
    
    public Long getId() {
        return idFactura;
    }

    public void setId(Long idFactura) {
        this.idFactura = idFactura;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }    
    
    public Date getFechaFaptura() {
        return FechaFaptura;
    }

    public void setFechaFaptura(Date FechaFaptura) {
        this.FechaFaptura = FechaFaptura;
    }
    
    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }
    
    public Educandos getEducandos() {
        return Educando;
    }

    public void setEducandos(Educandos Educando) {
        this.Educando = Educando;
    }    
    
    
    //! Metodos sobreescritos
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturas_Clientes)) {
            return false;
        }
        Facturas_Clientes other = (Facturas_Clientes) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "scouts.Facturas_Clientes[ id=" + idFactura + " ]";
    }
    
}
