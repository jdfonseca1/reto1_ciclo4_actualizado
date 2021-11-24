/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetoUnoJdfb.RetoUno.Servicio;


import RetoUnoJdfb.RetoUno.Modelo.Usuario;
import RetoUnoJdfb.RetoUno.Repositorio.UsersRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge Daniel Fonseca Blanco
 */
@Service
public class userServicio {
    
    @Autowired
    private UsersRepositorio usersRepositorio;
    
    public List<Usuario> getAll(){
        return usersRepositorio.getAll();
    }
    
    public Optional<Usuario> getUser(int id){
        return usersRepositorio.getUser(id);
    }
    
    public Usuario registrar(Usuario user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return usersRepositorio.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
    public boolean existeEmail(String email) {
        return usersRepositorio.existeEmail(email);
    }
    
    
    public Usuario autenticarUsuario(String email, String password) {
        Optional<Usuario> usuario = usersRepositorio.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new Usuario(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
    
}
