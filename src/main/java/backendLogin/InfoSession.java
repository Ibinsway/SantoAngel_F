/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendLogin;

import Entidades.Usuario;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author flamenquim
 */
@Named(value = "infoSession")
@SessionScoped
public class InfoSession implements Serializable {
    
    private Usuario usuario;
    
    //! Constructor
    
    public InfoSession() {
        
    }
    
    //! Getter, setter
    
    public Usuario getUsuario() { return usuario; }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    //! Metodos
    
    public String inicio() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        
        if(usuario != null) {
            //! Redirecciona a la pagina de inicio dependiendo del rol
            switch(usuario.getRolUsuario()) {
                case "Educando": return "PrincipalEducando.xhtml";
                case "Admin": return "PrincipalAdmin.xhtml"; 
                default: return "PrincipalScouter.xhtml";
            }
            
        } else { 
            return null;
        }
    }
    
    public String invalidarSesion() {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        
        return "login.xhtml";
    }
}