/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Entities.Tipo;
import Objects.Restaurant;
import java.sql.*;
import java.sql.CallableStatement;
import java.sql.Connection;  
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
/**
 *
 * @author maritocx
 */
public class Methods {
    Connection connDB=null;
    String correct="";
    ResultSet result=null;
    static CallableStatement call=null;
    EntityManager manager;
    EntityManagerFactory emf;
    /*Calling the login function in database*/
    
    public Methods() {
        emf = Persistence.createEntityManagerFactory("PideloAppWSPU");
        manager = emf.createEntityManager();
    }
    
    
    public String Login(String usser, String pass){
        String query ="Select Login(?,?)";  
        connDB = ConnectionDB.ConnectionDB();
        try{
            call=connDB.prepareCall(query);
            call.setString(1, usser);
            call.setString(2, pass);
            call.execute();
            result = call.getResultSet();
             
            while(result.next()){
                correct=result.getString(1);
            }
            
            if (correct.equals("Login correcto")) {
                return correct;
            }
            else if(correct.equals("Usuario correcto")){
                return correct;
            }
            else{
                return correct;
            }
            
        }catch (SQLException e){
            
        }finally{
            ConnectionDB.close(result,call,connDB);
        }
        
            return correct;
    }
    
    /*Calling the storage procedure to change the password*/
    public String changePass(String user, String email, String pass){
        String msg="";
        
        String query="Call changePassword(?,?,?,?)";
        connDB= ConnectionDB.ConnectionDB();
        try{
            call=connDB.prepareCall(query);
            call.setString(1, user);
            call.setString(2, email);
            call.setString(3, pass);
            call.registerOutParameter(4, java.sql.Types.VARCHAR);
            call.execute();
            
            msg=call.getString(4);
       
        }catch(SQLException e){
            
        }finally{
            ConnectionDB.close(result,call,connDB);
        }
        return msg;
    }
    
    /*Obsolet*/
    /*Calling the storage procedure to fill the kind of restaurants*/
//    public ArrayList fillKindofRestaurant(){
//        ArrayList<ArrayList> Lkindrestaurant = new ArrayList<ArrayList>();
//        ArrayList<String> LKind = new ArrayList<String>();
//        ArrayList<String> Limage = new ArrayList<String>();
//        
//        String query="Select tipo, img from Tipo where idTipo=1";
//        connDB=ConnectionDB.ConnectionDB();
//        try{
//            
//            Statement stmn= connDB.createStatement();
//
//            result=stmn.executeQuery(query);
//            while (result.next()){
//                LKind.add(result.getString(0));
//                Limage.add(result.getString(1));
//            }
//            Lkindrestaurant.add(LKind);
//            Lkindrestaurant.add(Limage);
//        }catch(SQLException e){
//            
//        }finally{
//            ConnectionDB.close(result,call,connDB);
//        }
//        
//        return Lkindrestaurant;
//    }
    
    /*Calling the something to fill the kind of restaurants*/
    public ArrayList<String> fillKindofRestaurant(){
        List<Object> variable4 = (List<Object>) manager.createQuery("SELECT t.idTipo FROM Tipo t").getResultList();
        
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 1; i < variable4.size()+1; i++) {
       
           String variable1 = (String) manager.createQuery("SELECT t.tipo FROM Tipo t WHERE t.idTipo=:para").setParameter("para", i).getSingleResult();
           String variable2 = (String) manager.createQuery("SELECT t.img FROM Tipo t WHERE t.idTipo=:para").setParameter("para", i).getSingleResult();
           String variable3 = i+","+variable1+","+variable2;
           lista.add(variable3);       
        }

        return lista;
    }
    
    /*Calling the something to fill all products*/
    public ArrayList<String> fillProducts(){
        List<Object> numProd = (List<Object>) manager.createQuery("SELECT p.idProd FROM Producto p").getResultList();
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 1; i < numProd.size()+1; i++) {
           String variable1 = (String) manager.createQuery("SELECT p.producto FROM Producto p WHERE p.idProd=:para").setParameter("para", i).getSingleResult();
           String variable3 = (String) manager.createQuery("SELECT p.descripcion FROM Producto p WHERE p.idProd=:para").setParameter("para", i).getSingleResult();
           Object variable2 = (Object) manager.createQuery("SELECT p.precio FROM Producto p WHERE p.idProd=:para").setParameter("para", i).getSingleResult();
           String variable4 = i+","+variable1+","+variable2+","+variable3;
           lista.add(variable4);
        }
        

        return lista;
    }
}
