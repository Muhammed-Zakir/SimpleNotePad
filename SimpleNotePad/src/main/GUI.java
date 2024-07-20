package main;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUI implements ActionListener{
		
	JFrame window; // the JFrame object declared
	// TEXT AREA
	JTextArea textArea; // the JTextArea object declared
	JScrollPane scrollPane;
	boolean wordWrapOn = false;
	// TOP MENU BAR
	JMenuBar menuBar;
	JMenu menuFile, menuEdit, menuFormat, menuColor;
	// FILE ITEM
	JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
	// FORMAT MENU
	JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize10, iFontSize12, iFontSize14, iFontSize16, iFontSize18;	  	
	JMenu menuFont, menuFontSize;
	// COLOR MENU
	JMenuItem iColor1, iColor2, iColor3;
	
	Function_File file = new Function_File(this);
	Function_Format format = new Function_Format(this);
	Function_Color color = new Function_Color(this);
	
	public static void main(String[] args) {
		new GUI(); // the GUI object instantiated
		
	}
	
	public GUI() {
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createFormatMenu();
		createColor();
		
		format.selectedFont = "Arial";
		format.createFont(16);
		format.textWrap();
		
		color.setColor("White");
		window.setVisible(true);
		
	}
	
	public void createWindow() {
		window = new JFrame("Notepad"); // JFrame object instantiated
		window.setSize(800, 600); // setSize from JFrame
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // GUI exit operation from JFrame
	
	}
	
	public void createTextArea() {
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
	}
	
	public void createMenuBar() {
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);
		
		menuFile = new JMenu("File");
		menuBar.add(menuFile);

		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);

		menuFormat = new JMenu("Format");
		menuBar.add(menuFormat);

		menuColor = new JMenu("Color");
		menuBar.add(menuColor);
		
	}
	
	public void createFileMenu() {
		iNew = new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew);
		
		iOpen = new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		menuFile.add(iOpen);
		
		iSave = new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);
		
		iSaveAs = new JMenuItem("Save As");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("Save As");
		menuFile.add(iSaveAs);
		
		iExit = new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);
		
	}
	
	public void createFormatMenu() {
		iWrap = new JMenuItem("Wrap text: Off");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Wrap text");
		menuFormat.add(iWrap);
		
		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);
		
		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);
		
		iFontCSMS = new JMenuItem("Comic Sans MS");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Sans MS");
		menuFont.add(iFontCSMS);
		
		iFontTNR = new JMenuItem("Times New Roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("Times New Roman");
		menuFont.add(iFontTNR);
		
		menuFontSize = new JMenu("Font Size");
		menuFormat.add(menuFontSize);
		
		iFontSize8 = new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("size8");
		menuFontSize.add(iFontSize8);

		iFontSize10 = new JMenuItem("10");
		iFontSize10.addActionListener(this);
		iFontSize10.setActionCommand("size10");
		menuFontSize.add(iFontSize10);
		
		iFontSize12 = new JMenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("size12");
		menuFontSize.add(iFontSize12);
	
		iFontSize14 = new JMenuItem("14");
		iFontSize14.addActionListener(this);
		iFontSize14.setActionCommand("size14");
		menuFontSize.add(iFontSize14);
		
		iFontSize16 = new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("size16");
		menuFontSize.add(iFontSize16);
		
		iFontSize18 = new JMenuItem("18");
		iFontSize18.addActionListener(this);
		iFontSize18.setActionCommand("size18");
		menuFontSize.add(iFontSize18);
	}
	
	public void createColor() {
		iColor1 = new JMenuItem("White");
		iColor1.addActionListener(this);
		iColor1.setActionCommand("White");
		menuColor.add(iColor1);

		iColor2 = new JMenuItem("Blue");
		iColor2.addActionListener(this);
		iColor2.setActionCommand("Blue");
		menuColor.add(iColor2);

		iColor3 = new JMenuItem("Black");
		iColor3.addActionListener(this);
		iColor3.setActionCommand("Black");
		menuColor.add(iColor3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		switch(command) {
		case "New":
			file.newFile(); break;
		case "Open":
			file.open(); break;
		case "Save":
			file.save(); break;
		case "Save As":
			file.saveAs(); break;		
		case "Exit":
			file.exit(); break;
		case "Wrap text":
			format.textWrap(); break;
		case "Arial":
			format.setFont(command); break;
		case "Comic Sans MS":
			format.setFont(command); break;
		case "Times New Roman":
			format.setFont(command); break;
		case "size8":
			format.createFont(8); break;
		case "size10":
			format.createFont(10); break;
		case "size12":
			format.createFont(12); break;
		case "size14":
			format.createFont(14); break;
		case "size16":
			format.createFont(16); break;
		case "size18":
			format.createFont(18); break;
		case "White":
			color.setColor(command); break;
		case "Black":
			color.setColor(command); break;
		case "Blue":
			color.setColor(command); break;
	}
	}
}
