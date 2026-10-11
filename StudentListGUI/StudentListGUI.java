// CS 123 Review Assignment
// GUI INTERFACE
// NoteL GUI stands for Graphical User Interface and is a visual program interface 
// that lets users interact with software using graphical elements like buttons, text boxes
// and windows instead of text commands

import java.awt.*; // for Dimension
import java.awt.event.*;
import javax.swing.*; // for GUI components 
import javax.swing.table.*;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/** CS123
 * Class StudentList is the driver program for the StudentList program.  It creates a
 * list of student names and grades to display, sorting based upon name or average.
 *
 * <p>This version uses a GUI to force students to not have access to the console.
 *
 */

// Note: ActionsListener is a in-built Java interface that belongs to import java.awt.event.*;
// It is imported on the 8-th code stroke in this program(scroll up)
public class StudentListGUI implements ActionListener  
{
    // GUI ELEMENTS
   private JFrame frame;
   private JButton button1;
   private JButton button2;

   private JTable table;
   private JScrollPane tableScrollPane;
    
   private final String[] columnNames = {"Name", "Average"};
   private List<StudentRecords> allStudents;

	
    /**  Main Program.
     *
     * @param args The OS parameters
     */
   public static void main(String[] args)  
   {
      StudentListGUI gui = new StudentListGUI();
   }
    
    /** The constructor that preps the GUI and all its components
     *
     */
   public StudentListGUI()
   {
      allStudents = new ArrayList<StudentRecords>();
      allStudents.add(new StudentRecords("Beau 10 9 10 9 10 9 10 9 10"));
      allStudents.add(new StudentRecords("Nott the Brave 5 5 5 5 5 5 5 5"));
      allStudents.add(new StudentRecords("Jester Lavorre 7 6 6 7 7 6 8 6 6 5 4 3 4 4"));
      allStudents.add(new StudentRecords("Fjord 3 4 5 6 7 8 9"));
      allStudents.add(new StudentRecords("Caleb Widowgast"));
      List<Integer> gradestemp = new ArrayList<>();
      gradestemp.add(8);gradestemp.add(8);gradestemp.add(8);gradestemp.add(8);gradestemp.add(9);
      StudentRecords x = new StudentRecords("Mollymuck", gradestemp);
      allStudents.add(x);
      gradestemp.clear();
      gradestemp.add(1);gradestemp.add(1);gradestemp.add(1);gradestemp.add(1);gradestemp.add(1);
      StudentRecords y = new StudentRecords("Yasha", gradestemp);
      allStudents.add(y);
      
      try{
         allStudents.add(new StudentRecords("  \t"));
         JOptionPane.showMessageDialog(null,"There is an error when checking the name size. Please fix your constructor."); 
         System.exit(-1);
      }
      catch (IllegalArgumentException e)
      {
         System.out.println("Error correctly caught and handled. Good Work.");
      }
      
      try{ if (x.getAverage() == y.getAverage()) throw new IllegalArgumentException(); }
      catch (IllegalArgumentException z) { JOptionPane.showMessageDialog(null,"There is an error with your constructor and try again.");  }
      

   
        // Call private method to set up the form.
      formSetup();
        
    
        
        // Open the frame.        
      frame.setVisible(true);
   
   }  
     
     /**
      * This method responds to all events thrown by the various elements
      * of the GUI
      * @param event The action event thrown by the GUI
      */
   @Override 
     public void actionPerformed(ActionEvent event)
   {
       //  If button is pressed or enter is pressed while the edit box has focus.   
      if (event.getSource() == button2)
      {
         Collections.sort(allStudents, new SortStudentsByGrade() );
         try {table.setModel( new DefaultTableModel(process(allStudents), columnNames) ); }
            catch (Exception e) {System.out.println(e);}
      }
      if (event.getSource() == button1)
      {
// Note: Collections.sort is a static method in Java’s java.util.Collections class that sorts a list into ascending order
// if you make List of names Ahmed, Nate and Bob, after sort it will be Ahmed, Bob, Nate
         Collections.sort(allStudents);
         try {table.setModel( new DefaultTableModel(process(allStudents), columnNames) ); }
            catch (Exception e) {System.out.println(e);}
      }
   }
     
     // Commands to set up the form.   
     // Note that the form must still be set to visible.
     // This does everything but that.
   private void formSetup()
   {
        // GUI SETUP
        // Window setup.      
      frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocation(new Point(100, 200));
      frame.setSize(new Dimension(800, 500));
      frame.setTitle("List of Students");
      frame.setLayout(new FlowLayout()); 
        // Find Get Roster button
      button1 = new JButton();
      button1.setText("Sort by Name");
      button1.addActionListener(this );
      button1.setEnabled(true);
        // Find Get Roster button
      button2 = new JButton();
      button2.setText("Sort by Average");
      button2.addActionListener(this );
      button2.setEnabled(true);
        
        // Set up Tree
        
      Object[][] data = process(allStudents);
        
      table = new JTable(data, columnNames);
      table.setPreferredScrollableViewportSize(new Dimension(700, 100));
      table.setFillsViewportHeight(true);
      tableScrollPane = new JScrollPane(table);
      table.setDefaultEditor(Object.class, null);
         
         
        // Add components to frame.
      frame.add(button1);
      frame.add(button2);
        
      frame.setResizable(false);
        
        
        // Layout the frame.
        // null layout to demonstrate the idea.   
        // not using the default layouts to show the idea.
      frame.setLayout(null); 
      button1.setBounds(10,10,150,25);
      button2.setBounds(170,10,150,25);
      tableScrollPane.setBounds(10, 110, 700,325);

        // Load up the Window
      frame.add(tableScrollPane);         
        
   }
     
   private static Object[][] process(List<StudentRecords> theData)     //List<List<String>>
   {
      int s = theData.size();
        
      String[][] dataArray = new String[s][2];
        
      for(int i = 0; i < s; i++)
      {
         try{
           dataArray[i][0]= theData.get(i).getBothValues().get(0);
           dataArray[i][1]= theData.get(i).getBothValues().get(1);
         }
         catch (Exception e)
         {
            throw new IllegalArgumentException(theData.get(i).getBothValues().toString() );
         }
         
      }
        
      return dataArray;
   }
     
          
}

/* This is a small Comparator to sort Students by their GPA
 */
class SortStudentsByGrade implements Comparator<StudentRecords>
{
   /* This is a small Comparator to sort Students by their GPA
    * @param a The first student.
    * @param b The second student.
    */

   public int compare (StudentRecords a,StudentRecords b)
   {
      if (a.getAverage() < b.getAverage()) return -1;
      if (a.getAverage() > b.getAverage()) return 1;
      return 0;
   }
}
