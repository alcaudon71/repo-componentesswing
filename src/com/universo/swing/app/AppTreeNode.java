package com.universo.swing.app;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

public class AppTreeNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoTree miMarco = new MarcoTree();

		// El cierre de este Frame cierra el programa
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		miMarco.setVisible(true);

	}
	
}

// Frame
class MarcoTree extends JFrame {

	private static final String FRAME_TITULO = "Panel Vista Arbol";
	private static final Integer FRAME_POS_HORIZONTAL = 300;
	private static final Integer FRAME_POS_VERTICAL = 300;
	public static final Integer FRAME_ANCHO = 500;
	public static final Integer FRAME_ALTO = 350;
	
	public static final String URL_LEAF_ICON = "C:\\Users\\jjsanchez\\eclipse-workspace-2021\\swing\\ComponentesSwing\\src\\com\\universo\\swing\\img\\manta-raya.png";
	public static final String URL_OPEN_ICON = "C:\\Users\\jjsanchez\\eclipse-workspace-2021\\swing\\ComponentesSwing\\src\\com\\universo\\swing\\img\\magia.png";
	public static final String URL_CLOSED_ICON = "C:\\Users\\jjsanchez\\eclipse-workspace-2021\\swing\\ComponentesSwing\\src\\com\\universo\\swing\\img\\salero.png";

	public MarcoTree() {

		setTitle (FRAME_TITULO);

		setBounds(FRAME_POS_HORIZONTAL, FRAME_POS_VERTICAL, FRAME_ANCHO, FRAME_ALTO);

		JPanel lamina = new JPanel();

		// Creamos el nodo raiz
		DefaultMutableTreeNode nodoRaiz = new DefaultMutableTreeNode("Tierra");
		 
		// Creamos el modelo del arbol
		DefaultTreeModel modeloArbol = new DefaultTreeModel(nodoRaiz);
		
		// Creamos la vista del arbol
		JTree vistaArbol = new JTree(nodoRaiz);
		
		// Creamos nodos de primer nivel 
		DefaultMutableTreeNode nodoEuropa = new DefaultMutableTreeNode("Europa");
		DefaultMutableTreeNode nodoAmerica = new DefaultMutableTreeNode("America");
		DefaultMutableTreeNode nodoAfrica = new DefaultMutableTreeNode("Africa");
		
		// Creamos nodos de segundo nivel
		DefaultMutableTreeNode nodoSpain = new DefaultMutableTreeNode("España");
		DefaultMutableTreeNode nodoPortugal = new DefaultMutableTreeNode("Portugal");
		DefaultMutableTreeNode nodoItalia = new DefaultMutableTreeNode("Italia");
		
		// Creamos nodos de tercer nivel
		DefaultMutableTreeNode nodoAndalucia = new DefaultMutableTreeNode("Andalucia");
		DefaultMutableTreeNode nodoMadrid = new DefaultMutableTreeNode("Madrid");
		DefaultMutableTreeNode nodoValencia = new DefaultMutableTreeNode("Valencia");
		DefaultMutableTreeNode nodoToscana = new DefaultMutableTreeNode("Toscana");
		
		// Creamos nodos de cuarto nivel
		DefaultMutableTreeNode nodoGranada = new DefaultMutableTreeNode("Granada");
		DefaultMutableTreeNode nodoSevilla = new DefaultMutableTreeNode("Sevilla");
		DefaultMutableTreeNode nodoMalaga = new DefaultMutableTreeNode("Malaga");
		
		// Establecemos relaciones del modelo
		nodoRaiz.add(nodoAmerica);
		nodoRaiz.add(nodoAfrica);
		nodoRaiz.add(nodoEuropa);
		
		nodoEuropa.add(nodoPortugal);
		nodoEuropa.add(nodoItalia);
		nodoEuropa.add(nodoSpain);
		
		nodoSpain.add(nodoMadrid);
		nodoSpain.add(nodoValencia);
		nodoSpain.add(nodoAndalucia);
		nodoItalia.add(nodoToscana);
		
		nodoAndalucia.add(nodoSevilla);
		nodoAndalucia.add(nodoMalaga);
		nodoAndalucia.add(nodoGranada);
		
		// Recuperamos el Render del Arbol
		DefaultTreeCellRenderer renderArbol = (DefaultTreeCellRenderer) vistaArbol.getCellRenderer();
		
		// Establecemos los iconos de los nodos del Arbol
		renderArbol.setLeafIcon(new ImageIcon(URL_LEAF_ICON));
		renderArbol.setOpenIcon(new ImageIcon(URL_OPEN_ICON));
		renderArbol.setClosedIcon(new ImageIcon(URL_CLOSED_ICON));
		
		// Recargamos la vista del Arbol
		vistaArbol.repaint();
		
		lamina.add(vistaArbol);
		lamina.setBackground(Color.cyan);
		
		//this.getContentPane().add(lamina, BorderLayout.CENTER);
		JScrollPane scroll = new JScrollPane(lamina);
		
		this.getContentPane().add(scroll);

	}

}
