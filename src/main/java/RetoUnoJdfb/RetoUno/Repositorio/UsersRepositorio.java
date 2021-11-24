/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetoUnoJdfb.RetoUno.Repositorio;

import RetoUnoJdfb.RetoUno.Interface.UserInterface;
import RetoUnoJdfb.RetoUno.Modelo.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jorge Daniel Fonseca Blanco
 */
@Repository
public class UsersRepositorio {
    
    @Autowired
    private UserInterface userInterface;
    
    
    public List<Usuario> getAll(){
     return (List<Usuario>) userInterface.findAll();
     }
    
    public Optional<Usuario> getUser(int id) {
        return userInterface.findById(id);
    }
    
     public Usuario save(Usuario user) {
        return userInterface.save(user);
    }
    
     public boolean existeEmail(String email) {
        Optional<Usuario> usuario = userInterface.findByEmail(email);

        return !usuario.isEmpty();
    }
    
     public Optional<Usuario> autenticarUsuario(String email, String password) {
        return userInterface.findByEmailAndPassword(email, password);
    }
    
    
}
