package com.bykenyodarz.market.web.controller;

import com.bykenyodarz.market.domain.services.UserDetailService;
import com.bykenyodarz.market.web.security.messages.AuthenticationResponse;
import com.bykenyodarz.market.web.security.request.AuthenticationRequest;
import com.bykenyodarz.market.web.security.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/auth")
@Api(tags = "Authentication")
public class AuthRestController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailService service;
    private final JwtUtils jwtUtils;

    public AuthRestController(AuthenticationManager authenticationManager,
                              UserDetailService service, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.service = service;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/authenticate")
    @ApiOperation(
            value = "Iniciar Sesión",
            notes = "Servicio que nos valida la información de usuario e inicia sesión")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario inicia sesión correctamente"),
            @ApiResponse(code = 201, message = "Usuario inicia sesión correctamente"),
            @ApiResponse(code = 400, message = "Campos Inválidos"),
            @ApiResponse(code = 401, message = "Usuario no autorizado"),
            @ApiResponse(code = 403, message = "Recurso no disponible"),
            @ApiResponse(code = 404, message = "Recurso no encontrado")
    })
    public ResponseEntity<Object> createAuth(@RequestBody @Valid AuthenticationRequest request,
                                        BindingResult result) {
        if (result.hasErrors()) return validar(result);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()));
        UserDetails userDetails = service.loadUserByUsername(request.getUsername());
        String jwt = jwtUtils.generateJwt(userDetails);
        return ResponseEntity.ok().body(new AuthenticationResponse(jwt));
    }


    // Validador de campos
    public ResponseEntity<Object> validar(BindingResult result) {
        Map<String, Object> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> errores.put(err.getField(), " El campo " + err.getField() + " " + err.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errores);
    }

}
