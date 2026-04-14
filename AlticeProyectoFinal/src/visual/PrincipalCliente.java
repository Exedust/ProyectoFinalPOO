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

public class PrincipalCliente extends JFrame {

	private Dimension dim;
	
	private JPanel contentPane;
	private JLabel lblBienvenido;
	private JPanel cardSolicitudes;
	private JTextField txtMontoDeuda;
	private JTextField txtPagosPendientes;
	private JPanel panelDeuda;
	private JComboBox<String> comboPagosPendientes;
	private JButton btnPagar;

	
	public PrincipalCliente() {
		try {
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalCliente.class.getResource("/img/alticelogo.png")));
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
			lblBienvenido.setText("Bienvenido, "+Altice.getInstance().buscarClienteById((Altice.getSesion().getCodigo())).getNombre());
		
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
		ImageIcon clientesIcon = new ImageIcon(PrincipalCliente.class.getResource("/img/cliente.png"));
		Image clientesImage = clientesIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon contratosIcon = new ImageIcon(PrincipalCliente.class.getResource("/img/contrato.png"));
		Image contratosImage = contratosIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon pagosIcon = new ImageIcon(PrincipalCliente.class.getResource("/img/pago.png"));
        Image pagosImage = pagosIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        
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
        
        JButton btnVer = new JButton("Ver");
        btnVer.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ListarSolicitudesCliente gestion = new ListarSolicitudesCliente();
        		gestion.setModal(true);
        		gestion.setVisible(true);
        	}
        });
        btnVer.setForeground(Color.WHITE);
        btnVer.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnVer.setBackground(new Color(0, 0, 51));
        cardSolicitudes.add(btnVer, BorderLayout.SOUTH);
        
        JLabel iconSolicitudes = new JLabel();
        iconSolicitudes.setHorizontalAlignment(SwingConstants.CENTER);
        cardSolicitudes.add(iconSolicitudes, BorderLayout.CENTER);
		ImageIcon solicitudesIcon = new ImageIcon(PrincipalCliente.class.getResource("/img/solicitud.png"));
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
		ImageIcon detallesIcon = new ImageIcon(PrincipalCliente.class.getResource("/img/usuario.png"));
		Image detallesImage = detallesIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		iconDetalles.setIcon(new ImageIcon(detallesImage));
		panel_1.add(iconDetalles);
		
		JButton btnVerDetalles = new JButton("Ver Detalles");
		btnVerDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Altice.getInstance().getRolUsuarioLogueado() == Rol.CLIENTE)
				{
					DetallesCliente nuevo = new DetallesCliente(Altice.getInstance().buscarClienteById(Altice.getSesion().getCodigo()));
					nuevo.setModal(true);
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
		comprobarDeuda();
	} catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Ocurrió un error al cargar la pantalla principal de administrador.\n\n" +
                "Detalles: " + e.getMessage(),
                "Error al abrir Altice",
                JOptionPane.ERROR_MESSAGE);
            
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

	private void comprobarDeuda() {
		if(Altice.getSesion() == null)
			return;
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

