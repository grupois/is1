package org.hotel.reserva;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class VistaListaReservas extends JList{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VistaListaReservas() {
		this.setCellRenderer(new item());
	}

	public void displayReservas(Object[] reservas) {
		this.setListData(reservas);
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
			Reserva res=(Reserva) value;
			setText(res.toString());
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
