package ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.PokemonDAO;
import models.Pokemon;
import models.TiposPokemon;

public class Pokedex {
	private PokemonDAO pkmnDAO;

	private int position, positionBack, positionFront;
	private boolean opcTipo;
	private Pokemon pokemon, crear;

	private JFrame frmPokedex;
	private JFrame parent;
	private Box hbTop = Box.createHorizontalBox();
	private JButton btnPkmnAnterior = new JButton();
	private JLabel lblPkmnActual = new JLabel();
	private Component hgTop_1 = Box.createHorizontalGlue();
	private Component hgTop_2 = Box.createHorizontalGlue();
	private JButton btnPkmnSiguiente = new JButton();
	private Component vgPokedex_1 = Box.createVerticalGlue();
	private Component vgPokedex_2 = Box.createVerticalGlue();
	private Box vbMid = Box.createVerticalBox();
	private Box hbNombre = Box.createHorizontalBox();
	private JLabel lblNombre = new JLabel();
	private JLabel lblNumero = new JLabel();
	private Box vbStats = Box.createVerticalBox();
	private Box hbAlturaCategoria = Box.createHorizontalBox();
	private Box hbPesoHabilidad = Box.createHorizontalBox();
	private Box hbTipos = Box.createHorizontalBox();
	private Box vbAltura = Box.createVerticalBox();
	private JLabel lblTxtAltura = new JLabel("Altura");
	private JLabel lblAltura = new JLabel();
	private Box vbCategoria = Box.createVerticalBox();
	private JLabel lblCategoria = new JLabel();
	private JLabel lblTxtCategoria = new JLabel("Categoria");
	private Box vbPeso = Box.createVerticalBox();
	private JLabel lblTxtPeso = new JLabel("Peso");
	private JLabel lblPeso = new JLabel();
	private Box vbHabilidad = Box.createVerticalBox();
	private JLabel lblTxtHabilidad = new JLabel("Habilidad");
	private JLabel lblHabilidad = new JLabel();
	private Box vbTipo = Box.createVerticalBox();
	private JLabel lblTxtTipo = new JLabel("Tipo");
	private Box hbTipo = Box.createHorizontalBox();
	private JLabel lblTipo1 = new JLabel();
	private JLabel lblTipo2 = new JLabel();
	private Component vsMid_1 = Box.createVerticalStrut(60);
	private JLabel lblAlturaEspacio = new JLabel("   ");
	private JLabel lblAltCatEspacio = new JLabel("     ");
	private JLabel lblCategoriaEspacio = new JLabel(" ");
	private JLabel lblStatsEspacio_1 = new JLabel(" ");
	private JLabel lblStatsEspacio_2 = new JLabel(" ");
	private JLabel lblPesHabEspacio = new JLabel("       ");
	private JLabel lblPesoEspacio = new JLabel(" ");
	private JLabel lblHabEspacio = new JLabel(" ");
	private JLabel lblStatsEspacio_3 = new JLabel(" ");
	private JLabel lblStatsEspacio_4 = new JLabel(" ");
	private Box hbTxtTipo = Box.createHorizontalBox();
	private JLabel lblTxtTipoEspacio = new JLabel("                        ");
	private JLabel lblTipoEspacio = new JLabel(" ");
	private JLabel lblTiposEspacio_1 = new JLabel("   ");
	private Box hbSub = Box.createHorizontalBox();
	private Component hgSub_1 = Box.createHorizontalGlue();
	private JButton btnCrear = new JButton("Crear");
	private JButton btnActualizar = new JButton("Actualizar");
	private Component hsSub_3 = Box.createHorizontalStrut(40);
	private JButton btnBorrar = new JButton("Borrar");
	private Component hgSub_2 = Box.createHorizontalGlue();
	private JButton btnBloqueado = new JButton();
	private Component hsSub_2 = Box.createHorizontalStrut(40);
	private Component hsSub_1 = Box.createHorizontalStrut(40);
	private JTextField textAltura = new JTextField();
	private JTextField textCategoria = new JTextField();
	private JTextField textPeso = new JTextField();
	private JTextField textHabilidad = new JTextField();
	private JTextField textNombre = new JTextField();
	private JTextField textNumero = new JTextField();
	private JLabel lblNombreEspacio = new JLabel("   Nº ");
	private JButton btnTipo1 = new JButton("Ninguno");
	private JButton btnTipo2 = new JButton("Ninguno");
	private JDesktopPane selTipo = new JDesktopPane();
	private JButton btnAgua = new JButton("Agua");
	private JButton btnElectrico = new JButton("Electrico");
	private JButton btnPlanta = new JButton("Planta");
	private JButton btnHielo = new JButton("Hielo");
	private JButton btnLucha = new JButton("Lucha");
	private JButton btnVeneno = new JButton("Veneno");
	private JButton btnTierra = new JButton("Tierra");
	private JButton btnVolador = new JButton("Volador");
	private JButton btnPsiquico = new JButton("Psíquico");
	private JButton btnBicho = new JButton("Bicho");
	private JButton btnRoca = new JButton("Roca");
	private JButton btnFantasma = new JButton("Fantasma");
	private JButton btnDragon = new JButton("Dragón");
	private JButton btnSinTipo = new JButton("Ninguno");
	private JButton btnHada = new JButton("Hada");
	private JButton btnAcero = new JButton("Acero");
	private JButton btnSiniestro = new JButton("Siniestro");
	private JButton btnSendActu = new JButton("Actualizar");
	private JButton btnCancelar = new JButton("Cancelar");
	private JButton btnSendCrear = new JButton("Crear");
	private Box hbActualizar = Box.createHorizontalBox();
	private JButton btnFuego = new JButton("Fuego");
	private JButton btnNormal = new JButton("Normal");
	private JLabel lblImg = new JLabel("");
	private Box hbMid = Box.createHorizontalBox();
	private Component horizontalStrut = Box.createHorizontalStrut(80);

