package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import logico.Altice;

import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class PrincipalAdmin extends JFrame {

	private Dimension dim;
	
	private JPanel contentPane;
	private JLabel lblBienvenido;
	private JMenuItem btnGuardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalAdmin frame = new PrincipalAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalAdmin() {
		setBackground(new Color(0, 0, 51));
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalAdmin.class.getResource("/img/alticelogo.png")));
		setTitle("Altice");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 671);
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height - 50);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setEnabled(false);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(51, 51, 102));
		setJMenuBar(menuBar);
		
		JMenu mnEmpleados = new JMenu("Empleados");
		mnEmpleados.setForeground(Color.WHITE);
		mnEmpleados.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnEmpleados);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registrar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarEmpleado registrar = new RegistrarEmpleado(null);
				registrar.setModal(true);
				registrar.setVisible(true);
			}
		});
		mntmNewMenuItem.setBackground(new Color(0, 0, 102));
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem.setForeground(Color.WHITE);
		mnEmpleados.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionEmpleados listar = new GestionEmpleados();
				listar.setModal(true);
				listar.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setBackground(new Color(0, 0, 102));
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem_1.setForeground(Color.WHITE);
		mnEmpleados.add(mntmNewMenuItem_1);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setForeground(Color.WHITE);
		mnClientes.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnClientes);
		
		JMenuItem menuItem = new JMenuItem("Registrar");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCliente registrar = new RegistrarCliente(null,false);
				registrar.setModal(true);
				registrar.setVisible(true);
			}
		});
		menuItem.setForeground(Color.WHITE);
		menuItem.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuItem.setBackground(new Color(0, 0, 102));
		mnClientes.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Listar");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionClientes gestion = new GestionClientes();
				gestion.setModal(true);
				gestion.setVisible(true);
						
			}
		});
		menuItem_1.setForeground(Color.WHITE);
		menuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuItem_1.setBackground(new Color(0, 0, 102));
		mnClientes.add(menuItem_1);
		
		JMenu mnContratos = new JMenu("Contratos");
		mnContratos.setForeground(Color.WHITE);
		mnContratos.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnContratos);
		
		JMenuItem menuItem_2 = new JMenuItem("Registrar");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarContrato nuevo = new RegistrarContrato();
				nuevo.setModal(true);
				nuevo.setVisible(true);
			}
		});
		menuItem_2.setForeground(Color.WHITE);
		menuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuItem_2.setBackground(new Color(0, 0, 102));
		mnContratos.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Listar");
		menuItem_3.setForeground(Color.WHITE);
		menuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuItem_3.setBackground(new Color(0, 0, 102));
		mnContratos.add(menuItem_3);
		
		JMenu mnPagos = new JMenu("Pagos");
		mnPagos.setForeground(Color.WHITE);
		mnPagos.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnPagos);
		
		JMenu mnPlanes = new JMenu("Planes");
		mnPlanes.setForeground(Color.WHITE);
		mnPlanes.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnPlanes);
		
		JMenu mnServicios = new JMenu("Servicios");
		mnServicios.setForeground(Color.WHITE);
		mnServicios.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnServicios);

		JMenuItem mntmRegistrarServicio = new JMenuItem("Registrar");
		mntmRegistrarServicio.setForeground(Color.WHITE);
		mntmRegistrarServicio.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmRegistrarServicio.setBackground(new Color(0, 0, 102));
		mntmRegistrarServicio.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        RegistrarServicio registrar = new RegistrarServicio(null, false);
		        registrar.setModal(true);
		        registrar.setVisible(true);
		    }
		});
		mnServicios.add(mntmRegistrarServicio);

		JMenuItem mntmListarServicio = new JMenuItem("Listar");
		mntmListarServicio.setForeground(Color.WHITE);
		mntmListarServicio.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmListarServicio.setBackground(new Color(0, 0, 102));
		mntmListarServicio.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        GestionServicios gestionar = new GestionServicios();
		        gestionar.setModal(true);
		        gestionar.setVisible(true);
		    }
		});
		mnServicios.add(mntmListarServicio);
        // ====================== SOLICITUDES ======================
        JMenu mnSolicitudes = new JMenu("Solicitudes");
        mnSolicitudes.setForeground(Color.WHITE);
        mnSolicitudes.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menuBar.add(mnSolicitudes);

        JMenuItem mntmRegistrarSolicitud = new JMenuItem("Registrar");
        mntmRegistrarSolicitud.setForeground(Color.WHITE);
        mntmRegistrarSolicitud.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        mntmRegistrarSolicitud.setBackground(new Color(0, 0, 102));
        mntmRegistrarSolicitud.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegistrarSolicitud registrar = new RegistrarSolicitud(null, false);
                registrar.setModal(true);
                registrar.setVisible(true);
            }
        });
        mnSolicitudes.add(mntmRegistrarSolicitud);

        JMenuItem mntmListarSolicitud = new JMenuItem("Listar");
        mntmListarSolicitud.setForeground(Color.WHITE);
        mntmListarSolicitud.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        mntmListarSolicitud.setBackground(new Color(0, 0, 102));
        mntmListarSolicitud.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GestionSolicitudes gestionar = new GestionSolicitudes();
                gestionar.setModal(true);
                gestionar.setVisible(true);
            }
        });
        mnSolicitudes.add(mntmListarSolicitud);
        
		JMenu mnNewMenu = new JMenu("Administracion");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		btnGuardar = new JMenuItem("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Altice.getInstance().guardarDatos();
			}
		});
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnGuardar.setBackground(new Color(0, 0, 102));
		mnNewMenu.add(btnGuardar);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(0, 0, 51));
		topPanel.setLayout(new BorderLayout());

		lblBienvenido = new JLabel("Bienvenido, ____");
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblBienvenido.setBorder(new EmptyBorder(5, 10, 5, 10));
		topPanel.add(lblBienvenido, BorderLayout.WEST);
		
		if(!Altice.getSesion().getUser().equalsIgnoreCase("admin"))
			lblBienvenido.setText("Bienvenido, "+Altice.getInstance().buscarEmpleadoById((Altice.getSesion().getCodigo())).getNombre());
		
		JButton btnCerrarSesion = new JButton("Cerrar sesión");
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setBackground(new Color(102, 0, 0));
		btnCerrarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCerrarSesion.setFocusPainted(false);
		topPanel.add(btnCerrarSesion, BorderLayout.EAST);

		contentPane.add(topPanel, BorderLayout.NORTH);
		
		// Panel central (ya lo tienes creado)
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		// Panel interno para el dashboard
		JPanel dashboardPanel = new JPanel();
		dashboardPanel.setBackground(new Color(0, 0, 51));
		dashboardPanel.setLayout(new GridBagLayout());
		panel.add(dashboardPanel, BorderLayout.NORTH);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20, 20, 20, 20);
		gbc.fill = GridBagConstraints.BOTH;

		//// Tarjeta 1: Empleados
		GridBagConstraints gbcEmpleados = new GridBagConstraints();
		gbcEmpleados.ipadx = 20;
		gbcEmpleados.gridx = 0;
		gbcEmpleados.insets = new Insets(20, 20, 20, 20);
		gbcEmpleados.fill = GridBagConstraints.BOTH;
		gbcEmpleados.gridy = 0;

		JPanel cardEmpleados = new JPanel(new BorderLayout());
		cardEmpleados.setBackground(new Color(102, 102, 204));
		cardEmpleados.setBorder(new TitledBorder(null, "Empleados", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 16), Color.WHITE));
		cardEmpleados.setPreferredSize(new Dimension(220, 200));

		JLabel iconEmpleados = new JLabel();
		iconEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon empleadosIcon = new ImageIcon(PrincipalAdmin.class.getResource("/img/empleado.png"));
		Image empleadosImage = empleadosIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		iconEmpleados.setIcon(new ImageIcon(empleadosImage));
		cardEmpleados.add(iconEmpleados, BorderLayout.CENTER);

		JButton btnGestionarEmpleados = new JButton("Gestionar");
		btnGestionarEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionEmpleados gestionar = new GestionEmpleados();
				gestionar.setModal(true);
				gestionar.setVisible(true);
			}
		});
		btnGestionarEmpleados.setForeground(Color.WHITE);
		btnGestionarEmpleados.setBackground(new Color(0, 0, 51));
		btnGestionarEmpleados.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cardEmpleados.add(btnGestionarEmpleados, BorderLayout.SOUTH);

		dashboardPanel.add(cardEmpleados, gbcEmpleados);

		GridBagConstraints gbcClientes = new GridBagConstraints();
		gbcClientes.ipadx = 20;
		gbcClientes.insets = new Insets(20, 20, 20, 20);
		gbcClientes.fill = GridBagConstraints.BOTH;
		gbcClientes.gridx = 1;
		gbcClientes.gridy = 0;

		JPanel cardClientes = new JPanel(new BorderLayout());
		cardClientes.setBackground(new Color(102, 102, 204));
		cardClientes.setBorder(new TitledBorder(null, "Clientes", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 16), Color.WHITE));
		cardClientes.setPreferredSize(new Dimension(220, 200));

		JLabel iconClientes = new JLabel();
		iconClientes.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon clientesIcon = new ImageIcon(PrincipalAdmin.class.getResource("/img/cliente.png"));
		Image clientesImage = clientesIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		iconClientes.setIcon(new ImageIcon(clientesImage));
		cardClientes.add(iconClientes, BorderLayout.CENTER);

		JButton btnGestionarClientes = new JButton("Gestionar");
		btnGestionarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionClientes gestion = new GestionClientes();
				gestion.setModal(true);
				gestion.setVisible(true);
			}
		});
		btnGestionarClientes.setForeground(Color.WHITE);
		btnGestionarClientes.setBackground(new Color(0, 0, 51));
		btnGestionarClientes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cardClientes.add(btnGestionarClientes, BorderLayout.SOUTH);

		dashboardPanel.add(cardClientes, gbcClientes);

		GridBagConstraints gbcContratos = new GridBagConstraints();
		gbcContratos.ipadx = 20;
		gbcContratos.insets = new Insets(20, 20, 20, 20);
		gbcContratos.fill = GridBagConstraints.BOTH;
		gbcContratos.gridx = 2;
		gbcContratos.gridy = 0;

		JPanel cardContratos = new JPanel(new BorderLayout());
		cardContratos.setBackground(new Color(102, 102, 204));
		cardContratos.setBorder(new TitledBorder(null, "Contratos", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 16), Color.WHITE));
		cardContratos.setPreferredSize(new Dimension(220, 200));

		JLabel iconContratos = new JLabel();
		iconContratos.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon contratosIcon = new ImageIcon(PrincipalAdmin.class.getResource("/img/contrato.png"));
		Image contratosImage = contratosIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		iconContratos.setIcon(new ImageIcon(contratosImage));
		cardContratos.add(iconContratos, BorderLayout.CENTER);

		JButton btnGestionarContratos = new JButton("Gestionar");
		btnGestionarContratos.setForeground(Color.WHITE);
		btnGestionarContratos.setBackground(new Color(0, 0, 51));
		btnGestionarContratos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cardContratos.add(btnGestionarContratos, BorderLayout.SOUTH);

		dashboardPanel.add(cardContratos, gbcContratos);
		
		GridBagConstraints gbcPlanes = new GridBagConstraints();
		gbcPlanes.ipadx = 20;
		gbcPlanes.insets = new Insets(20, 20, 20, 20);
		gbcPlanes.fill = GridBagConstraints.BOTH;
		gbcPlanes.gridx = 4;
		gbcPlanes.gridy = 0;

		JPanel cardPlanes = new JPanel(new BorderLayout());
		cardPlanes.setBackground(new Color(102, 102, 204));
		cardPlanes.setBorder(new TitledBorder(null, "Planes", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 16), Color.WHITE));
		cardPlanes.setPreferredSize(new Dimension(220, 200));

		JLabel iconPlanes = new JLabel();
		iconPlanes.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon planesIcon = new ImageIcon(PrincipalAdmin.class.getResource("/img/plan.png"));
		Image planesImage = planesIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		iconPlanes.setIcon(new ImageIcon(planesImage));
		cardPlanes.add(iconPlanes, BorderLayout.CENTER);

		JButton btnGestionarPlanes = new JButton("Gestionar");
		btnGestionarPlanes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionPlanes gestion = new GestionPlanes();
				gestion.setModal(true);
				gestion.setVisible(true);
			}
		});
		btnGestionarPlanes.setForeground(Color.WHITE);
		btnGestionarPlanes.setBackground(new Color(0, 0, 51));
		btnGestionarPlanes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cardPlanes.add(btnGestionarPlanes, BorderLayout.SOUTH);

		dashboardPanel.add(cardPlanes, gbcPlanes);

		GridBagConstraints gbcPagos = new GridBagConstraints();
		gbcPagos.ipadx = 20;
        gbcPagos.gridx = 3;
        gbcPagos.gridy = 0;
        gbcPagos.insets = new Insets(20, 20, 20, 20);
        gbcPagos.fill = GridBagConstraints.BOTH;
        JPanel cardPagos = new JPanel(new BorderLayout());
        cardPagos.setBackground(new Color(102, 102, 204));
        cardPagos.setBorder(new TitledBorder(null, "Pagos", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 16), Color.WHITE));
        cardPagos.setPreferredSize(new Dimension(220, 200));
        JLabel iconPagos = new JLabel();
        iconPagos.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon pagosIcon = new ImageIcon(PrincipalAdmin.class.getResource("/img/pago.png"));
        Image pagosImage = pagosIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        iconPagos.setIcon(new ImageIcon(pagosImage));
        cardPagos.add(iconPagos, BorderLayout.CENTER);
        JButton btnGestionarPagos = new JButton("Gestionar");
        btnGestionarPagos.setForeground(Color.WHITE);
        btnGestionarPagos.setBackground(new Color(0, 0, 51));
        btnGestionarPagos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cardPagos.add(btnGestionarPagos, BorderLayout.SOUTH);
        dashboardPanel.add(cardPagos, gbcPagos);

        // Tarjeta Reportes
        GridBagConstraints gbcReportes = new GridBagConstraints();
        gbcReportes.ipadx = 20;
        gbcReportes.gridx = 5;
        gbcReportes.gridy = 0;
        gbcReportes.insets = new Insets(20, 20, 20, 20);
        gbcReportes.fill = GridBagConstraints.BOTH;
        JPanel cardReportes = new JPanel(new BorderLayout());
        cardReportes.setBackground(new Color(102, 102, 204));
        cardReportes.setBorder(new TitledBorder(null, "Reportes", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 16), Color.WHITE));
        cardReportes.setPreferredSize(new Dimension(220, 200));
        JLabel iconReportes = new JLabel();
        iconReportes.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon reportesIcon = new ImageIcon(PrincipalAdmin.class.getResource("/img/reporte.png"));
        Image reportesImage = reportesIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        iconReportes.setIcon(new ImageIcon(reportesImage));
        cardReportes.add(iconReportes, BorderLayout.CENTER);
        JButton btnGestionarReportes = new JButton("Gestionar");
        btnGestionarReportes.setForeground(Color.WHITE);
        btnGestionarReportes.setBackground(new Color(0, 0, 51));
        btnGestionarReportes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cardReportes.add(btnGestionarReportes, BorderLayout.SOUTH);
        dashboardPanel.add(cardReportes, gbcReportes);

		ImageIcon icon = new ImageIcon(PrincipalAdmin.class.getResource("/img/alticeblanco.png"));
		Image image = icon.getImage();

	}
}
