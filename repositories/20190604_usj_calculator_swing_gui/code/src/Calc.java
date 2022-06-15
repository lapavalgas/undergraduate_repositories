import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calc extends JFrame {
	
	static String op = "";

    public static void main(String[] args) {
            Calc calc = new Calc();
            calc.setTitle("Calculadora"); 
            calc.setSize(200, 301); 
            calc.setLocationRelativeTo(null);
            calc.setLayout(null);
            calc.setVisible(true);
            
            JTextField tTxt1 = new JTextField();
            tTxt1.setBounds(1, 39, 135, 30);
            calc.add(tTxt1);
            tTxt1.setText("");
            
            JTextField tTxt2 = new JTextField();
            tTxt2.setBounds(1, 8, 135, 30);
            calc.add(tTxt2);
            tTxt2.setText("");
            
            JTextField tTxt3 = new JTextField();
            tTxt3.setBounds(136, 8, 45, 30);
            calc.add(tTxt3);
            tTxt3.setText("");

            JButton botao1 = new JButton();
            botao1.setText("1");
            botao1.setBounds(1, 76, 45, 45);
            botao1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	tTxt1.setText(tTxt1.getText() + "1"); 
                }
            });
            calc.add(botao1);
            
            JButton botao2 = new JButton();
            botao2.setText("2");
            botao2.setBounds(46, 76, 45, 45);
            botao2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	tTxt1.setText(tTxt1.getText() + "2"); 
                }
            });
            calc.add(botao2);
            
            JButton botao3 = new JButton();
            botao3.setText("3");
            botao3.setBounds(91, 76, 45, 45);
            botao3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	tTxt1.setText(tTxt1.getText() + "3"); 
                }
            });
            calc.add(botao3);
            
            JButton botao4 = new JButton();
            botao4.setText("4");
            botao4.setBounds(1, 121, 45, 45);
            botao4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	tTxt1.setText(tTxt1.getText() + "4"); 
                }
            });
            calc.add(botao4);
            
            JButton botao5 = new JButton();
            botao5.setText("5");
            botao5.setBounds(46, 121, 45, 45);
            botao5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	tTxt1.setText(tTxt1.getText() + "5");
                }
            });
            calc.add(botao5);
            
            JButton botao6 = new JButton();
            botao6.setText("6");
            botao6.setBounds(91, 121, 45, 45);
            botao6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	tTxt1.setText(tTxt1.getText() + "6"); 
                }
            });
            calc.add(botao6);
            
            JButton botao7 = new JButton();
            botao7.setText("7");
            botao7.setBounds(1, 166, 45, 45);
            botao7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	tTxt1.setText(tTxt1.getText() + "7"); 
                }
            });
            calc.add(botao7);
            
            JButton botao8 = new JButton();
            botao8.setText("8");
            botao8.setBounds(46, 166, 45, 45);
            botao8.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	tTxt1.setText(tTxt1.getText() + "8"); 
                }
            });
            calc.add(botao8);
            
            JButton botao9 = new JButton();
            botao9.setText("9");
            botao9.setBounds(91, 166, 45, 45);
            botao9.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	tTxt1.setText(tTxt1.getText() + "9"); 
                }
            });
            calc.add(botao9);
            
            JButton botaoC = new JButton();
            botaoC.setText("C");
            botaoC.setBounds(1, 211, 45, 45);
            botaoC.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tTxt1.setText("");
                    tTxt2.setText("");
                    tTxt3.setText("");
                }
            });
            calc.add(botaoC);
            
            JButton botao0 = new JButton();
            botao0.setText("0");
            botao0.setBounds(46, 211, 45, 45);
            botao0.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	tTxt1.setText(tTxt1.getText() + "0"); 
                }
            });
            calc.add(botao0);
            
            JButton botaoI = new JButton();
            botaoI.setText("=");
            botaoI.setBounds(91, 211, 45, 45);
            botaoI.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	Double pA, pB, soma, menos, mul, div;
                	switch(op) {
                	case "+":
                		pA = Double.parseDouble(tTxt2.getText());
                		pB = Double.parseDouble(tTxt1.getText());
                		soma = pA + pB;
                		tTxt2.setText(Double.toString(soma));
                    	tTxt3.setText("");     
                        tTxt1.setText(""); 
                		break;
                	case "-":
                		pA = Double.parseDouble(tTxt2.getText());
                		pB = Double.parseDouble(tTxt1.getText());
                		menos = pA - pB;
                		tTxt2.setText(Double.toString(menos));
                    	tTxt3.setText("");     
                        tTxt1.setText(""); 
                		break;
                	case "*":
                		pA = Double.parseDouble(tTxt2.getText());
                		pB = Double.parseDouble(tTxt1.getText());
                		mul = pA * pB;
                		tTxt2.setText(Double.toString(mul));
                    	tTxt3.setText("");     
                        tTxt1.setText(""); 
                		break;
                	case "/":
                		pA = Double.parseDouble(tTxt2.getText());
                		pB = Double.parseDouble(tTxt1.getText());
                		div = pA / pB;
                		tTxt2.setText(Double.toString(div));
                    	tTxt3.setText("");     
                        tTxt1.setText(""); 
                		break;
                	}
                	
                }
            });
            calc.add(botaoI);
            
            JButton botaos = new JButton();
            botaos.setText("+");
            botaos.setBounds(136, 76, 45, 45);
            botaos.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	if ("+".equals(op)) {
                		Double pA = Double.parseDouble(tTxt2.getText());
                		Double pB = Double.parseDouble(tTxt1.getText());
                		Double soma = pA + pB;
                		tTxt2.setText(Double.toString(soma));
                    	tTxt3.setText("+");     
                        tTxt1.setText(""); 
                        op = "+";	
                	} else {
                		tTxt2.setText(tTxt1.getText());
                    	tTxt3.setText("+");     
                        tTxt1.setText(""); 
                        op = "+";
                	}
                }
            });
            calc.add(botaos);
            
            JButton botaom = new JButton();
            botaom.setText("-");
            botaom.setBounds(136, 121, 45, 45);
            botaom.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	if ("-".equals(op)) {
                		Double pA = Double.parseDouble(tTxt2.getText());
                		Double pB = Double.parseDouble(tTxt1.getText());
                		Double menos = pA - pB;
                		tTxt2.setText(Double.toString(menos));
                    	tTxt3.setText("-");     
                        tTxt1.setText(""); 
                        op = "-";	
                	} else {
                		tTxt2.setText(tTxt1.getText());
                    	tTxt3.setText("-");     
                        tTxt1.setText(""); 
                        op = "-";
                	}
                }
            });
            calc.add(botaom);
            
            JButton botaomul = new JButton();
            botaomul.setText("*");
            botaomul.setBounds(136, 166, 45, 45);
            botaomul.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	if ("*".equals(op)) {
                		Double pA = Double.parseDouble(tTxt2.getText());
                		Double pB = Double.parseDouble(tTxt1.getText());
                		Double mul = pA * pB;
                		tTxt2.setText(Double.toString(mul));
                    	tTxt3.setText("*");     
                        tTxt1.setText(""); 
                        op = "*";	
                	} else {
                		tTxt2.setText(tTxt1.getText());
                    	tTxt3.setText("*");     
                        tTxt1.setText(""); 
                        op = "*";
                	}
                }
            });
            calc.add(botaomul);
            
            JButton botaodiv = new JButton();
            botaodiv.setText("/");
            botaodiv.setBounds(136, 211, 45, 45);
            botaodiv.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	if ("/".equals(op)) {
                		Double pA = Double.parseDouble(tTxt2.getText());
                		Double pB = Double.parseDouble(tTxt1.getText());
                		Double div = pA / pB;
                		tTxt2.setText(Double.toString(div));
                    	tTxt3.setText("/");     
                        tTxt1.setText(""); 
                        op = "/";	
                	} else {
                		tTxt2.setText(tTxt1.getText());
                    	tTxt3.setText("/");     
                        tTxt1.setText(""); 
                        op = "/";
                	}
                }
            });
            calc.add(botaodiv);
    }
}