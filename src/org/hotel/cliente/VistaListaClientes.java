package org.hotel.cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class VistaListaClientes extends JList{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public VistaListaClientes() {
		this.setCellRenderer(new item());
	}

	public void displayClientes(Object[] clientes) {
		this.setListData(clientes);
	}

	class item extends JLabel implements ListCellRenderer{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public item() {
			setOpaque(true);
			setIconTextGap(1);
		}


		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			Cliente client=(Cliente) value;
			String ruta=client.getRuta_foto().equals("Selecc. Foto")? "unknown.png" : client.getRuta_foto();
			ImageIcon ss=new ImageIcon(ruta);
			ss.setImage(ss.getImage().getScaledInstance(30, 30, VERTICAL_WRAP));
			setIconTextGap(1);
			setIcon(ss);
			if(client.getApellidos()!=null)
				setText("\t\t\t\t\t\t\t\t"+client.getNumeroCliente()+"\t\t\t\t\t\t\t\t"+client.getApellidos()+", "+client.getNombre());

			//add(new JLabel(client.getNombre()),);
			if (isSelected) {
				setBackground(Color.gray);
				setForeground(Color.white);
			} else {
				setBackground(Color.white);
				setForeground(Color.black);
			}		
			return this;
		}

	}
}