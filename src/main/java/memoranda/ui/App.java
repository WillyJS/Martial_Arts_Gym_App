package main.java.memoranda.ui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import main.java.memoranda.EventsScheduler;
import main.java.memoranda.util.Configuration;

/**
 * 
 * Copyright (c) 2003 Memoranda Team. http://memoranda.sf.net
 */

/* $Id: App.java,v 1.28 2007/03/20 06:21:46 alexeya Exp $ */
public class App {
	// boolean packFrame = false;

	static AppFrame frame = null;
	FileInputStream versionInput;

	public static final String GUIDE_URL = "https://github.com/amehlhase316/Dresden-2";
	public static final String BUGS_TRACKER_URL = "http://sourceforge.net/tracker/?group_id=90997&atid=595566";
	public static final String WEBSITE_URL = "https://github.com/amehlhase316/Dresden-2";

	/* ======================================================================== */
	/*
	 * Note: Please DO NOT edit the version/build info manually! The actual values
	 * are substituted by the Ant build script using 'version' property and
	 * datestamp.
	 */

	public static String VERSION_INFO = "1.0.0";
	public static String BUILD_INFO = "1.0.0";

	/* ======================================================================== */

	public static AppFrame getFrame() {
		return frame;
	}

	public void show() {
		if (frame.isVisible()) {
			frame.toFront();
			frame.requestFocus();
		} else
			init();
	}

	public App(boolean fullmode) {
		super();

		//When gradle build is run the version number will be incremented and pulled from build.gradle
		try{
			versionInput = new FileInputStream("version.properties");
			Properties resource = new Properties();
			resource.load(versionInput);
			VERSION_INFO = resource.getProperty("VERSION_INFO");
			BUILD_INFO = resource.getProperty("BUILD_INFO");
		} catch (IOException ex){
			ex.printStackTrace();
		}

		if (fullmode) {
			fullmode = !Configuration.get("START_MINIMIZED").equals("yes");
		}
		/* DEBUG */
		if (!fullmode) {
			System.out.println("Minimized mode");
		}
		System.out.println(VERSION_INFO);
		System.out.println(Configuration.get("LOOK_AND_FEEL"));
		try {
			if (Configuration.get("LOOK_AND_FEEL").equals("system"))
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			else if (Configuration.get("LOOK_AND_FEEL").equals("default"))
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			else if (Configuration.get("LOOK_AND_FEEL").toString().length() > 0)
				UIManager.setLookAndFeel(Configuration.get("LOOK_AND_FEEL").toString());

		} catch (Exception e) {
			new ExceptionDialog(e, "Error when initializing a pluggable look-and-feel. Default LF will be used.",
					"Make sure that specified look-and-feel library classes are on the CLASSPATH.");
		}
		if (Configuration.get("FIRST_DAY_OF_WEEK").equals("")) {
			String fdow;
			if (Calendar.getInstance().getFirstDayOfWeek() == 2)
				fdow = "mon";
			else
				fdow = "sun";
			Configuration.put("FIRST_DAY_OF_WEEK", fdow);
			Configuration.saveConfig();
			/* DEBUG */
			System.out.println("[DEBUG] first day of week is set to " + fdow);
		}

		EventsScheduler.init();
		frame = new AppFrame();
		if (fullmode) {
			init();
		}
	}

	static void init() {
		/*
		 * if (packFrame) { frame.pack(); } else { frame.validate(); }
		 * 
		 * Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		 * 
		 * Dimension frameSize = frame.getSize(); if (frameSize.height >
		 * screenSize.height) { frameSize.height = screenSize.height; } if
		 * (frameSize.width > screenSize.width) { frameSize.width = screenSize.width; }
		 * 
		 * 
		 * Make the window fullscreen - On Request of users This seems not to work on
		 * sun's version 1.4.1_01 Works great with 1.4.2 !!! So update your J2RE or
		 * J2SDK.
		 */
		/* Used to maximize the screen if the JVM Version if 1.4 or higher */
		/* --------------------------------------------------------------- */
		double JVMVer = Double.valueOf(System.getProperty("java.version").substring(0, 3)).doubleValue();

		frame.pack();
		if (JVMVer >= 1.4) {
			frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		} else {
			frame.setExtendedState(Frame.NORMAL);
		}
		/* --------------------------------------------------------------- */
		/* Added By Jeremy Whitlock (jcscoobyrs) 07-Nov-2003 at 15:54:24 */

		// Not needed ???
		frame.setVisible(true);
		frame.toFront();
		frame.requestFocus();
	}

	public static void closeWindow() {
		if (frame == null)
			return;
		frame.dispose();
	}
}