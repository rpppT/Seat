import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class FileChooser implements Serializable{
	public static final long serialVersionUID = 1111111111111111111L;

	public static FileChooser filechooser;
	
	public FileChooser() {
		filechooser = this;
	}
	public void FileChoose() {
        JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
        chooser.setCurrentDirectory(new File(System.getProperty("user.home"))); 
        chooser.setAcceptAllFileFilterUsed(true);  
        chooser.setDialogTitle("학생 데이터 저장"); 
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); 
        chooser.setMultiSelectionEnabled(false);
        
        int returnVal = chooser.showSaveDialog(null);
      
   if(returnVal == JFileChooser.APPROVE_OPTION) {
      try {
          FileOutputStream fos = new FileOutputStream(new File(chooser.getSelectedFile().getAbsolutePath()+".ser"));
          ObjectOutputStream oos = new ObjectOutputStream(fos);
          
          int CurrentNum = Jmenu_Students_Input_Num.total;
          int PreviousNum  =  Main.data.size();
          
          if(PreviousNum >  CurrentNum) {
        	  int index  = PreviousNum;
        	  for(int i=0; i<PreviousNum - CurrentNum; i++) {
        		  Main.data.remove(index);
        		  index -= 1;
        	  }
          }
          oos.writeObject(Main.data);
          oos.close();
        
      }catch(Exception e) {  
        }
      }    
	}
}
