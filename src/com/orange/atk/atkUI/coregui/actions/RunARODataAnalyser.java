package com.orange.atk.atkUI.coregui.actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.Icon;

import org.apache.log4j.Logger;

public class RunARODataAnalyser extends MatosAbstractAction {

	private static final String AROPATH = "ARO\\ARODataAnalyzer";
	private static final String LAUNCHARO = "cmd /c start aro.bat";

	public RunARODataAnalyser(String name, Icon icon, String shortDescription) {
		super(name, icon, shortDescription);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			Logger.getLogger(getClass()).info(LAUNCHARO);
			Runtime.getRuntime().exec(LAUNCHARO, null, new File(AROPATH + "\\bin"));
		} catch (IOException e) {
			Logger.getLogger(this.getClass()).error("Unable to start ARODataAnalyzer", e);
		}
	}

}
