package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.financiero.models.entity.UpdatePassword;
import com.apirest.financiero.models.entity.Usuarios;
import com.apirest.financiero.models.services.SendMailService;
import com.apirest.financiero.models.services.UsuarioService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1")
public class GUserController {
    public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

    @Autowired
    private SendMailService sendMailService;

    @Autowired
    private UsuarioService userService;

    @GetMapping("/users/list")
    public ResponseEntity<?> findAllUsers() {
        Map<String, Object> response = new HashMap<>();
        try{
            List<Usuarios> list = userService.findAllUsers();
            response.put("data", list);
            response.put("activos", userService.countByEstado(1));
            response.put("inactivos", userService.countByEstado(0));
            response.put("mensaje", "listado de usuarios!");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al consultar!");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/users/{idEntidad}")
    public List<Usuarios> findByIdEntidad(@PathVariable("idEntidad") Integer idEntidad) {
        return userService.findByIdEntidad(idEntidad);
    }

/*     @GetMapping("/users/find/{idUsr}")
    public ResponseEntity<?> findById(@PathVariable("idUsr") Integer idUsr) {
        return null;
    } */
    @GetMapping("/usuarios/list/{id}")
    public Usuarios findByUsernameId(@PathVariable("id") Long id) {
        return userService.findByUsernameId(id);
    }

    @GetMapping("/usuarios/count/nombre/{username}")
    public long countUsersByName(@PathVariable("username") String username) {
        return userService.countUsersByName(username);
    }

    @GetMapping("/usuarios/count/documento/{documento}")
    public long countUsersByDoc(@PathVariable("documento") String documento) {
        return userService.countUsersByDoc(documento);
    }

    @GetMapping("/usuarios/count/email/{email}")
    public long countUsersByEmail(@PathVariable("email") String email) {
        return userService.countUsersByEmail(email);
    }

    @PostMapping("/usuarios/save")
    public ResponseEntity<?> save(@RequestBody Usuarios usuarios) {
        Map<String, Object> response = new HashMap<>();
        try {
            String password = usuarios.getPassword();
            String email = usuarios.getEmail();
            String documento = usuarios.getDocumento();
            String username = usuarios.getUsername();
            usuarios.setPassword(passwordEncoder().encode(usuarios.getPassword()));
            usuarios.setPassChange(true);
            sendMailService.sendEmailPassword(email, documento, username, password);
            response.put("usuario", userService.save(usuarios));
            response.put("mensaje", "se ha creado el usuario!");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DataAccessException | MessagingException e) {
            response.put("mensaje", "Error al crear!");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/user/update/password")
    public ResponseEntity<?> updatePassword(@RequestBody UpdatePassword info) throws MessagingException {
        Map<String, Object> response = new HashMap<>();
        Usuarios userNew;
        try {
            userNew = userService.updatePassword(info.getUsuarios(), info.getNewpassword());
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al crear el usuario " + info.getUsuarios().getNombre());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("usuario", userNew);
        response.put("newpassword", info.getNewpassword());
        String email = userNew.getEmail();
        String documento = userNew.getDocumento();
        String username = userNew.getUsername();
        sendMailService.sendEmailCambiarPassword(email, documento, username);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            // userService.deleteUsuarioById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Eliminar El Usuario");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El Usuario con id " + id + " ha sido eliminado con éxito!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PutMapping("/usuarios/update")
    public ResponseEntity<?> update(@RequestBody Usuarios usuarios) {
        Map<String, Object> response = new HashMap<>();
        Usuarios actual = null;

        try {
            actual = userService.findByUsernameId(usuarios.getId());
            if (actual != null) {
                actual.setNombre( usuarios.getNombre() );
                actual.setApellido( usuarios.getApellido() );
                actual.setEmail( usuarios.getEmail() );
                response.put("usuario", userService.save(actual));
            }
            response.put("mensaje", "usuario actualizado!");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar!");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/usuarios/update/estado")
    public ResponseEntity<?> updateEstado(@RequestBody Usuarios usuarios) {
        Map<String, Object> response = new HashMap<>();
        Usuarios actual = null;
        Boolean activo = Boolean.valueOf(true);
        Boolean inactivo = Boolean.valueOf(false);
        try {
            actual = userService.findByUsernameId(usuarios.getId());
            if (actual != null) {
                if (usuarios.getEnabled().booleanValue() == true) {
                    usuarios.setEnabled(inactivo);
                    response.put("usuario", userService.save(usuarios));
                } else {
                    usuarios.setEnabled(activo);
                    response.put("usuario", userService.save(usuarios));
                }
            }
            response.put("mensaje", "se ha cambiado el estado!");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar!");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/usuarios/expirar")
    public ResponseEntity<?> expirar(@RequestBody Usuarios usuarios){
        Map<String, Object> response = new HashMap<>();
        try {
            usuarios.setPassChange(true);
            response.put("usuario", userService.save(usuarios));
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar!");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
     response.put("mensaje", "Contraseña experada!");
     return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
