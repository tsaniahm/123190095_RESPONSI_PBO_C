
package model;

import DBConnect.DBConnect;
import controller.BarangController;
import java.sql.*;
import javax.swing.JOptionPane;

public class BarangModel  {
    private Connection connection;
    private Statement statement;

    public BarangModel(){
        DBConnect dbConnect = new DBConnect();
        connection = dbConnect.getConnection();
    }
    
    public void createBarang(String [] data){
        try{
            String query = "INSERT INTO `barang`(`nama`, `massa`, `harga`) VALUES ('"+data[0]+"','"+data[1]+"','"+data[2]+"')";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
            JOptionPane.showMessageDialog(null, "Input Successfull");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    
    }
    
    public String[] createTotalBarang(String[] data){
        try{            
            float banyak = Float.valueOf(data[4]);
            float harga = Float.valueOf(data[3]);
            float total, total1;
            
            if(banyak == 12.0){
             total = harga*banyak;
             total1 = (float) (total - (total*(5.0/100.0)));
             data[4] =  String.valueOf(total1);
            }else if(banyak == 20.0){
             total = harga*banyak;
             total1 = (float) (total - (total*(10.0/100.0)));
             data[4] =  String.valueOf(total1);
            }else if(banyak == 144.0){
             total = harga*banyak;
             total1 = (float) (total - (total*(25.0/100.0)));
             data[4] =  String.valueOf(total1);
            }else{
             total = harga*banyak;
             total1 = (float) (total);
             data[4] =  String.valueOf(total1);
            }

         return data;
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
         return null;
        }  
        
    }
    
    
    public int countData(){ 
        int jmlData = 0; 
        try{
            statement = connection.createStatement();
            String query = "Select * from `barang`";
            ResultSet resultSet = statement.executeQuery(query); 
            while(resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return 0;
        }    
    }
    
    public String [][] readData(){
       try{
            int jmlData = 0; 
            String data[][] = new String[countData()][4];
            String query = "Select * from `barang`"; 
            ResultSet resultSet = statement.executeQuery(query); 
            while(resultSet.next()){
                data[jmlData][0] = resultSet.getString("id");
                data[jmlData][1] = resultSet.getString("nama"); 
                data[jmlData][2] = resultSet.getString("massa"); 
                data[jmlData][3] = resultSet.getString("harga");
                jmlData++; 
                
            }
            return data;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public String[] readData(String id){
    try{     
            String[] data = new String[4];
            statement = connection.createStatement();
            String query = "select * from barang where id = '"+id+"' "; 
            ResultSet resultSet = statement.executeQuery(query); 
            while(resultSet.next()){
                data[0] = resultSet.getString("id");
                data[1] = resultSet.getString("nama"); 
                data[2] = resultSet.getString("massa"); 
                data[3] = resultSet.getString("harga");
             
            }
            return data;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("SQL Error oik");
            return null;
        }
    }
    
    public void updateBarang(String[] data){
     try{
            String query = "UPDATE `barang` set `nama` = '"+data[1]+"', `massa` = '"+data[2]+"', `harga` = '"+data[3]+"' where `id` = '"+data[0]+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Update Successful!");
            JOptionPane.showMessageDialog(null,"Update Successful!");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void deleteBarang(String id){
     try{
            String query = "DELETE FROM `barang` WHERE `id` = '"+id+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);            
            BarangController barang = new BarangController();
            barang.readDataBarang();
            System.out.println("Delete Successful!");
            JOptionPane.showMessageDialog(null,"Delete Successful!");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    

}
