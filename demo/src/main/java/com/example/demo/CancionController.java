package com.example.demo;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CancionController {

    @QueryMapping
    public Cancion getCancion(@Argument String id) {
        return Cancion.getCancion(id);
    }
    @MutationMapping
    public Cancion addCancion(@Argument CancionInput cancionInput) {
        return Cancion.addCancion(cancionInput);
    }

    @SchemaMapping
    public Artista artista (Cancion cancion) {
        return Artista.findById(cancion.artistaId());
    }
}
