import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import students.student.Student;
import students.database.Database;

public class DatabaseGUI extends Frame {
    public DatabaseGUI() {
        super("Student Management");
        initComponents();
    }
                         
    private void initComponents() {
        db = new Database();

        label1 = new Label();
        label3 = new Label();
        label4 = new Label();
        label6 = new Label();
        textField2 = new TextField(); //Data Update Name
        label5 = new Label();
        label8 = new Label();
        textField3 = new TextField(); //Data Update Age
        button2 = new Button();
        label9 = new Label();
        textField4 = new TextField();
        label2 = new Label();
        textField5 = new TextField();
        button3 = new Button();
        label10 = new Label();
        choice1 = new Choice();
        label7 = new Label();
        textField1 = new TextField();
        button1 = new Button();
        label11 = new Label();
        label12 = new Label();
        choice2 = new Choice();
        label13 = new Label();
        textField6 = new TextField();
        button4 = new Button();
        label14 = new Label();
        textField7 = new TextField();
        label15 = new Label();
        textField8 = new TextField();
        label16 = new Label();
        textField9 = new TextField();
        button5 = new Button();
        label17 = new Label();
        textField10 = new TextField();
        choice3 = new Choice();
        label18 = new Label();
        button7 = new Button();
        label19 = new Label();
        label20 = new Label();
        label21 = new Label();
        textField11 = new TextField();
        textField12 = new TextField();
        textField13 = new TextField();
        label22 = new Label();

/*Status Display Start*/
        label22.setAlignment(Label.CENTER);
        label22.setBackground(new Color(72, 47, 47));
        label22.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label22.setFont(new Font("Dialog", 3, 18)); // NOI18N
        label22.setForeground(new Color(255, 255, 255));
        label22.setText("Status"); // Header
        add(label22);
        label22.setBounds(0, 370, 657, 30);
/*Status Display End*/      

/*Display Data Starts*/

        label1.setAlignment(Label.CENTER);
        label1.setBackground(new Color(72, 47, 47));
        label1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label1.setFont(new Font("Dialog", 3, 24)); // NOI18N
        label1.setForeground(new Color(255, 255, 255));
        label1.setText("Student Management"); // Header
        add(label1);
        label1.setBounds(0, 25, 657, 40);

        label3.setAlignment(Label.CENTER);
        label3.setBackground(Color.black);
        label3.setFont(new Font("Dialog", 3, 12)); // NOI18N
        label3.setForeground(new Color(255, 255, 255));
        label3.setText("Student Data"); // Display Data
        add(label3);
        label3.setBounds(390, 70, 250, 20);

        label17.setAlignment(Label.CENTER);
        label17.setFont(new Font("Dialog", 1, 12)); // NOI18N
        label17.setText("Select Id :"); // Data Display
        add(label17);
        label17.setBounds(400, 100, 60, 20);
        add(choice3);
        choice3.setBounds(470, 100, 90, 20);

        label18.setFont(new Font("Dialog", 1, 12)); // NOI18N
        label18.setText("Enter Id:"); //Data Display
        add(label18);
        label18.setBounds(400, 140, 50, 20);
        add(textField10);
        textField10.setBounds(470, 140, 90, 20);
        textField10.setText("0");

        button7.setBackground(new Color(0, 0, 0));
        button7.setFont(new Font("Dialog", 3, 12)); // NOI18N
        button7.setForeground(new Color(255, 255, 255));
        button7.setLabel("Fetch"); //Data Display
        add(button7);
        button7.setBounds(400, 180, 90, 30);
        button7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String sid1 = choice3.getItem(choice3.getSelectedIndex());
                String sid2 = textField10.getText();
                int id1 = Integer.parseInt(sid1);
                int id2 = Integer.parseInt(sid2);
                ResultSet rs = null;
                if(id1 == 0 ^ id2 == 0){
                    if(id1 > 0){
                        rs = db.select(id1);
                    }else if(id2 > 0){
                        rs = db.select(id2);
                    }
                }else{
                    textField11.setText("");
                    textField12.setText("");
                    textField13.setText("");
                    button2.setEnabled(false);
                    label22.setText("Status : Make One Field 0.");
                }
                try{
                    if(rs != null && rs.next()){
                        textField11.setText(rs.getString(1));
                        textField12.setText(rs.getString(2));
                        textField13.setText(rs.getString(3));
                        button2.setEnabled(true);
                        label22.setText("Status : Data Fetched Successfully.");
                    }
                }catch(SQLException es){
                    es.printStackTrace();
                }
            }
        });

        label19.setFont(new Font("Dialog", 1, 12)); // NOI18N
        label19.setText("ID : "); //Data Display
        add(label19);
        label19.setBounds(400, 240, 40, 20);
        add(textField11);
        textField11.setBounds(450, 240, 80, 20);
        textField11.setEditable(false);

        label20.setFont(new Font("Dialog", 1, 12)); // NOI18N
        label20.setText("Name :"); //Data Display
        add(label20);
        label20.setBounds(400, 270, 43, 20);
        add(textField12);
        textField12.setBounds(400, 290, 120, 20);
        textField12.setEditable(false);

        label21.setFont(new Font("Dialog", 1, 12)); // NOI18N
        label21.setText("Age :"); //Data Display
        add(label21);
        label21.setBounds(400, 320, 32, 20);
        add(textField13);
        textField13.setBounds(450, 320, 70, 20);
        textField13.setEditable(false);
