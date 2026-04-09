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

import logico.Altice;
import logico.TipoServicio;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;

public class RegistrarPlan extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtNombre;           // Nombre
    private JTextPane txtDescripcion;             // Descripción
    private JTextField txtCostoTotal;         // Costo Total

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
    private JCheckBox checkPackPremium;
    private JSpinner spnPrecioCable;
    private JSpinner spnMinutos;
    private JButton btnCancelar;
    private JButton btnAceptar;

    public static void main(String[] args) {
        try {
            RegistrarPlan dialog = new RegistrarPlan();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RegistrarPlan() {
        setTitle("Registrar Plan");
        setResizable(false);
        setBounds(100, 100, 595, 783);
        
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
                panelGeneral.setBounds(23, 13, 510, 207);
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
                panelServicios.setBounds(23, 245, 510, 71);
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
                panelInternet.setBounds(23, 339, 137, 232);
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
                panelCable.setBounds(215, 339, 137, 232);
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
                    checkPackPremium = new JCheckBox("Pack Premium");
                    checkPackPremium.setForeground(Color.WHITE);
                    checkPackPremium.setBackground(new Color(102, 102, 204));
                    checkPackPremium.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    checkPackPremium.setBounds(12, 110, 113, 25);
                    panelCable.add(checkPackPremium);
                }
            }

            // ====================== PANEL MOVIL ======================
            {
                panelMovil = new JPanel();
                panelMovil.setLayout(null);
                panelMovil.setBackground(new Color(102, 102, 204));
                panelMovil.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true),
                        "Movil", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
                panelMovil.setBounds(396, 339, 137, 232);
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
                    JSpinner spnGigas = new JSpinner();
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
                    JSpinner spnPrecioMovil = new JSpinner();
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
                panelCosto.setBounds(23, 608, 510, 61);
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
            btnCancelar.setForeground(Color.WHITE);
            btnCancelar.setBackground(new Color(102, 0, 0));
            btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btnCancelar.setFocusPainted(false);
            btnCancelar.setActionCommand("Cancel");
            buttonPane.add(btnCancelar);
        }
        ActionListener servicioListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelInternet.setVisible(chkbxInternet.isSelected());
                panelCable.setVisible(chckbxCable.isSelected());
                panelMovil.setVisible(chckbxTelefonia.isSelected());
            }
        };

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
}