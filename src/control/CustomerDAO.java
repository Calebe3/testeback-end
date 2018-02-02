/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CustomerAccount;

/**
 *
 * @author Calebe Cavalcante
 */
public class CustomerDAO {
    public String uri = "jdbc:mysql://localhost:3306/bd_testeback?zeroDateTimeBehavior=convertToNull";
    public String user = "root";
    public String pwd = "";
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            return DriverManager.getConnection(uri,user, pwd);
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean insert(CustomerAccount customer_acc) {
        boolean resp = false;
        //Estabelecendo a conexão
        Connection conn = getConnection();
        
        //Preparando a consulta
        String sql = "INSERT INTO tb_customer_account(id_customer, cpf_cnpj, nm_customer, is_active, vl_total) VALUES(?, ?, ?, ?, ?);";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setLong(1, customer_acc.getId_customer());
            pst.setString(2, customer_acc.getCpf_cnpj());
            pst.setString(3, customer_acc.getNm_customer());
            pst.setInt(4, customer_acc.getIs_active());
            pst.setDouble(5, customer_acc.getVl_total());
            
        //Executando a consulta
        int rows = pst.executeUpdate();
        
        //Tratando o resultado
        resp = (rows > 0);
        
        //Fechar a conexão
        conn.close();
     
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resp;
    }
    
    public List<CustomerAccount> readAll() {
        List<CustomerAccount> customers = new ArrayList<>();

        Connection conn = getConnection();

        String sql = "SELECT * FROM tb_customer_account";
        try {
            Statement stm = conn.createStatement();

            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                Long id_customer = rs.getLong("id_customer");
                String cpf_cnpj = rs.getString("cpf_cnpj");
                String nm_customer = rs.getString("nm_customer");
                int is_active = rs.getInt("is_active");
                double vl_total = rs.getDouble("vl_total");
                CustomerAccount customer = new CustomerAccount(id_customer, cpf_cnpj, nm_customer, is_active, vl_total);
                customers.add(customer);
            }

            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return customers;
    }



}