/* Display Data Ends */

/*Add Data Starts*/

        label4.setAlignment(Label.CENTER);
        label4.setBackground(Color.black);
        label4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        label4.setFont(new Font("Dialog", 3, 12)); // NOI18N
        label4.setForeground(new Color(255, 255, 255));
        label4.setText("Add Data"); // Add Data
        add(label4);
        label4.setBounds(10, 70, 210, 20);

        label9.setFont(new Font("Dialog", 1, 12)); // NOI18N
        label9.setText("Name :"); //Add Data
        add(label9);
        label9.setBounds(10, 100, 60, 20);
        add(textField4);
        textField4.setBounds(70, 100, 150, 20);

        label2.setBackground(Color.white);
        label2.setFont(new Font("Dialog", 1, 12)); // NOI18N
        label2.setText("Age :"); // Add Data
        add(label2);
        label2.setBounds(10, 140, 32, 20);
        add(textField5);
        textField5.setBounds(60, 140, 50, 20);

        button3.setBackground(new Color(0, 0, 0));
        button3.setFont(new Font("Dialog", 3, 12)); // NOI18N
        button3.setForeground(new Color(255, 255, 255));
        button3.setLabel("Insert"); // Add Data
        add(button3);
        button3.setBounds(120, 140, 90, 30);
        
        button3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String name = textField4.getText();
                String sage = textField5.getText();
                int age = Integer.parseInt(sage);
                st = new Student(name,age);
                if(db.insert(st)){
                    label22.setText("Status : Data Inserted Successfully.");
                    showId();
                }
                textField4.setText("");
                textField5.setText("");
            }
        });

/*Add Data Ends*/

