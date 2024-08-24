package Controlador;

import Modelo.Registrarse;
import Vista.Registro;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlRegistrarse implements MouseListener, KeyListener {
    
      //1- Mandar a llamar a las otras dos capas (modelo, vista)
   private Registrarse ModeloRegistrarse;
   private Registro VistaRegistrarse;
   
   //Constructor de la clase
   public ctrlRegistrarse(Registrarse Modelo, Registro Vista){
   this.ModeloRegistrarse = Modelo;
   this.VistaRegistrarse = Vista;
   
   //Mando a llamar al btnRegistrarse
   Vista.btnRegistrarse.addMouseListener(this);
   }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == VistaRegistrarse.btnRegistrarse){
                 
            ModeloRegistrarse.setNombre(VistaRegistrarse.txtNombre.getText());
            ModeloRegistrarse.setApellido(VistaRegistrarse.txtApellido.getText());
            ModeloRegistrarse.setFechaNacimiento(VistaRegistrarse.txtFechaNacimiento.getText());
            ModeloRegistrarse.setCorreo(VistaRegistrarse.txtCorreo.getText());
            ModeloRegistrarse.setTelefono(VistaRegistrarse.txtTelefono.getText());
            ModeloRegistrarse.setContraseña(VistaRegistrarse.txtContraseña.getText());
            
            ModeloRegistrarse.AgregarUsuarios();
     }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
