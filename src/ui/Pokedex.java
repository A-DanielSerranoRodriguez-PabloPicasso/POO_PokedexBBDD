package ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ListIterator;

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

import models.Pokemon;
import models.TiposPokemon;
import utils.Almacen;

public class Pokedex {
	private int position = 0, positionBack, positionFront;
	private boolean opcTipo;
	private Pokemon actualizar, crear = new Pokemon(-1, null, null, null, -1, -1, null, null, true);

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
	private final Box vbAltura = Box.createVerticalBox();
	private final JLabel lblTxtAltura = new JLabel("Altura");
	private final JLabel lblAltura = new JLabel();
	private final Box vbCategoria = Box.createVerticalBox();
	private final JLabel lblCategoria = new JLabel();
	private final JLabel lblTxtCategoria = new JLabel("Categoria");
	private final Box vbPeso = Box.createVerticalBox();
	private final JLabel lblTxtPeso = new JLabel("Peso");
	private final JLabel lblPeso = new JLabel();
	private final Box vbHabilidad = Box.createVerticalBox();
	private final JLabel lblTxtHabilidad = new JLabel("Habilidad");
	private final JLabel lblHabilidad = new JLabel();
	private final Box vbTipo = Box.createVerticalBox();
	private final JLabel lblTxtTipo = new JLabel("Tipo");
	private final Box hbTipo = Box.createHorizontalBox();
	private final JLabel lblTipo1 = new JLabel();
	private final JLabel lblTipo2 = new JLabel();
	private final Component vsMid_1 = Box.createVerticalStrut(60);
	private final JLabel lblAlturaEspacio = new JLabel("   ");
	private final JLabel lblAltCatEspacio = new JLabel("     ");
	private final JLabel lblCategoriaEspacio = new JLabel(" ");
	private final JLabel lblStatsEspacio_1 = new JLabel(" ");
	private final JLabel lblStatsEspacio_2 = new JLabel(" ");
	private final JLabel lblPesHabEspacio = new JLabel("       ");
	private final JLabel lblPesoEspacio = new JLabel(" ");
	private final JLabel lblHabEspacio = new JLabel(" ");
	private final JLabel lblStatsEspacio_3 = new JLabel(" ");
	private final JLabel lblStatsEspacio_4 = new JLabel(" ");
	private final Box hbTxtTipo = Box.createHorizontalBox();
	private final JLabel lblTxtTipoEspacio = new JLabel("                        ");
	private final JLabel lblTipoEspacio = new JLabel(" ");
	private final JLabel lblTiposEspacio_1 = new JLabel("   ");
	private final Box hbSub = Box.createHorizontalBox();
	private final Component hgSub_1 = Box.createHorizontalGlue();
	private final JButton btnCrear = new JButton("Crear");
	private final JButton btnActualizar = new JButton("Actualizar");
	private final Component hsSub_3 = Box.createHorizontalStrut(40);
	private final JButton btnBorrar = new JButton("Borrar");
	private final Component hgSub_2 = Box.createHorizontalGlue();
	private final JButton btnBloqueado = new JButton();
	private final Component hsSub_2 = Box.createHorizontalStrut(40);
	private final Component hsSub_1 = Box.createHorizontalStrut(40);
	private final JTextField textAltura = new JTextField();
	private final JTextField textCategoria = new JTextField();
	private final JTextField textPeso = new JTextField();
	private final JTextField textHabilidad = new JTextField();
	private final JTextField textNombre = new JTextField();
	private final JTextField textNumero = new JTextField();
	private final JLabel lblNombreEspacio = new JLabel("   Nº ");
	private final JButton btnTipo1 = new JButton("Ninguno");
	private final JButton btnTipo2 = new JButton("Ninguno");
	private final JDesktopPane selTipo = new JDesktopPane();
	private final JButton btnAgua = new JButton("Agua");
	private final JButton btnElectrico = new JButton("Electrico");
	private final JButton btnPlanta = new JButton("Planta");
	private final JButton btnHielo = new JButton("Hielo");
	private final JButton btnLucha = new JButton("Lucha");
	private final JButton btnVeneno = new JButton("Veneno");
	private final JButton btnTierra = new JButton("Tierra");
	private final JButton btnVolador = new JButton("Volador");
	private final JButton btnPsiquico = new JButton("Psíquico");
	private final JButton btnBicho = new JButton("Bicho");
	private final JButton btnRoca = new JButton("Roca");
	private final JButton btnFantasma = new JButton("Fantasma");
	private final JButton btnDragon = new JButton("Dragón");
	private final JButton btnSinTipo = new JButton("Ninguno");
	private final JButton btnHada = new JButton("Hada");
	private final JButton btnAcero = new JButton("Acero");
	private final JButton btnSiniestro = new JButton("Siniestro");
	private final JButton btnSendActu = new JButton("Actualizar");
	private final JButton btnCancelar = new JButton("Cancelar");
	private final JButton btnSendCrear = new JButton("Crear");
	private final Box hbActualizar = Box.createHorizontalBox();
	JButton btnFuego = new JButton("Fuego");
	JButton btnNormal = new JButton("Normal");
	private final JLabel lblImg = new JLabel("");
	private final Box hbMid = Box.createHorizontalBox();
	private final Component horizontalStrut = Box.createHorizontalStrut(80);

