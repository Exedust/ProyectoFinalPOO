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
import logico.Pago;
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
import java.util.ArrayList;
import java.awt.LayoutManager;
import javax.swing.JComboBox;

public class PrincipalEmpleado extends JFrame {

	private Dimension dim;
	
	private JPanel contentPane;
	private JLabel lblBienvenido;
	private JPanel cardClientes;
	private JPanel cardContratos;
	private JPanel cardPagos;
	private JPanel cardSolicitudes;
	private JTextField txtMontoDeuda;
	private JTextField txtPagosPendientes;
	private JPanel panelDeuda;
	private JComboBox<String> comboPagosPendientes;
	private JButton btnPagar;

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
					cerrarSesion();				
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
		panel.setLayout(null);

		JPanel dashboardPanel = new JPanel();
		dashboardPanel.setBounds(0, 0, 1904, 240);
		dashboardPanel.setBackground(new Color(0, 0, 51));
		GridBagLayout gbl_dashboardPanel = new GridBagLayout();
		gbl_dashboardPanel.rowWeights = new double[]{1.0};
		gbl_dashboardPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		dashboardPanel.setLayout(gbl_dashboardPanel);
		panel.add(dashboardPanel);

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
				comprobarDeuda();
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
		
		JPanel panel_1 = new JPanel((LayoutManager) null);
		panel_1.setPreferredSize(new Dimension(220, 200));
		panel_1.setBorder(new TitledBorder(null, "Mis Detalles", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 16), Color.WHITE));
		panel_1.setBackground(new Color(102, 102, 204));
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.ipadx = 20;
		gbc_panel_1.insets = new Insets(20, 20, 20, 20);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 5;
		gbc_panel_1.gridy = 0;
		dashboardPanel.add(panel_1, gbc_panel_1);
		
		JLabel iconDetalles = new JLabel();
		iconDetalles.setHorizontalAlignment(SwingConstants.CENTER);
		iconDetalles.setBounds(6, 23, 228, 138);
		ImageIcon detallesIcon = new ImageIcon(PrincipalEmpleado.class.getResource("/img/usuario.png"));
		Image detallesImage = detallesIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		iconDetalles.setIcon(new ImageIcon(detallesImage));
		panel_1.add(iconDetalles);
		
		JButton btnVerDetalles = new JButton("Ver Detalles");
		btnVerDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Altice.getInstance().getRolUsuarioLogueado() == Rol.TECNICO)
				{
					DetallesTecnico nuevo = new DetallesTecnico(Altice.getInstance().buscarEmpleadoById(Altice.getSesion().getCodigo()));
					nuevo.setModal(true);
					nuevo.setVisible(true);
				}
				if(Altice.getInstance().getRolUsuarioLogueado() == Rol.COMERCIAL)
				{
					DetallesComercial nuevo = new DetallesComercial(Altice.getInstance().buscarEmpleadoById(Altice.getSesion().getCodigo()));
					nuevo.setModal(true);;
					nuevo.setVisible(true);
				}
				comprobarDeuda();
			}
		});
		btnVerDetalles.setForeground(Color.WHITE);
		btnVerDetalles.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnVerDetalles.setBackground(new Color(0, 0, 51));
		btnVerDetalles.setBounds(6, 163, 228, 29);
		panel_1.add(btnVerDetalles);
		
		panelDeuda = new JPanel((LayoutManager) null);
		panelDeuda.setPreferredSize(new Dimension(220, 200));
		panelDeuda.setBorder(new TitledBorder(null, "Mi Deuda", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 16), Color.WHITE));
		panelDeuda.setBackground(new Color(102, 102, 204));
		panelDeuda.setBounds(660, 271, 590, 220);
		panel.add(panelDeuda);
		panelDeuda.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Monto:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(67, 40, 69, 22);
		panelDeuda.add(lblNewLabel);
		
		txtMontoDeuda = new JTextField();
		txtMontoDeuda.setHorizontalAlignment(SwingConstants.CENTER);
		txtMontoDeuda.setForeground(Color.WHITE);
		txtMontoDeuda.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		txtMontoDeuda.setEditable(false);
		txtMontoDeuda.setCaretColor(Color.WHITE);
		txtMontoDeuda.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
		txtMontoDeuda.setBackground(new Color(0, 0, 51));
		txtMontoDeuda.setBounds(134, 32, 124, 37);
		panelDeuda.add(txtMontoDeuda);
		
		JLabel label = new JLabel("Seleccionar Pago Pendiente");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		label.setBounds(190, 85, 200, 28);
		panelDeuda.add(label);
		
		comboPagosPendientes = new JComboBox<String>();
		comboPagosPendientes.setForeground(Color.WHITE);
		comboPagosPendientes.setFont(new Font("Segoe UI", Font.BOLD, 16));
		comboPagosPendientes.setBackground(new Color(0, 0, 51));
		comboPagosPendientes.setBounds(24, 126, 536, 40);
		panelDeuda.add(comboPagosPendientes);
		
		btnPagar = new JButton("Realizar Pago");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarPagoSeleccionado();
				
			}
		});
		btnPagar.setForeground(Color.WHITE);
		btnPagar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnPagar.setFocusPainted(false);
		btnPagar.setBackground(new Color(0, 0, 51));
		btnPagar.setBounds(432, 179, 128, 28);
		panelDeuda.add(btnPagar);
		
		JLabel lblPagosPendientes = new JLabel("Pagos Pendientes:");
		lblPagosPendientes.setForeground(Color.WHITE);
		lblPagosPendientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPagosPendientes.setBounds(279, 39, 147, 22);
		panelDeuda.add(lblPagosPendientes);
		
		txtPagosPendientes = new JTextField();
		txtPagosPendientes.setHorizontalAlignment(SwingConstants.CENTER);
		txtPagosPendientes.setForeground(Color.WHITE);
		txtPagosPendientes.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		txtPagosPendientes.setEditable(false);
		txtPagosPendientes.setCaretColor(Color.WHITE);
		txtPagosPendientes.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
		txtPagosPendientes.setBackground(new Color(0, 0, 51));
		txtPagosPendientes.setBounds(424, 35, 91, 37);
		panelDeuda.add(txtPagosPendientes);
		comprobarRol();
		comprobarDeuda();
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
	private void comprobarDeuda() {
	    String cedula = Altice.getInstance().buscarCedulaById(Altice.getSesion().getCodigo());

	    if (!Altice.getInstance().tieneContratoActivo(cedula)) {
	        panelDeuda.setVisible(false);
	        return;
	    }

	    panelDeuda.setVisible(true);

	    float deuda = Altice.getInstance().calcularDeudaCedula(cedula);
	    int cantidadPendientes = Altice.getInstance().contarPagosPendientesPorCedula(cedula);

	    txtMontoDeuda.setText(String.format("RD$ %.2f", deuda));
	    txtPagosPendientes.setText(String.format("%02d", cantidadPendientes));

	    comboPagosPendientes.removeAllItems();

	    ArrayList<Pago> pagosPendientes = Altice.getInstance().getPagosPendientesByCedula(cedula);

	    if (pagosPendientes.isEmpty()) {
	        comboPagosPendientes.addItem("No hay pagos pendientes");
	        btnPagar.setEnabled(false);
	        return;
	    }

	    for (Pago p : pagosPendientes) {
	        String item = p.getCodigo() + " - Monto: RD$ " + String.format("%.2f", p.getMonto())
	                    + " - Fecha: " + p.getFechaRegistro();
	        comboPagosPendientes.addItem(item);
	    }

	    btnPagar.setEnabled(true);
	}
	
	private void realizarPagoSeleccionado() {
	    if (comboPagosPendientes.getSelectedItem() == null ||
	        comboPagosPendientes.getSelectedItem().toString().contains("No hay")) {
	        
	        JOptionPane.showMessageDialog(this, 
	            "No hay pagos pendientes para realizar.", 
	            "Información", JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }

	    String itemSeleccionado = (String) comboPagosPendientes.getSelectedItem();
	    
	    String codigoPago = itemSeleccionado.split(" - ")[0].trim();

	    Pago pagoSeleccionado = Altice.getInstance().buscarPagoByCodigo(codigoPago);

	    if (pagoSeleccionado == null) {
	        JOptionPane.showMessageDialog(this, "No se encontró el pago seleccionado.", 
	            "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    RegistrarPagoDirecto reg = new RegistrarPagoDirecto(pagoSeleccionado);
	    reg.setModal(true);
	    reg.setVisible(true);

	    comprobarDeuda();
	}
}

