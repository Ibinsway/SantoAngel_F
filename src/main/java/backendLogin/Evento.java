/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendLogin;

import Entidades.Eventos;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Date;

/**
 *
 * @author flamenquim
 */
@Named(value = "evento")
@SessionScoped
public class Evento implements Serializable {
    
    private Eventos evento;
    
    public Evento() {
    }
    
    
}
