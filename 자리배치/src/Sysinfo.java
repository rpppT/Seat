import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Sysinfo extends JFrame {
	private JTextArea textArea = new JTextArea();
	private JScrollPane scroll = new JScrollPane(textArea);

	public Sysinfo() {
		textArea.setEnabled(false);
		textArea.setDisabledTextColor(Color.black);
		add(scroll);
		setPreferredSize(new Dimension(500, 500));
		pack();
		setResizable(false);
		setVisible(true);
	}

	public void print_info() {
		textArea.append(System.getProperty("java.runtime.version") + "\n");
		Properties prop = System.getProperties();
		Enumeration<Object> print_data = (Enumeration<Object>) prop.propertyNames();

		String key = "";
		while (print_data.hasMoreElements()) {
			key = (String) print_data.nextElement();
			textArea.append(key + "=" + System.getProperty(key) + "\n");
			textArea.setCaretPosition(textArea.getDocument().getLength());
		}
//		Read_Byte();
	}
	public void Read_Byte() {
		try {
			File path = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
			

			if(!path.exists())
				dispose();
			
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
			
			int [] data = new int[bis.available()];
			int i;
			
			for(i = 0 ; i<data.length; i++)
				data[i] = bis.read();
			
			for(i=0; i<data.length; i++) {
				textArea.append(Integer.toHexString(data[i])+"\t");
				if(i %5 == 0)
					textArea.append("\n");
				textArea.setCaretPosition(textArea.getDocument().getLength());
			}
			for(i = 0 ; i<data.length; i++) {
				textArea.append(Integer.toBinaryString(data[i]));
				if(i%5 == 0)
					textArea.append("\n");
				textArea.setCaretPosition(textArea.getDocument().getLength());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dispose();
	}
}
