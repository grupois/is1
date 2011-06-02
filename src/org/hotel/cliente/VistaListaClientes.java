package org.hotel.cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

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
			if (client.getRuta_foto()!=null) {
				ImageIcon ss=new ImageIcon(client.getRuta_foto());
				ss.setImage(ss.getImage().getScaledInstance(30, 30, VERTICAL_WRAP));
				setIconTextGap(1);
				setIcon(ss);
			}
			if(client.getApellidos()!=null)
				setText(client.getNumeroCliente()+"\t\t\t\t\t\t\t\t"+client.getApellidos()+", "+client.getNombre());

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