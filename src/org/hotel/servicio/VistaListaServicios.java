package org.hotel.servicio;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class VistaListaServicios extends JList {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VistaListaServicios() {
		this.setCellRenderer(new item());
	}

	public void displayReservas(Object[] servicios) {
		this.setListData(servicios);
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
			setText(((ServicioGenerico) value).getServicio());
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