/*Update Data Starts*/

        label6.setAlignment(Label.CENTER);
        label6.setBackground(Color.black);
        label6.setFont(new Font("Dialog", 3, 12)); // NOI18N
        label6.setForeground(new Color(255, 255, 255));
        label6.setText("Data Update"); // Update Data
        add(label6);
        label6.setBounds(10, 200, 210, 20);

        label5.setAlignment(Label.CENTER);
        label5.setFont(new Font("Dialog", 1, 12)); // NOI18N
        label5.setText("Name :"); //Data Update
        add(label5);
        label5.setBounds(120, 230, 43, 20);
        add(textField2);
        textField2.setBounds(120, 250, 100, 20);

        label8.setAlignment(Label.CENTER);
        label8.setFont(new Font("Dialog", 1, 12)); // NOI18N
        label8.setText("Age :"); // Data Update
        add(label8);
        label8.setBounds(120, 280, 40, 20);
        add(textField3);
        textField3.setBounds(160, 280, 60, 20);

        button2.setBackground(new Color(0, 0, 0));
        button2.setFont(new Font("Dialog", 3, 12)); // NOI18N
        button2.setForeground(new Color(255, 255, 255));
        button2.setLabel("Update"); //Update Button
        add(button2);
        button2.setBounds(120, 330, 100, 30);
        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String sid1 = choice1.getItem(choice1.getSelectedIndex());
                String sid2 = textField1.getText();
                String name = textField2.getText();
                String sage = textField3.getText();
                int age = Integer.parseInt(sage);
                int id1 = Integer.parseInt(sid1);
                int id2 = Integer.parseInt(sid2);
                boolean status1 = false;
                boolean status2 = false;
                if(id1 == 0 ^ id2 == 0){
                    if(id1 > 0){
                        status1 = db.update(id1,name);
                        status2 = db.update(id1,age);
                    }else if(id2 > 0){
                        status1 = db.update(id2,name);
                        status2 = db.update(id2,age);
                    }
                }else{
                    textField2.setText("");
                    textField3.setText("");
                    label22.setText("Status : Make One Field 0.");
                }
                if(status1 && status2){
                    label22.setText("Status : Data Updated Successfully.");
                    textField2.setText("");
                    textField3.setText("");
                }else{
                    label22.setText("Status : Something Went Wrong");
                }
            }
        });


        label10.setFont(new Font("Dialog", 1, 12)); // NOI18N
        label10.setText("Select Id:"); //Data Update
        add(label10);
        label10.setBounds(10, 230, 60, 20);
        add(choice1);
        choice1.setBounds(10, 250, 90, 20);

        label7.setFont(new Font("Dialog", 1, 12)); // NOI18N
        label7.setText("Enter Id:"); //Data Update
        add(label7);
        label7.setBounds(10, 280, 50, 20);
        add(textField1);
        textField1.setBounds(10, 300, 90, 20);
        textField1.setText("0");

        button1.setBackground(new Color(0, 0, 0));
        button1.setFont(new Font("Dialog", 3, 12)); // NOI18N
        button1.setForeground(new Color(255, 255, 255));
        button1.setLabel("Fetch"); //Data Update
        add(button1);
        button1.setBounds(10, 330, 90, 30);
        button2.setEnabled(false);
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String sid1 = choice1.getItem(choice1.getSelectedIndex());
                String sid2 = textField1.getText();
                int id1 = Integer.parseInt(sid1);
                int id2 = Integer.parseInt(sid2);
                ResultSet rs = null;
                if(id1 == 0 ^ id2 == 0){
                    if(id1 > 0){
                        rs = db.select(id1);
                    }else if(id2 > 0){
                        rs = db.select(id2);
                    }
                }else{
                    textField2.setText("");
                    textField3.setText("");
                    button2.setEnabled(false);
                    label22.setText("Status : Make One Field 0.");
                }
                try{
                    if(rs != null && rs.next()){
                        textField2.setText(rs.getString(2));
                        textField3.setText(rs.getString(3));
                        button2.setEnabled(true);
                        label22.setText("Status : Data Fetched Successfully.");
                    }
                }catch(SQLException es){
                    es.printStackTrace();
                }
            }
        });

/*Update Data Ends*/

