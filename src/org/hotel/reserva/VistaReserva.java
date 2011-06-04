package org.hotel.reserva;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import org.hotel.servicio.GestorServicios;
import org.hotel.servicio.ServicioGenerico;
import org.hotel.servicio.VistaListaServicios;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.SwingConstants;

public class VistaReserva extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private VistaReserva yo=this;
	private ControladorListaReservas contListRes;
	private VistaListaReservas vistaListRes;

	public void setVistaListRes(VistaListaReservas vistaListRes) {
		this.vistaListRes = vistaListRes;
	}

	public void setContListRes(ControladorListaReservas contListRes) {
		this.contListRes = contListRes;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaReserva frame = new VistaReserva(null,null);
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
	public VistaReserva(final ControladorReserva contRes,final Reserva res) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFechaInicioReserva = new JLabel("Fecha Inicio Reserva");
		lblFechaInicioReserva.setBounds(12, 12, 153, 15);
		contentPane.add(lblFechaInicioReserva);

		String[] dias=new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		String[] meses=new String[] {"Ene.", "Feb.", "Mar.", "Abr.", "May.", "Jun.", "Jul.", "Ago.", "Sep.", "Oct.", "Nov.", "Dic."};
		String[] anos=new String[] {"2011", "2012", "2013", "2014", "2015"};
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(dias));
		comboBox.setBounds(12, 30, 44, 24);
		contentPane.add(comboBox);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(meses));
		comboBox_1.setBounds(68, 30, 62, 24);
		contentPane.add(comboBox_1);

		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(anos));
		comboBox_2.setBounds(142, 30, 60, 24);
		contentPane.add(comboBox_2);

		JLabel lblFechaFinReserva = new JLabel("Fecha Fin Reserva");
		lblFechaFinReserva.setBounds(232, 12, 153, 15);
		contentPane.add(lblFechaFinReserva);

		final JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(dias));
		comboBox_3.setBounds(232, 30, 44, 24);
		contentPane.add(comboBox_3);

		final JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(meses));
		comboBox_4.setBounds(288, 30, 62, 24);
		contentPane.add(comboBox_4);

		final JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(anos));
		comboBox_5.setBounds(362, 30, 60, 24);
		contentPane.add(comboBox_5);

		JLabel lblNewLabel = new JLabel("Escoja el servicio que desee reservar");
		lblNewLabel.setBounds(22, 66, 313, 15);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 91, 410, 114);
		contentPane.add(scrollPane);

		final JLabel lblNewLabel_1 = new JLabel("0 €");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(347, 66, 70, 15);
		contentPane.add(lblNewLabel_1);

		final VistaListaServicios list = new VistaListaServicios();
		list.displayReservas(GestorServicios.getInstance().getArrayServicios());
		scrollPane.setColumnHeaderView(list);

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
				lblNewLabel_1.setText(((ServicioGenerico)list.getSelectedValue()).getPrecioBase()+" €");
			}
		});

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((comboBox_2.getSelectedIndex()<comboBox_5.getSelectedIndex())||(comboBox_2.getSelectedIndex()<=comboBox_5.getSelectedIndex()&&
						comboBox_1.getSelectedIndex()<comboBox_4.getSelectedIndex())||(comboBox_2.getSelectedIndex()<=comboBox_5.getSelectedIndex()&&
								comboBox_1.getSelectedIndex()<=comboBox_4.getSelectedIndex()&&comboBox.getSelectedIndex()<comboBox_3.getSelectedIndex())) {
					contRes.aceptarReserva(comboBox.getSelectedIndex()+1, comboBox_1.getSelectedIndex()+1,
							comboBox_2.getSelectedIndex()+2011,comboBox_3.getSelectedIndex()+1,
							comboBox_4.getSelectedIndex()+1, comboBox_5.getSelectedIndex()+2011,
							((ServicioGenerico) list.getSelectedValue()).reservar(comboBox.getSelectedIndex()+1,
									comboBox_1.getSelectedIndex()+1, comboBox_2.getSelectedIndex()+2011,
									comboBox_3.getSelectedIndex()+1, comboBox_4.getSelectedIndex()+1, comboBox_5.getSelectedIndex()+2011));
					contListRes.actualizarClientes(vistaListRes);
					yo.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(yo, "La fecha final debe ser superior a la inicial", "Error en las fechas", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAceptar.setBounds(72, 217, 117, 25);
		contentPane.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contRes.cancelarReserva()) {
					yo.dispose();
				}else{
					int[] fechas=res.getInicioFechaReserva();
					comboBox.setSelectedIndex(fechas[1]-1);
					comboBox_1.setSelectedIndex(fechas[2]-1);
					comboBox_2.setSelectedIndex(fechas[3]-2011);
					fechas=res.getFinFechaReserva();
					comboBox_3.setSelectedIndex(fechas[1]-1);
					comboBox_4.setSelectedIndex(fechas[2]-1);
					comboBox_5.setSelectedIndex(fechas[3]-2011);
					list.setSelectedValue(res.getServicio(), true);
				}
				contListRes.actualizarClientes(vistaListRes);
			}
		});
		btnCancelar.setBounds(232, 217, 117, 25);
		contentPane.add(btnCancelar);

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
			public void windowClosing(WindowEvent arg0) {
				if (contRes.cancelarReserva()) {
					yo.dispose();
				}else{
					int[] fechas=res.getInicioFechaReserva();
					comboBox.setSelectedIndex(fechas[1]-1);
					comboBox_1.setSelectedIndex(fechas[2]-1);
					comboBox_2.setSelectedIndex(fechas[3]-2011);
					fechas=res.getFinFechaReserva();
					comboBox_3.setSelectedIndex(fechas[1]-1);
					comboBox_4.setSelectedIndex(fechas[2]-1);
					comboBox_5.setSelectedIndex(fechas[3]-2011);
					list.setSelectedValue(res.getServicio(), true);
				}
				contListRes.actualizarClientes(vistaListRes);
			}

			@Override
			public void windowActivated(WindowEvent e) {}

			@Override
			public void windowClosed(WindowEvent arg0) {}

		});
	}
}
