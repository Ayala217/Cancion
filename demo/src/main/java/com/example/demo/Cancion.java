package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record Cancion (String id, String nombre, String genero, String artistaId){

    public static final List<Cancion> canciones = new ArrayList<>(Arrays.asList(
            new Cancion("cancion-1","Tabloid Junkie","Rock/pop","Artista-1"),
            new Cancion("cancion-2","Countdown to extintion","Trash Metal","Artista-2"),
            new Cancion("cancion-3","Given Up","Alternative Metal","Artista-3")
    ));

    public static Cancion getCancion(String id){
        return canciones.stream()
                .filter(cancion -> cancion.id.equals(id))
                .findFirst()
                .orElse(null);
    }

    public static Cancion addCancion(CancionInput cancionInput){
        final Cancion cancion = new Cancion(
                "cancion-"+canciones.size(),
                cancionInput.nombre(),
                cancionInput.genero(),
                cancionInput.artistaId()

        );
        canciones.add(cancion);
        return cancion;
    }


}
