package com.universo.swing.util;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellEditor;

public class EditorTree extends JComboBox implements TreeCellEditor {

	/** 
     * Observadores --> Lista de suscriptores a eventos de edicion  
     */
    private LinkedList<CellEditorListener> observadores = new LinkedList<CellEditorListener>();
    
    // --------------------
    // Constructor
    // --------------------
	public EditorTree() {
		super();
		// TODO Auto-generated constructor stub
		
	      // Posibles items del JComboBox
        addItem("España");
        addItem("Portugal");
        addItem("Italia");
        addItem("Francia");
        addItem("Alemania");
        addItem("Holanda");
        
        addItem("Madrid");
        addItem("Valencia");
        addItem("Andalucia");
        addItem("Cataluña");
        addItem("Aragon");
        addItem("Galicia");
        
        // Listener para enterarnos de cuando el usuario selecciona algún item
        addActionListener(
            new ActionListener() {
            	
                public void actionPerformed(ActionEvent e) {
                	
                    // Cuando el usuario selecciona el item, avisamos a los
                    // suscriptores de que la edición ha terminado.
                    Iterator<CellEditorListener> iterador = observadores.iterator();

                    while (iterador.hasNext())
                    {
                    	CellEditorListener observador = iterador.next();
                    	observador.editingStopped(new ChangeEvent(EditorTree.this));
                    }
                }
            }
        );
        
	}

    /**
     * Debemos devolver el dato que ha recogido el editor
     *
     * @return El dato.
     */
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		
		return getSelectedItem();
		
	}

    /**
     * Nos pasan el evento que ha sucedido sobre el nodo y debemos decidir si es
     * un evento para empezar a editar o no.
     * En este ejemplo se comprobara si es un triple click de raton. El doble click
     * ya lo tiene reservado el JTree para expandir/contraer nodos.
     *
     * @param anEvent Evento.
     *
     * @return true si se debe empezar a editar el nodo.
     */
	@Override
	public boolean isCellEditable(EventObject anEvent) {
		// TODO Auto-generated method stub
		
	      // Se comprueba si el evento es un evento de ratón
        if (anEvent instanceof MouseEvent)
        {
          // Y si es tripe click
            if (((MouseEvent) anEvent).getClickCount() == 3)
            {
                return true;
            }
        }

        // En caso contrario no hay que editar.
        return false;
	}

    /**
     * Para decidir si cuando se edita una celda, debe a su vez seleccionarse.
     * Habitualmente se devuelve true, ya que al editar se suele querer que se
     * seleccione.
     * Se pude devolver false si se quiere editar una celda sin que se deseleccionen
     * otras posibles celdas del JTree que estuvieran seleccionadas y sin que se
     * seleccione la celda que estamos editando.
     *
     * @param anEvent Evento que ha ocurrido sobre la celda.
     *
     * @return true si queremos que se seleccione.
     */
	@Override
	public boolean shouldSelectCell(EventObject anEvent) {
		// TODO Auto-generated method stub
		
		return true;
		
	}

	@Override
	public boolean stopCellEditing() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cancelCellEditing() {
		// TODO Auto-generated method stub
		
	}

    /**
     * Añade un nuevo suscriptor a cambios en el editor.
     *
     * @param l Un suscriptor
     */
	@Override
	public void addCellEditorListener(CellEditorListener l) {
		// TODO Auto-generated method stub
		
		observadores.add(l);
		
	}

	/**
     * Borra al suscriptor de la lista de suscriptores
     *
     * @param l Suscriptores
     */
	@Override
	public void removeCellEditorListener(CellEditorListener l) {
		// TODO Auto-generated method stub
		
		observadores.remove(l);
		
	}

    /**
     * Devuelve el Component que se usara para editar el dato.
     *
     * @param tree 			JTree en el que esta el dato que se va a editar
     * @param value 		El dato a editar. Este valor debe meterse en el Component
     * 							que se usa para editar, de forma que sea el que se muestre.
     * @param isSelected 	Si el dato esta seleccionado en el JTree
     * @param expanded 		Si el nodo del dato esta expandido
     * @param leaf 			Si el nodo del dato es hoja (no tiene hijos)
     * @param row 			Fila del JTree en el que esta el dato.
     *
     * @return 				El Component que hace de editor, mostrando value.
     */
	@Override
	public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded,
			boolean leaf, int row) {
		// TODO Auto-generated method stub
		
	    // Se marca el contenido de value como dato a mostrar en el JComboBox
		DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) value;
        setSelectedItem(nodo.getUserObject().toString());

        return this;
	}

}
