package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.Usuarios;

public interface IUsuarioService {
  public Usuarios findByUsername(String username);
}
