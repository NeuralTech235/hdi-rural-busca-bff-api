package com.hdi.ruralbuscalbff.api.controller.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioApi {
    private Integer usuarioId;
    private String nomeUsuario;
}
