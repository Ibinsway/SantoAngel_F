/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendLogin;

import Entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author RAFA, flamenquim
 */
@Named(value="login")
@RequestScoped
public class Login {
    
    private String usuario;
    private String contrasenia;
    private List<Usuario> usuarios;
    
    //! Constructor
    
    public Login() {
        
        usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("pepe", "1234", "Educando"));
        usuarios.add(new Usuario("manolo", "5678", "Scouter"));
        usuarios.add(new Usuario("angel", "admin", "Admin"));
        
    }
    
    //! Getters, setters
    
    public String getUsuario(){
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getContrasenia(){
        return contrasenia;
    }
    
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    //! Metodos
    
    public String autenticar(){
        
        if(this.contrasenia.equals("") || this.usuario.equals("")) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            if(this.contrasenia.equals("")) {
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña not found", "Contraseña not found"));
            
            } else if(this.usuario.equals("")) {
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User not found", "User not found"));
            } else {
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User in DB not found", "User in DB not found"));
            }
            //! return null;
        } else {
            for(Usuario u : usuarios){
            
                if(u.getNombre_Usuario().equals(usuario) &&
                   u.getContraseña_Usuario().equals(contrasenia)){

                    if(u.getRolUsuario().equals("Educando")){
                        return "PrincipalEducando.xhtml";

                    }else if(u.getRolUsuario().equals("Admin")){
                        return "PrincipalAdmin.xhtml";

                    }else {
                        return "PrincipalScouter.xhtml";
                    }
                }
            }
            //! return null;
        }
        return null;
    }
}
