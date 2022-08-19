package farenheitcentigrados;
import java.util.Date;
import java.text.SimpleDateFormat;
public class FarenheitCentigrados extends javax.swing.JFrame{
    private javax.swing.JLabel jlbGradosC;
    private javax.swing.JTextField jtfGradosC;
    private javax.swing.JLabel jlbGradosF;
    private javax.swing.JTextField jtfGradosF;
    private javax.swing.JButton jbtAceptar;
    private javax.swing.JTextField jtaFecha;
    private javax.swing.JLabel jlbFecha;
    private Object objTextField;
    public FarenheitCentigrados()
        {
         setSize(300,200)   ;
         setTitle("Conversion de temperaturas");
         initComponents();
        }
     private void initComponents()
     {
        
        
         jlbGradosC=new javax.swing.JLabel();
         jtfGradosC=new javax.swing.JTextField();
         
         jlbGradosF=new javax.swing.JLabel();
         jtfGradosF=new javax.swing.JTextField();
         
         jbtAceptar= new javax.swing.JButton();
         jtaFecha=new javax.swing.JTextField();
         jlbFecha=new javax.swing.JLabel();
        
         
         
         getContentPane().setLayout(null);
         addWindowListener(new java.awt.event.WindowAdapter()
         {
             public void windowOpened(java.awt.event.WindowEvent evt)
             {
                 formWindowOpened(evt);
             }
             public void windowClosing(java.awt.event.WindowEvent evt)
             {
                 exitForm(evt);
             }
         });
         //Etiqueta de fecha
         jlbFecha.setText("Fecha");
         getContentPane().add(jlbFecha);
         jlbFecha.setBounds(12,88,104,24);
         
         //Caja de texto de la fecha
         Date date = new Date();
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
         String str = formatter.format(date);
         jtaFecha.setEditable(false);
         jtaFecha.setText(str);
         getContentPane().add(jtaFecha);
         jtaFecha.setBounds(132,88,144,24);
         
         //Etiqueta grados centigrados
         jlbGradosC.setText("Grados centigrados");
         getContentPane().add(jlbGradosC);
         jlbGradosC.setHorizontalAlignment(javax.swing.JTextField.LEFT);
         jlbGradosC.setBounds(12,8,116,24);
         
         
         //Caja de texto para los grados centigrados
         jtfGradosC.setText("0.00");
         jtfGradosC.setHorizontalAlignment(javax.swing.JTextField.LEFT);
         getContentPane().add(jtfGradosC);
         jtfGradosC.setBounds(132,8,144,24);
         
         //Etiqueta grados Farenheit
         jlbGradosF.setText("Grados Farenheit");
         getContentPane().add(jlbGradosF);
         jlbGradosF.setBounds(12,48,104,24);
         
         //Caja de texto para los grados centigrados
         jtfGradosF.setText("0.00");
         jtfGradosF.setHorizontalAlignment(javax.swing.JTextField.LEFT);
         getContentPane().add(jtfGradosF);
         jtfGradosF.setBounds(132,48,144,24);
         
         //Boton aceptar
         jbtAceptar.setText("Aceptar");
         jbtAceptar.setMnemonic('A');
         getRootPane().setDefaultButton(jbtAceptar);
         getContentPane().add(jbtAceptar);
         jbtAceptar.setBounds(132,120,144,24);
         
         java.awt.event.KeyListener k1=new java.awt.event.KeyAdapter()
         {
             public void keyPressed(java.awt.event.KeyEvent evt)
             {
                 jtfGradosKeyPressed(evt);
             }
             public void keyTyped(java.awt.event.KeyEvent evt)
             {
                 jtfGradosKeyTyped(evt);
             }
             public void keyReleased(java.awt.event.KeyEvent evt)
             {
                 jtfGradosKeyReleased(evt);
             }
         };
         jtfGradosC.addKeyListener(k1);
         jtfGradosF.addKeyListener(k1);
         
         
         java.awt.event.FocusAdapter f1=new java.awt.event.FocusAdapter()
         {
             public void focusGained(java.awt.event.FocusEvent evt)
             {
                 jtfFocusGained(evt);
             }
         };
        jtfGradosC.addFocusListener(f1);
        jtfGradosF.addFocusListener(f1);
        
        
                 
         jbtAceptar.addActionListener(new java.awt.event.ActionListener()
         {
             public void actionPerformed(java.awt.event.ActionEvent evt)
             {
                 jbtAceptarActionPerformed(evt);
             }
         });
     }
     
     private void jtfGradosKeyPressed(java.awt.event.KeyEvent evt)
     {
         objTextField=evt.getSource();//Obtengo el objeto que produjo el evento
     }
     
     private void jtfGradosKeyTyped(java.awt.event.KeyEvent evt)
     {
         objTextField=evt.getSource();//Obtengo el objeto que produjo el evento
     }
     
     
     private void jtfGradosKeyReleased(java.awt.event.KeyEvent evt)
     {
         //Obtener la caja de texto que generó el evento
         javax.swing.JTextField objJTF=(javax.swing.JTextField)evt.getSource();
         //Fuente: Almacena el contenido de la caja de texto
         String str=objJTF.getText();
         char[]fuente=str.toCharArray();
         //reusltado:Almacena el contenido de la caja de texto validado
         char[]resultado=new char[fuente.length];
         int j=0;
         boolean error=false;
         //Almacenar en resultado los caracteres validos de fuente
         for(int i=0;i<fuente.length;i++)
         {
             if(fuente[i]>='0' && fuente[i]<='9' || fuente[i]=='.' || fuente[i]=='+' || fuente[i]=='-')
             {
                 resultado[j++]=fuente[i];
             }
             else
             {
                 error=true;
                 java.awt.Toolkit.getDefaultToolkit().beep();
             }
         }
         if(error)
         {
             objJTF.setText(new String(resultado,0,j));
         }
         //objTextField=evt.getSource();//Obtengo el objeto que produjo el evento
     }
     private void jtfFocusGained(java.awt.event.FocusEvent evt)
     {
      javax.swing.JTextField objEnfocado=(javax.swing.JTextField)evt.getSource();   
      objEnfocado.selectAll();
     }
     
     
     private void jbtAceptarActionPerformed(java.awt.event.ActionEvent evt)
     {
         try
         {
             double grados;
             String gradosConvertidos;
             //Si se escribio en la caja de texto grados centigrados
             if(objTextField==jtfGradosC)
             {
                 grados=Double.parseDouble(jtfGradosC.getText())*9/5+32;
                 gradosConvertidos=String.format("%.2f",grados);
                 jtfGradosF.setText(gradosConvertidos);
             }
             //Si se escribio en la caja de texto grados Farenheit
             if(objTextField==jtfGradosF)
             {
                 grados=(Double.parseDouble(jtfGradosF.getText())-32)*5/9;
                 gradosConvertidos=String.format("%.2f",grados);
                 jtfGradosC.setText(gradosConvertidos);
             }
         }
         catch(NumberFormatException ex)
         {
             jtfGradosC.setText("0.00");
             jtfGradosF.setText("32.00");
         }
     }
     
     private void formWindowOpened(java.awt.event.WindowEvent evt)
     {
         jtfGradosC.requestFocus();
     }
     
     private void exitForm(java.awt.event.WindowEvent evt)
     {
         System.exit(0);
     }
     
    public static void main(String[] args) {
        
        try
        {
            for(javax.swing.UIManager.LookAndFeelInfo info: javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println("No se pudo seleccionar el aspecto deseado "+ex);
        }
        
        
        FarenheitCentigrados appDeConversion=new FarenheitCentigrados();
        appDeConversion.setVisible(true);
    }
}
