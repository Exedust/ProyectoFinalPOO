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
import logico.Rol;

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
import java.awt.LayoutManager;

public class PrincipalEmpleado extends JFrame {

	private Dimension dim;
	
	private JPanel contentPane;
	private JLabel lblBienvenido;
	private JPanel cardClientes;
	private JPanel cardContratos;
	private JPanel cardPagos;
	private JPanel cardSolicitudes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalEmpleado frame = new PrincipalEmpleado();
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
	public PrincipalEmpleado() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(Altice.getSesion() != null)
				{
					Altice.getInstance().guardarDatos();					
				}
			}
		});
		setBackground(new Color(0, 0, 51));
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalEmpleado.class.getResource("/img/alticelogo.png")));
		setTitle("Altice");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 671);
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height - 50);
		setLocationRelativeTo(null);
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel dashboardPanel = new JPanel();
		dashboardPanel.setBackground(new Color(0, 0, 51));
		GridBagLayout gbl_dashboardPanel = new GridBagLayout();
		gbl_dashboardPanel.rowWeights = new double[]{1.0};
		gbl_dashboardPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		dashboardPanel.setLayout(gbl_dashboardPanel);
		panel.add(dashboardPanel, BorderLayout.NORTH);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20, 20, 20, 20);
		gbc.fill = GridBagConstraints.BOTH;
		
		GridBagConstraints gbc_cardClientes = new GridBagConstraints();
		gbc_cardClientes.ipadx = 20;
		gbc_cardClientes.insets = new Insets(20, 20, 20, 20);
		gbc_cardClientes.fill = GridBagConstraints.BOTH;
		gbc_cardClientes.gridx = 1;
		gbc_cardClientes.gridy = 0;

		cardClientes = new JPanel(new BorderLayout());
		cardClientes.setBackground(new Color(102, 102, 204));
		cardClientes.setBorder(new TitledBorder(null, "Clientes", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 16), Color.WHITE));
		cardClientes.setPreferredSize(new Dimension(220, 200));

		JLabel iconClientes = new JLabel();
		iconClientes.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon clientesIcon = new ImageIcon(PrincipalEmpleado.class.getResource("/img/cliente.png"));
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

		dashboardPanel.add(cardClientes, gbc_cardClientes);

		GridBagConstraints gbc_cardContratos = new GridBagConstraints();
		gbc_cardContratos.ipadx = 20;
		gbc_cardContratos.insets = new Insets(20, 20, 20, 20);
		gbc_cardContratos.fill = GridBagConstraints.BOTH;
		gbc_cardContratos.gridx = 2;
		gbc_cardContratos.gridy = 0;

		cardContratos = new JPanel(new BorderLayout());
		cardContratos.setBackground(new Color(102, 102, 204));
		cardContratos.setBorder(new TitledBorder(null, "Contratos", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 16), Color.WHITE));
		cardContratos.setPreferredSize(new Dimension(220, 200));

		JLabel iconContratos = new JLabel();
		iconContratos.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon contratosIcon = new ImageIcon(PrincipalEmpleado.class.getResource("/img/contrato.png"));
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

		dashboardPanel.add(cardContratos, gbc_cardContratos);
		GridBagConstraints gbc_cardPagos = new GridBagConstraints();
		gbc_cardPagos.ipadx = 20;
        gbc_cardPagos.gridx = 3;
        gbc_cardPagos.gridy = 0;
        gbc_cardPagos.insets = new Insets(20, 20, 20, 20);
        gbc_cardPagos.fill = GridBagConstraints.BOTH;
        cardPagos = new JPanel(new BorderLayout());
        cardPagos.setBackground(new Color(102, 102, 204));
        cardPagos.setBorder(new TitledBorder(null, "Pagos", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 16), Color.WHITE));
        cardPagos.setPreferredSize(new Dimension(220, 200));
        JLabel iconPagos = new JLabel();
        iconPagos.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon pagosIcon = new ImageIcon(PrincipalEmpleado.class.getResource("/img/pago.png"));
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
        dashboardPanel.add(cardPagos, gbc_cardPagos);
        
        cardSolicitudes = new JPanel((LayoutManager) null);
        cardSolicitudes.setPreferredSize(new Dimension(220, 200));
        cardSolicitudes.setBorder(new TitledBorder(null, "Solicitudes", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 16), Color.WHITE));
        cardSolicitudes.setBackground(new Color(102, 102, 204));
        GridBagConstraints gbc_cardSolicitudes = new GridBagConstraints();
        gbc_cardSolicitudes.ipadx = 20;
        gbc_cardSolicitudes.insets = new Insets(20, 20, 20, 20);
        gbc_cardSolicitudes.fill = GridBagConstraints.BOTH;
        gbc_cardSolicitudes.gridx = 4;
        gbc_cardSolicitudes.gridy = 0;
        dashboardPanel.add(cardSolicitudes, gbc_cardSolicitudes);
        cardSolicitudes.setLayout(new BorderLayout());
        
        JButton button = new JButton("Gestionar");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		GestionSolicitudes gestion = new GestionSolicitudes();
        		gestion.setModal(true);
        		gestion.setVisible(true);
        	}
        });
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        button.setBackground(new Color(0, 0, 51));
        cardSolicitudes.add(button, BorderLayout.SOUTH);
        
        JLabel iconSolicitudes = new JLabel();
        iconSolicitudes.setHorizontalAlignment(SwingConstants.CENTER);
        cardSolicitudes.add(iconSolicitudes, BorderLayout.CENTER);
		ImageIcon solicitudesIcon = new ImageIcon(PrincipalEmpleado.class.getResource("/img/solicitud.png"));
		Image solicitudesImage = solicitudesIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		iconSolicitudes.setIcon(new ImageIcon(solicitudesImage));
		comprobarRol();
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
	private void comprobarRol()
	{
		if(Altice.getInstance().getRolUsuarioLogueado() == Rol.TECNICO)
		{
			cardClientes.setVisible(false);
			cardContratos.setVisible(false);
			cardPagos.setVisible(false);
			
		}
	}
}
