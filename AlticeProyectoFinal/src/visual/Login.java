package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import logico.Altice;
import logico.Rol;
import logico.Usuario;

public class Login extends JFrame {

    private JPanel contentPane;
    private JTextField txtUsuario;
    private JPasswordField txtContra;
    private JButton btnIniciar;

    public static void main(String[] args) {
        try {
            Altice.getInstance().cargarDatos();
            if (Altice.getInstance().getMisUsuarios().isEmpty()) {
                crearUsuarioAdminPorDefecto();
            }
            Login frame = new Login();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Login() {
        setTitle("Altice - Iniciar Sesión");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/alticelogo.png")));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 983, 671);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 51));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 51));
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblLogo = new JLabel("");
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogo.setBounds(369, 13, 228, 249);
        panel.add(lblLogo);

        ImageIcon icon = new ImageIcon(Login.class.getResource("/img/alticeblanco.png"));
        Image image = icon.getImage().getScaledInstance(228, 249, Image.SCALE_SMOOTH);
        lblLogo.setIcon(new ImageIcon(image));

        JPanel panelLogin = new JPanel();
        panelLogin.setBackground(new Color(0, 0, 51));
        panelLogin.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "", 
                TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
        panelLogin.setBounds(263, 291, 441, 298);
        panel.add(panelLogin);
        panelLogin.setLayout(null);

        JLabel lblUsuario = new JLabel("Correo");
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblUsuario.setBounds(191, 39, 58, 14);
        panelLogin.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(113, 64, 215, 30);
        panelLogin.add(txtUsuario);
        txtUsuario.setColumns(10);

        JLabel lblContraseña = new JLabel("Contraseña");
        lblContraseña.setForeground(Color.WHITE);
        lblContraseña.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblContraseña.setBounds(180, 123, 80, 14);
        panelLogin.add(lblContraseña);

        txtContra = new JPasswordField();
        txtContra.setBounds(113, 148, 215, 30);
        panelLogin.add(txtContra);

        btnIniciar = new JButton("Iniciar Sesión");
        btnIniciar.setForeground(Color.WHITE);
        btnIniciar.setBackground(new Color(0, 0, 51));
        btnIniciar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnIniciar.setBounds(151, 224, 139, 40);
        panelLogin.add(btnIniciar);

        // Acción del botón
        btnIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                intentarLogin();
            }
        });

        // === TECLA ENTER PARA INICIAR SESIÓN ===
        txtContra.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnIniciar.doClick();   // Simula clic en el botón
                }
            }
        });

        // Hacer que el botón Iniciar sea el botón por defecto al presionar Enter
        getRootPane().setDefaultButton(btnIniciar);
    }

    private static void crearUsuarioAdminPorDefecto() {
        Usuario admin = new Usuario("admin", "admin", "admin", Rol.ADMINISTRADOR);
        Altice.getInstance().regUsuario(admin);
        Altice.getInstance().guardarDatos();
        System.out.println("Usuario administrador por defecto creado (admin / admin)");
    }

    private void intentarLogin() {
        String usuario = txtUsuario.getText().trim();
        String password = new String(txtContra.getPassword());

        if (usuario.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar usuario y contraseña",
                "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (Altice.getInstance().confirmarLogin(usuario, password)) {
            Rol rol = Altice.getInstance().getRolUsuarioLogueado();
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            Altice.getInstance().producirPagos();

            if (rol == Rol.ADMINISTRADOR) {
                PrincipalAdmin principal = new PrincipalAdmin();
                principal.setVisible(true);
            } else if (rol == Rol.TECNICO || rol == Rol.COMERCIAL) {
                 PrincipalEmpleado principal = new PrincipalEmpleado();
                 principal.setVisible(true);
                JOptionPane.showMessageDialog(this, "Bienvenido, " + rol.name(), "Acceso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Rol no reconocido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos",
                "Acceso denegado", JOptionPane.ERROR_MESSAGE);
            txtContra.setText("");
            txtContra.requestFocus();
        }
    }
}