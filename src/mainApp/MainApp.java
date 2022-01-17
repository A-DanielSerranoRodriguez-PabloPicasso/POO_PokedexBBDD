package mainApp;

import models.Pokemon;
import models.TiposPokemon;
import ui.Menu;
import utils.Almacen;

public class MainApp {

	public static void main(String[] args) {
		Almacen.pokemons.add(new Pokemon(1, "Bulbasaur", TiposPokemon.Planta, TiposPokemon.Veneno, 0.7, 6.9, "Espesura",
				"Semilla", true));
		Almacen.pokemons.add(new Pokemon(2, "Ivysaur", TiposPokemon.Planta, TiposPokemon.Veneno, 1, 13, "Espesura",
				"Semilla", false));
		Almacen.pokemons.add(new Pokemon(3, "Venusaur", TiposPokemon.Planta, TiposPokemon.Veneno, 2, 100, "Espesura",
				"Semilla", false));
		Almacen.pokemons.add(new Pokemon(4, "Charmander", TiposPokemon.Fuego, TiposPokemon.Ninguno, 0.6, 8.5,
				"Mar Llamas", "Lagartija", true));
		Almacen.pokemons.add(new Pokemon(5, "Charmeleon", TiposPokemon.Fuego, TiposPokemon.Ninguno, 1.1, 19,
				"Mar Llamas", "LLama", false));
		Almacen.pokemons.add(new Pokemon(6, "Charizard", TiposPokemon.Fuego, TiposPokemon.Volador, 1.7, 90.5,
				"Mar Llamas", "Lagartija", false));
		Almacen.pokemons.add(new Pokemon(7, "Squirtle", TiposPokemon.Agua, TiposPokemon.Ninguno, 0.5, 9, "Torrente",
				"Tortuguita", true));
		Almacen.pokemons.add(new Pokemon(8, "Wartortle", TiposPokemon.Agua, TiposPokemon.Ninguno, 1, 22.5, "Torrente",
				"Tortuga", false));
		Almacen.pokemons.add(new Pokemon(9, "Blastoise", TiposPokemon.Agua, TiposPokemon.Ninguno, 1.6, 85.5, "Torrente",
				"Armazón", false));
		
		new Menu();
	}

}
