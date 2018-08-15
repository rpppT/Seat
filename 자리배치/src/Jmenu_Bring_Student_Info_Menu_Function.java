import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class Jmenu_Bring_Student_Info_Menu_Function extends JFrame implements  Serializable{
	public static final long serialVersionUID = 1111111111111111111L;//Ŭ���� ���� ���̵�

	int unabledButtonCount;
	
	public Jmenu_Bring_Student_Info_Menu_Function() {
		setTitle("Made by rppt");
		Main.Screenshot_Menu.setEnabled(false);
		Main.Assigned_Seat_Menu.setEnabled(false);	
	}

	public int checkButtonUnabled(int size) {
		for(int i=0; i<Main.button.length; i++) {
			if(!Main.button[i].isEnabled()) {
				unabledButtonCount++;
			}
		}
		if(Main.button.length - unabledButtonCount >= size)
			return 0;
		else 
			return -1;
	}
	
	
@SuppressWarnings({ "resource", "unchecked" })
	public void GetData() {
        JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
        chooser.setCurrentDirectory(new File(System.getProperty("user.home"))); 
        chooser.setAcceptAllFileFilterUsed(true);   
        chooser.setDialogTitle("�л� ������  ��������"); 
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setMultiSelectionEnabled(false);
        
        int returnVal = chooser.showOpenDialog(null); 
        
        if(returnVal == JFileChooser.APPROVE_OPTION) { 
        	File open_file = chooser.getSelectedFile();
        	if(open_file.exists()) {
        		try {
					ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(open_file));

					Main.Screenshot_Menu.setEnabled(true);
					
					Main.data = (Map<Integer, String>) inputStream.readObject();

					if((Main.data.size() > Main.button.length) ||	checkButtonUnabled(Main.data.size()) == -1) {
						JOptionPane.showMessageDialog(null, "�� * ���� �ٲ� ��.");						
						JOptionPane.showMessageDialog(null, "�ҷ����� �л� �������� �л� ���� ���� (�� * ��)\n or Ȱ��ȭ���ִ� ��ư���� ����!!");
					}else {
						Main.Assigned_Seat_Menu.setEnabled(true);						
					}
					
        		} catch (Exception e1) {
        			JOptionPane.showMessageDialog(null, "�л� �����Ͱ� �ƴ�!!");
        		}
        	}else {
        		JOptionPane.showMessageDialog(null, "�������� �ʴ� ������!!");
        	}
        }
  	}
}
