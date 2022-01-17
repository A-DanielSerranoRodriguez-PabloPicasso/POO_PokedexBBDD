package ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.UserDAO;
import javax.swing.JPasswordField;

public class Menu {
	UserDAO userDAO = new UserDAO();

	private JFrame frmInicioDeSesin;
	private JPanel mainApp;
	private JPanel menus;
	private Box hbPokemonLogo;
	private JLabel lblPokemonlogo;
	private Box hbMenu;
	private JPanel menu;
	private JPanel inicial;
	private JPanel login;
	private JPanel register;
	private Box vbLogin;
	private JButton btnLogin;
	private Box hbLogin;
	private Box vbRegister;
	private Box hbRegister;
	private JButton btnRegister;
	private Box vbExit;
	private Box hbExit;
	private JButton btnExit;
	private Component vgInicial_1;
	private Component vgInicial_2;
	private Component vgInicial_3;
	private Component vgInicial_4;
	private Component vgLogin_1;
	private Box hbUsername_login;
	private Component hgUsername_login_1;
	private JLabel lblUsernameLogin;
	private Component hsUsername_login_1;
	private Box vbUsername_login;
	private Component vsUsername_login_1;
	private JTextField tfUsernameLogin;
	private Component vsUsername_login_2;
	private Component hgUsername_login_2;
	private Component vgLogin_2;
	private Box hbPasswd_login;
	private Component hgPasswd_login_1;
	private JLabel lblPasswdLogin;
	private Component hsPasswd_login_1;
	private Box vbPasswd_login;
	private Component vsPasswd_login_1;
	private Component vsPasswd_login_2;
	private Component hgPasswd_login_2;
	private Box hbOptions_login;
	private Component hgOptions_login_1;
	private JButton btnLoginLogin;
	private Component vgLogin_3;
	private Component hgOptions_login_2;
	private JButton btnCancelLogin;
	private Component hgOptions_login_3;
	private Component vgLogin_4;
	private Component vgRegister_1;
	private Box hbUsername_register;
	private Component hgUsername_register_1;
	private JLabel lblUsernameRegister;
	private Component hsUsername_register_1;
	private Box vbUsername_register;
	private Component vsUsername_register_1;
	private JTextField tfUsernameRegister;
	private Component vsUsername_register_2;
	private Component hgUsername_register_2;
	private Component vgRegister_2;
	private Box hbPasswd_register;
	private Component hgPasswd_register_1;
	private JLabel lblPasswdRegister;
	private Component hsPasswd_register_1;
	private Box vbPasswd_register;
	private Component vsPasswd_register_1;
	private Component vsPasswd_register_2;
	private Component hgPasswd_register_2;
	private Component vgRegister_3;
	private Box hbOptions_register;
	private Component hgOptions_register_1;
	private JButton btnRegisterRegister;
	private Component hgOptions_register_2;
	private JButton btnCancelRegister;
	private Component hgOptions_register_3;
	private Component vgRegister_5;
	private Box hbChkPasswd_register;
	private Component hgChkPasswd_register_1;
	private JLabel lblChkPasswdRegister;
	private Component hsChkPasswd_register_1;
	private Box vbChkPasswd_register;
	private Component vsChkPasswd_register_1;
	private Component vsChkPasswd_register_2;
	private Component hgChkPasswd_register_2;
	private Component vgRegister_4;
	private JPasswordField pfPasswdLogin;
	private JPasswordField pfPasswdRegister;
	private JPasswordField pfChkPasswdRegister;

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
		this.frmInicioDeSesin.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInicioDeSesin = new JFrame();
		frmInicioDeSesin.setTitle("Inicio de sesión");
		frmInicioDeSesin.setBounds(100, 100, 600, 450);
		frmInicioDeSesin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInicioDeSesin.getContentPane()
				.setLayout(new BoxLayout(frmInicioDeSesin.getContentPane(), BoxLayout.PAGE_AXIS));
		setUIComponents();
		setUIBehaviour();
	}

	private void setUIComponents() {

		mainApp = new JPanel();
		frmInicioDeSesin.getContentPane().add(mainApp);
		mainApp.setLayout(new CardLayout(0, 0));

		menus = new JPanel();
		mainApp.add(menus, "name_17823706361686");
		menus.setLayout(new BoxLayout(menus, BoxLayout.PAGE_AXIS));

		hbPokemonLogo = Box.createHorizontalBox();
		menus.add(hbPokemonLogo);

		lblPokemonlogo = new JLabel("");
		lblPokemonlogo.setIcon(new ImageIcon(
				"/home/Puente/PC/1ºCFGS - Desarrollo de Aplicaciones Multiplataforma/Proyectos/Java/Java/Pokedex - Basica/src/mainApp/pokemon-logo_escalado.png"));
		hbPokemonLogo.add(lblPokemonlogo);

		hbMenu = Box.createHorizontalBox();
		menus.add(hbMenu);

		menu = new JPanel();
		hbMenu.add(menu);
		menu.setLayout(new CardLayout(0, 0));

		inicial = new JPanel();
		menu.add(inicial, "name_18086991792731");
		inicial.setLayout(new BoxLayout(inicial, BoxLayout.PAGE_AXIS));

		vgInicial_1 = Box.createVerticalGlue();
		inicial.add(vgInicial_1);

		vbLogin = Box.createVerticalBox();
		inicial.add(vbLogin);

		hbLogin = Box.createHorizontalBox();
		vbLogin.add(hbLogin);

		btnLogin = new JButton("Iniciar sesión");
		hbLogin.add(btnLogin);

		vgInicial_2 = Box.createVerticalGlue();
		inicial.add(vgInicial_2);

		vbRegister = Box.createVerticalBox();
		inicial.add(vbRegister);

		hbRegister = Box.createHorizontalBox();
		vbRegister.add(hbRegister);

		btnRegister = new JButton("Registrarse");
		hbRegister.add(btnRegister);

		vgInicial_3 = Box.createVerticalGlue();
		inicial.add(vgInicial_3);

		vbExit = Box.createVerticalBox();
		inicial.add(vbExit);

		hbExit = Box.createHorizontalBox();
		vbExit.add(hbExit);

		btnExit = new JButton("Salir");
		hbExit.add(btnExit);

		vgInicial_4 = Box.createVerticalGlue();
		inicial.add(vgInicial_4);

		login = new JPanel();
		menu.add(login, "name_18143695036489");
		login.setLayout(new BoxLayout(login, BoxLayout.PAGE_AXIS));

		vgLogin_1 = Box.createVerticalGlue();
		login.add(vgLogin_1);

		hbUsername_login = Box.createHorizontalBox();
		login.add(hbUsername_login);

		hgUsername_login_1 = Box.createHorizontalGlue();
		hbUsername_login.add(hgUsername_login_1);

		lblUsernameLogin = new JLabel("Usuario");
		lblUsernameLogin.setOpaque(true);
		hbUsername_login.add(lblUsernameLogin);

		hsUsername_login_1 = Box.createHorizontalStrut(48);
		hbUsername_login.add(hsUsername_login_1);

		vbUsername_login = Box.createVerticalBox();
		hbUsername_login.add(vbUsername_login);

		vsUsername_login_1 = Box.createVerticalStrut(20);
		vbUsername_login.add(vsUsername_login_1);

		tfUsernameLogin = new JTextField();
		tfUsernameLogin.setMaximumSize(new Dimension(400, 50));
		vbUsername_login.add(tfUsernameLogin);
		tfUsernameLogin.setColumns(10);

		vsUsername_login_2 = Box.createVerticalStrut(20);
		vbUsername_login.add(vsUsername_login_2);

		hgUsername_login_2 = Box.createHorizontalGlue();
		hbUsername_login.add(hgUsername_login_2);

		vgLogin_2 = Box.createVerticalGlue();
		login.add(vgLogin_2);

		hbPasswd_login = Box.createHorizontalBox();
		login.add(hbPasswd_login);

		hgPasswd_login_1 = Box.createHorizontalGlue();
		hbPasswd_login.add(hgPasswd_login_1);

		lblPasswdLogin = new JLabel("Contraseña");
		lblPasswdLogin.setOpaque(true);
		hbPasswd_login.add(lblPasswdLogin);

		hsPasswd_login_1 = Box.createHorizontalStrut(20);
		hbPasswd_login.add(hsPasswd_login_1);

		vbPasswd_login = Box.createVerticalBox();
		hbPasswd_login.add(vbPasswd_login);

		vsPasswd_login_1 = Box.createVerticalStrut(20);
		vbPasswd_login.add(vsPasswd_login_1);

		pfPasswdLogin = new JPasswordField();
		pfPasswdLogin.setMaximumSize(new Dimension(400, 50));
		pfPasswdLogin.setColumns(10);
		vbPasswd_login.add(pfPasswdLogin);

		vsPasswd_login_2 = Box.createVerticalStrut(20);
		vbPasswd_login.add(vsPasswd_login_2);

		hgPasswd_login_2 = Box.createHorizontalGlue();
		hbPasswd_login.add(hgPasswd_login_2);

		vgLogin_3 = Box.createVerticalGlue();
		login.add(vgLogin_3);

		hbOptions_login = Box.createHorizontalBox();
		login.add(hbOptions_login);

		hgOptions_login_1 = Box.createHorizontalGlue();
		hbOptions_login.add(hgOptions_login_1);

		btnLoginLogin = new JButton("Entrar");
		hbOptions_login.add(btnLoginLogin);

		hgOptions_login_2 = Box.createHorizontalGlue();
		hbOptions_login.add(hgOptions_login_2);

		btnCancelLogin = new JButton("Cancelar");
		hbOptions_login.add(btnCancelLogin);

		hgOptions_login_3 = Box.createHorizontalGlue();
		hbOptions_login.add(hgOptions_login_3);

		vgLogin_4 = Box.createVerticalGlue();
		login.add(vgLogin_4);

		register = new JPanel();
		menu.add(register, "name_18149304954957");
		register.setLayout(new BoxLayout(register, BoxLayout.PAGE_AXIS));

		vgRegister_1 = Box.createVerticalGlue();
		register.add(vgRegister_1);

		hbUsername_register = Box.createHorizontalBox();
		register.add(hbUsername_register);

		hgUsername_register_1 = Box.createHorizontalGlue();
		hbUsername_register.add(hgUsername_register_1);

		lblUsernameRegister = new JLabel("Usuario");
		lblUsernameRegister.setOpaque(true);
		hbUsername_register.add(lblUsernameRegister);

		hsUsername_register_1 = Box.createHorizontalStrut(101);
		hbUsername_register.add(hsUsername_register_1);

		vbUsername_register = Box.createVerticalBox();
		hbUsername_register.add(vbUsername_register);

		vsUsername_register_1 = Box.createVerticalStrut(20);
		vbUsername_register.add(vsUsername_register_1);

		tfUsernameRegister = new JTextField();
		tfUsernameRegister.setMaximumSize(new Dimension(400, 50));
		tfUsernameRegister.setColumns(10);
		vbUsername_register.add(tfUsernameRegister);

		vsUsername_register_2 = Box.createVerticalStrut(20);
		vbUsername_register.add(vsUsername_register_2);

		hgUsername_register_2 = Box.createHorizontalGlue();
		hbUsername_register.add(hgUsername_register_2);

		vgRegister_2 = Box.createVerticalGlue();
		register.add(vgRegister_2);

		hbPasswd_register = Box.createHorizontalBox();
		register.add(hbPasswd_register);

		hgPasswd_register_1 = Box.createHorizontalGlue();
		hbPasswd_register.add(hgPasswd_register_1);

		lblPasswdRegister = new JLabel("Contraseña");
		lblPasswdRegister.setOpaque(true);
		hbPasswd_register.add(lblPasswdRegister);

		hsPasswd_register_1 = Box.createHorizontalStrut(73);
		hbPasswd_register.add(hsPasswd_register_1);

		vbPasswd_register = Box.createVerticalBox();
		hbPasswd_register.add(vbPasswd_register);

		vsPasswd_register_1 = Box.createVerticalStrut(20);
		vbPasswd_register.add(vsPasswd_register_1);

		pfPasswdRegister = new JPasswordField();
		pfPasswdRegister.setMaximumSize(new Dimension(400, 50));
		vbPasswd_register.add(pfPasswdRegister);

		vsPasswd_register_2 = Box.createVerticalStrut(20);
		vbPasswd_register.add(vsPasswd_register_2);

		hgPasswd_register_2 = Box.createHorizontalGlue();
		hbPasswd_register.add(hgPasswd_register_2);

		vgRegister_3 = Box.createVerticalGlue();
		register.add(vgRegister_3);

		hbChkPasswd_register = Box.createHorizontalBox();
		register.add(hbChkPasswd_register);

		hgChkPasswd_register_1 = Box.createHorizontalGlue();
		hbChkPasswd_register.add(hgChkPasswd_register_1);

		lblChkPasswdRegister = new JLabel("Repetir contraseña");
		lblChkPasswdRegister.setOpaque(true);
		hbChkPasswd_register.add(lblChkPasswdRegister);

		hsChkPasswd_register_1 = Box.createHorizontalStrut(20);
		hbChkPasswd_register.add(hsChkPasswd_register_1);

		vbChkPasswd_register = Box.createVerticalBox();
		hbChkPasswd_register.add(vbChkPasswd_register);

		vsChkPasswd_register_1 = Box.createVerticalStrut(20);
		vbChkPasswd_register.add(vsChkPasswd_register_1);

		pfChkPasswdRegister = new JPasswordField();
		pfChkPasswdRegister.setMaximumSize(new Dimension(400, 50));
		vbChkPasswd_register.add(pfChkPasswdRegister);

		vsChkPasswd_register_2 = Box.createVerticalStrut(20);
		vbChkPasswd_register.add(vsChkPasswd_register_2);

		hgChkPasswd_register_2 = Box.createHorizontalGlue();
		hbChkPasswd_register.add(hgChkPasswd_register_2);

		vgRegister_4 = Box.createVerticalGlue();
		register.add(vgRegister_4);

		hbOptions_register = Box.createHorizontalBox();
		register.add(hbOptions_register);

		hgOptions_register_1 = Box.createHorizontalGlue();
		hbOptions_register.add(hgOptions_register_1);

		btnRegisterRegister = new JButton("Registrarse");
		hbOptions_register.add(btnRegisterRegister);

		hgOptions_register_2 = Box.createHorizontalGlue();
		hbOptions_register.add(hgOptions_register_2);

		btnCancelRegister = new JButton("Cancelar");
		hbOptions_register.add(btnCancelRegister);

		hgOptions_register_3 = Box.createHorizontalGlue();
		hbOptions_register.add(hgOptions_register_3);

		vgRegister_5 = Box.createVerticalGlue();
		register.add(vgRegister_5);
	}

	private void setUIBehaviour() {
		// Menu inicial
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicial.setVisible(false);
				login.setVisible(true);
			}
		});

		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicial.setVisible(false);
				register.setVisible(true);
			}
		});

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// Menu login
		btnLoginLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame entrar = new JFrame();

				if (userDAO.login(tfUsernameLogin.getText(), new String(pfPasswdLogin.getPassword()))) {
					lblUsernameLogin.setBackground(new Color(238, 238, 238));
					lblUsernameLogin.setForeground(new Color(0, 0, 0));
					lblPasswdLogin.setBackground(new Color(238, 238, 238));
					lblPasswdLogin.setForeground(new Color(0, 0, 0));
					JOptionPane.showMessageDialog(entrar, "Bienvenido a su Pokédex " + tfUsernameLogin.getText());
					new Pokedex(frmInicioDeSesin);
				} else {
					lblUsernameLogin.setBackground(new Color(200, 0, 0));
					lblUsernameLogin.setForeground(new Color(255, 255, 255));
					lblPasswdLogin.setBackground(new Color(200, 0, 0));
					lblPasswdLogin.setForeground(new Color(255, 255, 255));
					JOptionPane.showMessageDialog(entrar, "Nombre o contraseña incorrectos");
				}
			}
		});

		btnCancelLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicial.setVisible(true);
				login.setVisible(false);
			}
		});

		// Menu register
		btnRegisterRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame registro = new JFrame();
				String user = tfUsernameRegister.getText(), passwd = new String(pfPasswdRegister.getPassword()),
						chkPasswd = new String(pfChkPasswdRegister.getPassword());

				if (passwd.equals(chkPasswd)) {
					if (userDAO.register(user, passwd)) {
						tfUsernameLogin.setText(user);
						lblUsernameRegister.setBackground(new Color(238, 238, 238));
						lblUsernameRegister.setForeground(new Color(0, 0, 0));
						lblPasswdRegister.setBackground(new Color(238, 238, 238));
						lblPasswdRegister.setForeground(new Color(0, 0, 0));
						lblChkPasswdRegister.setBackground(new Color(238, 238, 238));
						lblChkPasswdRegister.setForeground(new Color(0, 0, 0));
						JOptionPane.showMessageDialog(registro,
								"Se ha registrado correctamente.\nAhora inicie sesión.");
						register.setVisible(false);
						login.setVisible(true);
					} else {
						lblUsernameRegister.setBackground(new Color(200, 0, 0));
						lblUsernameRegister.setForeground(new Color(255, 255, 255));
						lblPasswdRegister.setBackground(new Color(238, 238, 238));
						lblPasswdRegister.setForeground(new Color(0, 0, 0));
						lblChkPasswdRegister.setBackground(new Color(238, 238, 238));
						lblChkPasswdRegister.setForeground(new Color(0, 0, 0));
						JOptionPane.showMessageDialog(registro, "Nombre de usuario ya ocupado");
					}
				} else {
					lblUsernameRegister.setBackground(new Color(238, 238, 238));
					lblUsernameRegister.setForeground(new Color(0, 0, 0));
					lblPasswdRegister.setBackground(new Color(200, 0, 0));
					lblPasswdRegister.setForeground(new Color(255, 255, 255));
					lblChkPasswdRegister.setBackground(new Color(200, 0, 0));
					lblChkPasswdRegister.setForeground(new Color(255, 255, 255));
					JOptionPane.showMessageDialog(registro, "Las contraseñas no coinciden");
				}
			}
		});

		btnCancelRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicial.setVisible(true);
				register.setVisible(false);
			}
		});
	}

}
