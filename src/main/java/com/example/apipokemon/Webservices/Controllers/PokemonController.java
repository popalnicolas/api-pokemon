package com.example.apipokemon.Webservices.Controllers;

import com.example.apipokemon.Model.Pokemon;
import com.example.apipokemon.Webservices.Services.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PokemonController
{
    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService)
    {
        this.pokemonService = pokemonService;
    }

    @Operation(summary = "Returns list of all pokemons. Can be also used with parameter id", description = "")
    @GetMapping("/pokemons")
    @ResponseBody
    public ResponseEntity<List<Pokemon>> getAllPokemons(@RequestParam Optional<Integer> id, @RequestParam Optional<Integer> type)
    {
        List<Pokemon> pokemons;
        if(id.isEmpty() && type.isEmpty()) {
            pokemons = pokemonService.getAllPokemons();
        }
        else if(type.isPresent())
        {
            pokemons = pokemonService.getPokemonByType(type.get());
        }
        else
        {
            pokemons = pokemonService.getPokemonById(id.get());
        }

        if(!pokemons.isEmpty())
            return ResponseEntity.ok(pokemons);

        return ResponseEntity.notFound().build();

    }

    @PutMapping("/pokemons/like")
    @ResponseBody
    public ResponseEntity<List<Pokemon>> likePokemon(@RequestBody Pokemon pokemon) {
        pokemonService.likePokemon(pokemon);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Creates new pokemon", description = "")
    @PostMapping("/pokemons")
    public ResponseEntity insertPokemon(@RequestBody Pokemon pokemon)
    {
        pokemonService.insertPokemon(pokemon);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @Operation(summary = "Deletes pokemon", description = "")
    @DeleteMapping("/pokemons/{id}")
    public ResponseEntity removePokemon(@PathVariable("id") int id)
    {
        pokemonService.removePokemon(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
