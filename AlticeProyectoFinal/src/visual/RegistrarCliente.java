package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Altice;
import logico.Cliente;
import logico.Rol;
import logico.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistrarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Cliente miCliente;
	private boolean cerrar;
	
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JPasswordField txtContra;
	private JPasswordField txtConfirmar;
	private JRadioButton rbPersona;
	private JRadioButton rbEmpresa;
	private JLabel lblCedula;
	
	private ButtonGroup groupTipoCliente;
	private JTextField txtCodigo;
	private JCheckBox checkActivo;
	private JButton btnMostrar;
	private JTextField txtContraVisible;
	private JTextField txtConfirmarVisible;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarCliente dialog = new RegistrarCliente(null, false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarCliente(Cliente client, boolean cerrarAlRegistrar) {
		miCliente = client;
		cerrar = cerrarAlRegistrar;
		setTitle("Registrar Cliente");
		
		if(miCliente != null)
			setTitle("Modificar Cliente");
		
		setResizable(false);
		setBounds(100, 100, 614, 568);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(0, 0, 51));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 0, 51));
			panel.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBackground(new Color(102, 102, 204));
				panel_1.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
				panel_1.setBounds(8, 112, 567, 297);
				panel.add(panel_1);
				{
					JLabel label = new JLabel("Nombre");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(12, 24, 56, 16);
					panel_1.add(label);
				}
				{
					txtNombre = new JTextField();
					txtNombre.setBackground(new Color(0, 0, 51));
					txtNombre.setForeground(Color.WHITE);
					txtNombre.setCaretColor(Color.WHITE);
					txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					txtNombre.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					txtNombre.setColumns(10);
					txtNombre.setBounds(12, 53, 263, 24);
					panel_1.add(txtNombre);
				}
				{
					lblCedula = new JLabel("Cedula");
					lblCedula.setForeground(Color.WHITE);
					lblCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					lblCedula.setBounds(12, 88, 56, 16);
					panel_1.add(lblCedula);
				}
				{
					txtCedula = new JTextField();
					txtCedula.addKeyListener(new KeyAdapter() {
						@Override
						public void keyTyped(KeyEvent e) {
							char tecla = e.getKeyChar();
							if(!Character.isDigit(tecla))
								e.consume();
						}
					});
					txtCedula.setBackground(new Color(0, 0, 51));
					txtCedula.setForeground(Color.WHITE);
					txtCedula.setCaretColor(Color.WHITE);
					txtCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					txtCedula.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					txtCedula.setColumns(10);
					txtCedula.setBounds(12, 117, 263, 24);
					panel_1.add(txtCedula);
				}
				{
					JLabel label = new JLabel("Telefono");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(12, 152, 56, 16);
					panel_1.add(label);
				}
				{
					txtTelefono = new JTextField();
					txtTelefono.addKeyListener(new KeyAdapter() {
						@Override
						public void keyTyped(KeyEvent e) {
							char tecla = e.getKeyChar();
							if(!Character.isDigit(tecla))
								e.consume();
						}
					});
					txtTelefono.setBackground(new Color(0, 0, 51));
					txtTelefono.setForeground(Color.WHITE);
					txtTelefono.setCaretColor(Color.WHITE);
					txtTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					txtTelefono.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					txtTelefono.setColumns(10);
					txtTelefono.setBounds(12, 181, 263, 24);
					panel_1.add(txtTelefono);
				}
				{
					JLabel label = new JLabel("Direccion");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(12, 216, 122, 16);
					panel_1.add(label);
				}
				{
					txtDireccion = new JTextField();
					txtDireccion.setBackground(new Color(0, 0, 51));
					txtDireccion.setForeground(Color.WHITE);
					txtDireccion.setCaretColor(Color.WHITE);
					txtDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					txtDireccion.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					txtDireccion.setColumns(10);
					txtDireccion.setBounds(12, 245, 263, 24);
					panel_1.add(txtDireccion);
				}
				{
					JLabel label = new JLabel("Correo electronico");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(287, 24, 122, 16);
					panel_1.add(label);
				}
				{
					txtCorreo = new JTextField();
					txtCorreo.setBackground(new Color(0, 0, 51));
					txtCorreo.setForeground(Color.WHITE);
					txtCorreo.setCaretColor(Color.WHITE);
					txtCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					txtCorreo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					txtCorreo.setColumns(10);
					txtCorreo.setBounds(287, 53, 263, 24);
					panel_1.add(txtCorreo);
				}
				{
					JLabel label = new JLabel("Contraseña");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(287, 88, 122, 16);
					panel_1.add(label);
				}
				{
					txtContra = new JPasswordField();
					txtContra.setBackground(new Color(0, 0, 51));
					txtContra.setForeground(Color.WHITE);
					txtContra.setCaretColor(Color.WHITE);
					txtContra.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					txtContra.setBounds(287, 117, 263, 24);
					panel_1.add(txtContra);
				}
				{
					JLabel label = new JLabel("Confirmar Contraseña");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(287, 152, 154, 16);
					panel_1.add(label);
				}
				{
					txtConfirmar = new JPasswordField();
					txtConfirmar.setBackground(new Color(0, 0, 51));
					txtConfirmar.setForeground(Color.WHITE);
					txtConfirmar.setCaretColor(Color.WHITE);
					txtConfirmar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					txtConfirmar.setBounds(287, 181, 263, 24);
					panel_1.add(txtConfirmar);
				}
				{
					btnMostrar = new JButton("Mostrar Contrase\u00F1a");
					btnMostrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(txtContra.isVisible())
							{
								txtContra.setVisible(false);
								txtConfirmar.setVisible(false);
								txtContraVisible.setText(txtContra.getText());
								txtContraVisible.setVisible(true);
								txtConfirmarVisible.setText(txtConfirmar.getText());
								txtConfirmarVisible.setVisible(true);
								
								txtContraVisible.setEditable(false);
								txtConfirmarVisible.setEditable(false);
								btnMostrar.setText("Ocultar contraseña");
							}
							else
							{
								txtContra.setVisible(true);
								txtConfirmar.setVisible(true);
								txtContraVisible.setVisible(false);
								txtConfirmarVisible.setVisible(false);
								btnMostrar.setText("Mostrar contraseña");
							}
						}
					});
					btnMostrar.setForeground(Color.WHITE);
					btnMostrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					btnMostrar.setFocusPainted(false);
					btnMostrar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					btnMostrar.setBackground(new Color(0, 0, 51));
					btnMostrar.setBounds(405, 259, 145, 25);
					panel_1.add(btnMostrar);
				}
				{
					txtContraVisible = new JTextField();
					txtContraVisible.setForeground(Color.WHITE);
					txtContraVisible.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					txtContraVisible.setColumns(10);
					txtContraVisible.setCaretColor(Color.WHITE);
					txtContraVisible.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					txtContraVisible.setBackground(new Color(0, 0, 51));
					txtContraVisible.setBounds(287, 118, 263, 24);
					panel_1.add(txtContraVisible);
					txtContraVisible.setVisible(false);
				}
				{
					txtConfirmarVisible = new JTextField();
					txtConfirmarVisible.setForeground(Color.WHITE);
					txtConfirmarVisible.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					txtConfirmarVisible.setColumns(10);
					txtConfirmarVisible.setCaretColor(Color.WHITE);
					txtConfirmarVisible.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					txtConfirmarVisible.setBackground(new Color(0, 0, 51));
					txtConfirmarVisible.setBounds(287, 182, 263, 24);
					panel_1.add(txtConfirmarVisible);
					txtConfirmarVisible.setVisible(false);
				}
			}
			{
				rbPersona = new JRadioButton("Persona");
				rbPersona.setForeground(Color.WHITE);
				rbPersona.setBackground(new Color(0, 0, 51));
				rbPersona.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				rbPersona.setSelected(true);
				rbPersona.setBounds(8, 78, 82, 25);
				panel.add(rbPersona);
				
				rbPersona.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						lblCedula.setText("Cedula");
					}
				});
			}
			{
				rbEmpresa = new JRadioButton("Empresa");
				rbEmpresa.setForeground(Color.WHITE);
				rbEmpresa.setBackground(new Color(0, 0, 51));
				rbEmpresa.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				rbEmpresa.setBounds(94, 78, 127, 25);
				panel.add(rbEmpresa);
				{
					checkActivo = new JCheckBox("Activo");
					checkActivo.setSelected(true);
					checkActivo.setForeground(Color.WHITE);
					checkActivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
					checkActivo.setBackground(new Color(102, 102, 204));
					checkActivo.setBounds(260, 427, 77, 25);
					panel.add(checkActivo);
				}
				{
					JLabel lblCdigo = new JLabel("C\u00F3digo");
					lblCdigo.setForeground(Color.WHITE);
					lblCdigo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					lblCdigo.setBounds(12, 16, 56, 16);
					panel.add(lblCdigo);
				}
				{
					txtCodigo = new JTextField();
					txtCodigo.setEditable(false);
					txtCodigo.setForeground(Color.WHITE);
					txtCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					txtCodigo.setColumns(10);
					txtCodigo.setCaretColor(Color.WHITE);
					txtCodigo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					txtCodigo.setBackground(new Color(0, 0, 51));
					txtCodigo.setBounds(12, 45, 112, 24);
					panel.add(txtCodigo);
					txtCodigo.setText(String.format("CL-%05d", Altice.getGenClienteid()));
				}
				
				rbEmpresa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						lblCedula.setText("RNC");
					}
				});
			}
		}
		
		groupTipoCliente = new ButtonGroup();
		groupTipoCliente.add(rbPersona);
		groupTipoCliente.add(rbEmpresa);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 0, 51));
			buttonPane.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						registrarCliente();
					}
				});
				btnAceptar.setForeground(Color.WHITE);
				btnAceptar.setBackground(new Color(0, 0, 51));
				btnAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				btnAceptar.setFocusPainted(false);
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setForeground(Color.WHITE);
				btnCancelar.setBackground(new Color(102, 0, 0));
				btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				btnCancelar.setFocusPainted(false);
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		if(miCliente == null)
		{
			checkActivo.setSelected(true);
			checkActivo.setVisible(false);
		}
		loadCliente();
	}
	private void registrarCliente() {
	    
	    if (miCliente != null) {
	        if (registrar()) {
	            JOptionPane.showMessageDialog(this, "Cliente modificado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	            
	            if (checkActivo.isSelected()) {
	                miCliente.getUsuario().setFechaDesactivacion(null);
	            } else {
	                Altice.getInstance().desactivarCliente(miCliente.getCodigo());
	            }
	            dispose();
	        }
	        return;
	    }

	    int opcion = JOptionPane.showConfirmDialog(this,
	            "¿Desea registrar este cliente?",
	            "Confirmar Registro",
	            JOptionPane.YES_NO_OPTION,
	            JOptionPane.QUESTION_MESSAGE);

	    if (opcion != JOptionPane.YES_OPTION) {
	        return;
	    }

	    if (registrar()) {
	        JOptionPane.showMessageDialog(this, "Cliente registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	        
	        if (cerrar) {
	            dispose();                    
	        } else {
	            clean();                      
	            txtNombre.requestFocus();
	        }
	    }
	}
	private boolean registrar() {
	    if (!validar()) {
	        return false;
	    }

	    String codigo = txtCodigo.getText();
	    String nombre = txtNombre.getText().trim();
	    String cedula = txtCedula.getText().trim();
	    String telefono = txtTelefono.getText().trim();
	    String direccion = txtDireccion.getText().trim();
	    String correo = txtCorreo.getText().trim();
	    String contra = new String(txtContra.getPassword());

	    Usuario user = new Usuario(codigo, correo, contra, Rol.CLIENTE);
	    user.setActivo(checkActivo.isSelected());
	    user.setEmpresa(rbEmpresa.isSelected());

	    Cliente nuevo = new Cliente(nombre, cedula, telefono, direccion, correo, user);

	    if (miCliente == null) {
	        return Altice.getInstance().registrarCliente(nuevo);
	    } else {
	        return Altice.getInstance().modificarCliente(nuevo);
	    }
	}

	private boolean validar() {
	    if (txtNombre.getText().trim().isEmpty() ||
	        txtCedula.getText().trim().isEmpty() ||
	        txtTelefono.getText().trim().isEmpty() ||
	        txtDireccion.getText().trim().isEmpty() ||
	        txtCorreo.getText().trim().isEmpty() ||
	        txtContra.getPassword().length == 0) {

	        JOptionPane.showMessageDialog(this, "Debe llenar todos los campos!", "Error", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

	    if (!txtContra.getText().equals(txtConfirmar.getText())) {
	        JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
	        txtConfirmar.requestFocus();
	        return false;
	    }

	    if (miCliente == null) {
	        if (Altice.getInstance().buscarClienteByCedula(txtCedula.getText().trim()) != null) {
	            JOptionPane.showMessageDialog(this, "Ya existe un cliente con esta cédula", "Error", JOptionPane.ERROR_MESSAGE);
	            txtCedula.requestFocus();
	            return false;
	        }
	    }

	    return true;
	}

	private void clean() {
	    txtNombre.setText("");
	    txtCedula.setText("");
	    txtTelefono.setText("");
	    txtDireccion.setText("");
	    txtCorreo.setText("");
	    txtContra.setText("");
	    txtConfirmar.setText("");
	    checkActivo.setSelected(true);
	    rbPersona.setSelected(true);
	    lblCedula.setText("Cedula");

	    txtCodigo.setText(String.format("CL-%05d", Altice.getGenClienteid()));
	}

	private void loadCliente() {
	    if (miCliente == null) return;

	    txtCodigo.setText(miCliente.getCodigo());
	    txtNombre.setText(miCliente.getNombre());
	    txtCedula.setText(miCliente.getCedula());
	    txtTelefono.setText(miCliente.getTelefono());
	    txtDireccion.setText(miCliente.getDireccion());
	    txtCorreo.setText(miCliente.getEmail());

	    txtContra.setText(miCliente.getUsuario().getPassword());
	    txtConfirmar.setText(miCliente.getUsuario().getPassword());

	    checkActivo.setSelected(miCliente.getUsuario() != null && miCliente.getUsuario().isActivo());
	    if(miCliente.getUsuario().isEmpresa())
	    {
	    	rbEmpresa.setSelected(true);
	    	lblCedula.setText("RNC");
	    }
	}
}