	/**
	 * Create the application.
	 */
	public Pokedex(JFrame parent) {
		this.parent = parent;

		pkmnDAO = new PokemonDAO();
		frmPokedex = new JFrame();

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.pokemon = pkmnDAO.getFirst();
		this.position = pokemon.getNumeroPokedex();
		this.positionBack = pkmnDAO.getBack(position).getNumeroPokedex();
		this.positionFront = pkmnDAO.getFront(position).getNumeroPokedex();
		this.parent.setVisible(false);

		textNombre.setVisible(false);
		textNombre.setMaximumSize(new Dimension(100, 200));
		textNombre.setColumns(10);
		textAltura.setMaximumSize(new Dimension(100, 200));
		textAltura.setVisible(false);
		textAltura.setColumns(10);
		frmPokedex.setTitle("Pokedex");
		frmPokedex.setBounds(100, 100, 1150, 800);
		frmPokedex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokedex.getContentPane().setLayout(new BoxLayout(frmPokedex.getContentPane(), BoxLayout.PAGE_AXIS));

		updateText();
		setUIComponents();
		setUIBehaviour();
	}

	public void setUIComponents() {
		frmPokedex.getContentPane().add(hbTop);
		hbTop.add(btnPkmnAnterior);

		hbTop.add(hgTop_1);
		hbTop.add(lblPkmnActual);

		hbTop.add(hgTop_2);
		hbTop.add(btnPkmnSiguiente);

		frmPokedex.getContentPane().add(vgPokedex_1);

		frmPokedex.getContentPane().add(hbMid);
		hbMid.add(horizontalStrut);
		hbMid.add(lblImg);
		hbMid.add(vbMid);

		vbMid.add(hbNombre);

		hbNombre.add(lblNombre);

		hbNombre.add(textNombre);

		hbNombre.add(lblNombreEspacio);

		hbNombre.add(lblNumero);
		textNumero.setVisible(false);
		textNumero.setMaximumSize(new Dimension(100, 200));
		textNumero.setColumns(10);

		hbNombre.add(textNumero);

		vbMid.add(vsMid_1);

		vbMid.add(vbStats);

		vbStats.add(hbAlturaCategoria);

		hbAlturaCategoria.add(vbAltura);

		vbAltura.add(lblTxtAltura);

		vbAltura.add(lblAlturaEspacio);

		vbAltura.add(lblAltura);

		vbAltura.add(textAltura);

		hbAlturaCategoria.add(lblAltCatEspacio);

		hbAlturaCategoria.add(vbCategoria);

		vbCategoria.add(lblTxtCategoria);

		vbCategoria.add(lblCategoriaEspacio);

		vbCategoria.add(lblCategoria);
		textCategoria.setVisible(false);
		textCategoria.setMaximumSize(new Dimension(100, 200));
		textCategoria.setColumns(10);

		vbCategoria.add(textCategoria);

		vbStats.add(lblStatsEspacio_1);

		vbStats.add(lblStatsEspacio_2);

		vbStats.add(hbPesoHabilidad);

		hbPesoHabilidad.add(vbPeso);

		vbPeso.add(lblTxtPeso);

		vbPeso.add(lblPesoEspacio);

		vbPeso.add(lblPeso);
		textPeso.setVisible(false);
		textPeso.setMaximumSize(new Dimension(100, 200));
		textPeso.setColumns(10);

		vbPeso.add(textPeso);

		hbPesoHabilidad.add(lblPesHabEspacio);

		hbPesoHabilidad.add(vbHabilidad);

		vbHabilidad.add(lblTxtHabilidad);

		vbHabilidad.add(lblHabEspacio);

		vbHabilidad.add(lblHabilidad);
		textHabilidad.setVisible(false);
		textHabilidad.setMaximumSize(new Dimension(100, 200));
		textHabilidad.setColumns(10);

		vbHabilidad.add(textHabilidad);

		vbStats.add(lblStatsEspacio_3);

		vbStats.add(lblStatsEspacio_4);

		vbStats.add(hbTipos);

		hbTipos.add(vbTipo);

		vbTipo.add(hbTxtTipo);
		hbTxtTipo.add(lblTxtTipo);

		hbTxtTipo.add(lblTxtTipoEspacio);

		vbTipo.add(lblTipoEspacio);

		vbTipo.add(hbTipo);

		hbTipo.add(lblTipo1);
		btnTipo1.setVisible(false);

		hbTipo.add(btnTipo1);
		selTipo.setVisible(false);
		selTipo.setBackground(SystemColor.window);
		selTipo.setMaximumSize(new Dimension(530, 100000));

		hbTipo.add(selTipo);
		selTipo.setLayout(null);

		btnFuego.setBounds(12, 49, 117, 25);
		selTipo.add(btnFuego);

		btnNormal.setBounds(12, 12, 117, 25);
		selTipo.add(btnNormal);
		btnAgua.setBounds(12, 86, 117, 25);

		selTipo.add(btnAgua);
		btnElectrico.setBounds(12, 123, 117, 25);

		selTipo.add(btnElectrico);
		btnPlanta.setBounds(12, 160, 117, 25);

		selTipo.add(btnPlanta);
		btnHielo.setBounds(12, 197, 117, 25);

		selTipo.add(btnHielo);
		btnLucha.setBounds(141, 12, 117, 25);

		selTipo.add(btnLucha);
		btnVeneno.setBounds(141, 49, 117, 25);

		selTipo.add(btnVeneno);
		btnTierra.setBounds(141, 86, 117, 25);

		selTipo.add(btnTierra);
		btnVolador.setBounds(141, 123, 117, 25);

		selTipo.add(btnVolador);
		btnPsiquico.setBounds(141, 160, 117, 25);

		selTipo.add(btnPsiquico);
		btnBicho.setBounds(141, 197, 117, 25);

		selTipo.add(btnBicho);
		btnRoca.setBounds(270, 12, 117, 25);

		selTipo.add(btnRoca);
		btnFantasma.setBounds(270, 49, 117, 25);

		selTipo.add(btnFantasma);
		btnDragon.setBounds(270, 86, 117, 25);

		selTipo.add(btnDragon);
		btnSinTipo.setVisible(false);
		btnSinTipo.setBounds(399, 104, 117, 25);

		selTipo.add(btnSinTipo);
		btnHada.setBounds(270, 123, 117, 25);

		selTipo.add(btnHada);
		btnAcero.setBounds(270, 160, 117, 25);

		selTipo.add(btnAcero);
		btnSiniestro.setBounds(270, 197, 117, 25);

		selTipo.add(btnSiniestro);

		hbTipo.add(lblTiposEspacio_1);

		hbTipo.add(lblTipo2);
		btnTipo2.setVisible(false);

		hbTipo.add(btnTipo2);

		frmPokedex.getContentPane().add(vgPokedex_2);

		frmPokedex.getContentPane().add(hbSub);

		hbSub.add(hgSub_1);

		hbSub.add(btnBloqueado);

		hbSub.add(hsSub_1);

		hbSub.add(btnCrear);
		btnSendCrear.setVisible(false);

		hbSub.add(btnSendCrear);

		hbSub.add(hsSub_2);

		hbSub.add(hbActualizar);
		hbActualizar.add(btnActualizar);
		hbActualizar.add(btnSendActu);
		hbActualizar.add(hsSub_3);

		btnSendActu.setVisible(false);
		btnCancelar.setVisible(false);

		hbSub.add(btnCancelar);

		hbSub.add(btnBorrar);

		hbSub.add(hgSub_2);
		frmPokedex.setVisible(true);
	}