	/**
	 * Create the application.
	 */
	public Pokedex(JFrame parent) {
		this.positionBack = Almacen.pokemons.size() - 1;
		this.positionFront = position + 1;
		this.parent = parent;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		textNombre.setVisible(false);
		textNombre.setMaximumSize(new Dimension(100, 200));
		textNombre.setColumns(10);
		textAltura.setMaximumSize(new Dimension(100, 200));
		textAltura.setVisible(false);
		textAltura.setColumns(10);
		this.parent.setVisible(false);
		frmPokedex = new JFrame();
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
				if (position == Almacen.pokemons.size() - 1) {
					position = 0;
					positionFront = position + 1;
					positionBack = Almacen.pokemons.size() - 1;
				} else {
					position++;
					if (positionBack == Almacen.pokemons.size() - 1) {
						positionBack = 0;
					} else {
						positionBack++;
					}
					if (positionFront == Almacen.pokemons.size() - 1) {
						positionFront = 0;
					} else {
						positionFront++;
					}
				}
				if (Almacen.pokemons.size() == 1) {
					positionFront = positionBack = position;
				}
				updateText();
			}
		});

		btnPkmnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (position == 0) {
					position = Almacen.pokemons.size() - 1;
					positionFront = 0;
					positionBack = Almacen.pokemons.size() - 2;
				} else {
					position--;
					if (positionBack == 0) {
						positionBack = Almacen.pokemons.size() - 1;
					} else {
						positionBack--;
					}
					if (positionFront == 0) {
						positionFront = Almacen.pokemons.size() - 1;
					} else {
						positionFront--;
					}
				}
				if (Almacen.pokemons.size() == 1) {
					positionFront = positionBack = position;
				}
				updateText();
			}
		});

		btnBloqueado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Almacen.pokemons.get(position).isConocido())
					Almacen.pokemons.get(position).setConocido(false);
				else
					Almacen.pokemons.get(position).setConocido(true);

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
				if (!textNumero.getText().isBlank() && !textNombre.getText().isBlank()
						&& !btnTipo1.getText().equals("Ninguno") && !textAltura.getText().isBlank()
						&& !textPeso.getText().isBlank() && !textCategoria.getText().isBlank()
						&& !textHabilidad.getText().isBlank()) {

					boolean posible = true, posibleNum = true;

					if (Almacen.pokemons.size() == 0) {
						crear.setNombre(textNombre.getText());
						crear.setTipo1(TiposPokemon.valueOf(btnTipo1.getText()));

						if (!btnTipo2.getText().equals("Ninguno")) {
							crear.setTipo2(TiposPokemon.valueOf(btnTipo2.getText()));
						} else {
							crear.setTipo2(TiposPokemon.Ninguno);
						}

						crear.setAltura(Double.parseDouble(textAltura.getText()));
						crear.setPeso(Double.parseDouble(textPeso.getText()));
						crear.setCategoria(textCategoria.getText());
						crear.setHabilidad(textHabilidad.getText());
						crear.setNumeroPokedex(Integer.parseInt(textNumero.getText()));
						Almacen.pokemons.add(crear);

						System.out.println(crear);

						position = 0;
						positionBack = 0;
						positionFront = 0;

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

						updateText();
					} else {

						for (Pokemon comprobar : Almacen.pokemons) {
							if (comprobar.getNombre().equals(textNombre.getText())) {
								posible = false;
							}
						}

						if (posible) {
							crear.setNombre(textNombre.getText());
						} else {
							JFrame imposible = new JFrame();
							JOptionPane.showMessageDialog(imposible, "No se puede cambiar.\nNombre ya ocupado");
							textNombre.setText("");
						}

						crear.setTipo1(TiposPokemon.valueOf(btnTipo1.getText()));

						if (!btnTipo2.getText().equals("Ninguno")) {
							crear.setTipo2(TiposPokemon.valueOf(btnTipo2.getText()));
						} else {
							crear.setTipo2(TiposPokemon.Ninguno);
						}

						crear.setAltura(Double.parseDouble(textAltura.getText()));
						crear.setPeso(Double.parseDouble(textPeso.getText()));
						crear.setCategoria(textCategoria.getText());
						crear.setHabilidad(textHabilidad.getText());

						for (Pokemon comprobar : Almacen.pokemons) {
							if (comprobar.getNumeroPokedex() == Double.parseDouble(textNumero.getText())) {
								posible = false;
							}
						}

						if (posibleNum) {
							boolean actualizado = false;
							int i = 0;
							crear.setNumeroPokedex(Integer.parseInt(textNumero.getText()));

							while (!actualizado) {
								if (i == 0) {
									if (crear.getNumeroPokedex() < Almacen.pokemons.get(i).getNumeroPokedex()) {
										Almacen.pokemons.add(0, crear);
										actualizado = true;
									}
								} else if (i == Almacen.pokemons.size() - 1) {
									Almacen.pokemons.add(crear);
									actualizado = true;
								} else {
									for (int j = 0; j < Almacen.pokemons.size(); j++) {
										if (j != 0 && j != Almacen.pokemons.size() - 1) {
											if (Almacen.pokemons.get(j - 1).getNumeroPokedex() < crear
													.getNumeroPokedex()
													&& Almacen.pokemons.get(j + 1).getNumeroPokedex() > crear
															.getNumeroPokedex()) {
												Almacen.pokemons.add(j, crear);
												actualizado = true;
											}
										}
									}

								}
								i++;
							}
							i = 0;
						} else {
							JFrame imposible = new JFrame();
							JOptionPane.showMessageDialog(imposible, "No se puede cambiar.\nNumero ya ocupado");
							textNumero.setText("");
						}

						if (crear.getPosition(crear) == 0) {
							position = 0;
							positionBack = Almacen.pokemons.size() - 1;
							positionFront = 1;
						} else if (crear.getPosition(crear) == Almacen.pokemons.size() - 1) {
							position = Almacen.pokemons.size() - 1;
							positionBack = Almacen.pokemons.size() - 2;
							positionFront = 0;
						} else {
							position = crear.getPosition(crear);
							positionBack = Almacen.pokemons.size() - 1
									- (Almacen.pokemons.size() - crear.getPosition(crear));
							positionFront = position + 1;
						}
						
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
						
						updateText();
					}
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

				btnTipo1.setText(Almacen.pokemons.get(position).getTipo1());
				btnTipo2.setText(Almacen.pokemons.get(position).getTipo2());

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
					boolean posible = true;

					for (Pokemon comprobar : Almacen.pokemons) {
						if (comprobar.getNombre().equals(textNombre.getText())) {
							posible = false;
						}
					}

					if (posible) {
						Almacen.pokemons.get(position).setNombre(textNombre.getText());
					} else {
						JFrame imposible = new JFrame();
						JOptionPane.showMessageDialog(imposible, "No se puede cambiar.\nNombre ya ocupado");
					}

				}

				if (!btnTipo1.getText().equals("Ninguno")) {
					Almacen.pokemons.get(position).setTipo1(TiposPokemon.valueOf(btnTipo1.getText()));
				}

				if (!btnTipo2.getText().equals("Ninguno")) {
					Almacen.pokemons.get(position).setTipo2(TiposPokemon.valueOf(btnTipo2.getText()));
				}

				if (!textAltura.getText().isBlank()) {
					Almacen.pokemons.get(position).setAltura(Double.parseDouble(textAltura.getText()));
				}

				if (!textPeso.getText().isBlank()) {
					Almacen.pokemons.get(position).setPeso(Double.parseDouble(textPeso.getText()));

				}

				if (!textCategoria.getText().isBlank()) {
					Almacen.pokemons.get(position).setCategoria(textCategoria.getText());
				}

				if (!textHabilidad.getText().isBlank()) {
					Almacen.pokemons.get(position).setHabilidad(textHabilidad.getText());
				}

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

				updateText();
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

				if (Almacen.pokemons.size() == 0) {
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
				updateTipo(TiposPokemon.Ninguno);
			}
		});
		// ############################################

		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListIterator<Pokemon> reordenar = Almacen.pokemons.listIterator();
				actualizar = Almacen.pokemons.get(position);
				while (reordenar.hasNext()) {
					if (reordenar.next().getNumeroPokedex() == actualizar.getNumeroPokedex()) {
						reordenar.remove();
					}
				}
				if (position > Almacen.pokemons.size() - 1) {
					position = Almacen.pokemons.size() - 1;
					positionBack = Almacen.pokemons.size() - 2;
					positionFront = 0;
				}
				if (positionBack > Almacen.pokemons.size() - 1) {
					positionBack = Almacen.pokemons.size() - 1;
				}
				positionFront = position + 1;
				if (positionFront > Almacen.pokemons.size() - 1) {
					positionFront = 0;
				}

				if (Almacen.pokemons.size() == 1) {
					positionFront = positionBack = position;
				}

				updateText();
			}
		});
	}

	public void updateTipo(TiposPokemon tipo) {
		if (opcTipo) {
			btnTipo2.setText(tipo.name());
		} else {
			btnTipo1.setText(tipo.name());
		}

		selTipo.setVisible(false);
		btnTipo1.setVisible(true);
		btnTipo2.setVisible(true);
	}

	public void updateText() {

		if (Almacen.pokemons.size() == 0) {
			hbTop.setVisible(false);
			hbMid.setVisible(false);
			lblImg.setVisible(false);
			vbMid.setVisible(false);
			btnBloqueado.setVisible(false);
			btnActualizar.setVisible(false);
			btnBorrar.setVisible(false);
			Almacen.pokemons.clear();
		} else {
			hbTop.setVisible(true);
			if (Almacen.pokemons.size() == 1) {
				btnPkmnAnterior.setVisible(false);
				btnPkmnSiguiente.setVisible(false);
			} else {
				btnPkmnAnterior.setVisible(true);
				btnPkmnSiguiente.setVisible(true);
			}
			hbMid.setVisible(true);
			lblImg.setVisible(true);
			vbMid.setVisible(true);
			btnBloqueado.setVisible(true);
			btnActualizar.setVisible(true);
			btnBorrar.setVisible(true);
			if (Almacen.pokemons.get(positionBack).isConocido())
				btnPkmnAnterior.setText("<   " + Almacen.pokemons.get(positionBack).getNumeroPokedex() + " "
						+ Almacen.pokemons.get(positionBack).getNombre());
			else
				btnPkmnAnterior.setText("<   " + Almacen.pokemons.get(positionBack).getNumeroPokedex() + " ?????????");

			if (Almacen.pokemons.get(position).isConocido()) {
				Image image;
					
				if(Almacen.pokemons.get(position).getNumeroPokedex()<10) {
					try {
						URL url = new URL("https://assets.pokemon.com/assets/cms2/img/pokedex/full/00"+Almacen.pokemons.get(position).getNumeroPokedex()+".png");
						image = ImageIO.read(url);
						lblImg.setIcon(new ImageIcon(image));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if(Almacen.pokemons.get(position).getNumeroPokedex()<100) {
					try {
						URL url = new URL("https://assets.pokemon.com/assets/cms2/img/pokedex/full/0"+Almacen.pokemons.get(position).getNumeroPokedex()+".png");
						image = ImageIO.read(url);
						lblImg.setIcon(new ImageIcon(image));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					try {
						URL url = new URL("https://assets.pokemon.com/assets/cms2/img/pokedex/full/"+Almacen.pokemons.get(position).getNumeroPokedex()+".png");
						image = ImageIO.read(url);
						lblImg.setIcon(new ImageIcon(image));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				lblPkmnActual.setText(Almacen.pokemons.get(position).getNombre());
				lblAltura.setText(Double.toString(Almacen.pokemons.get(position).getAltura()));
				lblNombre.setText(Almacen.pokemons.get(position).getNombre());
				lblNumero.setText(Integer.toString(Almacen.pokemons.get(position).getNumeroPokedex()));
				lblCategoria.setText(Almacen.pokemons.get(position).getCategoria());
				lblPeso.setText(Double.toString(Almacen.pokemons.get(position).getPeso()));
				lblHabilidad.setText(Almacen.pokemons.get(position).getHabilidad());

				lblTipo1.setText(Almacen.pokemons.get(position).getTipo1());
				if (!Almacen.pokemons.get(position).getTipo2().equals("Ninguno"))
					lblTipo2.setText(Almacen.pokemons.get(position).getTipo2());
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
				lblNumero.setText(Integer.toString(Almacen.pokemons.get(position).getNumeroPokedex()));
				lblCategoria.setText("?????????");
				lblPeso.setText("?????????");
				lblHabilidad.setText("?????????");

				lblTipo1.setText("?????????");
				if (!Almacen.pokemons.get(position).getTipo2().equals("Ninguno"))
					lblTipo2.setText("?????????");
				else
					lblTipo2.setText("");

				btnBloqueado.setText("Descubrir");
				btnActualizar.setVisible(false);
				hbActualizar.setVisible(false);
				btnBorrar.setVisible(false);
			}

			if (Almacen.pokemons.get(positionFront).isConocido())
				btnPkmnSiguiente.setText(Almacen.pokemons.get(positionFront).getNumeroPokedex() + " "
						+ Almacen.pokemons.get(positionFront).getNombre() + "   >");
			else
				btnPkmnSiguiente.setText(Almacen.pokemons.get(positionFront).getNumeroPokedex() + " ?????????   >");
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
