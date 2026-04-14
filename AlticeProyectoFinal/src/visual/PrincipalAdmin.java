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
import logico.EstadoSolicitud;
import logico.Pago;
import logico.Solicitud;

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
import javax.swing.JOptionPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.awt.LayoutManager;
import javax.swing.JComboBox;

public class PrincipalAdmin extends JFrame {

	private Dimension dim;
	
	private JPanel contentPane;
	private JLabel lblBienvenido;
	private JMenuItem btnGuardar;
	private JTextField txtMontoPendiente;
	private JTextField txtPagosPendientes;
	private JTextField txtCobrado;
	private JTextField txtPagosEfectuados;
	private JTextField txtSoliPendientes;
	private JTextField txtSoliCompletadas;
	private JTextField txtContratosActivos;
	private JTextField txtContratosCerrados;
	private JComboBox<String> comboFiltros;
	private JButton btnFiltrar;
	private JLabel lblMes;
	private JPanel panelInformacionGeneral;

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(Altice.getSesion() != null)
				{
					cerrarSesion();				
				}
			}
		});
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
		
		JMenuItem menuItem_4 = new JMenuItem("Registrar");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPago pago = new RegistrarPago();
				pago.setModal(true);
				pago.setVisible(true);
			}
		});
		menuItem_4.setForeground(Color.WHITE);
		menuItem_4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuItem_4.setBackground(new Color(0, 0, 102));
		mnPagos.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("Listar");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionPagos gestion = new GestionPagos();
				gestion.setModal(true);
				gestion.setVisible(true);
			}
		});
		menuItem_5.setForeground(Color.WHITE);
		menuItem_5.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuItem_5.setBackground(new Color(0, 0, 102));
		mnPagos.add(menuItem_5);
		
		JMenu mnPlanes = new JMenu("Planes");
		mnPlanes.setForeground(Color.WHITE);
		mnPlanes.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnPlanes);
		
		JMenuItem menuItem_6 = new JMenuItem("Registrar");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPlan plan = new RegistrarPlan(null);
				plan.setModal(true);
				plan.setVisible(true);
			}
		});
		menuItem_6.setForeground(Color.WHITE);
		menuItem_6.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuItem_6.setBackground(new Color(0, 0, 102));
		mnPlanes.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("Listar");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionPlanes plan = new GestionPlanes();
				plan.setModal(true);
				plan.setVisible(true);
			}
		});
		menuItem_7.setForeground(Color.WHITE);
		menuItem_7.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuItem_7.setBackground(new Color(0, 0, 102));
		mnPlanes.add(menuItem_7);
		
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
		
		btnGuardar = new JMenuItem("Respaldar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviarBackup();
				
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
		
		if(Altice.getSesion() != null && !Altice.getSesion().getUser().equalsIgnoreCase("admin"))
			lblBienvenido.setText("Bienvenido, "+Altice.getInstance().buscarEmpleadoById((Altice.getSesion().getCodigo())).getNombre());
		
		JButton btnCerrarSesion = new JButton("Cerrar sesión");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarSesion();
			}
		});
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
		panel.setLayout(null);

		// Panel interno para el dashboard
		JPanel dashboardPanel = new JPanel();
		dashboardPanel.setBounds(0, 0, 1904, 240);
		dashboardPanel.setBackground(new Color(0, 0, 51));
		dashboardPanel.setLayout(new GridBagLayout());
		panel.add(dashboardPanel);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20, 20, 20, 20);
		gbc.fill = GridBagConstraints.BOTH;

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
		btnGestionarContratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionContratos gestion = new GestionContratos();
				gestion.setModal(true);
				gestion.setVisible(true);
			}
		});
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
        btnGestionarPagos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		GestionPagos gestion = new GestionPagos();
        		gestion.setModal(true);
        		gestion.setVisible(true);
        	}
        });
        btnGestionarPagos.setForeground(Color.WHITE);
        btnGestionarPagos.setBackground(new Color(0, 0, 51));
        btnGestionarPagos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cardPagos.add(btnGestionarPagos, BorderLayout.SOUTH);
        dashboardPanel.add(cardPagos, gbcPagos);

        // Tarjeta Reportes
        // ====================== TARJETA REPORTES ======================
        GridBagConstraints gbcReportes = new GridBagConstraints();
        gbcReportes.ipadx = 20;
        gbcReportes.gridx = 5;
        gbcReportes.gridy = 0;
        gbcReportes.insets = new Insets(20, 20, 20, 20);
        gbcReportes.fill = GridBagConstraints.BOTH;

        JPanel cardReportes = new JPanel(new BorderLayout());
        cardReportes.setBackground(new Color(102, 102, 204));
        cardReportes.setBorder(new TitledBorder(null, "Reportes", TitledBorder.LEADING, TitledBorder.TOP, 
                new Font("Segoe UI", Font.BOLD, 16), Color.WHITE));
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
        btnGestionarReportes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Reportes reportes = new Reportes();
                reportes.setModal(true);
                reportes.setVisible(true);
            }
        });
        cardReportes.add(btnGestionarReportes, BorderLayout.SOUTH);

        dashboardPanel.add(cardReportes, gbcReportes);
        
        panelInformacionGeneral = new JPanel((LayoutManager) null);
        panelInformacionGeneral.setPreferredSize(new Dimension(220, 200));
        panelInformacionGeneral.setBorder(new TitledBorder(null, "Información General", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 16), Color.WHITE));
        panelInformacionGeneral.setBackground(new Color(102, 102, 204));
        panelInformacionGeneral.setBounds(524, 253, 848, 332);
        panel.add(panelInformacionGeneral);
        panelInformacionGeneral.setLayout(null);
        
        JLabel lblMontoPorCobrar = new JLabel("Pendiente:");
        lblMontoPorCobrar.setForeground(Color.WHITE);
        lblMontoPorCobrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblMontoPorCobrar.setBounds(271, 100, 91, 22);
        panelInformacionGeneral.add(lblMontoPorCobrar);
        
        txtMontoPendiente = new JTextField();
        txtMontoPendiente.setText("RD$ 0.00");
        txtMontoPendiente.setHorizontalAlignment(SwingConstants.CENTER);
        txtMontoPendiente.setForeground(Color.WHITE);
        txtMontoPendiente.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        txtMontoPendiente.setEditable(false);
        txtMontoPendiente.setCaretColor(Color.WHITE);
        txtMontoPendiente.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
        txtMontoPendiente.setBackground(new Color(0, 0, 51));
        txtMontoPendiente.setBounds(253, 135, 124, 37);
        panelInformacionGeneral.add(txtMontoPendiente);
        
        JLabel label_1 = new JLabel("Pagos Pendientes:");
        label_1.setForeground(Color.WHITE);
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label_1.setBounds(452, 100, 147, 22);
        panelInformacionGeneral.add(label_1);
        
        txtPagosPendientes = new JTextField();
        txtPagosPendientes.setText("00");
        txtPagosPendientes.setHorizontalAlignment(SwingConstants.CENTER);
        txtPagosPendientes.setForeground(Color.WHITE);
        txtPagosPendientes.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        txtPagosPendientes.setEditable(false);
        txtPagosPendientes.setCaretColor(Color.WHITE);
        txtPagosPendientes.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
        txtPagosPendientes.setBackground(new Color(0, 0, 51));
        txtPagosPendientes.setBounds(477, 135, 91, 37);
        panelInformacionGeneral.add(txtPagosPendientes);
        
        JLabel lblMontoCobrado = new JLabel("Cobrado:");
        lblMontoCobrado.setForeground(Color.WHITE);
        lblMontoCobrado.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblMontoCobrado.setBounds(74, 100, 91, 22);
        panelInformacionGeneral.add(lblMontoCobrado);
        
        txtCobrado = new JTextField();
        txtCobrado.setText("RD$ 0.00");
        txtCobrado.setHorizontalAlignment(SwingConstants.CENTER);
        txtCobrado.setForeground(Color.WHITE);
        txtCobrado.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        txtCobrado.setEditable(false);
        txtCobrado.setCaretColor(Color.WHITE);
        txtCobrado.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
        txtCobrado.setBackground(new Color(0, 0, 51));
        txtCobrado.setBounds(44, 135, 124, 37);
        panelInformacionGeneral.add(txtCobrado);
        
        txtPagosEfectuados = new JTextField();
        txtPagosEfectuados.setText("00");
        txtPagosEfectuados.setHorizontalAlignment(SwingConstants.CENTER);
        txtPagosEfectuados.setForeground(Color.WHITE);
        txtPagosEfectuados.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        txtPagosEfectuados.setEditable(false);
        txtPagosEfectuados.setCaretColor(Color.WHITE);
        txtPagosEfectuados.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
        txtPagosEfectuados.setBackground(new Color(0, 0, 51));
        txtPagosEfectuados.setBounds(666, 135, 91, 37);
        panelInformacionGeneral.add(txtPagosEfectuados);
        
        JLabel lblPagosEfectuados = new JLabel("Pagos Efectuados:");
        lblPagosEfectuados.setForeground(Color.WHITE);
        lblPagosEfectuados.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPagosEfectuados.setBounds(641, 100, 147, 22);
        panelInformacionGeneral.add(lblPagosEfectuados);
        
        lblMes = new JLabel("Abril");
        lblMes.setForeground(new Color(255, 255, 255));
        lblMes.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblMes.setBounds(44, 41, 306, 34);
        panelInformacionGeneral.add(lblMes);
        
        txtSoliPendientes = new JTextField();
        txtSoliPendientes.setText("00");
        txtSoliPendientes.setHorizontalAlignment(SwingConstants.CENTER);
        txtSoliPendientes.setForeground(Color.WHITE);
        txtSoliPendientes.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        txtSoliPendientes.setEditable(false);
        txtSoliPendientes.setCaretColor(Color.WHITE);
        txtSoliPendientes.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
        txtSoliPendientes.setBackground(new Color(0, 0, 51));
        txtSoliPendientes.setBounds(477, 243, 91, 37);
        panelInformacionGeneral.add(txtSoliPendientes);
        
        JLabel lblSolicitudesPendientes = new JLabel("Soli. Pendientes:");
        lblSolicitudesPendientes.setForeground(Color.WHITE);
        lblSolicitudesPendientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblSolicitudesPendientes.setBounds(455, 211, 140, 22);
        panelInformacionGeneral.add(lblSolicitudesPendientes);
        
        txtSoliCompletadas = new JTextField();
        txtSoliCompletadas.setText("00");
        txtSoliCompletadas.setHorizontalAlignment(SwingConstants.CENTER);
        txtSoliCompletadas.setForeground(Color.WHITE);
        txtSoliCompletadas.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        txtSoliCompletadas.setEditable(false);
        txtSoliCompletadas.setCaretColor(Color.WHITE);
        txtSoliCompletadas.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
        txtSoliCompletadas.setBackground(new Color(0, 0, 51));
        txtSoliCompletadas.setBounds(666, 243, 91, 37);
        panelInformacionGeneral.add(txtSoliCompletadas);
        
        JLabel lblSolicitudesCompletadas = new JLabel("Soli. Completadas:");
        lblSolicitudesCompletadas.setForeground(Color.WHITE);
        lblSolicitudesCompletadas.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblSolicitudesCompletadas.setBounds(637, 211, 157, 22);
        panelInformacionGeneral.add(lblSolicitudesCompletadas);
        
        JLabel lblContratosActivos = new JLabel("Contratos Activos:");
        lblContratosActivos.setForeground(Color.WHITE);
        lblContratosActivos.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblContratosActivos.setBounds(44, 211, 147, 22);
        panelInformacionGeneral.add(lblContratosActivos);
        
        JLabel lblContratosCerrados = new JLabel("Contratos Cerrados:");
        lblContratosCerrados.setForeground(Color.WHITE);
        lblContratosCerrados.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblContratosCerrados.setBounds(235, 211, 157, 22);
        panelInformacionGeneral.add(lblContratosCerrados);
        
        txtContratosActivos = new JTextField();
        txtContratosActivos.setText("00");
        txtContratosActivos.setHorizontalAlignment(SwingConstants.CENTER);
        txtContratosActivos.setForeground(Color.WHITE);
        txtContratosActivos.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        txtContratosActivos.setEditable(false);
        txtContratosActivos.setCaretColor(Color.WHITE);
        txtContratosActivos.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
        txtContratosActivos.setBackground(new Color(0, 0, 51));
        txtContratosActivos.setBounds(72, 243, 91, 37);
        panelInformacionGeneral.add(txtContratosActivos);
        
        txtContratosCerrados = new JTextField();
        txtContratosCerrados.setText("00");
        txtContratosCerrados.setHorizontalAlignment(SwingConstants.CENTER);
        txtContratosCerrados.setForeground(Color.WHITE);
        txtContratosCerrados.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        txtContratosCerrados.setEditable(false);
        txtContratosCerrados.setCaretColor(Color.WHITE);
        txtContratosCerrados.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
        txtContratosCerrados.setBackground(new Color(0, 0, 51));
        txtContratosCerrados.setBounds(271, 243, 91, 37);
        panelInformacionGeneral.add(txtContratosCerrados);
        
        comboFiltros = new JComboBox<String>();
        comboFiltros.setForeground(Color.WHITE);
        comboFiltros.setFont(new Font("Segoe UI", Font.BOLD, 17));
        comboFiltros.setBackground(new Color(0, 0, 51));
        comboFiltros.setBounds(362, 41, 298, 28);
        panelInformacionGeneral.add(comboFiltros);

        comboFiltros.addItem("Mes Actual");
        comboFiltros.addItem("Últimos 3 meses");
        comboFiltros.addItem("Últimos 6 meses");
        comboFiltros.addItem("Último año");
        comboFiltros.addItem("Todos los Tiempos");
        
        btnFiltrar = new JButton("Filtrar");
        btnFiltrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
		        actualizarDashboard();
        	}
        });
        btnFiltrar.setForeground(Color.WHITE);
        btnFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        btnFiltrar.setFocusPainted(false);
        btnFiltrar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
        btnFiltrar.setBackground(new Color(0, 0, 51));
        btnFiltrar.setBounds(672, 41, 116, 28);
        panelInformacionGeneral.add(btnFiltrar);

		ImageIcon icon = new ImageIcon(PrincipalAdmin.class.getResource("/img/alticeblanco.png"));
		Image image = icon.getImage();
		actualizarDashboard();

	}
	private void actualizarDashboard() {
	    String filtro = (String) comboFiltros.getSelectedItem();
	    if (filtro == null) filtro = "Mes Actual";

	    LocalDate hoy = LocalDate.now();
	    LocalDate fechaInicioFiltro = null;

	    switch (filtro) {
	        case "Mes Actual":
	            fechaInicioFiltro = hoy.withDayOfMonth(1);
	            break;
	        case "Últimos 3 meses":
	            fechaInicioFiltro = hoy.minusMonths(3);
	            break;
	        case "Últimos 6 meses":
	            fechaInicioFiltro = hoy.minusMonths(6);
	            break;
	        case "Último año":
	            fechaInicioFiltro = hoy.minusYears(1);
	            break;
	        case "Todos los Tiempos":
	            fechaInicioFiltro = null;
	            break;
	    }

	    float montoPendiente = 0.0f;
	    int pagosPendientes = 0;
	    for (Pago p : Altice.getInstance().getMisPagos()) {
	        if (p.isPendiente() && p.isActivo()) {
	            montoPendiente += p.getMonto();
	            pagosPendientes++;
	        }
	    }

	    float montoCobrado = 0.0f;
	    int pagosEfectuados = 0;
	    for (Pago p : Altice.getInstance().getMisPagos()) {
	        if (!p.isPendiente() && p.isActivo() && p.getFechaPago() != null) {
	            if (fechaInicioFiltro == null || 
	                !p.getFechaPago().isBefore(fechaInicioFiltro)) {
	                montoCobrado += p.getMonto();
	                pagosEfectuados++;
	            }
	        }
	    }

	    int soliPendientes = 0;
	    int soliCompletadas = 0;
	    for (Solicitud s : Altice.getInstance().getMisSolicitudes()) {
	        if (s.getEstado() == EstadoSolicitud.PENDIENTE || s.getEstado() == EstadoSolicitud.EN_PROCESO) {
	            soliPendientes++;
	        } else if (s.isResuelto()) {
	            soliCompletadas++;
	        }
	    }

	    int contratosActivos = Altice.getInstance().contarContratosActivos();
	    int contratosCerrados = Altice.getInstance().contarContratosCerrados();


	    txtMontoPendiente.setText(String.format("RD$ %.2f", montoPendiente));
	    txtPagosPendientes.setText(String.format("%02d", pagosPendientes));
	    txtCobrado.setText(String.format("RD$ %.2f", montoCobrado));
	    txtPagosEfectuados.setText(String.format("%02d", pagosEfectuados));
	    txtSoliPendientes.setText(String.format("%02d", soliPendientes));
	    txtSoliCompletadas.setText(String.format("%02d", soliCompletadas));
	    txtContratosActivos.setText(String.format("%02d", contratosActivos));
	    txtContratosCerrados.setText(String.format("%02d", contratosCerrados));


	    if (filtro.equals("Mes Actual")) {
	        lblMes.setText(hoy.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")).toUpperCase());
	    } else if (filtro.equals("Último año")) {
	        lblMes.setText(String.valueOf(hoy.getYear()));
	    } else {
	        lblMes.setText(filtro);
	    }
	}
	private void cerrarSesion()
	{
		if(Altice.getSesion() == null)
		{
			return;
		}
        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Seguro que desea cerrar sesión?",
                "Cerrar Sesión",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (opcion != JOptionPane.YES_OPTION) return;
        
        Altice.getInstance().cerrarSesion();
        Login log = new Login();
        dispose();
        log.setVisible(true);
        Altice.getInstance().guardarDatos();
	}
	private void enviarBackup() {
	    try {
	        Socket nsfd = new Socket("localhost", 7000);
	        DataOutputStream salida = new DataOutputStream(nsfd.getOutputStream());

	        // Enviar comando para que el servidor sepa que es un respaldo
	        salida.writeUTF("BACKUP");

	        // Leer el archivo altice.dat y enviarlo byte por byte
	        FileInputStream fis = new FileInputStream("altice.dat");
	        int unByte;
	        while ((unByte = fis.read()) != -1) {
	            salida.write(unByte);
	        }

	        fis.close();
	        salida.close();
	        nsfd.close();

	        JOptionPane.showMessageDialog(this, 
	            "Respaldo enviado correctamente al servidor", 
	            "Éxito", JOptionPane.INFORMATION_MESSAGE);

	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, 
	            "Error al enviar el respaldo.\n" + e.getMessage(), 
	            "Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	    }
	}
}
