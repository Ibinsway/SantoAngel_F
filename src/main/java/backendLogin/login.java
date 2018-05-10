/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendLogin;

import Entidades.Coordinador;
import Entidades.Educandos;
import Entidades.Scouts;
import Entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author RAFA
 */
@Named(value="login")
@RequestScoped
public class login {
    private String user;
    private String pass;
    private List<Usuario> users;
    
    public String login(){
        //Creamos 1 usuario de cada rol y los añadimos a la lista de usuarios creados
        Educandos ed = new Educandos();
        ed.setNombre_Usuario("pepe");
        ed.setContraseña_Usuario("1234");
        
        Scouts sc = new Scouts();
        sc.setNombre_Usuario("manolo");
        sc.setContraseña_Usuario("5678");
        
        Coordinador co = new Coordinador();
        co.setNombre_Usuario("angel");
        co.setContraseña_Usuario("admin");
        
        users = new ArrayList<>();
        users.add(ed);
        users.add(sc);
        users.add(co);
        
        return verify();
    }
    
    public String verify(){
        for(Usuario u:users){
            if(u.getNombre_Usuario().equals(user) && u.getContraseña_Usuario().equals(pass)){
                if(u.getClass().equals(Educandos.class)){
                    return "PrincipalEducando.xhtml";
                }else if(u.getClass().equals(Coordinador.class)){
                    return "PrincipalAdmin.xhtml";
                }else {
                    return "PrincipalScouter.xhtml";
                }
            }
        
        }
        return null;
    }
    
    public String getuser(){
        return user;
    }
    public String getpass(){
        return pass;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
