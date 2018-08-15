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
	public static final long serialVersionUID = 1111111111111111111L;//클래스 버전 아이디

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
        chooser.setDialogTitle("학생 데이터  가져오기"); 
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
						JOptionPane.showMessageDialog(null, "행 * 열을 바꾸 삼.");						
						JOptionPane.showMessageDialog(null, "불러오는 학생 데이터의 학생 수가 현재 (행 * 열)\n or 활성화되있는 버튼보다 많음!!");
					}else {
						Main.Assigned_Seat_Menu.setEnabled(true);						
					}
					
        		} catch (Exception e1) {
        			JOptionPane.showMessageDialog(null, "학생 데이터가 아님!!");
        		}
        	}else {
        		JOptionPane.showMessageDialog(null, "존재하지 않는 파일임!!");
        	}
        }
  	}
}
