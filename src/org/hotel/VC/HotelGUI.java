package org.hotel.VC;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.hotel.cliente.Cliente;
import org.hotel.cliente.ControladorCliente;
import org.hotel.cliente.VistaCliente;
import javax.swing.JButton;

public class HotelGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 140284042199982527L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					HotelGUI frame = new HotelGUI();
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
	public HotelGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 263);
		contentPane.add(tabbedPane);

		JPanel panelClientes=new JPanel();
		tabbedPane.addTab("Clientes",panelClientes);

		JPanel panelReservas = new JPanel();
		tabbedPane.addTab("Reservas", null, panelReservas, null);
		panelClientes.setLayout(null);
		panelClientes.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 429, 190);
		panelClientes.add(scrollPane);

		VistaCliente list = new VistaCliente();
		list.setVisibleRowCount(4);
		scrollPane.setColumnHeaderView(list);
		ControladorCliente contClient= new ControladorCliente();
		Cliente[] clientes=new Cliente[2];
		contClient.actualizarClientes(list, clientes);
		
		JButton btnAadirCliente = new JButton("Añadir Cliente");
		btnAadirCliente.setBounds(45, 199, 146, 25);
		panelClientes.add(btnAadirCliente);
		
		JButton btnEliminarCliente = new JButton("Eliminar Cliente");
		btnEliminarCliente.setBounds(222, 199, 146, 25);
		panelClientes.add(btnEliminarCliente);


		JPanel panelInstalaciones = new JPanel();
		panelInstalaciones.setToolTipText("");
		tabbedPane.addTab("Instalaciones", null, panelInstalaciones, null);
		panelInstalaciones.setLayout(null);

	}
}
