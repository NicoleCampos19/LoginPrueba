package Modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registrarse {
    
    private int id_usuario;
    private String nombre;
    private String apellido;
    private String fecha_nacimiento;
    private String correo;
    private String telefono;
    private String contraseña;
    private String imgFoto;
    private int id_tipousuario;
     
    // Getters y Setters
    public int getIdUsuario() {
        return id_usuario;
    }
     
    public void setIdUsuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
      
    public String getNombre() {
        return nombre;
    }
     
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
     
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
     
    public String getFechaNacimiento() {
        return fecha_nacimiento;
    }
     
    public void setFechaNacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
     
    public String getCorreo() {
        return correo;
    }
     
    public void setCorreo(String correo) {
        this.correo = correo;
    }
     
    public String getTelefono() {
        return telefono;
    }
     
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
     
    public String getContraseña() {
        return contraseña;
    }
     
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
     
    public String getImgFoto() {
        return imgFoto;
    }
     
    public void setImgFoto(String imgFoto) {
        this.imgFoto = imgFoto;
    }
     
    public int getIdTipoUsuario() {
        return id_tipousuario;
    }

    public void setIdTipoUsuario(int id_tipousuario) {
        this.id_tipousuario = id_tipousuario;
    }
    
    // Método para encriptar la contraseña utilizando SHA-256
    private String encriptarSHA256(String contraseña) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(contraseña.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // Agregar nuevos usuarios
    public void AgregarUsuarios() {
        // Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexión.getConexion();
        try {
            // Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addUsuario = conexion.prepareStatement("INSERT INTO tbUsuarios (nombre, apellido, fecha_nacimiento, correo, telefono, contraseña, id_tipo_usuario, imgFoto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            // Establecer valores de la consulta SQL
            addUsuario.setString(1, getNombre());
            addUsuario.setString(2, getApellido());
            addUsuario.setString(3, getFechaNacimiento());
            addUsuario.setString(4, getCorreo());
            addUsuario.setString(5, getTelefono());
            addUsuario.setString(6, encriptarSHA256(getContraseña()));  // Encriptar la contraseña antes de insertarla
            addUsuario.setInt(7, getIdTipoUsuario());
            addUsuario.setString(8, getImgFoto());
            // Ejecutar la consulta
            addUsuario.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("Este es el error: " + ex);
        }
    }
}
