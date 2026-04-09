package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Altice;
import logico.Empleado;
import logico.Rol;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class GestionEmpleados extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtCedula;
    private JTextField txtNombre;
    private JButton btnBuscarNombre;
    private static JTable table;
    
	private static DefaultTableModel model;
	private static Object[] row;
	
	private Empleado selected = null;
	private JButton btnBuscarCedula;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnDesactivar;
	private JButton btnDetalles;
	private static JComboBox<String> comboFiltrar;
	

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            GestionEmpleados dialog = new GestionEmpleados();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public GestionEmpleados() {
        setTitle("Gestionar Empleados");
        setResizable(false);
        setBounds(100, 100, 1280, 770);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0, 0, 51));
        getContentPane().setLayout(new BorderLayout());
        
        contentPanel.setBackground(new Color(0, 0, 51));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        {
            JPanel panel = new JPanel();
            panel.setBackground(new Color(102, 102, 204));
            panel.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            panel.setBounds(12, 145, 1102, 496);
            contentPanel.add(panel);
            panel.setLayout(new BorderLayout(0, 0));
            
            JScrollPane scrollPane = new JScrollPane();
            panel.add(scrollPane, BorderLayout.CENTER);
            
            table = new JTable();
            table.setFillsViewportHeight(true);
    		table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            
    		String[] headers = {
    				"ID",
    				"Cédula",
    				"Nombre",
    				"Telefono",
    				"Correo",
    				"Rol",
    				"Salario",
    				"Fecha de Registro"
    		};
    		
    		model = new DefaultTableModel() {
    			@Override
    			public boolean isCellEditable(int row, int column) {
    				return false;
    			}
    			
    		};
    		model.setColumnIdentifiers(headers);
    		table.setModel(model);
    		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
    		scrollPane.setViewportView(table);
    		table.addMouseListener(new MouseAdapter() {
    			@Override
    			public void mouseClicked(MouseEvent e) {

    				int ind = table.getSelectedRow();

    				if (ind != -1) {

    					selected = Altice.getInstance().buscarEmpleadoById(table.getValueAt(ind, 0).toString());

    					btnModificar.setEnabled(true);
    					if(selected.isActivo())
    						btnDesactivar.setEnabled(true);
    					
    					btnDetalles.setEnabled(true);
    				}
    			}
    		});
        }

        {
            txtCedula = new JTextField();
            txtCedula.setBackground(new Color(0, 0, 51));
            txtCedula.setForeground(Color.WHITE);
            txtCedula.setCaretColor(Color.WHITE);
            txtCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            txtCedula.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            txtCedula.setBounds(12, 110, 232, 24);
            contentPanel.add(txtCedula);
            txtCedula.setColumns(10);
        }
        {
            txtNombre = new JTextField();
            txtNombre.setBackground(new Color(0, 0, 51));
            txtNombre.setForeground(Color.WHITE);
            txtNombre.setCaretColor(Color.WHITE);
            txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            txtNombre.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            txtNombre.setBounds(388, 110, 232, 24);
            contentPanel.add(txtNombre);
            txtNombre.setColumns(10);
        }
        {
            btnBuscarNombre = new JButton("Buscar");
            btnBuscarNombre.setForeground(Color.WHITE);
            btnBuscarNombre.setBackground(new Color(0, 0, 51));
            btnBuscarNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnBuscarNombre.setFocusPainted(false);
            btnBuscarNombre.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnBuscarNombre.setBounds(632, 109, 97, 25);
            contentPanel.add(btnBuscarNombre);
        }
        {
            comboFiltrar = new JComboBox<String>();
            comboFiltrar.setModel(new DefaultComboBoxModel<String>(new String[] {"Todos", "T\u00E9cnicos", "Comerciales", "Administradores", "Inactivos"}));
            comboFiltrar.setBackground(new Color(0, 0, 51));
            comboFiltrar.setForeground(Color.WHITE);
            comboFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            comboFiltrar.setBounds(797, 110, 208, 24);
            contentPanel.add(comboFiltrar);
        }
        {
            JButton btnFiltrar = new JButton("Filtrar");
            btnFiltrar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		loadEmpleados();
            	}
            });
            btnFiltrar.setForeground(Color.WHITE);
            btnFiltrar.setBackground(new Color(0, 0, 51));
            btnFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnFiltrar.setFocusPainted(false);
            btnFiltrar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnFiltrar.setBounds(1017, 110, 97, 25);
            contentPanel.add(btnFiltrar);
        }

        {
            JLabel lblNewLabel = new JLabel("Cedula");
            lblNewLabel.setForeground(Color.WHITE);
            lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblNewLabel.setBounds(12, 88, 56, 16);
            contentPanel.add(lblNewLabel);
        }
        {
            JLabel lblNewLabel_1 = new JLabel("Nombre");
            lblNewLabel_1.setForeground(Color.WHITE);
            lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblNewLabel_1.setBounds(388, 88, 56, 16);
            contentPanel.add(lblNewLabel_1);
        }
        {
            JLabel lblEmpleadosRegistrados = new JLabel("Empleados registrados: 00");
            lblEmpleadosRegistrados.setForeground(Color.WHITE);
            lblEmpleadosRegistrados.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblEmpleadosRegistrados.setBounds(12, 23, 216, 16);
            contentPanel.add(lblEmpleadosRegistrados);
        }
        {
            JLabel lblTecnicosRegistrados = new JLabel("Tecnicos registrados: 00");
            lblTecnicosRegistrados.setForeground(Color.WHITE);
            lblTecnicosRegistrados.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblTecnicosRegistrados.setBounds(12, 59, 216, 16);
            contentPanel.add(lblTecnicosRegistrados);
        }
        {
            JLabel label = new JLabel("Comerciales registrados: 00");
            label.setForeground(Color.WHITE);
            label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            label.setBounds(240, 59, 216, 16);
            contentPanel.add(label);
        }
        {
            JLabel lblAdministradoresRegistrados = new JLabel("Administradores registrados: 00");
            lblAdministradoresRegistrados.setForeground(Color.WHITE);
            lblAdministradoresRegistrados.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblAdministradoresRegistrados.setBounds(468, 59, 216, 16);
            contentPanel.add(lblAdministradoresRegistrados);
        }

        {
            btnAgregar = new JButton("Agregar");
            btnAgregar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		RegistrarEmpleado registrar = new RegistrarEmpleado(null);
            		registrar.setModal(true);
            		registrar.setVisible(true);
            		loadEmpleados();
            	}
            });
            btnAgregar.setForeground(Color.WHITE);
            btnAgregar.setBackground(new Color(0, 0, 51));
            btnAgregar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnAgregar.setFocusPainted(false);
            btnAgregar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnAgregar.setBounds(1143, 145, 97, 25);
            contentPanel.add(btnAgregar);
        }
        {
            btnModificar = new JButton("Modificar");
            btnModificar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		if(selected != null)
            		{
            			RegistrarEmpleado modificar = new RegistrarEmpleado(selected);
            			modificar.setModal(true);
            			modificar.setVisible(true);
            			loadEmpleados();
            			btnModificar.setEnabled(false);
            			btnDesactivar.setEnabled(false);
            			btnDetalles.setEnabled(false);
            		}
            	}
            });
            btnModificar.setForeground(Color.WHITE);
            btnModificar.setBackground(new Color(0, 0, 51));
            btnModificar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnModificar.setFocusPainted(false);
            btnModificar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnModificar.setBounds(1143, 183, 97, 25);
            contentPanel.add(btnModificar);
            btnModificar.setEnabled(false);
        }
        {
            btnDesactivar = new JButton("Desactivar");
            btnDesactivar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		desactivar();
            		loadEmpleados();
        			btnModificar.setEnabled(false);
        			btnDesactivar.setEnabled(false);
        			btnDetalles.setEnabled(false);
            	}
            });
            btnDesactivar.setForeground(Color.WHITE);
            btnDesactivar.setBackground(new Color(102, 0, 0)); 
            btnDesactivar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnDesactivar.setFocusPainted(false);
            btnDesactivar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnDesactivar.setBounds(1143, 221, 97, 25);
            contentPanel.add(btnDesactivar);
            btnDesactivar.setEnabled(false);
        }
        {
            btnDetalles = new JButton("Detalles");
            btnDetalles.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		if(selected.getRol()==Rol.COMERCIAL || selected.getRol() == Rol.ADMINISTRADOR)
            		{
            			DetallesComercial detalles = new DetallesComercial(selected);
            			detalles.setModal(true);
            			detalles.setVisible(true);
            		}
            		if(selected.getRol()==Rol.TECNICO)
            		{
            			DetallesTecnico detalles = new DetallesTecnico(selected);
            			detalles.setModal(true);
            			detalles.setVisible(true);
            		}
            		
            		btnDetalles.setEnabled(false);
            	}
            });
            btnDetalles.setForeground(Color.WHITE);
            btnDetalles.setBackground(new Color(0, 0, 51));
            btnDetalles.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnDetalles.setFocusPainted(false);
            btnDetalles.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnDetalles.setBounds(1143, 302, 97, 25);
            contentPanel.add(btnDetalles);
            btnDetalles.setEnabled(false);
        }
        
        btnBuscarCedula = new JButton("Buscar");
        btnBuscarCedula.setForeground(Color.WHITE);
        btnBuscarCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        btnBuscarCedula.setFocusPainted(false);
        btnBuscarCedula.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
        btnBuscarCedula.setBackground(new Color(0, 0, 51));
        btnBuscarCedula.setBounds(257, 107, 97, 25);
        contentPanel.add(btnBuscarCedula);

        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(0, 0, 51));
            buttonPane.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                    TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            JButton btnSalir = new JButton("Salir");
            btnSalir.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		dispose();
            	}
            });
            btnSalir.setForeground(Color.WHITE);
            btnSalir.setBackground(new Color(102, 0, 0));
            btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btnSalir.setFocusPainted(false);
            btnSalir.setActionCommand("Cancel");
            buttonPane.add(btnSalir);
        }
        loadEmpleados();
    }
    
    public static void loadEmpleados() {
        model.setRowCount(0);
        row = new Object[table.getColumnCount()];

        String filtro = comboFiltrar.getSelectedItem().toString();

        for (Empleado emp : Altice.getInstance().getMisEmpleados()) {
            boolean incluir = false;

            switch (filtro) {
                case "Todos":
                    incluir = emp.isActivo();
                    break;
                case "Técnicos":
                    incluir = emp.getRol() == Rol.TECNICO && emp.isActivo();
                    break;
                case "Comerciales":
                    incluir = emp.getRol() == Rol.COMERCIAL && emp.isActivo();
                    break;
                case "Administradores":
                    incluir = emp.getRol() == Rol.ADMINISTRADOR && emp.isActivo();
                    break;
                case "Inactivos":
                    incluir = !emp.getUsuario().isActivo();
                    break;
            }

            if (incluir) {
                row[0] = emp.getCodigo();
                row[1] = emp.getCedula();
                row[2] = emp.getNombre();
                row[3] = emp.getTelefono();
                row[4] = emp.getEmail();
                row[5] = emp.getRol().name();
                row[6] = emp.getSalario();
                row[7] = emp.getUsuario().getFechaRegistro();
                model.addRow(row);
            }
        }
    }
    
    public void desactivar()
    {
    	if(selected != null)
		{
	        int opcion = JOptionPane.showConfirmDialog(this,
	                "¿Desea desactivar este empleado?",
	                "Desactivar Empleado",
	                JOptionPane.YES_NO_OPTION,
	                JOptionPane.QUESTION_MESSAGE);

	        if (opcion != JOptionPane.YES_OPTION) 
	        	return;
	        Altice.getInstance().desactivarEmpleado(selected.getCodigo());
	        JOptionPane.showMessageDialog(this, "Empleado desactivado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		}
    }
}