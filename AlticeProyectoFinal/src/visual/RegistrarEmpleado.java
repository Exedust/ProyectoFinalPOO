package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import logico.Altice;
import logico.Empleado;
import logico.Rol;
import logico.Usuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistrarEmpleado extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private Empleado miEmpleado;

    private JTextField txtNombre;
    private JTextField txtCedula;
    private JTextField txtTelefono;
    private JTextField txtDireccion;
    private JTextField txtCorreo;
    private JPasswordField txtContra;
    private JPasswordField txtConfirmContra;
    private JLabel lblCedula;
    private JRadioButton rdbtnTecnico;
    private JRadioButton rdbtnComercial;
    private JRadioButton rdbtnAdministrador;
    private ButtonGroup groupTipoEmpleado;
    private JLabel lblSalario;
    private JSpinner spinnerSalario;
    private JLabel lblComision;
    private JSpinner spinnerComision;
    private JCheckBox checkActivo;
    private JTextField txtCodigo;
    private JLabel label_1;
    private JButton btnCancelar;
    private JLabel lblConfirmarContra;
    private JButton btnMostrar;
    private JTextField txtConfirmarVisible;
    private JTextField txtContraVisible;

    public RegistrarEmpleado(Empleado emp) {
        miEmpleado = emp;
        setTitle("Registrar Empleado");
        if (miEmpleado != null) {
            setTitle("Modificar Empleado");
        }
        setResizable(false);
        setBounds(100, 100, 614, 710);
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
            panel.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                    TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            contentPanel.add(panel, BorderLayout.CENTER);
            panel.setLayout(null);

            // ====================== PANEL DATOS PERSONALES ======================
            {
                JPanel panelDatos = new JPanel();
                panelDatos.setLayout(null);
                panelDatos.setBackground(new Color(102, 102, 204));
                panelDatos.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                panelDatos.setBounds(12, 86, 567, 297);
                panel.add(panelDatos);

                {
                    JLabel label = new JLabel("Nombre");
                    label.setForeground(Color.WHITE);
                    label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    label.setBounds(12, 24, 56, 16);
                    panelDatos.add(label);
                }
                {
                    txtNombre = new JTextField();
                    txtNombre.setBackground(new Color(0, 0, 51));
                    txtNombre.setForeground(Color.WHITE);
                    txtNombre.setCaretColor(Color.WHITE);
                    txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtNombre.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtNombre.setBounds(12, 53, 263, 24);
                    txtNombre.addKeyListener(new KeyAdapter() {
                        public void keyTyped(KeyEvent e) {
                            if (Character.isDigit(e.getKeyChar())) e.consume();
                        }
                    });
                    panelDatos.add(txtNombre);
                }

                {
                    lblCedula = new JLabel("Cedula");
                    lblCedula.setForeground(Color.WHITE);
                    lblCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblCedula.setBounds(12, 88, 56, 16);
                    panelDatos.add(lblCedula);
                }
                {
                    txtCedula = new JTextField();
                    txtCedula.setBackground(new Color(0, 0, 51));
                    txtCedula.setForeground(Color.WHITE);
                    txtCedula.setCaretColor(Color.WHITE);
                    txtCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtCedula.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtCedula.setBounds(12, 117, 263, 24);
                    txtCedula.addKeyListener(new KeyAdapter() {
                        public void keyTyped(KeyEvent e) {
                            if (!Character.isDigit(e.getKeyChar()) || txtCedula.getText().length() >= 11)
                                e.consume();
                        }
                    });
                    panelDatos.add(txtCedula);
                }

                {
                    JLabel label = new JLabel("Telefono");
                    label.setForeground(Color.WHITE);
                    label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    label.setBounds(12, 152, 56, 16);
                    panelDatos.add(label);
                }
                {
                    txtTelefono = new JTextField();
                    txtTelefono.setBackground(new Color(0, 0, 51));
                    txtTelefono.setForeground(Color.WHITE);
                    txtTelefono.setCaretColor(Color.WHITE);
                    txtTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtTelefono.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtTelefono.setBounds(12, 181, 263, 24);
                    txtTelefono.addKeyListener(new KeyAdapter() {
                        public void keyTyped(KeyEvent e) {
                            if (!Character.isDigit(e.getKeyChar()) || txtTelefono.getText().length() >= 10)
                                e.consume();
                        }
                    });
                    panelDatos.add(txtTelefono);
                }

                {
                    JLabel label = new JLabel("Direccion");
                    label.setForeground(Color.WHITE);
                    label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    label.setBounds(12, 216, 122, 16);
                    panelDatos.add(label);
                }
                {
                    txtDireccion = new JTextField();
                    txtDireccion.setBackground(new Color(0, 0, 51));
                    txtDireccion.setForeground(Color.WHITE);
                    txtDireccion.setCaretColor(Color.WHITE);
                    txtDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtDireccion.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtDireccion.setBounds(12, 245, 263, 24);
                    panelDatos.add(txtDireccion);
                }

                {
                    JLabel label = new JLabel("Correo electronico");
                    label.setForeground(Color.WHITE);
                    label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    label.setBounds(287, 24, 122, 16);
                    panelDatos.add(label);
                }
                {
                    txtCorreo = new JTextField();
                    txtCorreo.setBackground(new Color(0, 0, 51));
                    txtCorreo.setForeground(Color.WHITE);
                    txtCorreo.setCaretColor(Color.WHITE);
                    txtCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtCorreo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtCorreo.setBounds(287, 53, 263, 24);
                    panelDatos.add(txtCorreo);
                }

                {
                    JLabel label = new JLabel("Contraseña");
                    label.setForeground(Color.WHITE);
                    label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    label.setBounds(287, 88, 122, 16);
                    panelDatos.add(label);
                }
                {
                    txtContra = new JPasswordField();
                    txtContra.setBackground(new Color(0, 0, 51));
                    txtContra.setForeground(Color.WHITE);
                    txtContra.setCaretColor(Color.WHITE);
                    txtContra.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtContra.setBounds(287, 117, 263, 24);
                    panelDatos.add(txtContra);
                }

                {
                    lblConfirmarContra = new JLabel("Confirmar Contraseña");
                    lblConfirmarContra.setForeground(Color.WHITE);
                    lblConfirmarContra.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblConfirmarContra.setBounds(287, 152, 154, 16);
                    panelDatos.add(lblConfirmarContra);
                }
                {
                    txtConfirmContra = new JPasswordField();
                    txtConfirmContra.setBackground(new Color(0, 0, 51));
                    txtConfirmContra.setForeground(Color.WHITE);
                    txtConfirmContra.setCaretColor(Color.WHITE);
                    txtConfirmContra.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtConfirmContra.setBounds(287, 181, 263, 24);
                    panelDatos.add(txtConfirmContra);
                }

                // Botón Mostrar Contraseña
                {
                    btnMostrar = new JButton("Mostrar Contraseña");
                    btnMostrar.addActionListener(e -> {
                        if (txtContra.isVisible()) {
                            txtContra.setVisible(false);
                            txtConfirmContra.setVisible(false);
                            txtContraVisible.setText(new String(txtContra.getPassword()));
                            txtConfirmarVisible.setText(new String(txtConfirmContra.getPassword()));
                            txtContraVisible.setVisible(true);
                            txtConfirmarVisible.setVisible(true);
                            btnMostrar.setText("Ocultar Contraseña");
                        } else {
                            txtContra.setVisible(true);
                            txtConfirmContra.setVisible(true);
                            txtContraVisible.setVisible(false);
                            txtConfirmarVisible.setVisible(false);
                            btnMostrar.setText("Mostrar Contraseña");
                        }
                    });
                    btnMostrar.setForeground(Color.WHITE);
                    btnMostrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    btnMostrar.setFocusPainted(false);
                    btnMostrar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    btnMostrar.setBackground(new Color(0, 0, 51));
                    btnMostrar.setBounds(405, 245, 145, 25);
                    panelDatos.add(btnMostrar);
                }

                {
                    txtContraVisible = new JTextField();
                    txtContraVisible.setForeground(Color.WHITE);
                    txtContraVisible.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtContraVisible.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtContraVisible.setBackground(new Color(0, 0, 51));
                    txtContraVisible.setBounds(287, 118, 263, 24);
                    txtContraVisible.setVisible(false);
                    panelDatos.add(txtContraVisible);
                }
                {
                    txtConfirmarVisible = new JTextField();
                    txtConfirmarVisible.setForeground(Color.WHITE);
                    txtConfirmarVisible.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtConfirmarVisible.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtConfirmarVisible.setBackground(new Color(0, 0, 51));
                    txtConfirmarVisible.setBounds(287, 182, 263, 24);
                    txtConfirmarVisible.setVisible(false);
                    panelDatos.add(txtConfirmarVisible);
                }
            }

            // ====================== PANEL TIPO EMPLEADO ======================
            {
                JPanel panelTipo = new JPanel();
                panelTipo.setBackground(new Color(102, 102, 204));
                panelTipo.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                        TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
                panelTipo.setBounds(141, 396, 324, 143);
                panel.add(panelTipo);
                panelTipo.setLayout(null);

                rdbtnTecnico = new JRadioButton("Técnico");
                rdbtnTecnico.setForeground(Color.WHITE);
                rdbtnTecnico.setBackground(new Color(102, 102, 204));
                rdbtnTecnico.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                rdbtnTecnico.setSelected(true);
                rdbtnTecnico.setBounds(19, 9, 82, 25);
                panelTipo.add(rdbtnTecnico);

                rdbtnComercial = new JRadioButton("Comercial");
                rdbtnComercial.setForeground(Color.WHITE);
                rdbtnComercial.setBackground(new Color(102, 102, 204));
                rdbtnComercial.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                rdbtnComercial.setBounds(19, 55, 96, 25);
                panelTipo.add(rdbtnComercial);

                rdbtnAdministrador = new JRadioButton("Administrador");
                rdbtnAdministrador.setForeground(Color.WHITE);
                rdbtnAdministrador.setBackground(new Color(102, 102, 204));
                rdbtnAdministrador.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                rdbtnAdministrador.setBounds(19, 101, 131, 25);
                panelTipo.add(rdbtnAdministrador);

                lblSalario = new JLabel("Salario");
                lblSalario.setForeground(Color.WHITE);
                lblSalario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblSalario.setBounds(185, 9, 47, 16);
                panelTipo.add(lblSalario);

                spinnerSalario = new JSpinner();
                spinnerSalario.setBounds(185, 38, 82, 22);
                panelTipo.add(spinnerSalario);

                lblComision = new JLabel("Comisión");
                lblComision.setForeground(Color.WHITE);
                lblComision.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblComision.setBounds(185, 73, 59, 16);
                panelTipo.add(lblComision);

                spinnerComision = new JSpinner();
                spinnerComision.setBounds(185, 102, 82, 22);
                panelTipo.add(spinnerComision);

                groupTipoEmpleado = new ButtonGroup();
                groupTipoEmpleado.add(rdbtnTecnico);
                groupTipoEmpleado.add(rdbtnComercial);
                groupTipoEmpleado.add(rdbtnAdministrador);

                ActionListener tipoListener = e -> {
                    boolean esTecnico = rdbtnTecnico.isSelected();
                    lblComision.setVisible(!esTecnico);
                    spinnerComision.setVisible(!esTecnico);
                };
                rdbtnTecnico.addActionListener(tipoListener);
                rdbtnComercial.addActionListener(tipoListener);
                rdbtnAdministrador.addActionListener(tipoListener);
            }

            {
                checkActivo = new JCheckBox("Activo");
                checkActivo.setSelected(true);
                checkActivo.setForeground(Color.WHITE);
                checkActivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
                checkActivo.setBackground(new Color(102, 102, 204));
                checkActivo.setBounds(264, 556, 77, 25);
                panel.add(checkActivo);
            }

            {
                txtCodigo = new JTextField();
                txtCodigo.setEditable(false);
                txtCodigo.setForeground(Color.WHITE);
                txtCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtCodigo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtCodigo.setBackground(new Color(0, 0, 51));
                txtCodigo.setBounds(12, 42, 112, 24);
                txtCodigo.setText(String.format("E-%05d", Altice.getGenEmpleadoid()));
                panel.add(txtCodigo);
            }

            {
                label_1 = new JLabel("Código");
                label_1.setForeground(Color.WHITE);
                label_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                label_1.setBounds(12, 13, 56, 16);
                panel.add(label_1);
            }
        }

        // ====================== BOTONES INFERIORES ======================
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(0, 0, 51));
            buttonPane.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                    TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            JButton btnAceptar = new JButton("Aceptar");
            btnAceptar.addActionListener(e -> registrarEmpleado());
            btnAceptar.setForeground(Color.WHITE);
            btnAceptar.setBackground(new Color(0, 0, 51));
            btnAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btnAceptar.setFocusPainted(false);
            buttonPane.add(btnAceptar);
            getRootPane().setDefaultButton(btnAceptar);

            btnCancelar = new JButton("Cancelar");
            btnCancelar.addActionListener(e -> dispose());
            btnCancelar.setForeground(Color.WHITE);
            btnCancelar.setBackground(new Color(102, 0, 0));
            btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btnCancelar.setFocusPainted(false);
            buttonPane.add(btnCancelar);
        }

        if (miEmpleado != null) {
            loadEmpleado();
            txtCedula.setEnabled(false);
            txtCorreo.setEnabled(false);
            txtNombre.setEnabled(false);
        } else {
            clean();
            checkActivo.setVisible(false);
        }

        lblComision.setVisible(false);
        spinnerComision.setVisible(false);
    }

    private void registrarEmpleado() {
        if (miEmpleado != null) {
            if (registrar()) {
                JOptionPane.showMessageDialog(this, "Empleado modificado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                if (checkActivo.isSelected()) {
                    miEmpleado.getUsuario().setFechaDesactivacion(null);
                } else {
                    Altice.getInstance().desactivarEmpleado(miEmpleado.getCodigo());
                }
                dispose();
            }
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea registrar este empleado?",
                "Confirmar Registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (opcion != JOptionPane.YES_OPTION) return;

        if (registrar()) {
            JOptionPane.showMessageDialog(this, "Empleado registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            clean();
            txtNombre.requestFocus();
        }
    }

    private boolean registrar() {
        if (!validar()) return false;

        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText().trim();
        String cedula = txtCedula.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String correo = txtCorreo.getText().trim();
        String contra = new String(txtContra.getPassword());
        float salario = ((Number) spinnerSalario.getValue()).floatValue();
        float comision = ((Number) spinnerComision.getValue()).floatValue();

        Rol tipo = Rol.TECNICO;
        if (rdbtnComercial.isSelected()) tipo = Rol.COMERCIAL;
        if (rdbtnAdministrador.isSelected()) tipo = Rol.ADMINISTRADOR;

        Usuario user = new Usuario(codigo, correo, contra, tipo);
        user.setActivo(checkActivo.isSelected());

        Empleado nuevo = new Empleado(nombre, cedula, correo, telefono, direccion, user, comision, salario);

        if (miEmpleado == null) {
            return Altice.getInstance().registrarEmpleado(nuevo);
        } else {
            return Altice.getInstance().modificarEmpleado(nuevo);
        }
    }

    private boolean validar() {
        String nombre = txtNombre.getText().trim();
        String cedula = txtCedula.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String correo = txtCorreo.getText().trim();
        String contra = new String(txtContra.getPassword());
        String confirmar = new String(txtConfirmContra.getPassword());

        if (nombre.isEmpty() || cedula.isEmpty() || telefono.isEmpty() ||
            direccion.isEmpty() || correo.isEmpty() || contra.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos!", "Error", JOptionPane.ERROR_MESSAGE);
            if (nombre.isEmpty()) txtNombre.requestFocus();
            else if (cedula.isEmpty()) txtCedula.requestFocus();
            else if (telefono.isEmpty()) txtTelefono.requestFocus();
            else if (direccion.isEmpty()) txtDireccion.requestFocus();
            else if (correo.isEmpty()) txtCorreo.requestFocus();
            else txtContra.requestFocus();
            return false;
        }

        if (!contra.equals(confirmar)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
            txtConfirmContra.requestFocus();
            return false;
        }

        if (cedula.length() != 11) {
            JOptionPane.showMessageDialog(this, "La cédula debe tener exactamente 11 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
            txtCedula.requestFocus();
            return false;
        }

        if (!cedula.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "La cédula solo debe contener números", "Error", JOptionPane.ERROR_MESSAGE);
            txtCedula.requestFocus();
            return false;
        }

        if (telefono.length() != 10) {
            JOptionPane.showMessageDialog(this, "El teléfono debe tener exactamente 10 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
            txtTelefono.requestFocus();
            return false;
        }

        if (!telefono.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "El teléfono solo debe contener números", "Error", JOptionPane.ERROR_MESSAGE);
            txtTelefono.requestFocus();
            return false;
        }

        if (!correo.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]{2,}$")) {
            JOptionPane.showMessageDialog(this, "El formato del correo no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
            txtCorreo.requestFocus();
            return false;
        }

        if (((Number) spinnerSalario.getValue()).floatValue() <= 0) {
            JOptionPane.showMessageDialog(this, "El salario debe ser mayor a 0", "Error", JOptionPane.ERROR_MESSAGE);
            spinnerSalario.requestFocus();
            return false;
        }

        if (miEmpleado == null) {
            if (Altice.getInstance().buscarPersonaByCedula(cedula) != null) {
                JOptionPane.showMessageDialog(this, "Esta cédula ya ha sido registrada.", "Error", JOptionPane.ERROR_MESSAGE);
                txtCedula.requestFocus();
                return false;
            }
            if (Altice.getInstance().existeCorreo(correo)) {
                JOptionPane.showMessageDialog(this, "Este correo ya ha sido registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                txtCorreo.requestFocus();
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
        txtConfirmContra.setText("");
        txtContraVisible.setText("");
        txtConfirmarVisible.setText("");

        spinnerSalario.setValue(0);
        spinnerComision.setValue(0);

        checkActivo.setSelected(true);
        rdbtnTecnico.setSelected(true);

        txtCodigo.setText(String.format("E-%05d", Altice.getGenEmpleadoid()));

        // Forzar estado inicial: contraseñas ocultas
        txtContra.setVisible(true);
        txtConfirmContra.setVisible(true);
        txtContraVisible.setVisible(false);
        txtConfirmarVisible.setVisible(false);
        btnMostrar.setText("Mostrar Contraseña");

        lblComision.setVisible(false);
        spinnerComision.setVisible(false);

        txtNombre.requestFocus();
    }

    private void loadEmpleado() {
        if (miEmpleado == null) return;

        txtCodigo.setText(miEmpleado.getCodigo());
        txtNombre.setText(miEmpleado.getNombre());
        txtCedula.setText(miEmpleado.getCedula());
        txtTelefono.setText(miEmpleado.getTelefono());
        txtDireccion.setText(miEmpleado.getDireccion());
        txtCorreo.setText(miEmpleado.getEmail());

        String password = miEmpleado.getUsuario() != null ? miEmpleado.getUsuario().getPassword() : "";
        txtContra.setText(password);
        txtConfirmContra.setText(password);

        spinnerSalario.setValue(miEmpleado.getSalario());
        spinnerComision.setValue(miEmpleado.getComision() != null ? miEmpleado.getComision() : 0);

        checkActivo.setSelected(miEmpleado.getUsuario() != null && miEmpleado.getUsuario().isActivo());

        Rol rol = miEmpleado.getRol();
        if (rol == Rol.TECNICO) rdbtnTecnico.setSelected(true);
        else if (rol == Rol.COMERCIAL) rdbtnComercial.setSelected(true);
        else if (rol == Rol.ADMINISTRADOR) rdbtnAdministrador.setSelected(true);

        lblComision.setVisible(!rdbtnTecnico.isSelected());
        spinnerComision.setVisible(!rdbtnTecnico.isSelected());

        // Forzar contraseñas ocultas en modo modificar
        txtContra.setVisible(true);
        txtConfirmContra.setVisible(true);
        txtContraVisible.setVisible(false);
        txtConfirmarVisible.setVisible(false);
        btnMostrar.setText("Mostrar Contraseña");
    }
}