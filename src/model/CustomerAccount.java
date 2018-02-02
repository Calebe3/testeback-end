/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Calebe Cavalcante
 */
public class CustomerAccount {
    private long id_customer;
    private String cpf_cnpj, nm_customer;
    private int is_active;
    private double vl_total;

    public CustomerAccount(long id_customer, String cpf_cnpj, String nm_customer, int is_active, double vl_total) {
        this.id_customer = id_customer;
        this.cpf_cnpj = cpf_cnpj;
        this.nm_customer = nm_customer;
        this.is_active = is_active;
        this.vl_total = vl_total;
    }

    public long getId_customer() {
        return id_customer;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public String getNm_customer() {
        return nm_customer;
    }

    public int getIs_active() {
        return is_active;
    }

    public double getVl_total() {
        return vl_total;
    }

    @Override
    public String toString() {
        return "CustomerAccount{" + "id_customer=" + id_customer + ", cpf_cnpj=" + cpf_cnpj + ", nm_customer=" + nm_customer + ", is_active=" + is_active + ", vl_total=" + vl_total + '}';
    }
    
}
