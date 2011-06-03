package org.hotel.VC;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.hotel.cliente.Cliente;
import org.hotel.cliente.ControladorListaClientes;
import org.hotel.cliente.GestorClientes;
import org.hotel.cliente.VistaListaClientes;

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
		tabbedPane.setBounds(0, 0, 444, 272);
		contentPane.add(tabbedPane);

		JPanel panelClientes=new JPanel();
		tabbedPane.addTab("Clientes",panelClientes);

		JPanel panelReservas = new JPanel();
		tabbedPane.addTab("Reservas", null, panelReservas, null);
		panelClientes.setLayout(null);
		panelClientes.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 423, 190);
		panelClientes.add(scrollPane);

		final VistaListaClientes list = new VistaListaClientes();
		list.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
		            Cliente client=(Cliente) list.getSelectedValue();
		            client.getVista().setVisible(true);
		         }
			}
		});
		list.setVisibleRowCount(4);
		scrollPane.setColumnHeaderView(list);
		final ControladorListaClientes contClient= new ControladorListaClientes();
		
		JButton btnAadirCliente = new JButton("A\u00F1adir Cliente");
		btnAadirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente client=GestorClientes.getInstance().anadirCliente();
				client.getVista().setVistaClientes(list);
				client.getVista().setControladorClientes(contClient);
				client.getVista().setVisible(true);
			}
		});
		
		btnAadirCliente.setBounds(46, 199, 146, 25);
		panelClientes.add(btnAadirCliente);
		
		JButton btnEliminarCliente = new JButton("Eliminar Cliente");
		btnEliminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente cl=(Cliente) list.getSelectedValue();
				cl.getVista().dispose();
				contClient.eliminarCliente(cl.getNumeroCliente());
				contClient.actualizarClientes(list);
			}
		});
		btnEliminarCliente.setBounds(222, 199, 146, 25);
		panelClientes.add(btnEliminarCliente);


		JPanel panelInstalaciones = new JPanel();
		panelInstalaciones.setToolTipText("");
		tabbedPane.addTab("Instalaciones", null, panelInstalaciones, null);
		panelInstalaciones.setLayout(null);

	}
	
	public void notificar() {
		
	}
}
