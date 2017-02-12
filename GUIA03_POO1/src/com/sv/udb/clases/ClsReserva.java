/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Walter
 */
public class ClsReserva {
    double Reg = 500, PReg = 2.90;
    double Esp = 500, PEsp = 3.11;
    double Die = 500, PDie = 2.53;
    int Tipo;
    double cantidad;
    String Cliente;

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }
    

    public void realCompr(String z) {
        switch(z) {
            case "Regular":                
                if (Tipo == 1){
                    cantidad = cantidad/PReg;
                    if (cantidad < Reg){
                        Reg -= cantidad;
                    }else{ JOptionPane.showMessageDialog(null, "No hay suficiente gas"); }
                } else {
                    if (cantidad < Reg){
                        Reg -= cantidad;
                    }else{ JOptionPane.showMessageDialog(null, "No hay suficiente gas"); }
                }                
                break;
                
            case "Especial":
                if (Tipo == 1){
                    cantidad = cantidad/PEsp;
                    if (cantidad < Esp){
                        Esp -= cantidad;
                    }else{ JOptionPane.showMessageDialog(null, "No hay suficiente gas"); }
                } else {
                    if (cantidad < Esp){
                        Esp -= cantidad;
                    }else{ JOptionPane.showMessageDialog(null, "No hay suficiente gas"); }
                }
                break;
                
            case "Diesel":
                if (Tipo == 1){
                    cantidad = cantidad/PDie;
                    if (cantidad < Die){
                        Die -= cantidad;
                    }else{ JOptionPane.showMessageDialog(null, "No hay suficiente gas"); }
                } else {
                    if (cantidad < Die){
                        Die -= cantidad;
                    }else{ JOptionPane.showMessageDialog(null, "No hay suficiente gas"); }
                }
                break;
        }            
    }
    
    public double porcentaje(String z) {
        switch(z) {
            case "Regular":                
                double poRe;
                poRe = ((100*Reg)/500);
                return poRe;
                
            case "Especial":
                double poEs;
                poEs = ((100*Esp)/500);
                return poEs;
                
            case "Diesel":
                double poDi;
                poDi = ((100*Die)/500);
                return poDi;
        }
        return 0;
    }

    public List<ClsVentas> getData()
    {
        List<ClsVentas> resp = null;
        try
        {
            String csvFile = "com/sv/udb/files/ventas.csv";
            File file = new File(ClassLoader.getSystemResource(csvFile).getFile());
            String line = "";
            String simb = ",";
            if(file.exists())
            {
                resp = new ArrayList<>();
                BufferedReader br = new BufferedReader(new FileReader(file));
                while ((line = br.readLine()) != null)
                {
                    String[] nota = line.split(simb);
                    resp.add(new ClsVentas(nota[0], nota[1], nota[2]));
                }
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    return resp;
    }
    
    public void Actualizar(List<ClsVentas> Nuevo){
        
        String outputFile = "src\\com\\sv\\udb\\files\\ventas.csv";
        
        try {  
            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
            csvOutput.setTextQualifier('"');
            for(ClsVentas temp : Nuevo){
                csvOutput.write(temp.getTipo());
                csvOutput.write(temp.getNombre());
                csvOutput.write(temp.getCompra());
                csvOutput.endRecord();                   
            }
            
            csvOutput.close();
         
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}
