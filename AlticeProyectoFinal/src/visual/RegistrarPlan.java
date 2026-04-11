package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import logico.Altice;
import logico.Plan;
import logico.TipoServicio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class RegistrarPlan extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private Plan miPlan;
    
    private JTextField txtNombre;          
    private JTextPane txtDescripcion;            
    private JTextField txtCostoTotal;         

    private JCheckBox chkbxInternet;
    private JCheckBox chckbxCable;
    private JCheckBox chckbxTelefonia;

    private JPanel panelInternet;
    private JPanel panelCable;
    private JPanel panelMovil;
    private JSpinner spnBajada;
    private JSpinner spnSubida;
    private JSpinner spnPrecioInternet;
    private JCheckBox checkPackBasico;
    private JCheckBox checkPackHD;
    private JSpinner spnPrecioCable;
    private JSpinner spnMinutos;
    private JButton btnCancelar;
    private JButton btnAceptar;
    private JSpinner spnPrecioMovil;
    private JSpinner spnGigas;
    private JCheckBox checkActivo;
    private JLabel label;
    private JTextField txtCodigo;

    public static void main(String[] args) {
        try {
            RegistrarPlan dialog = new RegistrarPlan(null);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RegistrarPlan(Plan plan) {
    	miPlan = plan;
    	
        setTitle("Registrar Plan");
        if(miPlan != null)
        	setTitle("Modificar Plan");
        
        setResizable(false);
        setBounds(100, 100, 595, 770);
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

            // ====================== INFORMACIÓN GENERAL ======================
            {
                JPanel panelGeneral = new JPanel();
                panelGeneral.setLayout(null);
                panelGeneral.setBackground(new Color(102, 102, 204));
                panelGeneral.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                panelGeneral.setBounds(22, 42, 510, 207);
                panel.add(panelGeneral);

                {
                    JLabel lblNombre = new JLabel("Nombre");
                    lblNombre.setForeground(Color.WHITE);
                    lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblNombre.setBounds(227, 13, 56, 16);
                    panelGeneral.add(lblNombre);
                }
                {
                    txtNombre = new JTextField();
                    txtNombre.setBackground(new Color(0, 0, 51));
                    txtNombre.setForeground(Color.WHITE);
                    txtNombre.setCaretColor(Color.WHITE);
                    txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtNombre.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtNombre.setBounds(81, 42, 347, 24);
                    panelGeneral.add(txtNombre);
                }

                {
                    JLabel lblDescripcion = new JLabel("Descripcion");
                    lblDescripcion.setForeground(Color.WHITE);
                    lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblDescripcion.setBounds(218, 89, 74, 16);
                    panelGeneral.add(lblDescripcion);
                }
                {
                    txtDescripcion = new JTextPane();
                    txtDescripcion.setBackground(new Color(0, 0, 51));
                    txtDescripcion.setForeground(Color.WHITE);
                    txtDescripcion.setCaretColor(Color.WHITE);
                    txtDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtDescripcion.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtDescripcion.setBounds(72, 118, 365, 64);
                    panelGeneral.add(txtDescripcion);
                }
            }

            // ====================== SERVICIOS INCLUIDOS ======================
            {
                JPanel panelServicios = new JPanel();
                panelServicios.setLayout(null);
                panelServicios.setBackground(new Color(102, 102, 204));
                panelServicios.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true),
                        "Servicios Incluidos", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
                panelServicios.setBounds(22, 261, 510, 71);
                panel.add(panelServicios);

                {
                    chkbxInternet = new JCheckBox("Internet");
                    chkbxInternet.setForeground(Color.WHITE);
                    chkbxInternet.setBackground(new Color(102, 102, 204));
                    chkbxInternet.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    chkbxInternet.setBounds(68, 26, 86, 25);
                    panelServicios.add(chkbxInternet);
                }
                {
                    chckbxCable = new JCheckBox("Cable");
                    chckbxCable.setForeground(Color.WHITE);
                    chckbxCable.setBackground(new Color(102, 102, 204));
                    chckbxCable.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    chckbxCable.setBounds(212, 26, 86, 25);
                    panelServicios.add(chckbxCable);
                }
                {
                    chckbxTelefonia = new JCheckBox("Movil");
                    chckbxTelefonia.setForeground(Color.WHITE);
                    chckbxTelefonia.setBackground(new Color(102, 102, 204));
                    chckbxTelefonia.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    chckbxTelefonia.setBounds(363, 26, 75, 25);
                    panelServicios.add(chckbxTelefonia);
                }
            }

            // ====================== PANEL INTERNET ======================
            {
                panelInternet = new JPanel();
                panelInternet.setLayout(null);
                panelInternet.setBackground(new Color(102, 102, 204));
                panelInternet.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true),
                        "Internet", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
                panelInternet.setBounds(22, 345, 137, 232);
                panel.add(panelInternet);

                {
                    JLabel lblBajada = new JLabel("Bajada (Mbps)");
                    lblBajada.setForeground(Color.WHITE);
                    lblBajada.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblBajada.setBounds(23, 30, 91, 16);
                    panelInternet.add(lblBajada);
                }
                {
                    spnBajada = new JSpinner();
                    spnBajada.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
                    spnBajada.setForeground(Color.WHITE);
                    spnBajada.setBackground(new Color(51, 51, 102));
                    spnBajada.setBounds(23, 59, 91, 22);
                    panelInternet.add(spnBajada);
                }
                {
                    JLabel lblSubida = new JLabel("Subida (Mbps)");
                    lblSubida.setForeground(Color.WHITE);
                    lblSubida.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblSubida.setBounds(23, 94, 91, 16);
                    panelInternet.add(lblSubida);
                }
                {
                    spnSubida = new JSpinner();
                    spnSubida.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
                    spnSubida.setForeground(Color.WHITE);
                    spnSubida.setBackground(new Color(51, 51, 102));
                    spnSubida.setBounds(23, 123, 91, 22);
                    panelInternet.add(spnSubida);
                }
                {
                    JLabel lblPrecio = new JLabel("Precio");
                    lblPrecio.setForeground(Color.WHITE);
                    lblPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblPrecio.setBounds(45, 158, 46, 16);
                    panelInternet.add(lblPrecio);
                }
                {
                    spnPrecioInternet = new JSpinner();
                    spnPrecioInternet.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
                    spnPrecioInternet.setForeground(Color.WHITE);
                    spnPrecioInternet.setBackground(new Color(51, 51, 102));
                    spnPrecioInternet.setBounds(23, 186, 91, 22);
                    panelInternet.add(spnPrecioInternet);
                }
            }

            // ====================== PANEL CABLE ======================
            {
                panelCable = new JPanel();
                panelCable.setLayout(null);
                panelCable.setBackground(new Color(102, 102, 204));
                panelCable.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true),
                        "Cable", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
                panelCable.setBounds(214, 345, 137, 232);
                panel.add(panelCable);

                {
                    JLabel lblPrecio = new JLabel("Precio");
                    lblPrecio.setForeground(Color.WHITE);
                    lblPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblPrecio.setBounds(46, 158, 45, 16);
                    panelCable.add(lblPrecio);
                }
                {
                    spnPrecioCable = new JSpinner();
                    spnPrecioCable.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
                    spnPrecioCable.setForeground(Color.WHITE);
                    spnPrecioCable.setBackground(new Color(51, 51, 102));
                    spnPrecioCable.setBounds(23, 186, 91, 22);
                    panelCable.add(spnPrecioCable);
                }
                {
                    checkPackBasico = new JCheckBox("Pack básico");
                    checkPackBasico.setForeground(Color.WHITE);
                    checkPackBasico.setBackground(new Color(102, 102, 204));
                    checkPackBasico.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    checkPackBasico.setBounds(16, 45, 105, 25);
                    panelCable.add(checkPackBasico);
                }
                {
                    checkPackHD = new JCheckBox("Pack HD");
                    checkPackHD.setForeground(Color.WHITE);
                    checkPackHD.setBackground(new Color(102, 102, 204));
                    checkPackHD.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    checkPackHD.setBounds(12, 110, 113, 25);
                    panelCable.add(checkPackHD);
                }
            }

            // ====================== PANEL MOVIL ======================
            {
                panelMovil = new JPanel();
                panelMovil.setLayout(null);
                panelMovil.setBackground(new Color(102, 102, 204));
                panelMovil.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true),
                        "Movil", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
                panelMovil.setBounds(395, 345, 137, 232);
                panel.add(panelMovil);

                {
                    JLabel lblMinutos = new JLabel("Minutos");
                    lblMinutos.setForeground(Color.WHITE);
                    lblMinutos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblMinutos.setBounds(40, 30, 56, 16);
                    panelMovil.add(lblMinutos);
                }
                {
                    spnMinutos = new JSpinner();
                    spnMinutos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
                    spnMinutos.setForeground(Color.WHITE);
                    spnMinutos.setBackground(new Color(51, 51, 102));
                    spnMinutos.setBounds(23, 59, 91, 22);
                    panelMovil.add(spnMinutos);
                }
                {
                    JLabel lblGigas = new JLabel("Gigas");
                    lblGigas.setForeground(Color.WHITE);
                    lblGigas.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblGigas.setBounds(49, 94, 39, 16);
                    panelMovil.add(lblGigas);
                }
                {
                    spnGigas = new JSpinner();
                    spnGigas.setForeground(Color.WHITE);
                    spnGigas.setBackground(new Color(51, 51, 102));
                    spnGigas.setBounds(23, 123, 91, 22);
                    panelMovil.add(spnGigas);
                }
                {
                    JLabel lblPrecio = new JLabel("Precio");
                    lblPrecio.setForeground(Color.WHITE);
                    lblPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblPrecio.setBounds(49, 158, 39, 16);
                    panelMovil.add(lblPrecio);
                }
                {
                    spnPrecioMovil = new JSpinner();
                    spnPrecioMovil.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
                    spnPrecioMovil.setForeground(Color.WHITE);
                    spnPrecioMovil.setBackground(new Color(51, 51, 102));
                    spnPrecioMovil.setBounds(23, 186, 91, 22);
                    panelMovil.add(spnPrecioMovil);
                }
            }

            // ====================== COSTO TOTAL ======================
            {
                JPanel panelCosto = new JPanel();
                panelCosto.setLayout(null);
                panelCosto.setBackground(new Color(102, 102, 204));
                panelCosto.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true),
                        "Costo Total", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
                panelCosto.setBounds(22, 590, 510, 61);
                panel.add(panelCosto);

                {
                    txtCostoTotal = new JTextField();
                    txtCostoTotal.setHorizontalAlignment(SwingConstants.CENTER);
                    txtCostoTotal.setEditable(false);
                    txtCostoTotal.setBackground(new Color(0, 0, 51));
                    txtCostoTotal.setForeground(Color.WHITE);
                    txtCostoTotal.setCaretColor(Color.WHITE);
                    txtCostoTotal.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtCostoTotal.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtCostoTotal.setBounds(197, 24, 116, 24);
                    panelCosto.add(txtCostoTotal);
                }
                
                checkActivo = new JCheckBox("Activo");
                checkActivo.setBounds(410, 23, 77, 25);
                panelCosto.add(checkActivo);
                checkActivo.setSelected(true);
                checkActivo.setForeground(Color.WHITE);
                checkActivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
                checkActivo.setBackground(new Color(102, 102, 204));
            }
            {
            	label = new JLabel("C\u00F3digo");
            	label.setForeground(Color.WHITE);
            	label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            	label.setBounds(22, 13, 56, 16);
            	panel.add(label);
            }
            {
            	txtCodigo = new JTextField();
            	txtCodigo.setForeground(Color.WHITE);
            	txtCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            	txtCodigo.setEditable(false);
            	txtCodigo.setColumns(10);
            	txtCodigo.setCaretColor(Color.WHITE);
            	txtCodigo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            	txtCodigo.setBackground(new Color(0, 0, 51));
            	txtCodigo.setBounds(77, 9, 112, 24);
            	panel.add(txtCodigo);
            	txtCodigo.setText(String.format("PL-%05d", Altice.getGenPlanid()));
            }
        }

        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(0, 0, 51));
            buttonPane.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                    TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            btnAceptar = new JButton("Aceptar");
            btnAceptar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		registrarPlan();
            	}
            });
            btnAceptar.setForeground(Color.WHITE);
            btnAceptar.setBackground(new Color(0, 0, 51));
            btnAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btnAceptar.setFocusPainted(false);
            btnAceptar.setActionCommand("OK");
            buttonPane.add(btnAceptar);
            getRootPane().setDefaultButton(btnAceptar);

            btnCancelar = new JButton("Cancelar");
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
        // ====================== LISTENERS ======================
        ActionListener servicioListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelInternet.setVisible(chkbxInternet.isSelected());
                panelCable.setVisible(chckbxCable.isSelected());
                panelMovil.setVisible(chckbxTelefonia.isSelected());

                if (!chkbxInternet.isSelected()) {
                    spnBajada.setValue(0);
                    spnSubida.setValue(0);
                    spnPrecioInternet.setValue(0);
                }
                if (!chckbxCable.isSelected()) {
                    checkPackBasico.setSelected(false);
                    checkPackHD.setSelected(false);
                    spnPrecioCable.setValue(0);
                }
                if (!chckbxTelefonia.isSelected()) {
                    spnMinutos.setValue(0);
                    spnGigas.setValue(0);
                    spnPrecioMovil.setValue(0);
                }
                actualizarCostoTotal();
            }
        };

        ChangeListener cambioListener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                actualizarCostoTotal();
            }
        };

        spnPrecioInternet.addChangeListener(cambioListener);
        spnPrecioCable.addChangeListener(cambioListener);
        spnPrecioMovil.addChangeListener(cambioListener);

        chkbxInternet.addActionListener(servicioListener);
        chckbxCable.addActionListener(servicioListener);
        chckbxTelefonia.addActionListener(servicioListener);

        panelInternet.setVisible(false);
        panelCable.setVisible(false);
        panelMovil.setVisible(false);

        chkbxInternet.setEnabled(false);  
        chckbxCable.setEnabled(false);
        chckbxTelefonia.setEnabled(false);

        comprobarServicios();
        actualizarCostoTotal();

        if (miPlan != null) {
            loadPlan(miPlan);
            checkActivo.setVisible(true);
        } else {
            checkActivo.setVisible(false);
            txtCodigo.setText(String.format("PL-%05d", Altice.getGenPlanid()));
        }
    }
    
    private void registrarPlan() {
        if (miPlan != null) {
            if (registrar()) {
                JOptionPane.showMessageDialog(this, "Plan modificado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	            if (!checkActivo.isSelected()) {
	                Altice.getInstance().desactivarPlan(miPlan.getCodigo());
	            }
	            dispose();
            }
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea registrar este plan?",
                "Confirmar Registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opcion != JOptionPane.YES_OPTION) {
            return;
        }

        if (registrar()) {
            JOptionPane.showMessageDialog(this, "Plan registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            clean();
            txtNombre.requestFocus();
            
        }
    }

    private boolean registrar() {
        if (!validar()) {
            return false;
        }

        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText().trim();
        String descripcion = txtDescripcion.getText().trim();

        Plan nuevo;

        if (miPlan == null) {
            nuevo = new Plan(codigo, nombre, descripcion);
        } else {
            nuevo = miPlan;
            nuevo.setNombre(nombre);
            nuevo.setDescripcion(descripcion);
        }

        nuevo.setTieneInternet(chkbxInternet.isSelected());
        nuevo.setTieneCable(chckbxCable.isSelected());
        nuevo.setTieneMovil(chckbxTelefonia.isSelected());

        if (chkbxInternet.isSelected()) {
            nuevo.setBajadamegas((int) spnBajada.getValue());
            nuevo.setSubidamegas((int) spnSubida.getValue());
            nuevo.setPrecioInternet(((Number) spnPrecioInternet.getValue()).floatValue());
        }

        if (chckbxCable.isSelected()) {
            nuevo.setPackBasico(checkPackBasico.isSelected());
            nuevo.setPackHD(checkPackHD.isSelected());
            nuevo.setPrecioCable(((Number) spnPrecioCable.getValue()).floatValue());
        }

        if (chckbxTelefonia.isSelected()) {
            nuevo.setMinutos((int) spnMinutos.getValue());
            nuevo.setGb((int) spnGigas.getValue());
            nuevo.setPrecioMovil(((Number) spnPrecioMovil.getValue()).floatValue());
        }

        nuevo.setActivo(checkActivo.isSelected());

        if (miPlan == null) {
            return Altice.getInstance().registrarPlan(nuevo);
        } else {
            return Altice.getInstance().modificarPlan(nuevo);
        }
    }
    
    private void clean() {
        txtNombre.setText("");
        txtDescripcion.setText("");

        checkActivo.setSelected(true);

        chkbxInternet.setSelected(false);
        chckbxCable.setSelected(false);
        chckbxTelefonia.setSelected(false);

        panelInternet.setVisible(chkbxInternet.isSelected());
        panelCable.setVisible(chckbxCable.isSelected());
        panelMovil.setVisible(chckbxTelefonia.isSelected());
        
        spnBajada.setValue(0);
        spnSubida.setValue(0);
        spnPrecioInternet.setValue(0);
        checkPackBasico.setSelected(false);
        checkPackHD.setSelected(false);
        spnPrecioCable.setValue(0);

        spnMinutos.setValue(0);
        spnGigas.setValue(0);
        spnPrecioMovil.setValue(0);
        	
        txtCodigo.setText(String.format("PL-%05d", Altice.getGenPlanid()));
        txtCostoTotal.setText("RD$0.0");
    }
    private void loadPlan(Plan plan) {
        if (plan == null) return;

        txtNombre.setText(plan.getNombre());
        txtDescripcion.setText(plan.getDescripcion());
        txtCodigo.setText(plan.getCodigo());

        chkbxInternet.setSelected(plan.isTieneInternet());
        chckbxCable.setSelected(plan.isTieneCable());
        chckbxTelefonia.setSelected(plan.isTieneMovil());

        panelInternet.setVisible(chkbxInternet.isSelected());
        panelCable.setVisible(chckbxCable.isSelected());
        panelMovil.setVisible(chckbxTelefonia.isSelected());

        if (plan.isTieneInternet()) {
            spnBajada.setValue(plan.getBajadamegas());
            spnSubida.setValue(plan.getSubidamegas());
            spnPrecioInternet.setValue(plan.getPrecioInternet());
        }

        if (plan.isTieneCable()) {
            checkPackBasico.setSelected(plan.isPackBasico());
            checkPackHD.setSelected(plan.isPackHD());
            spnPrecioCable.setValue(plan.getPrecioCable());
        }

        if (plan.isTieneMovil()) {
            spnMinutos.setValue(plan.getMinutos());
            spnGigas.setValue(plan.getGb());
            spnPrecioMovil.setValue(plan.getPrecioMovil());
        }

        checkActivo.setSelected(plan.isActivo());

        actualizarCostoTotal();
    }
    private boolean validar() {
        
        String nombre = txtNombre.getText().trim();
        
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el nombre del plan.", "Error", JOptionPane.ERROR_MESSAGE);
            txtNombre.requestFocus();
            return false;
        }

        if (txtDescripcion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una descripción del plan.", "Error", JOptionPane.ERROR_MESSAGE);
            txtDescripcion.requestFocus();
            return false;
        }

        Plan planExistente = Altice.getInstance().buscarPlanByNombre(nombre);
        
        if (planExistente != null) {
            if (miPlan != null && miPlan.getCodigo().equals(planExistente.getCodigo())) {
            } else {
                if (planExistente.isActivo()) {
                    JOptionPane.showMessageDialog(this, 
                        "Ya existe un plan activo con este nombre.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                    txtNombre.requestFocus();
                    return false;
                }
            }
        }

        if (!chkbxInternet.isSelected() && !chckbxCable.isSelected() && !chckbxTelefonia.isSelected()) {
            JOptionPane.showMessageDialog(this, 
                "Debe seleccionar al menos un servicio (Internet, Cable o Móvil).", 
                "Error", JOptionPane.ERROR_MESSAGE);
            chkbxInternet.requestFocus();
            return false;
        }
        
        if (chkbxInternet.isSelected()) {
            if ((int) spnBajada.getValue() <= 0) {
                JOptionPane.showMessageDialog(this, "La velocidad de bajada debe ser mayor a 0 Mbps.", "Error", JOptionPane.ERROR_MESSAGE);
                spnBajada.requestFocus();
                return false;
            }
            if ((int) spnSubida.getValue() <= 0) {
                JOptionPane.showMessageDialog(this, "La velocidad de subida debe ser mayor a 0 Mbps.", "Error", JOptionPane.ERROR_MESSAGE);
                spnSubida.requestFocus();
                return false;
            }
            if (((Number) spnPrecioInternet.getValue()).floatValue() <= 0) {
                JOptionPane.showMessageDialog(this, "El precio del servicio de Internet debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                spnPrecioInternet.requestFocus();
                return false;
            }
        }

        if (chckbxCable.isSelected()) {
            if (((Number) spnPrecioCable.getValue()).floatValue() <= 0) {
                JOptionPane.showMessageDialog(this, "El precio del servicio de Cable debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                spnPrecioCable.requestFocus();
                return false;
            }
            if (!checkPackBasico.isSelected() && !checkPackHD.isSelected()) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un pack de Cable (Básico o HD).", "Error", JOptionPane.ERROR_MESSAGE);
                checkPackBasico.requestFocus();
                return false;
            }
        }

        // ====================== VALIDACIÓN MOVIL ======================
        if (chckbxTelefonia.isSelected()) {
            if ((int) spnMinutos.getValue() <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad de minutos debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                spnMinutos.requestFocus();
                return false;
            }
            if ((int) spnGigas.getValue() <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad de gigas debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                spnGigas.requestFocus();
                return false;
            }
            if (((Number) spnPrecioMovil.getValue()).floatValue() <= 0) {
                JOptionPane.showMessageDialog(this, "El precio del servicio Móvil debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                spnPrecioMovil.requestFocus();
                return false;
            }
        }

        return true;
    }
    
    public void comprobarServicios()
    {
    	if(Altice.getInstance().existeServicio(TipoServicio.INTERNET))
    		chkbxInternet.setEnabled(true);
    	if(Altice.getInstance().existeServicio(TipoServicio.CABLE))
    		chckbxCable.setEnabled(true);
    	if(Altice.getInstance().existeServicio(TipoServicio.MOVIL))
    		chckbxTelefonia.setEnabled(true);
    	
    }
    private void actualizarCostoTotal() {
        float total = 0f;

        if (chkbxInternet.isSelected()) {
            total += ((Number) spnPrecioInternet.getValue()).floatValue();
        }
        if (chckbxCable.isSelected()) {
            total += ((Number) spnPrecioCable.getValue()).floatValue();
        }
        if (chckbxTelefonia.isSelected()) {
            total += ((Number) spnPrecioMovil.getValue()).floatValue();
        }

        txtCostoTotal.setText(String.format("RD$ %.2f", total));
    }
}