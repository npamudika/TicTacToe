/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TicTacToe;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tharaka
 */
public class LeaderBoad extends javax.swing.JFrame {

   
    Support sup;
    
    public void setSup(Support sup){
        this.sup = sup;
         DB db = sup.getDb();
        ArrayList<String> nameList = db.selectLocal("users", "name", null);
        Iterator<String> it = nameList.iterator();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        ArrayList<String> markList = db.selectLocal("users", "marks", null);
        Iterator<String> itMark = markList.iterator();
        while(it.hasNext()){
            String name = it.next();
            int marks = (Integer.parseInt(itMark.next()));
            map.put(name, marks);
        }
        LinkedHashMap lmap = sortHashMapByValuesD(map);
        try{
            Iterator mIt = lmap.entrySet().iterator();
            Map.Entry pairs = (Map.Entry)mIt.next();
            player3.setText((String)pairs.getKey());
           // System.out.println((String)pairs.getKey());
            
            pairs = (Map.Entry)mIt.next();
            player2.setText((String)pairs.getKey());
           // System.out.println((String)pairs.getKey());
            
            pairs = (Map.Entry)mIt.next();
            player1.setText((String)pairs.getKey());
          //  System.out.println((String)pairs.getKey());
            
        }catch(Exception e){
            
        }
        
    }
    
    public LinkedHashMap sortHashMapByValuesD(HashMap passedMap) {
   List mapKeys = new ArrayList(passedMap.keySet());
   List mapValues = new ArrayList(passedMap.values());
   Collections.sort(mapValues);
   Collections.sort(mapKeys);

   LinkedHashMap sortedMap = new LinkedHashMap();

   Iterator valueIt = mapValues.iterator();
   while (valueIt.hasNext()) {
       Object val = valueIt.next();
       Iterator keyIt = mapKeys.iterator();

       while (keyIt.hasNext()) {
           Object key = keyIt.next();
           String comp1 = passedMap.get(key).toString();
           String comp2 = val.toString();

           if (comp1.equals(comp2)){
               passedMap.remove(key);
               mapKeys.remove(key);
               sortedMap.put((String)key, (Integer)val);
               break;
           }

       }

   }
   return sortedMap;
}
    
    
    public LeaderBoad() {
         setUndecorated(true);
          Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        initComponents();
    //     setExtendedState(Frame.MAXIMIZED_BOTH);
       setLocation((dim.width - jLabel1.getWidth())/2, (dim.height - jLabel1.getHeight())/2);
        setSize(jLabel1.getWidth()-40, jLabel1.getHeight());  
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        player1 = new javax.swing.JLabel();
        player2 = new javax.swing.JLabel();
        player3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TicTacToe/exitBtn.jpg"))); // NOI18N
        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(400, 680, 130, 50);

        player1.setFont(new java.awt.Font("Carter One", 0, 36)); // NOI18N
        player1.setText("p1");
        getContentPane().add(player1);
        player1.setBounds(190, 230, 330, 90);

        player2.setFont(new java.awt.Font("Carter One", 0, 36)); // NOI18N
        player2.setText("p2");
        getContentPane().add(player2);
        player2.setBounds(190, 360, 330, 90);

        player3.setFont(new java.awt.Font("Carter One", 0, 36)); // NOI18N
        player3.setText("p3");
        getContentPane().add(player3);
        player3.setBounds(190, 510, 340, 90);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TicTacToe/leaderBoad`.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 640, 820);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

            MainMenue ma = new MainMenue();
            ma.setSup(sup);
            ma.show();
            this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(LeaderBoad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeaderBoad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeaderBoad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeaderBoad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeaderBoad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel player1;
    private javax.swing.JLabel player2;
    private javax.swing.JLabel player3;
    // End of variables declaration//GEN-END:variables
}
