import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Browser extends JFrame {
    private JPanel panel1;
    private JTextField BarraBuscadora;
    private JButton Buscar;
    private JButton Retroceder;
    private JButton Avanzar;
    private JTextField Muestrapag;

    public Browser(){
      super("hola");
      setContentPane(panel1);
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        int c=1;
        if(stack1.isEmpty()){
        Retroceder.setVisible(false);}
        Avanzar.setVisible(false);
        Buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                while(!stack2.isEmpty()){
                    stack2.pop();
                }
                Avanzar.setVisible(false);
                Muestrapag.setText(BarraBuscadora.getText());
                stack1.push(BarraBuscadora.getText());
                if(stack1.size()>1){
                    Retroceder.setVisible(true);
                }

            }
        });
        Retroceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(stack1.size()<3){
                    Retroceder.setVisible(false);
                }
                stack2.push(stack1.pop());
                if(!stack2.isEmpty()){
                    Avanzar.setVisible(true);
                }

                BarraBuscadora.setText(stack1.peek());
                Muestrapag.setText(stack1.peek());
            }
        });
        Avanzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BarraBuscadora.setText(stack2.peek());
                Muestrapag.setText(stack2.peek());
                stack1.push(stack2.pop());
                if(!stack1.isEmpty()){
                    Retroceder.setVisible(true);
                }
                if(stack2.size()<1){
                    Avanzar.setVisible(false);
                }



            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
