package com.example.apipokemon.Webservices.Services;

import com.example.apipokemon.Model.Pokemon;
import com.example.apipokemon.Repositories.IPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PokemonService
{
    private final IPokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(IPokemonRepository pokemonRepository)
    {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getAllPokemons()
    {
        return pokemonRepository.getAllPokemons();
    }

    public List<Pokemon> getPokemonById(int id)
    {
        return pokemonRepository.getPokemonById(id);
    }

    public List<Pokemon> getPokemonByType(int type)
    {
        return pokemonRepository.getPokemonByType(type);
    }

    public void likePokemon(Pokemon pokemon)
    {
        pokemonRepository.save(pokemon);
    }

    public void insertPokemon(Pokemon pokemon)
    {
        pokemon.setPokemonId(0);
        pokemon.setPokemonLikes(0);
        pokemonRepository.save(pokemon);
    }

    public void removePokemon(int id)
    {
        pokemonRepository.deleteById(id);
    }
}
