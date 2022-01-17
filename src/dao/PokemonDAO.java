package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Pokemon;
import models.TiposPokemon;

public class PokemonDAO extends AbstractDAO {
	Pokemon pokemon;

	public PokemonDAO() {
		super();
	}

	public Pokemon getFirst() {
		try (ResultSet pkmn = this.createStatement()
				.executeQuery("select * from pokemons where num_pokedex = (select min(num_pokedex) from pokemons);");) {
			if (pkmn.next())
				if (pkmn.getString("tipo2") != null)
					return new Pokemon(pkmn.getInt("num_pokedex"), pkmn.getString("nombre"),
							TiposPokemon.valueOf(pkmn.getString("tipo1")),
							TiposPokemon.valueOf(pkmn.getString("tipo2")), pkmn.getDouble("altura"),
							pkmn.getDouble("peso"), pkmn.getString("habilidad"), pkmn.getString("categoria"),
							pkmn.getBoolean("conocido"));
				else
					return new Pokemon(pkmn.getInt("num_pokedex"), pkmn.getString("nombre"),
							TiposPokemon.valueOf(pkmn.getString("tipo1")), null, pkmn.getDouble("altura"),
							pkmn.getDouble("peso"), pkmn.getString("habilidad"), pkmn.getString("categoria"),
							pkmn.getBoolean("conocido"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Pokemon getLast() {
		try (ResultSet pkmn = this.createStatement()
				.executeQuery("select * from pokemons where num_pokedex = (select max(num_pokedex) from pokemons);");) {
			if (pkmn.next())
				if (pkmn.getString("tipo2") != null)
					return new Pokemon(pkmn.getInt("num_pokedex"), pkmn.getString("nombre"),
							TiposPokemon.valueOf(pkmn.getString("tipo1")),
							TiposPokemon.valueOf(pkmn.getString("tipo2")), pkmn.getDouble("altura"),
							pkmn.getDouble("peso"), pkmn.getString("habilidad"), pkmn.getString("categoria"),
							pkmn.getBoolean("conocido"));
				else
					return new Pokemon(pkmn.getInt("num_pokedex"), pkmn.getString("nombre"),
							TiposPokemon.valueOf(pkmn.getString("tipo1")), null, pkmn.getDouble("altura"),
							pkmn.getDouble("peso"), pkmn.getString("habilidad"), pkmn.getString("categoria"),
							pkmn.getBoolean("conocido"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Pokemon getFront(int num) {
		try (ResultSet pkmn = this.createStatement().executeQuery(
				"select * from pokemons where num_pokedex = (select min(num_pokedex) from pokemons where num_pokedex > "
						+ num + ");");) {
			if (pkmn.next())
				if (pkmn.getString("tipo2") != null)
					return new Pokemon(pkmn.getInt("num_pokedex"), pkmn.getString("nombre"),
							TiposPokemon.valueOf(pkmn.getString("tipo1")),
							TiposPokemon.valueOf(pkmn.getString("tipo2")), pkmn.getDouble("altura"),
							pkmn.getDouble("peso"), pkmn.getString("habilidad"), pkmn.getString("categoria"),
							pkmn.getBoolean("conocido"));
				else
					return new Pokemon(pkmn.getInt("num_pokedex"), pkmn.getString("nombre"),
							TiposPokemon.valueOf(pkmn.getString("tipo1")), null, pkmn.getDouble("altura"),
							pkmn.getDouble("peso"), pkmn.getString("habilidad"), pkmn.getString("categoria"),
							pkmn.getBoolean("conocido"));
			else
				return getFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Pokemon getBack(int num) {
		try (ResultSet pkmn = this.createStatement().executeQuery(
				"select * from pokemons where num_pokedex = (select max(num_pokedex) from pokemons where num_pokedex < "
						+ num + ");");) {
			if (pkmn.next())
				if (pkmn.getString("tipo2") != null)
					return new Pokemon(pkmn.getInt("num_pokedex"), pkmn.getString("nombre"),
							TiposPokemon.valueOf(pkmn.getString("tipo1")),
							TiposPokemon.valueOf(pkmn.getString("tipo2")), pkmn.getDouble("altura"),
							pkmn.getDouble("peso"), pkmn.getString("habilidad"), pkmn.getString("categoria"),
							pkmn.getBoolean("conocido"));
				else
					return new Pokemon(pkmn.getInt("num_pokedex"), pkmn.getString("nombre"),
							TiposPokemon.valueOf(pkmn.getString("tipo1")), null, pkmn.getDouble("altura"),
							pkmn.getDouble("peso"), pkmn.getString("habilidad"), pkmn.getString("categoria"),
							pkmn.getBoolean("conocido"));
			else
				return getLast();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int pkmnCount() {
		try (ResultSet pkmn = this.createStatement().executeQuery("select count(*) from pokemons;");) {
			if (pkmn.next())
				return pkmn.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void insertPokemon(Pokemon poke) {
		try {
			if (poke.getTipo2() != null)
				this.createStatement()
						.executeUpdate("insert into pokemons values(" + poke.getNumeroPokedex() + ",'"
								+ poke.getNombre() + "','" + TiposPokemon.valueOf(poke.getTipo1()) + "','"
								+ TiposPokemon.valueOf(poke.getTipo2()) + "'," + poke.getAltura() + "," + poke.getPeso()
								+ ",'" + poke.getHabilidad() + "','" + poke.getCategoria() + "'," + true + ");");
			else
				this.createStatement()
						.executeUpdate("insert into pokemons values(" + poke.getNumeroPokedex() + ",'"
								+ poke.getNombre() + "','" + TiposPokemon.valueOf(poke.getTipo1()) + "'," + null + ","
								+ poke.getAltura() + "," + poke.getPeso() + ",'" + poke.getHabilidad() + "','"
								+ poke.getCategoria() + "'," + true + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePokemon(Pokemon poke) {
		try {
			if (poke.getTipo2() != null)
				this.createStatement()
						.executeUpdate("update pokemons set nombre = '" + poke.getNombre() + "', tipo1 = '"
								+ TiposPokemon.valueOf(poke.getTipo1()) + "', tipo2 = '"
								+ TiposPokemon.valueOf(poke.getTipo2()) + "', altura = " + poke.getAltura()
								+ ", peso = " + poke.getPeso() + ", habilidad = '" + poke.getHabilidad()
								+ "', categoria = '" + poke.getCategoria() + "', conocido = " + true
								+ " where num_pokedex = " + poke.getNumeroPokedex() + ";");
			else
				this.createStatement()
						.executeUpdate("update pokemons set nombre = '" + poke.getNombre() + "', tipo1 = '"
								+ TiposPokemon.valueOf(poke.getTipo1()) + "', tipo2 = " + null + ", altura = "
								+ poke.getAltura() + ", peso = " + poke.getPeso() + ", habilidad = '"
								+ poke.getHabilidad() + "', categoria = '" + poke.getCategoria() + "', conocido = "
								+ true + " where num_pokedex = " + poke.getNumeroPokedex() + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletePokemon(Integer num) {
		try {
			this.createStatement().executeUpdate("delete from pokemons where num_pokedex = " + num + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isKnowPkmn(Pokemon poke) {
		try (ResultSet pkmn = this.createStatement()
				.executeQuery("select conocido from pokemons where num_pokedex = " + poke.getNumeroPokedex() + ";");) {
			if (pkmn.next())
				return pkmn.getBoolean(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean setKnowPkmn(Pokemon poke, Boolean conocido) {
		try {
			this.createStatement().executeUpdate("update pokemons set conocido = " + conocido + " where num_pokedex = "
					+ poke.getNumeroPokedex() + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean numOccupied(Integer num) {
		try (ResultSet pkmn = this.createStatement()
				.executeQuery("select * from pokemons where num_pokedex = " + num + ";");) {
			if (pkmn.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean nameOccupied(String name) {
		try (ResultSet pkmn = this.createStatement()
				.executeQuery("select * from pokemons where nombre = '" + name + "';");) {
			if (pkmn.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

//	private ResultSet getPokemons() {
//		try {
//			return this.createStatement().executeQuery("select * from pokemons;");
//		} catch (SQLException e) {
////			e.printStackTrace();
//			System.out.println("Error en la obtencion de pokemons");
//		}
//		return null;
//	}

}