	public void setUIBehaviour() {
		btnPkmnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pokemon = pkmnDAO.getFront(pokemon.getNumeroPokedex());
				updateText();
			}
		});

		btnPkmnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pokemon = pkmnDAO.getBack(pokemon.getNumeroPokedex());
				updateText();
			}
		});

		btnBloqueado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pokemon.isConocido()) {
					pokemon.setConocido(false);
					pkmnDAO.setKnowPkmn(pokemon, false);
				} else {
					pokemon.setConocido(true);
					pkmnDAO.setKnowPkmn(pokemon, true);
				}

				updateText();
			}
		});

		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNombre.setVisible(false);
				lblNumero.setVisible(false);
				lblAltura.setVisible(false);
				lblHabilidad.setVisible(false);
				lblPeso.setVisible(false);
				lblCategoria.setVisible(false);
				lblTipo1.setVisible(false);
				lblTipo2.setVisible(false);
				btnActualizar.setVisible(false);
				btnBloqueado.setVisible(false);
				btnCrear.setVisible(false);
				btnSendActu.setVisible(false);
				btnBorrar.setVisible(false);
				btnPkmnAnterior.setVisible(false);
				btnPkmnSiguiente.setVisible(false);
				lblImg.setIcon(null);

				hbTop.setVisible(true);
				vbMid.setVisible(true);
				textNombre.setVisible(true);
				textNumero.setVisible(true);
				textAltura.setVisible(true);
				textHabilidad.setVisible(true);
				textPeso.setVisible(true);
				textCategoria.setVisible(true);
				btnTipo1.setVisible(true);
				btnTipo2.setVisible(true);
				btnSendCrear.setVisible(true);
				btnCancelar.setVisible(true);
			}
		});

		btnSendCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((!textNumero.getText().isBlank() && !pkmnDAO.numOccupied(Integer.parseInt(textNumero.getText())))
						&& (!textNombre.getText().isBlank() && !pkmnDAO.nameOccupied(textNombre.getText()))
						&& !btnTipo1.getText().equals("Ninguno") && !textAltura.getText().isBlank()
						&& !textPeso.getText().isBlank() && !textCategoria.getText().isBlank()
						&& !textHabilidad.getText().isBlank()) {
					crear = new Pokemon();

					crear.setNumeroPokedex(Integer.parseInt(textNumero.getText()));
					crear.setNombre(textNombre.getText());
					crear.setTipo1(TiposPokemon.valueOf(btnTipo1.getText()));

					if (!btnTipo2.getText().equals("Ninguno")) {
						crear.setTipo2(TiposPokemon.valueOf(btnTipo2.getText()));
					} else {
						crear.setTipo2(null);
					}

					crear.setAltura(Double.parseDouble(textAltura.getText()));
					crear.setPeso(Double.parseDouble(textPeso.getText()));
					crear.setCategoria(textCategoria.getText());
					crear.setHabilidad(textHabilidad.getText());
					crear.setNumeroPokedex(Integer.parseInt(textNumero.getText()));

					pkmnDAO.insertPokemon(crear);

					textNombre.setVisible(false);
					textNumero.setVisible(false);
					textAltura.setVisible(false);
					textHabilidad.setVisible(false);
					textPeso.setVisible(false);
					textCategoria.setVisible(false);
					btnTipo1.setVisible(false);
					btnTipo2.setVisible(false);
					btnSendCrear.setVisible(false);
					btnCancelar.setVisible(false);
					selTipo.setVisible(false);
					btnSinTipo.setVisible(false);

					updateText();

					lblNombre.setVisible(true);
					lblNumero.setVisible(true);
					lblAltura.setVisible(true);
					lblHabilidad.setVisible(true);
					lblPeso.setVisible(true);
					lblCategoria.setVisible(true);
					lblTipo1.setVisible(true);
					lblTipo2.setVisible(true);
					btnActualizar.setVisible(true);
					btnBloqueado.setVisible(true);
					btnCrear.setVisible(true);
					btnBorrar.setVisible(true);
					btnPkmnAnterior.setVisible(true);
					btnPkmnSiguiente.setVisible(true);

					position = crear.getNumeroPokedex();

					if (crear.getNumeroPokedex() > positionBack && crear.getNumeroPokedex() > position)
						positionBack = pkmnDAO.getBack(position).getNumeroPokedex();

					if (crear.getNumeroPokedex() < positionFront && crear.getNumeroPokedex() > position)
						positionFront = pkmnDAO.getFront(position).getNumeroPokedex();

					crear = null;

				} else if (pkmnDAO.numOccupied(Integer.parseInt(textNumero.getText()))
						&& pkmnDAO.nameOccupied(textNombre.getText())) {
					JFrame error = new JFrame();
					JOptionPane.showMessageDialog(error, "Numero y nombre ya ocupados");
				} else if (pkmnDAO.nameOccupied(textNombre.getText())) {
					JFrame error = new JFrame();
					JOptionPane.showMessageDialog(error, "Nombre ya ocupado");
				} else if (pkmnDAO.numOccupied(Integer.parseInt(textNumero.getText()))) {
					JFrame error = new JFrame();
					JOptionPane.showMessageDialog(error, "Numero ya ocupado");
				} else {
					JFrame error = new JFrame();
					JOptionPane.showMessageDialog(error, "Todos los campos son necesarios");
				}
			}
		});

		btnActualizar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				lblNombre.setVisible(false);
				lblAltura.setVisible(false);
				lblHabilidad.setVisible(false);
				lblPeso.setVisible(false);
				lblCategoria.setVisible(false);
				lblTipo1.setVisible(false);
				lblTipo2.setVisible(false);
				btnActualizar.setVisible(false);
				btnBloqueado.setVisible(false);
				btnCrear.setVisible(false);
				btnSendCrear.setVisible(false);
				btnBorrar.setVisible(false);
				btnPkmnAnterior.setVisible(false);
				btnPkmnSiguiente.setVisible(false);

				btnTipo1.setText(pokemon.getTipo1());
				if (pokemon.getTipo2() != null)
					btnTipo2.setText(pokemon.getTipo2());
				else
					btnTipo2.setText("Ninguno");

				textNombre.setVisible(true);
				textAltura.setVisible(true);
				textHabilidad.setVisible(true);
				textPeso.setVisible(true);
				textCategoria.setVisible(true);
				btnTipo1.setVisible(true);
				btnTipo2.setVisible(true);
				btnSendActu.setVisible(true);
				btnCancelar.setVisible(true);

			}
		});

		btnSendActu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textNombre.getText().isBlank()) {
					if (!pkmnDAO.nameOccupied(textNombre.getText())) {
						pokemon.setNombre(textNombre.getText());
					} else {
						JFrame imposible = new JFrame();
						JOptionPane.showMessageDialog(imposible, "No se puede cambiar.\nNombre ya ocupado");
					}
				}

				if (!btnTipo1.getText().equals("Ninguno")) {
					pokemon.setTipo1(TiposPokemon.valueOf(btnTipo1.getText()));
				}

				if (!btnTipo2.getText().equals("Ninguno")) {
					pokemon.setTipo2(TiposPokemon.valueOf(btnTipo2.getText()));
				} else {
					pokemon.setTipo2(null);
				}

				if (!textAltura.getText().isBlank()) {
					pokemon.setAltura(Double.parseDouble(textAltura.getText()));
				}

				if (!textPeso.getText().isBlank()) {
					pokemon.setPeso(Double.parseDouble(textPeso.getText()));
				}

				if (!textCategoria.getText().isBlank()) {
					pokemon.setCategoria(textCategoria.getText());
				}

				if (!textHabilidad.getText().isBlank()) {
					pokemon.setHabilidad(textHabilidad.getText());
				}

				pkmnDAO.updatePokemon(pokemon);

				textNombre.setVisible(false);
				textNumero.setVisible(false);
				textAltura.setVisible(false);
				textHabilidad.setVisible(false);
				textPeso.setVisible(false);
				textCategoria.setVisible(false);
				btnTipo1.setVisible(false);
				btnTipo2.setVisible(false);
				btnSendActu.setVisible(false);
				btnCancelar.setVisible(false);
				selTipo.setVisible(false);
				btnSinTipo.setVisible(false);

				updateText();

				lblNombre.setVisible(true);
				lblNumero.setVisible(true);
				lblAltura.setVisible(true);
				lblHabilidad.setVisible(true);
				lblPeso.setVisible(true);
				lblCategoria.setVisible(true);
				lblTipo1.setVisible(true);
				lblTipo2.setVisible(true);
				btnActualizar.setVisible(true);
				btnBloqueado.setVisible(true);
				btnCrear.setVisible(true);
				btnBorrar.setVisible(true);
				btnPkmnAnterior.setVisible(true);
				btnPkmnSiguiente.setVisible(true);
			}
		});

		btnCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				textNombre.setVisible(false);
				textNumero.setVisible(false);
				textAltura.setVisible(false);
				textHabilidad.setVisible(false);
				textPeso.setVisible(false);
				textCategoria.setVisible(false);
				btnTipo1.setVisible(false);
				btnTipo2.setVisible(false);
				btnSendCrear.setVisible(false);
				btnSendActu.setVisible(false);
				btnCancelar.setVisible(false);
				selTipo.setVisible(false);
				btnSinTipo.setVisible(false);

				if (pkmnDAO.pkmnCount() == 0) {
					btnCrear.setVisible(true);
					hbTop.setVisible(false);
					vbMid.setVisible(false);
					btnBloqueado.setVisible(false);
					btnActualizar.setVisible(false);
					btnBorrar.setVisible(false);
					btnCancelar.setVisible(false);
				} else {
					lblNombre.setVisible(true);
					lblNumero.setVisible(true);
					lblAltura.setVisible(true);
					lblHabilidad.setVisible(true);
					lblPeso.setVisible(true);
					lblCategoria.setVisible(true);
					lblTipo1.setVisible(true);
					lblTipo2.setVisible(true);
					btnActualizar.setVisible(true);
					btnBloqueado.setVisible(true);
					btnCrear.setVisible(true);
					btnBorrar.setVisible(true);
					btnPkmnAnterior.setVisible(true);
					btnPkmnSiguiente.setVisible(true);
				}

				updateText();
			}
		});

		btnTipo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcTipo = false;
				btnTipo1.setVisible(false);
				btnTipo2.setVisible(false);
				selTipo.setVisible(true);
				btnSinTipo.setVisible(false);
			}
		});

		btnTipo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcTipo = true;
				btnTipo1.setVisible(false);
				btnTipo2.setVisible(false);
				selTipo.setVisible(true);
				btnSinTipo.setVisible(true);
			}
		});

		// ########## Botones tipo pokemon ##########
		btnNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTipo(TiposPokemon.Normal);
			}
		});
		btnFuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTipo(TiposPokemon.Fuego);
			}
		});
		btnAgua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTipo(TiposPokemon.Agua);
			}
		});
		btnElectrico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTipo(TiposPokemon.Electrico);
			}
		});
		btnPlanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTipo(TiposPokemon.Planta);
			}
		});
		btnHielo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTipo(TiposPokemon.Hielo);
			}
		});
		btnLucha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTipo(TiposPokemon.Lucha);
			}
		});
		btnVeneno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTipo(TiposPokemon.Veneno);
			}
		});
		btnTierra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTipo(TiposPokemon.Tierra);
			}
		});
		btnVolador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTipo(TiposPokemon.Volador);
			}
		});
		btnPsiquico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTipo(TiposPokemon.Psiquico);
			}
		});
		btnBicho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTipo(TiposPokemon.Bicho);
			}
		});
		btnRoca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTipo(TiposPokemon.Roca);
			}
		});
		btnFantasma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTipo(TiposPokemon.Fantasma);
			}
		});
		btnDragon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTipo(TiposPokemon.Dragon);
			}
		});
		btnHada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTipo(TiposPokemon.Hada);
			}
		});
		btnAcero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTipo(TiposPokemon.Acero);
			}
		});
		btnSiniestro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTipo(TiposPokemon.Siniestro);
			}
		});
		btnSinTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTipo(null);
			}
		});
		// ############################################

		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pkmnDAO.deletePokemon(position);
				pokemon = pkmnDAO.getBack(position);
				updateText();
			}
		});
	}

	public void updateTipo(TiposPokemon tipo) {
		if (opcTipo) {
			if (tipo != null)
				btnTipo2.setText(tipo.name());
			else
				btnTipo2.setText("Ninguno");
		} else {
			btnTipo1.setText(tipo.name());
		}

		selTipo.setVisible(false);
		btnTipo1.setVisible(true);
		btnTipo2.setVisible(true);
	}

	public void updateText() {
		if (pkmnDAO.pkmnCount() == 0) {
			hbTop.setVisible(false);
			hbMid.setVisible(false);
			lblImg.setVisible(false);
			vbMid.setVisible(false);
			btnBloqueado.setVisible(false);
			btnActualizar.setVisible(false);
			btnBorrar.setVisible(false);
		} else {
			hbTop.setVisible(true);
			if (pkmnDAO.pkmnCount() == 1) {
				btnPkmnAnterior.setVisible(false);
				btnPkmnSiguiente.setVisible(false);
			} else {
				btnPkmnAnterior.setVisible(true);
				btnPkmnSiguiente.setVisible(true);
				position = pokemon.getNumeroPokedex();
				positionBack = pkmnDAO.getBack(position).getNumeroPokedex();
				positionFront = pkmnDAO.getFront(position).getNumeroPokedex();
			}
			hbMid.setVisible(true);
			lblImg.setVisible(true);
			vbMid.setVisible(true);
			btnBloqueado.setVisible(true);
			btnActualizar.setVisible(true);
			btnBorrar.setVisible(true);

			if (pkmnDAO.getBack(position).isConocido())
				btnPkmnAnterior.setText("<   " + pkmnDAO.getBack(position).getNumeroPokedex() + " "
						+ pkmnDAO.getBack(position).getNombre());
			else
				btnPkmnAnterior.setText("<   " + pkmnDAO.getBack(position).getNumeroPokedex() + " ?????????");

			if (pkmnDAO.getFront(position).isConocido())
				btnPkmnSiguiente.setText(pkmnDAO.getFront(position).getNumeroPokedex() + " "
						+ pkmnDAO.getFront(position).getNombre() + "   >");
			else
				btnPkmnSiguiente.setText(pkmnDAO.getFront(position).getNumeroPokedex() + " ?????????   >");

			if (pokemon.isConocido()) {
				Image image;

				if (pokemon.getNumeroPokedex() < 10) {
					try {
						URL url = new URL("https://assets.pokemon.com/assets/cms2/img/pokedex/full/00"
								+ pokemon.getNumeroPokedex() + ".png");
						image = ImageIO.read(url);
						lblImg.setIcon(new ImageIcon(image));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (pokemon.getNumeroPokedex() < 100) {
					try {
						URL url = new URL("https://assets.pokemon.com/assets/cms2/img/pokedex/full/0"
								+ pokemon.getNumeroPokedex() + ".png");
						image = ImageIO.read(url);
						lblImg.setIcon(new ImageIcon(image));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					try {
						URL url = new URL("https://assets.pokemon.com/assets/cms2/img/pokedex/full/"
								+ pokemon.getNumeroPokedex() + ".png");
						image = ImageIO.read(url);
						lblImg.setIcon(new ImageIcon(image));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				lblPkmnActual.setText(pokemon.getNombre());
				lblAltura.setText(Double.toString(pokemon.getAltura()));
				lblNombre.setText(pokemon.getNombre());
				lblNumero.setText(Integer.toString(pokemon.getNumeroPokedex()));
				lblCategoria.setText(pokemon.getCategoria());
				lblPeso.setText(Double.toString(pokemon.getPeso()));
				lblHabilidad.setText(pokemon.getHabilidad());

				lblTipo1.setText(pokemon.getTipo1());
				if (pokemon.getTipo2() != null)
					lblTipo2.setText(pokemon.getTipo2());
				else
					lblTipo2.setText("");

				lblImg.setText("");
				btnBloqueado.setText("Olvidar");
				btnActualizar.setVisible(true);
				hbActualizar.setVisible(true);
				btnBorrar.setVisible(true);
			} else {
				lblImg.setText("?????????");
				lblImg.setIcon(null);
				lblPkmnActual.setText("?????????");
				lblAltura.setText("?????????");
				lblNombre.setText("?????????");
				lblNumero.setText(Integer.toString(pokemon.getNumeroPokedex()));
				lblCategoria.setText("?????????");
				lblPeso.setText("?????????");
				lblHabilidad.setText("?????????");
				lblTipo1.setText("?????????");

				if (pokemon.getTipo2() != null)
					lblTipo2.setText("?????????");
				else
					lblTipo2.setText("");

				btnBloqueado.setText("Descubrir");
				btnActualizar.setVisible(false);
				hbActualizar.setVisible(false);
				btnBorrar.setVisible(false);
			}
		}
		textNombre.setText("");
		textNumero.setText("");
		textAltura.setText("");
		textHabilidad.setText("");
		textPeso.setText("");
		textCategoria.setText("");
		btnTipo1.setText("Ninguno");
		btnTipo2.setText("Ninguno");
	}
}
