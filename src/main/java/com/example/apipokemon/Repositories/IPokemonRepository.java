package com.example.apipokemon.Repositories;

import com.example.apipokemon.Model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPokemonRepository extends JpaRepository<Pokemon, Integer>
{
    @Query(value = "SELECT * FROM [pokemon].[dbo].[pokemon]", nativeQuery = true)
    List<Pokemon> getAllPokemons();

    @Query(value = "SELECT * FROM [pokemon].[dbo].[pokemon] WHERE pokemonId=:id", nativeQuery = true)
    List<Pokemon> getPokemonById(@Param("id") int pokemonId);

    @Query(value = "SELECT * FROM [pokemon].[dbo].[pokemon] WHERE pokemonType=:type", nativeQuery = true)
    List<Pokemon> getPokemonByType(@Param("type") int pokemonType);
}
