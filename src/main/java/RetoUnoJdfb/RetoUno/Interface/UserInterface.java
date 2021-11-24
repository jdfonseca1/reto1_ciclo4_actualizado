/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetoUnoJdfb.RetoUno.Interface;


import RetoUnoJdfb.RetoUno.Modelo.Usuario;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author usuario
 */
public interface UserInterface extends CrudRepository<Usuario, Integer> {
    
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByEmailAndPassword(String email, String password);
    
}
