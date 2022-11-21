/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControllerPersistencia;
import java.util.List;

/**
 *
 * @author emiliano
 */
public class Controller {
    
    ControllerPersistencia controlPersis = new ControllerPersistencia(); 
    
    public void guardar(String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {
        Duenio duenio = new Duenio();
        Mascota masco = new Mascota();
        
        duenio.setNombre(nombreDuenio);
        duenio.setTelefono(celDuenio);
        
        masco.setNombre(nombreMasco);
        masco.setColor(color);
        masco.setRaza(raza);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp);
        masco.setUnDuenio(duenio);
        
        controlPersis.guardar(duenio,masco);
    }

    public List<Mascota> getMascotas() {
        return controlPersis.getMascotas();
    }

    public void deleteMascota(int num_cliente) {
        controlPersis.DeleteMascota(num_cliente);
    }

    public void editMascota(Mascota mascota, String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {
       mascota.setRaza(raza);
       mascota.setAlergico(alergico);
       mascota.setNombre(nombreMasco);
       mascota.setAtencion_especial(atenEsp);
       mascota.setColor(color);
       mascota.setObservaciones(observaciones);
       
       controlPersis.editarMascota(mascota);
       Duenio duenio = this.buscarDuenio(mascota.getUnDuenio().getId_duenio());
       
       duenio.setNombre(nombreDuenio);
       duenio.setTelefono(celDuenio);
       
       this.modificarDuenio(duenio);
    }

    public Mascota getOneMascota(int num_cliente) {
       return controlPersis.getOneMascota(num_cliente);
    }

    private Duenio buscarDuenio(int id_duenio) {
       return controlPersis.findDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
       controlPersis.modificarDuenio(duenio);
    }
    
}
