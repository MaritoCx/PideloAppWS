/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import Entities.Tipo;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import Modelo.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author maritocx
 */
@WebService(serviceName = "PideloAppWS")
public class PideloAppWS {

    Methods methods = new Methods();
    
    /**
     * Web service operation
     * @param usuario
     * @param contrasenia
     * @return 
     */
    @WebMethod(operationName = "Login")
    public String Login(@WebParam(name = "usuario") String usuario, @WebParam(name = "contrasenia") String contrasenia) {
        //Web method to login
        if (methods.Login(usuario, contrasenia).equals("Login correcto")) {
            return "Login correcto";
        }
        else if(methods.Login(usuario, contrasenia).equals("Usuario correcto")){
            return "Usuario correcto";
        }
        else{
            return "Error";    
        }
        
    }
    

    /**
     * Web service operation
     * @param user
     * @param email
     * @param newPassword
     * @return 
     */
    @WebMethod(operationName = "ChangePassword")
    public String ChangePassword(@WebParam(name = "user") String user, @WebParam(name = "email") String email, 
            @WebParam(name = "newPassword") String newPassword) {
        //TODO write your implementation code here:
        String msg="";
        msg=methods.changePass(user,email,newPassword);
        if (msg.equals("Operacion exitosa")) {
            return "La contraseña se modifico correctamente :)";
        }
        else{
            return "Ocurrio un error";
        }
        
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getKindofRestaurant")
    public ArrayList<String> getKindofRestaurant() {
        //TODO write your implementation code here:

        return methods.fillKindofRestaurant();
    }
    
    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getProducts")
    public ArrayList<String> getProducts() {
        //TODO write your implementation code here:

        return methods.fillProducts();
    }
    
    
    /**
     * Web service operation
     * @param NombreRest
     * @param TipoRest
     * @param Rep
     * @param Mail
     * @param Tel
     * @param Open
     * @param Close
     * @param Dep
     * @param Usser
     * @param Dir
     * @param DUINIT
     * @return 
     * @throws java.text.ParseException 
     */
    
    @WebMethod(operationName = "AddRestaurant")
    public String AddRestaurant(@WebParam(name = "NomrbreRest") String NombreRest, @WebParam(name = "TipoRest") Integer TipoRest, 
            @WebParam(name = "Representante") String Rep,@WebParam(name = "email")String Mail,@WebParam(name = "Phone") String Tel,
            @WebParam(name = "OpenTime")String Open,@WebParam(name = "CloseTime")String Close,@WebParam(name = "Department")Integer Dep,
            @WebParam(name = "Usser")Integer Usser,@WebParam(name = "Direction")String Dir,@WebParam(name = "DUINIT")String DUINIT) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
              
        String msg = methods.addRestaurant(NombreRest, TipoRest, Rep, Mail, Tel, Open, Close, Dep, Usser, Dir, DUINIT);
        if (msg.equals("Creación de la empresa realizado con éxito"))return msg;
        else{
            if (msg.isEmpty()) return "Ocurrio un error";
            else return msg;
        }     
    }
}
