 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 import org.hibernate.*;
 import org.hibernate.cfg.*;

 class A1 extends JFrame{
 Container c;
 JLabel labName,labFeedback,labSuggestion;
 JTextField txtName,txtSuggestion;
 JRadioButton rbExcellent,rbGood,rbModerate,rbBad;
 JButton btnSubmit;

 A1()
 {
 c=getContentPane();
 c.setLayout(null);
 labName=new JLabel("Enter Name:");
 txtName=new JTextField(15);
 labFeedback=new JLabel("Feedback:");
 rbExcellent=new JRadioButton("Excellent",true);
 rbGood=new JRadioButton("Good");
 rbModerate=new JRadioButton("Moderate");
 rbBad=new JRadioButton("Bad");
 labSuggestion=new JLabel("Suggestion:");
 txtSuggestion=new JTextField(60);

 btnSubmit=new JButton("Submit");
 btnSubmit.setBackground(Color.GREEN);

 Font f=new Font("Times new Roman",Font.BOLD,35);
 labName.setFont(f);
 txtName.setFont(f);
 labFeedback.setFont(f);
 rbExcellent.setFont(f);
 rbGood.setFont(f);
 rbModerate.setFont(f);
 rbBad.setFont(f);
 labSuggestion.setFont(f);
 txtSuggestion.setFont(f);
 btnSubmit.setFont(f);

ButtonGroup bg=new ButtonGroup();
bg.add(rbExcellent);
bg.add(rbGood);
bg.add(rbModerate);
bg.add(rbBad);

 labName.setBounds(40,30,200,40);
 txtName.setBounds(260,30,200,40);
 labFeedback.setBounds(40,100,200,40);
 rbExcellent.setBounds(260,100,200,40);
 rbGood.setBounds(260,150,200,40);
 rbModerate.setBounds(260,200,200,40);
 rbBad.setBounds(260,250,200,40);
 labSuggestion.setBounds(40,300,200,40);
 txtSuggestion.setBounds(260,310,200,40);
 btnSubmit.setBounds(260,390,200,40);

c.add(labName);
c.add(txtName);
c.add(labFeedback);
c.add(rbExcellent);
c.add(rbGood);
c.add(rbModerate);
c.add(rbBad);
c.add(labSuggestion);
c.add(txtSuggestion);
c.add(btnSubmit);

 ActionListener a =(ae) -> {
 Configuration cfg=new Configuration();
 cfg.configure("hibernate.cfg.xml");


 SessionFactory sf=cfg.buildSessionFactory();
 Session s=null;
 Transaction t =null;

 try
 {
 s=sf.openSession();
 java.util.List<Feedback> data=new java.util.ArrayList<>();
 data=s.createQuery("from Feedback").list();
 int id=data.size()+1;
 String name=txtName.getText();
 String fb="";
 if(rbExcellent.isSelected())
 fb="Excellent";
 else if(rbGood.isSelected())
 fb="Good";
 else if(rbModerate.isSelected())
 fb="Moderate";
 else
 fb="Bad";
 String suggestion=txtSuggestion.getText();
 Feedback feedback=new Feedback(id,name,fb,suggestion);
 t=s.beginTransaction();
 s.save(feedback);
 t.commit();

 JOptionPane.showMessageDialog(c,"Thank You for your response");
 txtName.setText("");
 rbExcellent.setSelected(true);
 txtName.requestFocus();
}
 catch(Exception e)
{
 t.rollback();
 JOptionPane.showMessageDialog(c,"issue"+ e);
}
 finally
{
 s.close();
}
};
 btnSubmit.addActionListener(a);
 setTitle("SYNC INTERN'S SURVEY SYSTEM");
 setSize(700,600);
 setLocationRelativeTo(null);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setVisible(true);
}
}
 class A1Test{
 public static void main(String args[])
{
 A1 a=new A1();
}
}






