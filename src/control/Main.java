/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.List;
import model.CustomerAccount;

/**
 *
 * @author Calebe Cavalcante
 */
public class Main {
    /**
     *
     * @param args
     */
    public static void main(String args[]){
        CustomerDAO customer_dao = new CustomerDAO();
        //Criação de clientes
        CustomerAccount customer_acc1 = new CustomerAccount(1550, "01002003040", "Gustavo Santos", 1, 1000);
        CustomerAccount customer_acc2 = new CustomerAccount(2200, "09002005010", "Gabriel Nakamura", 1, 850);
        CustomerAccount customer_acc3 = new CustomerAccount(1900, "18048065020", "Stella Siqueiras", 0, 2500);
        CustomerAccount customer_acc4 = new CustomerAccount(1450, "56023084120", "Leandro Arruda", 1, 1050);
        CustomerAccount customer_acc5 = new CustomerAccount(2000, "96385274199", "Vinicius Bonilha", 1, 400);
        //Inserção dos clientes no banco
        customer_dao.insert(customer_acc1);
        customer_dao.insert(customer_acc2);
        customer_dao.insert(customer_acc3);
        customer_dao.insert(customer_acc4);
        customer_dao.insert(customer_acc5);
        
        List<CustomerAccount> customers = customer_dao.readAll();
        List<CustomerAccount> customers_approv = new ArrayList();
        double vl_media = 0;
        
        for (CustomerAccount customer : customers) {
            if (customer.getId_customer() >= 1500 && customer.getId_customer() <= 2700
                && customer.getIs_active() == 1
                && customer.getVl_total() > 560){
                vl_media += customer.getVl_total();
                customers_approv.add(customer);
            }
        }
        vl_media /= customers_approv.size();
        
        System.out.println("Média final: " + vl_media);
        System.out.println("Clientes utilizados no cálculo: " + customers_approv);
    }
    
}
