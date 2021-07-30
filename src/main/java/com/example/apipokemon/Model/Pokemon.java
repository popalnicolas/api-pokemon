package com.example.apipokemon.Model;

import javax.persistence.*;

@Entity
@Table(name = "pokemon", schema = "dbo")
public class Pokemon
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pokemonId")
    private int pokemonId;

    @Column(name = "pokemonName")
    private String pokemonName;

    @Column(name = "pokemonType")
    private int pokemonType;

    @Column(name = "pokemonImage")
    private String pokemonImage;

    @Column(name = "pokemonDescription")
    private String pokemonDescription;

    @Column(name = "pokemonLikes")
    private int pokemonLikes;

    public Pokemon() {
    }

    public Pokemon(int pokemonId, String pokemonName, int pokemonType, String pokemonImage, String pokemonDescription, int pokemonLikes) {
        this.pokemonId = pokemonId;
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
        this.pokemonImage = pokemonImage;
        this.pokemonDescription = pokemonDescription;
        this.pokemonLikes = pokemonLikes;
    }

    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public int getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(int pokemonType) {
        this.pokemonType = pokemonType;
    }

    public String getPokemonImage() {
        return pokemonImage;
    }

    public void setPokemonImage(String pokemonImage) {
        this.pokemonImage = pokemonImage;
    }

    public String getPokemonDescription() {
        return pokemonDescription;
    }

    public void setPokemonDescription(String pokemonDescription) {
        this.pokemonDescription = pokemonDescription;
    }

    public int getPokemonLikes() {
        return pokemonLikes;
    }

    public void setPokemonLikes(int pokemonLikes) {
        this.pokemonLikes = pokemonLikes;
    }
}
