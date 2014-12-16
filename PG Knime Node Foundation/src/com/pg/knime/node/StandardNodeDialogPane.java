package com.pg.knime.node;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.knime.core.node.NodeDialogPane;


public abstract class StandardNodeDialogPane extends NodeDialogPane {

	
	protected JPanel buildStandardPanel ( LabelComponentPair... pairs ) {
		int ypos = 0;
		
		JPanel pnl = new JPanel( new GridBagLayout() );
		
		for ( LabelComponentPair pair : pairs ) {
			if ( !"".equals(pair.getLabel()) && pair.getLabel() != null )
				pnl.add(new JLabel(pair.getLabel()), getGBC(0, ypos++, 0, 0));
			
			pnl.add(pair.getComponent(), getGBC(0, ypos++, 1, 0));
		}
		
		return pnl;
	}
	
	
	protected static GridBagConstraints getGBC(int gridx, int gridy, int weightx, int weighty) {
		return new GridBagConstraints(gridx, // gridx
				gridy, // gridy
				1, // gridwidth
				1, // gridheight
				weightx, // weightx
				weighty, // weighty
				GridBagConstraints.NORTHWEST, // anchor
				GridBagConstraints.HORIZONTAL, // fill
				new Insets(5, 5, 5, 5), // insets
				0, // ipadx
				0); // ipady
	}
	
	protected class LabelComponentPair {
		
		private String label;
		private Component component;
		
		public LabelComponentPair( String label, Component component ) {
			this.label = label;
			this.component = component;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public Component getComponent() {
			return component;
		}

		public void setComponent(Component component) {
			this.component = component;
		}
		
	}
	
}
