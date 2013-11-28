/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usach.pingeso.taa.validators;

import cl.usach.pingeso.taa.sessionbeans.UserFacadeLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Diego
 */
@FacesValidator("RutValidator")
public class RutValidator implements Validator {
    UserFacadeLocal userFacade = lookupUserFacadeLocal();
    private static final String RUT_PATTERN = "^[0-9]+$";
    private Pattern pattern;
    private Matcher matcher;
        
    public RutValidator(){
        pattern = Pattern.compile(RUT_PATTERN);
    }
        
    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {
        matcher = pattern.matcher(value.toString());
        System.out.println(matcher.matches());
        if (!matcher.matches()) {
            FacesMessage msg =
                    new FacesMessage("Rut ingresado no es válido.",
                    "Rut ingresado no es válido.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        
        if (userFacade.find(value) != null) {
            String mensaje = "Rut ingresado ya existe.";
            FacesMessage msg = new FacesMessage(mensaje, mensaje);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
    private UserFacadeLocal lookupUserFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (UserFacadeLocal) c.lookup("java:global/taa/taa-ejb/UserFacade!cl.usach.pingeso.taa.sessionbeans.UserFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}