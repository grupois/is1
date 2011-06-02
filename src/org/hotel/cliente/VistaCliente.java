package org.hotel.cliente;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VistaCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private ControladorCliente controlador;
	private VistaCliente yo=this;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCliente frame = new VistaCliente(new ControladorCliente(null));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaCliente(final ControladorCliente cont) {
		this.controlador=cont;
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {}
			
			@Override
			public void windowIconified(WindowEvent arg0) {}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {}
			
			@Override
			public void windowClosing(WindowEvent arg0) {}

			@Override
			public void windowActivated(WindowEvent e) {}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				yo.setVisible(false);
			}
		
		});
		setBounds(100, 100, 450, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(21, 36, 61, 16);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(21, 73, 61, 16);
		contentPane.add(lblApellidos);
		
		textField = new JTextField();
		textField.setBounds(106, 30, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 67, 134, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(21, 113, 61, 16);
		contentPane.add(lblDni);
		
		textField_2 = new JTextField();
		textField_2.setBounds(106, 107, 134, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(21, 151, 82, 16);
		contentPane.add(lblNacionalidad);
		
		textField_3 = new JTextField();
		textField_3.setBounds(106, 145, 134, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCorreoe = new JLabel("Email");
		lblCorreoe.setBounds(21, 193, 52, 16);
		contentPane.add(lblCorreoe);
		
		textField_4 = new JTextField();
		textField_4.setBounds(106, 187, 134, 28);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		
		final JButton btnSeleccFoto = new JButton("Selecc. Foto");
		btnSeleccFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc=new JFileChooser();
				int returnVal = fc.showOpenDialog(null);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       btnSeleccFoto.setText("Insertado");
			       btnSeleccFoto.setText(fc.getSelectedFile().getAbsolutePath());
			    }
			}
		});
		btnSeleccFoto.setBounds(292, 36, 117, 58);
		contentPane.add(btnSeleccFoto);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente clientecancelar=controlador.cancelar();
				textField.setText(clientecancelar.getNombre());
				textField_1.setText(clientecancelar.getApellidos());
				textField_2.setText(clientecancelar.getDni());
				textField_3.setText(clientecancelar.getNacionalidad());
				textField_4.setText(clientecancelar.getCorreo());
				btnSeleccFoto.setText(clientecancelar.getRuta_foto());
				yo.setVisible(false);
			}
		});
		btnCancelar.setBounds(292, 186, 117, 29);
		contentPane.add(btnCancelar);

		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.aceptar(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(),
						textField_4.getText(), btnSeleccFoto.getText());
				yo.setVisible(false);
			}
		});
		btnAceptar.setBounds(292, 137, 117, 29);
		contentPane.add(btnAceptar);
		
	}
}
