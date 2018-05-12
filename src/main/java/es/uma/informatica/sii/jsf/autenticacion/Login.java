/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import Entidades.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author francis
 */
@Named(value = "login")
@RequestScoped
public class Login {

    private String usuario;
    private String contrasenia;
    private List<Usuario> usuarios;
    
    @Inject
    private ControlAutorizacion ctrl;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("pepe", "1234", "Educando"));
        usuarios.add(new Usuario("manolo", "qwer", "Scouter"));
        usuarios.add(new Usuario("kingjose", "saucony", "Admin"));
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String autenticar() {
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        boolean esta = false;
        Iterator aux = usuarios.iterator();
        Usuario x = null;
        while(aux.hasNext()&&(!esta)){
            x = (Usuario) aux.next();
            if(x.getUsuario().equals(usuario)){
                esta = true;
            }
        }
        if(esta){
            if(x.getContraseña_Usuario().equals(contrasenia)){
                ctrl.setUsuario(x);
                return ctrl.home();
            }else{
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña incorrecta", "Contraseña incorrecta"));
            }
        }else{
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario no encontrado", "Usuario no encontrado"));
        }
        return null;
    }
}
