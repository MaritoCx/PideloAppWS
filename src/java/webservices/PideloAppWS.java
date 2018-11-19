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
import java.util.ArrayList;
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
     * @return 
     */
    /*Obsolet*/
//    @WebMethod(operationName = "getKidofRestaurant")
//    public ArrayList<ArrayList> getKidofRestaurant() {
//        //TODO write your implementation code here:
//        
//        return methods.fillKindofRestaurant();
//    }
    
    
}
