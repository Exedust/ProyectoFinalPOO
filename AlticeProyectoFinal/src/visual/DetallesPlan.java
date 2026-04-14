package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import logico.Plan;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DetallesPlan extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private Plan miPlan;
    
    private JTextField txtNombre;
    private JTextPane txtDescripcion;
    private JTextField txtBajada;
    private JTextField txtSubida;
    private JTextField txtPrecioInternet;
    private JTextField txtMinutos;
    private JTextField txtGigas;
    private JTextField txtPrecioMovil;
    private JTextField txtPrecioCable;
    private JTextField txtCostoTotal;
    
    private JCheckBox chkbxInternet;
    private JCheckBox chckbxCable;
    private JCheckBox chckbxMovil;
    private JCheckBox chckbxPackBasico;
    private JCheckBox chckbxPackPremium;
    private JTextField txtCodigo;
    private JPanel panelInternet;
    private JPanel panelCable;
    private JPanel panelMovil;
    private JButton cancelButton;

    public DetallesPlan(Plan plan) {
        setTitle("Detalles del Plan");
        miPlan = plan;
        setResizable(false);
        setBounds(100, 100, 595, 766);
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
                panelGeneral.setBounds(25, 46, 510, 207);
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
                    txtNombre.setEditable(false);
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
                    txtDescripcion.setEditable(false);
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
                panelServicios.setBounds(25, 266, 510, 71);
                panel.add(panelServicios);

                {
                    chkbxInternet = new JCheckBox("Internet");
                    chkbxInternet.setEnabled(false);
                    chkbxInternet.setForeground(Color.WHITE);
                    chkbxInternet.setBackground(new Color(102, 102, 204));
                    chkbxInternet.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    chkbxInternet.setBounds(68, 26, 86, 25);
                    panelServicios.add(chkbxInternet);
                }
                {
                    chckbxCable = new JCheckBox("Cable");
                    chckbxCable.setEnabled(false);
                    chckbxCable.setForeground(Color.WHITE);
                    chckbxCable.setBackground(new Color(102, 102, 204));
                    chckbxCable.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    chckbxCable.setBounds(212, 26, 86, 25);
                    panelServicios.add(chckbxCable);
                }
                {
                    chckbxMovil = new JCheckBox("Movil");
                    chckbxMovil.setEnabled(false);
                    chckbxMovil.setForeground(Color.WHITE);
                    chckbxMovil.setBackground(new Color(102, 102, 204));
                    chckbxMovil.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    chckbxMovil.setBounds(363, 26, 75, 25);
                    panelServicios.add(chckbxMovil);
                }
            }

            // ====================== PANEL INTERNET ======================
            {
                panelInternet = new JPanel();
                panelInternet.setLayout(null);
                panelInternet.setBackground(new Color(102, 102, 204));
                panelInternet.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true),
                        "Internet", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
                panelInternet.setBounds(25, 350, 137, 232);
                panel.add(panelInternet);

                {
                    JLabel lblBajada = new JLabel("Bajada (Mbps)");
                    lblBajada.setForeground(Color.WHITE);
                    lblBajada.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblBajada.setBounds(23, 30, 91, 16);
                    panelInternet.add(lblBajada);
                }
                {
                    txtBajada = new JTextField();
                    txtBajada.setEditable(false);
                    txtBajada.setBackground(new Color(0, 0, 51));
                    txtBajada.setForeground(Color.WHITE);
                    txtBajada.setCaretColor(Color.WHITE);
                    txtBajada.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtBajada.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtBajada.setBounds(23, 59, 91, 24);
                    panelInternet.add(txtBajada);
                }
                {
                    JLabel lblSubida = new JLabel("Subida (Mbps)");
                    lblSubida.setForeground(Color.WHITE);
                    lblSubida.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblSubida.setBounds(23, 94, 91, 16);
                    panelInternet.add(lblSubida);
                }
                {
                    txtSubida = new JTextField();
                    txtSubida.setEditable(false);
                    txtSubida.setBackground(new Color(0, 0, 51));
                    txtSubida.setForeground(Color.WHITE);
                    txtSubida.setCaretColor(Color.WHITE);
                    txtSubida.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtSubida.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtSubida.setBounds(23, 123, 91, 24);
                    panelInternet.add(txtSubida);
                }
                {
                    JLabel lblPrecio = new JLabel("Precio");
                    lblPrecio.setForeground(Color.WHITE);
                    lblPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblPrecio.setBounds(45, 158, 46, 16);
                    panelInternet.add(lblPrecio);
                }
                {
                    txtPrecioInternet = new JTextField();
                    txtPrecioInternet.setEditable(false);
                    txtPrecioInternet.setBackground(new Color(0, 0, 51));
                    txtPrecioInternet.setForeground(Color.WHITE);
                    txtPrecioInternet.setCaretColor(Color.WHITE);
                    txtPrecioInternet.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtPrecioInternet.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtPrecioInternet.setBounds(23, 186, 91, 24);
                    panelInternet.add(txtPrecioInternet);
                }
            }

            // ====================== PANEL CABLE ======================
            {
                panelCable = new JPanel();
                panelCable.setLayout(null);
                panelCable.setBackground(new Color(102, 102, 204));
                panelCable.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true),
                        "Cable", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
                panelCable.setBounds(217, 350, 137, 232);
                panel.add(panelCable);

                {
                    JLabel lblPrecio = new JLabel("Precio");
                    lblPrecio.setForeground(Color.WHITE);
                    lblPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblPrecio.setBounds(46, 158, 45, 16);
                    panelCable.add(lblPrecio);
                }
                {
                    txtPrecioCable = new JTextField();
                    txtPrecioCable.setEditable(false);
                    txtPrecioCable.setBackground(new Color(0, 0, 51));
                    txtPrecioCable.setForeground(Color.WHITE);
                    txtPrecioCable.setCaretColor(Color.WHITE);
                    txtPrecioCable.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtPrecioCable.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtPrecioCable.setBounds(23, 186, 91, 24);
                    panelCable.add(txtPrecioCable);
                }
                {
                    chckbxPackBasico = new JCheckBox("Pack básico");
                    chckbxPackBasico.setEnabled(false);
                    chckbxPackBasico.setForeground(Color.WHITE);
                    chckbxPackBasico.setBackground(new Color(102, 102, 204));
                    chckbxPackBasico.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    chckbxPackBasico.setBounds(16, 45, 105, 25);
                    panelCable.add(chckbxPackBasico);
                }
                {
                    chckbxPackPremium = new JCheckBox("Pack Premium");
                    chckbxPackPremium.setEnabled(false);
                    chckbxPackPremium.setForeground(Color.WHITE);
                    chckbxPackPremium.setBackground(new Color(102, 102, 204));
                    chckbxPackPremium.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    chckbxPackPremium.setBounds(12, 110, 113, 25);
                    panelCable.add(chckbxPackPremium);
                }
            }

            // ====================== PANEL MOVIL ======================
            {
                panelMovil = new JPanel();
                panelMovil.setLayout(null);
                panelMovil.setBackground(new Color(102, 102, 204));
                panelMovil.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true),
                        "Movil", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
                panelMovil.setBounds(398, 350, 137, 232);
                panel.add(panelMovil);

                {
                    JLabel lblMinutos = new JLabel("Minutos");
                    lblMinutos.setForeground(Color.WHITE);
                    lblMinutos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblMinutos.setBounds(40, 30, 56, 16);
                    panelMovil.add(lblMinutos);
                }
                {
                    txtMinutos = new JTextField();
                    txtMinutos.setEditable(false);
                    txtMinutos.setBackground(new Color(0, 0, 51));
                    txtMinutos.setForeground(Color.WHITE);
                    txtMinutos.setCaretColor(Color.WHITE);
                    txtMinutos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtMinutos.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtMinutos.setBounds(23, 59, 91, 24);
                    panelMovil.add(txtMinutos);
                }
                {
                    JLabel lblGigas = new JLabel("Gigas");
                    lblGigas.setForeground(Color.WHITE);
                    lblGigas.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblGigas.setBounds(49, 94, 39, 16);
                    panelMovil.add(lblGigas);
                }
                {
                    txtGigas = new JTextField();
                    txtGigas.setEditable(false);
                    txtGigas.setBackground(new Color(0, 0, 51));
                    txtGigas.setForeground(Color.WHITE);
                    txtGigas.setCaretColor(Color.WHITE);
                    txtGigas.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtGigas.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtGigas.setBounds(23, 123, 91, 24);
                    panelMovil.add(txtGigas);
                }
                {
                    JLabel lblPrecio = new JLabel("Precio");
                    lblPrecio.setForeground(Color.WHITE);
                    lblPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblPrecio.setBounds(49, 158, 39, 16);
                    panelMovil.add(lblPrecio);
                }
                {
                    txtPrecioMovil = new JTextField();
                    txtPrecioMovil.setEditable(false);
                    txtPrecioMovil.setBackground(new Color(0, 0, 51));
                    txtPrecioMovil.setForeground(Color.WHITE);
                    txtPrecioMovil.setCaretColor(Color.WHITE);
                    txtPrecioMovil.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtPrecioMovil.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtPrecioMovil.setBounds(23, 186, 91, 24);
                    panelMovil.add(txtPrecioMovil);
                }
            }

            // ====================== COSTO TOTAL ======================
            {
                JPanel panelCosto = new JPanel();
                panelCosto.setLayout(null);
                panelCosto.setBackground(new Color(102, 102, 204));
                panelCosto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Costo Total", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
                panelCosto.setBounds(25, 595, 510, 61);
                panel.add(panelCosto);

                {
                    txtCostoTotal = new JTextField();
                    txtCostoTotal.setEditable(false);
                    txtCostoTotal.setBackground(new Color(0, 0, 51));
                    txtCostoTotal.setForeground(Color.WHITE);
                    txtCostoTotal.setCaretColor(Color.WHITE);
                    txtCostoTotal.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtCostoTotal.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtCostoTotal.setBounds(197, 24, 116, 24);
                    panelCosto.add(txtCostoTotal);
                }
            }
            {
            	JLabel label = new JLabel("C\u00F3digo");
            	label.setForeground(Color.WHITE);
            	label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            	label.setBounds(25, 17, 56, 16);
            	panel.add(label);
            }
            {
            	txtCodigo = new JTextField();
            	txtCodigo.setText("PL-00000");
            	txtCodigo.setForeground(Color.WHITE);
            	txtCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            	txtCodigo.setEditable(false);
            	txtCodigo.setColumns(10);
            	txtCodigo.setCaretColor(Color.WHITE);
            	txtCodigo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            	txtCodigo.setBackground(new Color(0, 0, 51));
            	txtCodigo.setBounds(80, 13, 112, 24);
            	panel.add(txtCodigo);
            }
        }

        // ====================== BOTONES OK / CANCEL ======================
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(0, 0, 51));
            buttonPane.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                    TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            cancelButton = new JButton("Salir");
            cancelButton.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		dispose();
            	}
            });
            cancelButton.setForeground(Color.WHITE);
            cancelButton.setBackground(new Color(102, 0, 0));
            cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            cancelButton.setFocusPainted(false);
            cancelButton.setActionCommand("Cancel");
            buttonPane.add(cancelButton);
        }
        loadPlan(miPlan);
    }
    private void loadPlan(Plan plan) {
        if (plan == null) return;

        txtNombre.setText(plan.getNombre());
        txtDescripcion.setText(plan.getDescripcion());
        txtCodigo.setText(plan.getCodigo());

        chkbxInternet.setSelected(plan.isTieneInternet());
        chckbxCable.setSelected(plan.isTieneCable());
        chckbxMovil.setSelected(plan.isTieneMovil());

        panelInternet.setVisible(chkbxInternet.isSelected());
        panelCable.setVisible(chckbxCable.isSelected());
        panelMovil.setVisible(chckbxMovil.isSelected());

        if (plan.isTieneInternet()) {
            txtBajada.setText(String.valueOf(plan.getBajadamegas()));
            txtSubida.setText(String.valueOf(plan.getSubidamegas()));
            txtPrecioInternet.setText(String.format("RD$%.2f", plan.getPrecioInternet()));
        }

        if (plan.isTieneCable()) {
            chckbxPackBasico.setSelected(plan.isPackBasico());
            chckbxPackPremium.setSelected(plan.isPackHD());  
            txtPrecioCable.setText(String.format("RD$%.2f", plan.getPrecioCable()));
        }

        if (plan.isTieneMovil()) {
            txtMinutos.setText(String.valueOf(plan.getMinutos()));
            txtGigas.setText(String.valueOf(plan.getGb()));
            txtPrecioMovil.setText(String.format("RD$%.2f", plan.getPrecioMovil()));
        }

        if (txtCostoTotal != null) {
            txtCostoTotal.setText(String.format("RD$ %.2f", plan.getMonto()));
        }
        chkbxInternet.setEnabled(false);
        chckbxCable.setEnabled(false);
        chckbxMovil.setEnabled(false);
        chckbxPackBasico.setEnabled(false);
        chckbxPackPremium.setEnabled(false);

    }
}