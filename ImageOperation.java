import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.*;
import java.io.*;

public class ImageOperation {

    public static void operate(int key) {
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();

        try{
            FileInputStream fis =new FileInputStream(file);
            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }

            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Success");

        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
       
        JFrame f=new JFrame();
        f.setTitle("IMAGE-ENCRYPTION");
        f.setSize(400,300);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Font font=new Font("Roboto",Font.BOLD,25);
        JButton button=new JButton();
        button.setText("Open Image");
        button.setFont(font);
       

        JTextField textField=new JTextField(10);
        textField.setFont(font);

        f.setLayout(new FlowLayout());
        f.add(button);
        f.add(textField);
        f.setVisible(true);

        button.addActionListener(e->{
            String text= textField.getText();
            int temp=Integer.parseInt(text);
            operate(temp);
        });


    }
}
