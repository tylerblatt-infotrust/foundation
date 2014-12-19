package com.pg.knime.node;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.knime.core.node.NodeDialogPane;

public abstract class StandardNodeDialogPane extends NodeDialogPane {

	protected JPanel buildStandardPanel(LabelComponentPair... pairs) {
		int ypos = 0;

		JPanel pnl = new JPanel(new GridBagLayout());

		for (LabelComponentPair pair : pairs) {
			if (!"".equals(pair.getLabel()) && pair.getLabel() != null)
				pnl.add(new JLabel(pair.getLabel()), getGBC(0, ypos++, 0, 0));
			if (pair.getComponent()!=null )
				pnl.add(pair.getComponent(), getGBC(0, ypos, 1, 0));
			if ( pair.getButton() != null ) 
				pnl.add(pair.getButton(), getGBC(1, ypos, 0, 0 ));
			
			ypos++;
		}

		// If any space at bottom
		pnl.add(new JPanel(), getGBC(0, ypos++, 1, 100));
		
		return pnl;
	}

	protected static GridBagConstraints getGBC(int gridx, int gridy,
			int weightx, int weighty) {
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

		private String label = null;
		private Component component = null;
		private Component button = null;

		public LabelComponentPair(String label, Component component) {
			this.label = label;
			this.component = component;
		}

		public LabelComponentPair(String label, Component component, Component button) {
			this.label = label;
			this.component = component;
			this.button = button;
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
		
		public Component getButton() {
			return button;
		}

	}

	protected class PanelBuilder {

		List<LabelComponentPair> items = new ArrayList<LabelComponentPair>();

		public PanelBuilder() {
		}

		public PanelBuilder add(String label) {
			items.add(new LabelComponentPair(label, null));
			return this;
		}
		
		public PanelBuilder add(String label, Component component) {
			items.add(new LabelComponentPair(label, component));
			return this;
		}
		
		public PanelBuilder add(String label, Component component, Component button) {
			items.add(new LabelComponentPair(label, component, button));
			return this;
		}

		public LabelComponentPair[] build() {
			return this.items.toArray(new LabelComponentPair[] {});
		}

	}

}
