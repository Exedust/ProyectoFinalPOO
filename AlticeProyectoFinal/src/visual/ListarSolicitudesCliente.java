package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import logico.Altice;
import logico.Solicitud;
import logico.TipoSolicitud;
import logico.Cliente;
import logico.Empleado;
import logico.EstadoSolicitud;
import logico.Persona;
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

public class ListarSolicitudesCliente extends JDialog {

    private final JPanel contentPanel = new JPanel();
   
    private static JTable table;
    private static DefaultTableModel model;
    private static Object[] row;
    private Solicitud selected = null;
    private JButton btnAgregar;
    private JButton btnCancelar;
    private JButton btnVerDetalles;
    private JButton btnSalir;

    private static JComboBox<String> comboFiltrar;

    private JLabel lblTotal;
    private JLabel lblPendientes;
    private JLabel lblCompletadas;

    public ListarSolicitudesCliente() {
        setTitle("Ver mis solicitudes");
        setResizable(false);
        setBounds(100, 100, 1280, 700);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(0, 0, 51));
        getContentPane().setLayout(new BorderLayout());

        contentPanel.setBackground(new Color(0, 0, 51));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        {
            JPanel panelTabla = new JPanel();
            panelTabla.setBackground(new Color(102, 102, 204));
            panelTabla.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            panelTabla.setBounds(12, 89, 1102, 496);
            contentPanel.add(panelTabla);
            panelTabla.setLayout(new BorderLayout(0, 0));

            JScrollPane scrollPane = new JScrollPane();
            panelTabla.add(scrollPane, BorderLayout.CENTER);

            table = new JTable();
            table.setFillsViewportHeight(true);
            table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.setRowHeight(25);

            String[] headers = {
                "Código", "Tipo", "Empleado Asignado",
                "Estado", "Fecha Emisión", "Fecha Atención"
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
                        String codigo = table.getValueAt(ind, 0).toString();
                        selected = Altice.getInstance().buscarSolicitudByCodigo(codigo);

                        if (selected != null) {
                            boolean puedeCancelar = !selected.isResuelto() && !selected.isCancelada() && !selected.isEnProceso();

                            btnCancelar.setEnabled(puedeCancelar);
                            btnVerDetalles.setEnabled(true);
                        }
                    } else {
                        desactivarBotones();
                    }
                }
            });
        }

        {
            comboFiltrar = new JComboBox<>();
            comboFiltrar.setModel(new DefaultComboBoxModel<>(new String[] {
                 "Pendientes", "En Proceso", "Completadas", "Canceladas", "Todos"
            }));
            comboFiltrar.setBackground(new Color(0, 0, 51));
            comboFiltrar.setForeground(Color.WHITE);
            comboFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            comboFiltrar.setBounds(809, 52, 200, 24);
            contentPanel.add(comboFiltrar);
        }

        {
            JButton btnFiltrar = new JButton("Filtrar");
            btnFiltrar.addActionListener(e -> loadSolicitudes());
            btnFiltrar.setForeground(Color.WHITE);
            btnFiltrar.setBackground(new Color(0, 0, 51));
            btnFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnFiltrar.setFocusPainted(false);
            btnFiltrar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnFiltrar.setBounds(1019, 52, 97, 25);
            contentPanel.add(btnFiltrar);
        }

        {
            lblTotal = new JLabel("Solicitudes Registradas: 00");
            lblTotal.setForeground(Color.WHITE);
            lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 13));
            lblTotal.setBounds(12, 23, 230, 16);
            contentPanel.add(lblTotal);
        }
        {
            lblPendientes = new JLabel("Solicitudes Pendientes: 00");
            lblPendientes.setForeground(Color.WHITE);
            lblPendientes.setFont(new Font("Segoe UI", Font.BOLD, 13));
            lblPendientes.setBounds(12, 52, 230, 16);
            contentPanel.add(lblPendientes);
        }
        {
            lblCompletadas = new JLabel("Solicitudes Completadas: 00");
            lblCompletadas.setForeground(Color.WHITE);
            lblCompletadas.setFont(new Font("Segoe UI", Font.BOLD, 13));
            lblCompletadas.setBounds(208, 52, 230, 16);
            contentPanel.add(lblCompletadas);
        }

        {
            btnAgregar = new JButton("Agregar");
            btnAgregar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		RegistrarSolicitudCliente nuevo =  new RegistrarSolicitudCliente();
            		nuevo.setModal(true);
            		nuevo.setVisible(true);
            		loadSolicitudes();
            	}
            });
            btnAgregar.setForeground(Color.WHITE);
            btnAgregar.setBackground(new Color(0, 0, 51));
            btnAgregar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnAgregar.setFocusPainted(false);
            btnAgregar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnAgregar.setBounds(1148, 484, 97, 25);
            contentPanel.add(btnAgregar);
        }

        {
            btnCancelar = new JButton("Cancelar");
            btnCancelar.setForeground(Color.WHITE);
            btnCancelar.setBackground(new Color(102, 0, 0));
            btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnCancelar.setFocusPainted(false);
            btnCancelar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnCancelar.setBounds(1148, 522, 97, 25);
            btnCancelar.setEnabled(false);
            btnCancelar.addActionListener(e -> {
                cancelarSolicitud();
                desactivarBotones();
            });
            contentPanel.add(btnCancelar);
        }

        {
            btnVerDetalles = new JButton("Ver Detalles");
            btnVerDetalles.setForeground(Color.WHITE);
            btnVerDetalles.setBackground(new Color(0, 0, 51));
            btnVerDetalles.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnVerDetalles.setFocusPainted(false);
            btnVerDetalles.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnVerDetalles.setBounds(1148, 560, 97, 25);
            btnVerDetalles.setEnabled(false);
           
            btnVerDetalles.addActionListener(e -> {
                if (selected != null) {
                    try {
                        DetallesSolicitud detalles = new DetallesSolicitud(selected);
                        detalles.setModal(true);
                        detalles.setVisible(true);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Error al abrir los detalles", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            contentPanel.add(btnVerDetalles);
        }

        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(0, 0, 51));
            buttonPane.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                    TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            btnSalir = new JButton("Salir");
            btnSalir.setForeground(Color.WHITE);
            btnSalir.setBackground(new Color(102, 0, 0));
            btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btnSalir.setFocusPainted(false);
            btnSalir.addActionListener(e -> dispose());
            buttonPane.add(btnSalir);
        }

        loadSolicitudes();
        desactivarBotones();
    }

    public void loadSolicitudes() {
        model.setRowCount(0);
        row = new Object[8];

        String filtro = (String) comboFiltrar.getSelectedItem();
        
        String cedulaCliente = null;
        if (Altice.getSesion() != null) {
            cedulaCliente = Altice.getInstance().buscarCedulaById(Altice.getSesion().getCodigo());
        }

        if (cedulaCliente == null) {
            JOptionPane.showMessageDialog(this, "No se pudo identificar al cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Solicitud s : Altice.getInstance().getMisSolicitudes()) {
            if (s.getCliente() == null || s.getCliente().getCedula() == null ||
                !s.getCliente().getCedula().equalsIgnoreCase(cedulaCliente)) {
                continue;
            }

            boolean incluir = false;

            switch (filtro) {
                case "Todos":
                    incluir = true;
                    break;
                case "Pendientes":
                    incluir = s.getEstado() == EstadoSolicitud.PENDIENTE;
                    break;
                case "En Proceso":
                    incluir = s.getEstado() == EstadoSolicitud.EN_PROCESO;
                    break;
                case "Completadas":
                    incluir = s.getEstado() == EstadoSolicitud.COMPLETADA;
                    break;
                case "Canceladas":
                    incluir = s.getEstado() == EstadoSolicitud.CANCELADA;
                    break;
            }

            if (!incluir) continue;

            Empleado emp = s.getEmpleado();

            row[0] = s.getCodigo();
            row[1] = s.getTipo() != null ? s.getTipo().name() : "N/A";
            row[2] = (emp != null) ? emp.getNombre() : "No asignado";
            row[3] = s.getEstado() != null ? s.getEstado().name() : "N/A";
            row[4] = s.getFechaRegistro() != null ? s.getFechaRegistro().toString() : "";
            row[5] = s.getFechaAtencion() != null ? s.getFechaAtencion().toString() : "";

            model.addRow(row);
        }

        actualizarContadores(cedulaCliente);
    }

    private void actualizarContadores(String cedulaCliente) {
        if (cedulaCliente == null) {
            lblTotal.setText("Solicitudes Registradas: 00");
            lblPendientes.setText("Solicitudes Pendientes: 00");
            lblCompletadas.setText("Solicitudes Completadas: 00");
            return;
        }

        int total = 0;
        int pendientes = 0;
        int completadas = 0;

        for (Solicitud s : Altice.getInstance().getMisSolicitudes()) {
            if (s.getCliente() == null || s.getCliente().getCedula() == null ||
                !s.getCliente().getCedula().equalsIgnoreCase(cedulaCliente)) {
                continue;
            }

            total++;

            if (s.getEstado() == EstadoSolicitud.PENDIENTE) {
                pendientes++;
            } else if (s.getEstado() == EstadoSolicitud.COMPLETADA) {
                completadas++;
            }
        }

        lblTotal.setText("Solicitudes Registradas: " + String.format("%02d", total));
        lblPendientes.setText("Solicitudes Pendientes: " + String.format("%02d", pendientes));
        lblCompletadas.setText("Solicitudes Completadas: " + String.format("%02d", completadas));
    }


    private void cancelarSolicitud() {
        if (selected == null) return;

        if (selected.isResuelto() || selected.isCancelada()) {
            JOptionPane.showMessageDialog(this, "No se puede cancelar una solicitud ya finalizada.", 
                "Acción no permitida", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(selected.getTipo() == TipoSolicitud.INSTALACION)
        {
            JOptionPane.showMessageDialog(this, "No puedes cancelar una solicitud de instalación.", 
                    "Acción no permitida", JOptionPane.WARNING_MESSAGE);
                return;
        }

        int opcion = JOptionPane.showConfirmDialog(this, "¿Desea cancelar esta solicitud?", 
                "Confirmar Cancelación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (opcion == JOptionPane.YES_OPTION) {
            if (Altice.getInstance().cancelarSolicitud(selected.getCodigo())) {
                JOptionPane.showMessageDialog(this, "Solicitud cancelada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                loadSolicitudes();
                desactivarBotones();
            }
        }
    }

    private void desactivarBotones() {
        btnCancelar.setEnabled(false);
        btnVerDetalles.setEnabled(false);
        selected = null;
    }
}