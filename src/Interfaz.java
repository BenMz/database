
import dbman.DBObject;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.Document;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ben
 */
public class Interfaz extends javax.swing.JFrame {
    static String Message;
    static String codigoInt;
    static int contador = -1;
    /**
     * Creates new form 
     */
    public Interfaz() {
        initComponents();
        //manejo de undo/redo
         final UndoManager undoManager = new UndoManager();
Document doc = queryText.getDocument();
doc.addUndoableEditListener(new UndoableEditListener() {
    @Override
    public void undoableEditHappened(UndoableEditEvent e) {

//        System.out.println("Add edit");
        undoManager.addEdit(e.getEdit());

    }
});

InputMap im = queryText.getInputMap(JComponent.WHEN_FOCUSED);
ActionMap am = queryText.getActionMap();

im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Undo");
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Redo");

am.put("Undo", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (undoManager.canUndo()) {
                undoManager.undo();
            }
        } catch (CannotUndoException exp) {
            exp.printStackTrace();
        }
    }
});
am.put("Redo", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (undoManager.canRedo()) {
                undoManager.redo();
            }
        } catch (CannotUndoException exp) {
            exp.printStackTrace();
        }
    }
});
     
   
    
    }

public static String createTree(String word){
    if(word.length()>1 && word.charAt(0)=='('){
        contador++;

       
//        String nombre = createTree(word.substring(1, word.length()));
        
        
    }else if(word.length()>1 && word.charAt(word.length()-1)==')'){
        int cont=0;
        while(word.length()>1 && word.charAt(word.length()-1)==')'){
            cont++;
            word = word.substring(0, word.length()-1);
        }
        System.out.println(word);
        javax.swing.tree.DefaultMutableTreeNode treeNode = new javax.swing.tree.DefaultMutableTreeNode(word);
       
        while(cont>0){
            System.out.println("===FIN "+contador+"======");
            contador--;
            cont--;
           
        }
    }else{

    }
    return word;
}
    public static class UnderlineListener extends BaseErrorListener {
    String output = "";
	public void syntaxError(Recognizer<?, ?> recognizer,
				Object offendingSymbol,
				int line, int charPositionInLine,
				String msg,
				RecognitionException e)
    {
        System.err.println("line "+line+":"+charPositionInLine+" "+msg);
        output+="line "+line+":"+charPositionInLine+" "+msg+"\n";
        underlineError(recognizer,(Token)offendingSymbol,
                       line, charPositionInLine);
    }

    protected void underlineError(Recognizer recognizer,
                                  Token offendingToken, int line,
                                  int charPositionInLine) {
        CommonTokenStream tokens =
            (CommonTokenStream)recognizer.getInputStream();
        String input = tokens.getTokenSource().getInputStream().toString();
        String[] lines = input.split("\n");
        String errorLine = lines[line - 1];
        output+=errorLine+"\n";
//        System.err.println(errorLine);
        for (int i=0; i<charPositionInLine; i++){ System.err.print(" "); output+=" ";}
        int start = offendingToken.getStartIndex();
        int stop = offendingToken.getStopIndex();
        if ( start>=0 && stop>=0 ) {
            for (int i=start; i<=stop; i++) {System.err.print("^");output+="^\n";}
        }
//        JOptionPane.showMessageDialog(null,output, "PARSE ERROR",JOptionPane.ERROR_MESSAGE);
        Message=output;
    }
}
    public String parser(){
        String inputFile = "t.expr";
        try{
        InputStream is = System.in;
        is = new FileInputStream(inputFile);

        ANTLRInputStream input = new ANTLRInputStream(is);
        SQLLexer lexer = new SQLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(tokens);
        parser.removeErrorListeners(); // remove ConsoleErrorListener
        parser.addErrorListener(new UnderlineListener());
        ParseTree tree = parser.queries(); // parse; start at queries
       System.out.println(tree.toStringTree(parser)); // print tree as text
                String test = tree.toStringTree(parser);
        
        String[] result = test.split("\\ ");
//        System.out.println(tree.toStringTree(parser)); // print tree as text
//          ParseTree tree = parser.program(); // parse; start at prog
        Visitante eval = new Visitante(verbose.isSelected());
        eval.visit(tree);   
        int iterador = 0;
        String message = "";
        if(verbose.isSelected()){
            for(Object data : eval.getAll()){
                message+=data.toString()+"\n";
            }
        }
        else
             message = eval.getMensajes();
        for(String s: result){
           createTree(s);
           
        }
        
        
        System.out.println("TERMINA COMPILACION");
//        BufferedReader reader = new BufferedReader(new FileReader("D:\\cole x_x\\Java\\Parser3\\src\\t.expr"));
//        String linea = reader.readLine();
//        reader.close();
        int contLinea = 1;
        String textoFinal="";
//        while(linea!=null){
//            reader.readLine();
//        }
            return message;
        }
        
        catch(Exception e){
       
        }
        return "";
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        queryText = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultText = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        verbose = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        queryText.setColumns(20);
        queryText.setRows(5);
        jScrollPane1.setViewportView(queryText);

        jTabbedPane1.addTab("Query Editor", jScrollPane1);

        resultText.setEditable(false);
        resultText.setColumns(20);
        resultText.setRows(5);
        jScrollPane2.setViewportView(resultText);

        jButton1.setText("Execute");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        verbose.setText("verbose");
        verbose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verboseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(verbose)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(verbose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        JOptionPane.showMessageDialog(null,"aa");
        String programa = queryText.getText();
        System.out.println(Arrays.toString(new File("src").listFiles()));
        resultText.setText("");
        PrintWriter writer;
        try {
                    writer = new PrintWriter("t.expr");
                    writer.println(programa);
                    writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
       Message= parser();
        System.out.println(Message);
       String texto =Message;
       resultText.setText(texto);
       codigoInt = "";
       Message=null;
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void verboseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verboseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verboseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea queryText;
    private javax.swing.JTextArea resultText;
    private javax.swing.JCheckBox verbose;
    // End of variables declaration//GEN-END:variables
}