/*Delete Data Starts*/

        label11.setAlignment(Label.CENTER);
        label11.setBackground(Color.black);
        label11.setFont(new Font("Dialog", 3, 12)); // NOI18N
        label11.setForeground(new Color(255, 255, 255));
        label11.setText("Data Delete"); //Data Delete
        add(label11);
        label11.setBounds(240, 70, 140, 20);

        label12.setFont(new Font("Dialog", 1, 12)); // NOI18N
        label12.setText("Select Id:"); //Data Delete
        add(label12);
        label12.setBounds(240, 100, 60, 20);
        add(choice2);
        choice2.setBounds(300, 100, 80, 20);

        label13.setFont(new Font("Dialog", 1, 12)); // NOI18N
        label13.setText("Enter Id:"); //Data Delete
        add(label13);
        label13.setBounds(240, 140, 50, 20);
        add(textField6);
        textField6.setBounds(300, 140, 80, 20);
        textField6.setText("0");

        button4.setBackground(new Color(0, 0, 0));
        button4.setFont(new Font("Dialog", 3, 12)); // NOI18N
        button4.setForeground(new Color(255, 255, 255));
        button4.setLabel("Fetch"); //Data Delete
        add(button4);
        button4.setBounds(260, 170, 110, 30);
        button5.setEnabled(false);
        button4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String sid1 = choice2.getItem(choice2.getSelectedIndex());
                String sid2 = textField6.getText();
                int id1 = Integer.parseInt(sid1);
                int id2 = Integer.parseInt(sid2);
                ResultSet rs = null;
                if(id1 == 0 ^ id2 == 0){
                    if(id1 > 0){
                        rs = db.select(id1);
                    }else if(id2 > 0){
                        rs = db.select(id2);
                    }
                }else{
                    textField7.setText("");
                    textField8.setText("");
                    textField9.setText("");
                    button5.setEnabled(false);
                    label22.setText("Status : Make One Field 0.");
                }
                try{
                    if(rs != null && rs.next()){
                        textField7.setText(rs.getString(1));
                        textField8.setText(rs.getString(2));
                        textField9.setText(rs.getString(3));
                        button5.setEnabled(true);
                        label22.setText("Status : Data Fetched Successfully.");
                    }
                }catch(SQLException es){
                    es.printStackTrace();
                }
            }
        });

        label14.setFont(new Font("Dialog", 1, 12)); // NOI18N
        label14.setText("ID : "); //Data Delete
        add(label14);
        label14.setBounds(250, 220, 40, 20);
        add(textField7);
        textField7.setBounds(290, 220, 80, 20);
        textField7.setEditable(false);

        label15.setFont(new Font("Dialog", 1, 12)); // NOI18N
        label15.setText("Name :"); //Data Delete
        add(label15);
        label15.setBounds(250, 250, 43, 20);
        add(textField8);
        textField8.setBounds(250, 270, 120, 20);
        textField8.setEditable(false);

        label16.setFont(new Font("Dialog", 1, 12)); // NOI18N
        label16.setText("Age :"); //Data Delete
        add(label16);
        label16.setBounds(250, 300, 32, 20);
        add(textField9);
        textField9.setBounds(300, 300, 70, 20);
        textField9.setEditable(false);

        button5.setBackground(new Color(0, 0, 0));
        button5.setFont(new Font("Dialog", 3, 12)); // NOI18N
        button5.setForeground(new Color(255, 255, 255));
        button5.setLabel("Delete"); //Data Delete
        add(button5);
        button5.setBounds(250, 330, 120, 30);
        button5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String sid1 = choice2.getItem(choice2.getSelectedIndex());
                String sid2 = textField6.getText();
                int id1 = Integer.parseInt(sid1);
                int id2 = Integer.parseInt(sid2);
                boolean status = false;
                if(id1 == 0 ^ id2 == 0){
                    if(id1 > 0){
                        if(db.delete(id1)) status = true;
                    }else if(id2 > 0){
                        if(db.delete(id2)) status = true;
                    }
                }else{
                    button5.setEnabled(false);
                    label22.setText("Status : Make One Field 0.");
                }
                showId();
                if(status){
                    label22.setText("Status : Data Deleted Successfully.");
                    textField7.setText("");
                    textField8.setText("");
                    textField9.setText("");
                }
            }
        });

/*Delete Data Ends*/

        showId();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                exitForm(evt);
            }
        });

        setSize(650,405);
        setLayout(null);
        setVisible(true);
    }// </editor-fold>                        

    private void exitForm(WindowEvent evt) {                          
        System.exit(0);
    }                         

    public static void main(String args[]) {
       new DatabaseGUI();
    }

    private void showId(){
        try{
            choice1.removeAll();
            choice2.removeAll();
            choice3.removeAll();
            ResultSet rs = db.select("id");
            choice1.add(String.valueOf(0));
            choice2.add(String.valueOf(0));
            choice3.add(String.valueOf(0));
            while(rs.next()){
                choice1.add(rs.getString(1));
                choice2.add(rs.getString(1));
                choice3.add(rs.getString(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    

    // Variables declaration
    private Student st; 
    private Database db;                   
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Choice choice1;
    private Choice choice2;
    private Choice choice3;
    private Label label1;
    private Label label10;
    private Label label11;
    private Label label12;
    private Label label13;
    private Label label14;
    private Label label15;
    private Label label16;
    private Label label17;
    private Label label18;
    private Label label19;
    private Label label20;
    private Label label21;
    private Label label22;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    private Label label6;
    private Label label7;
    private Label label8;
    private Label label9;
    private TextField textField1;
    private TextField textField2;
    private TextField textField3;
    private TextField textField4;
    private TextField textField5;
    private TextField textField6;
    private TextField textField7;
    private TextField textField8;
    private TextField textField9;
    private TextField textField10;
    private TextField textField11;
    private TextField textField12;
    private TextField textField13;
    // End of variables declaration                   
}