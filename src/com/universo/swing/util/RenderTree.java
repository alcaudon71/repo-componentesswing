package com.universo.swing.util;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

public class RenderTree extends JPanel implements TreeCellRenderer {

	public static final String URL_LEAF_ICON = "C:\\Users\\jjsanchez\\eclipse-workspace-2021\\swing\\ComponentesSwing\\src\\com\\universo\\swing\\img\\manta-raya.png";
	public static final String URL_OPEN_ICON = "C:\\Users\\jjsanchez\\eclipse-workspace-2021\\swing\\ComponentesSwing\\src\\com\\universo\\swing\\img\\magia.png";
	public static final String URL_CLOSED_ICON = "C:\\Users\\jjsanchez\\eclipse-workspace-2021\\swing\\ComponentesSwing\\src\\com\\universo\\swing\\img\\salero.png";

	private JButton   botonIcono = new JButton();
	private JButton   botonTexto = new JButton();
	   
	private ImageIcon iconoHoja = new ImageIcon(URL_LEAF_ICON);
	private ImageIcon iconoAbierto = new ImageIcon(URL_OPEN_ICON);
	private ImageIcon iconoCerrado = new ImageIcon(URL_CLOSED_ICON);
	   
	public RenderTree() {
		
		add(botonIcono);
		add(botonTexto);
		setOpaque(false);
		   
	}

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {
		// TODO Auto-generated method stub
		
		// Se pone el icono adecuado
		if (leaf)
		{
		   botonIcono.setIcon(iconoHoja);
		}
		else if (expanded)
		{
		   botonIcono.setIcon(iconoAbierto);
		}
		else
		{
		   botonIcono.setIcon(iconoCerrado);
		}

		// Y el texto.
		DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) value;
		String texto = nodo.getUserObject().toString();
		botonTexto.setText(texto);
		   
		return this;
	}
	
}
