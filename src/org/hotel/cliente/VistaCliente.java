package org.hotel.cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class VistaCliente extends JList{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public VistaCliente() {
		this.setCellRenderer(new item());
	}

	public void displayClientes(Cliente[] clientes) {
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
			//Cliente client=(Cliente) value;
			ImageIcon ss=new ImageIcon("Basketball.png");
			setLayout(new BorderLayout());
			add(new JLabel("Probando1"),BorderLayout.EAST);
			setIconTextGap(1);
			setIcon(ss);
			setText("Probando2");

			//add(new JLabel(client.getNombre()),);
			if (isSelected) {
				setBackground(Color.yellow);
				setForeground(Color.white);
			} else {
				setBackground(Color.white);
				setForeground(Color.black);
			}			
			return this;
		}

	}
}