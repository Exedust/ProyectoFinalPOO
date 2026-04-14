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
import logico.Pago;
import logico.Rol;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class GestionPagos extends JDialog {

    private final JPanel contentPanel = new JPanel();

    private JTable table;
    private DefaultTableModel model;
    private Object[] row;
    private Pago selected = null;

    private JButton btnRealizarPago;
    private JButton btnVerContrato;
    private JButton btnCancelarPago;
    private JButton btnSalir;

    private JTextField txtCedula;
    private JTextField txtCodigoContrato;
    private JButton btnCodigoContrato;

    private JComboBox<String> comboFiltrar;
    private JButton btnAgregar;
    private JButton btnCedula;
    private JLabel lblCedula;

    public GestionPagos() {
        setTitle("Gestionar Pagos");
        setResizable(false);
        setBounds(100, 100, 1280, 770);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(0, 0, 51));
        getContentPane().setLayout(new BorderLayout());

        contentPanel.setBackground(new Color(0, 0, 51));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        // ====================== PANEL PRINCIPAL DE TABLA ======================
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
            table.setRowHeight(25);
            table.setFillsViewportHeight(true);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.setFont(new Font("Segoe UI", Font.PLAIN, 13));

            model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            String[] headers = {"Código Pago", "Cliente", "Cédula", "Contrato", "Monto", "Fecha Registro", "Fecha Pago", "Estado"};
            model.setColumnIdentifiers(headers);
            table.setModel(model);
            table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
            scrollPane.setViewportView(table);

            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int ind = table.getSelectedRow();
                    if (ind != -1) {
                        String codigo = table.getValueAt(ind, 0).toString();
                        selected = Altice.getInstance().buscarPagoByCodigo(codigo);

                        if (selected != null) {
                            boolean esPendiente = selected.isPendiente() && selected.isActivo();
                            boolean esRealizado = !selected.isPendiente() && selected.isActivo();

                            btnRealizarPago.setEnabled(esPendiente);           
                            btnCancelarPago.setEnabled(esPendiente || esRealizado);
                            btnVerContrato.setEnabled(true);
                        }
                    } else {
                        selected = null;
                        btnRealizarPago.setEnabled(false);
                        btnCancelarPago.setEnabled(false);
                        btnVerContrato.setEnabled(false);
                    }
                }
            });
        }

        // ====================== CAMPOS DE BÚSQUEDA ======================
        {
            txtCedula = new JTextField();
            txtCedula.setBackground(new Color(0, 0, 51));
            txtCedula.setForeground(Color.WHITE);
            txtCedula.setCaretColor(Color.WHITE);
            txtCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            txtCedula.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            txtCedula.setBounds(12, 110, 232, 24);
            contentPanel.add(txtCedula);
        }
        {
            txtCodigoContrato = new JTextField();
            txtCodigoContrato.setBackground(new Color(0, 0, 51));
            txtCodigoContrato.setForeground(Color.WHITE);
            txtCodigoContrato.setCaretColor(Color.WHITE);
            txtCodigoContrato.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            txtCodigoContrato.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            txtCodigoContrato.setBounds(365, 107, 232, 24);
            contentPanel.add(txtCodigoContrato);
        }
        {
            btnCodigoContrato = new JButton("Buscar");
            btnCodigoContrato.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		loadPagos();
            	}
            });
            btnCodigoContrato.setForeground(Color.WHITE);
            btnCodigoContrato.setBackground(new Color(0, 0, 51));
            btnCodigoContrato.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnCodigoContrato.setFocusPainted(false);
            btnCodigoContrato.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnCodigoContrato.setBounds(609, 107, 97, 25);
            contentPanel.add(btnCodigoContrato);
        }

        {
        	comboFiltrar = new JComboBox<>();
        	comboFiltrar.setBackground(new Color(0, 0, 51));
        	comboFiltrar.setForeground(Color.WHITE);
        	comboFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        	comboFiltrar.setBounds(797, 110, 208, 24);

        	comboFiltrar.addItem("Pendientes");
        	comboFiltrar.addItem("Realizados");
        	comboFiltrar.addItem("Cancelados");
        	comboFiltrar.addItem("Todos");  

        	contentPanel.add(comboFiltrar);
        }
        {
            JButton btnFiltrar = new JButton("Filtrar");
            btnFiltrar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    loadPagos();
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

        // ====================== CONTADORES ======================
        {
            JLabel lblPagosRegistrados = new JLabel("Pagos registrados: 00");
            lblPagosRegistrados.setForeground(Color.WHITE);
            lblPagosRegistrados.setFont(new Font("Segoe UI", Font.BOLD, 13));
            lblPagosRegistrados.setBounds(12, 23, 216, 16);
            contentPanel.add(lblPagosRegistrados);
        }
        {
            JLabel lblPagosPendientes = new JLabel("Pagos pendientes: 00");
            lblPagosPendientes.setForeground(Color.WHITE);
            lblPagosPendientes.setFont(new Font("Segoe UI", Font.BOLD, 13));
            lblPagosPendientes.setBounds(12, 50, 216, 16);
            contentPanel.add(lblPagosPendientes);
        }
        {
            JLabel lblPagosRealizados = new JLabel("Pagos realizados: 00");
            lblPagosRealizados.setForeground(Color.WHITE);
            lblPagosRealizados.setFont(new Font("Segoe UI", Font.BOLD, 13));
            lblPagosRealizados.setBounds(240, 50, 216, 16);
            contentPanel.add(lblPagosRealizados);
        }
        {
            JLabel lblMontoPendiente = new JLabel("Monto pendiente: RD$ 0.00");
            lblMontoPendiente.setForeground(Color.WHITE);
            lblMontoPendiente.setFont(new Font("Segoe UI", Font.BOLD, 13));
            lblMontoPendiente.setBounds(468, 50, 216, 16);
            contentPanel.add(lblMontoPendiente);
        }

        // ====================== BOTONES LATERALES ======================
        {
            btnRealizarPago = new JButton("Realizar Pago");
            btnRealizarPago.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (selected != null && selected.isPendiente()) {
                    	RegistrarPagoDirecto pagar = new RegistrarPagoDirecto(selected);
                    	pagar.setModal(true);
                    	pagar.setVisible(true);
                    	loadPagos();
                        }
                    }
            });
            btnRealizarPago.setForeground(Color.WHITE);
            btnRealizarPago.setBackground(new Color(0, 0, 51));
            btnRealizarPago.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnRealizarPago.setFocusPainted(false);
            btnRealizarPago.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnRealizarPago.setBounds(1143, 190, 97, 25);
            btnRealizarPago.setEnabled(false);
            contentPanel.add(btnRealizarPago);
        }

        {
            btnVerContrato = new JButton("Ver Contrato");
            btnVerContrato.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		if(selected != null)
            		{
            			DetallesContrato ver = new DetallesContrato(selected.getContrato());
            			ver.setModal(true);
            			ver.setVisible(true);
            			btnRealizarPago.setEnabled(false);
            			btnVerContrato.setEnabled(false);
            			btnCancelarPago.setEnabled(false);
            		}
            		
            	}
            });
            btnVerContrato.setForeground(Color.WHITE);
            btnVerContrato.setBackground(new Color(0, 0, 51));
            btnVerContrato.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnVerContrato.setFocusPainted(false);
            btnVerContrato.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnVerContrato.setBounds(1143, 281, 97, 25);
            btnVerContrato.setEnabled(false);
            contentPanel.add(btnVerContrato);
        }

        {
            btnCancelarPago = new JButton("Cancelar Pago");
            btnCancelarPago.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		cancelarPago();
            	}
            });
            btnCancelarPago.setForeground(Color.WHITE);
            btnCancelarPago.setBackground(new Color(102, 0, 0));
            btnCancelarPago.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnCancelarPago.setFocusPainted(false);
            btnCancelarPago.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnCancelarPago.setBounds(1143, 228, 97, 25);
            btnCancelarPago.setEnabled(false);
            contentPanel.add(btnCancelarPago);
        }
        {
        	btnAgregar = new JButton("Agregar");
        	btnAgregar.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			RegistrarPago pago = new RegistrarPago();
        			pago.setModal(true);
        			pago.setVisible(true);
        			loadPagos();
        		}
        	});
        	btnAgregar.setForeground(Color.WHITE);
        	btnAgregar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        	btnAgregar.setFocusPainted(false);
        	btnAgregar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
        	btnAgregar.setBackground(new Color(0, 0, 51));
        	btnAgregar.setBounds(1143, 152, 97, 25);
        	contentPanel.add(btnAgregar);
        }
        {
        	btnCedula = new JButton("Buscar");
        	btnCedula.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			loadPagos();
        		}
        	});
        	btnCedula.setForeground(Color.WHITE);
        	btnCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        	btnCedula.setFocusPainted(false);
        	btnCedula.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
        	btnCedula.setBackground(new Color(0, 0, 51));
        	btnCedula.setBounds(256, 107, 97, 25);
        	contentPanel.add(btnCedula);
        }
        {
        	lblCedula = new JLabel("Cedula");
        	lblCedula.setForeground(Color.WHITE);
        	lblCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        	lblCedula.setBounds(12, 81, 216, 16);
        	contentPanel.add(lblCedula);
        }

        // ====================== BOTONES INFERIORES ======================
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(0, 0, 51));
            buttonPane.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                    TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            btnSalir = new JButton("Salir");
            btnSalir.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            btnSalir.setForeground(Color.WHITE);
            btnSalir.setBackground(new Color(102, 0, 0));
            btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btnSalir.setFocusPainted(false);
            buttonPane.add(btnSalir);
        }

        loadPagos();
    }

    private void cancelarPago() {
        if (selected == null) {
            JOptionPane.showMessageDialog(this, 
                "Debe seleccionar un pago primero.", 
                "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!selected.isPendiente() && selected.isActivo()) {
            JOptionPane.showMessageDialog(this,
                "No se puede cancelar un pago que ya ha sido realizado.",
                "Acción no permitida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!selected.isActivo()) {
            JOptionPane.showMessageDialog(this,
                "Este pago ya está cancelado.",
                "Acción no permitida", JOptionPane.WARNING_MESSAGE);
            return;
        }


        String cedulaLogueado = Altice.getInstance().buscarCedulaById(Altice.getSesion().getCodigo());

        if (selected.getCliente() != null && 
            selected.getCliente().getCedula() != null &&
            selected.getCliente().getCedula().equalsIgnoreCase(cedulaLogueado)) {
            
            JOptionPane.showMessageDialog(this,
                "No puedes cancelar un pago que está registrado a tu propio nombre.",
                "Acceso denegado", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea cancelar este pago pendiente?\n\n" +
                "Código: " + selected.getCodigo() + "\n" +
                "Cliente: " + (selected.getCliente() != null ? selected.getCliente().getNombre() : "N/A") + "\n" +
                "Monto: RD$ " + String.format("%.2f", selected.getMonto()),
                "Confirmar Cancelación de Pago",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (opcion != JOptionPane.YES_OPTION) {
            return;
        }

        if (Altice.getInstance().cancelarPago(selected.getCodigo())) {
            JOptionPane.showMessageDialog(this,
                    "Pago cancelado correctamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
            
            loadPagos();
        } else {
            JOptionPane.showMessageDialog(this,
                    "No se pudo cancelar el pago",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    public void loadPagos() {
        if (model == null) return;
        model.setRowCount(0);
        row = new Object[table.getColumnCount()];

        String filtro = comboFiltrar.getSelectedItem() != null ? 
                        comboFiltrar.getSelectedItem().toString() : "Todos";

        String textoCedula = txtCedula.getText().trim();
        String textoCodigoContrato = txtCodigoContrato.getText().trim();

        for (Pago p : Altice.getInstance().getMisPagos()) {
            boolean incluir = false;

            switch (filtro) {
                case "Pendientes":
                    incluir = p.isPendiente() && p.isActivo();
                    break;
                case "Realizados":
                    incluir = !p.isPendiente() && p.isActivo();
                    break;
                case "Cancelados":
                    incluir = !p.isActivo();
                    break;
                case "Todos":
                default:
                    incluir = true;
                    break;
            }

            if (!incluir) continue;

            if (!textoCedula.isEmpty()) {
                if (p.getCliente() == null || p.getCliente().getCedula() == null ||
                    !p.getCliente().getCedula().toLowerCase().contains(textoCedula.toLowerCase())) {
                    continue;
                }
            }

            if (!textoCodigoContrato.isEmpty()) {
                if (p.getContrato() == null || p.getContrato().getCodigo() == null ||
                    !p.getContrato().getCodigo().toLowerCase().contains(textoCodigoContrato.toLowerCase())) {
                    continue;
                }
            }
            String estado = "REALIZADO";
            if (!p.isActivo()) {
                estado = "CANCELADO";
            } else if (p.isPendiente()) {
                estado = "PENDIENTE";
            }

            row[0] = p.getCodigo();
            row[1] = p.getCliente() != null ? p.getCliente().getNombre() : "N/A";
            row[2] = p.getCliente() != null ? p.getCliente().getCedula() : "N/A";
            row[3] = p.getContrato() != null ? p.getContrato().getCodigo() : "N/A";
            row[4] = String.format("RD$ %.2f", p.getMonto());
            row[5] = p.getFechaRegistro() != null ? p.getFechaRegistro().toString() : "";
            row[6] = p.getFechaPago() != null ? p.getFechaPago().toString() : "";
            row[7] = estado;

            model.addRow(row);
        }

        actualizarContadores();
    }
    
    private void actualizarContadores() {
        int registrados = 0;
        int pendientes = 0;
        int realizados = 0;
        double montoPendienteTotal = 0.0;

        for (Pago p : Altice.getInstance().getMisPagos()) {
            registrados++;

            if (p.isPendiente() && p.isActivo()) {
                pendientes++;
                montoPendienteTotal += p.getMonto();
            } else if (!p.isPendiente() && p.isActivo()) {
                realizados++;
            }
        }

        // Actualizar labels
        for (Component c : contentPanel.getComponents()) {
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                String text = label.getText();

                if (text.startsWith("Pagos registrados")) {
                    label.setText("Pagos registrados: " + String.format("%02d", registrados));
                } else if (text.startsWith("Pagos pendientes")) {
                    label.setText("Pagos pendientes: " + String.format("%02d", pendientes));
                } else if (text.startsWith("Pagos realizados")) {
                    label.setText("Pagos realizados: " + String.format("%02d", realizados));
                } else if (text.startsWith("Monto pendiente")) {
                    label.setText("Monto pendiente: RD$ " + String.format("%.2f", montoPendienteTotal));
                }
            }
        }
    }
}