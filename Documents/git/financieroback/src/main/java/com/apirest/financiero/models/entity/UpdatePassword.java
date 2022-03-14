package com.apirest.financiero.models.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class UpdatePassword {

    private Usuarios usuarios;
    private String newpassword;
}
