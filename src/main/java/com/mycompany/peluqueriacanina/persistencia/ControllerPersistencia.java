/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emiliano
 */
public class ControllerPersistencia {
    
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascoJpa = new MascotaJpaController();
    
    public void guardar(Duenio duenio, Mascota masco) {
       duenioJpa.create(duenio);
       mascoJpa.create(masco);
    }

    public List<Mascota> getMascotas() {
       return mascoJpa.findMascotaEntities();
    }

    public void DeleteMascota(int num_cliente) {
        
        try{
            
        mascoJpa.destroy(num_cliente);
        
        }
        catch(NonexistentEntityException e){
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE,null,e);
        }
    }

    public Mascota getOneMascota(int num_cliente) {
        return mascoJpa.findMascota(num_cliente);
    }

    public Duenio findDuenio(int id_duenio) {
        return duenioJpa.findDuenio(id_duenio);
    }

    public void editarMascota(Mascota mascota) {
        
        try{
            
       mascoJpa.edit(mascota);
       
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void modificarDuenio(Duenio duenio) {
        
        try{
            
        duenioJpa.edit(duenio);
       
        }catch(Exception e){
            System.out.println(e);
        } 
    }
    
}
