/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import ua.com.codefire.listener.IArtilceDialogListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import static ua.com.codefire.MainFrame.factory;
import ua.com.codefire.entity.Article;
import ua.com.codefire.entity.Author;
import ua.com.codefire.entity.Category;

/**
 *
 * @author Haivan
 */
public class ArticleDialog extends javax.swing.JDialog {

    private Article article;
    private EModeArticleDialog modeArticleDialog;

    private List<IArtilceDialogListener> addEditArticleListeners;

    private static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    /**
     * Creates new form ArticleDialog
     */
    public ArticleDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public ArticleDialog(java.awt.Frame parent, boolean modal, Article article, EModeArticleDialog modeArticleDialog) {
        super(parent, modal);
        initComponents();

        this.addEditArticleListeners = new ArrayList<>();
        this.setTitle(modeArticleDialog.toString() + ":" + modeArticleDialog.getValue()+":"+modeArticleDialog.getCode());

        this.article = article;
        this.modeArticleDialog = modeArticleDialog;

        InitFields();
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public EModeArticleDialog getModeArticleDialog() {
        return modeArticleDialog;
    }

    public void setModeArticleDialog(EModeArticleDialog modeArticleDialog) {
        this.modeArticleDialog = modeArticleDialog;
    }

    public void addActionListener(IArtilceDialogListener addEditArticleListener) {
        addEditArticleListeners.add(addEditArticleListener);
    }

    private void InitFields() {
        // Statement
        EntityManager manager = factory.createEntityManager();

        TypedQuery<Author> queryAuthor = manager.createQuery("SELECT a FROM Author a", Author.class);
        List<Author> authorList = queryAuthor.getResultList();

        TypedQuery<Category> queryCategory = manager.createQuery("SELECT c FROM Category c", Category.class);
        List<Category> categoryList = queryCategory.getResultList();

        List<Category> articleCategoryList = article.getCategories();

        manager.close();

        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        // заполняем список авторов
        for (Author author : authorList) {
            dcbm.addElement(author);
        }
        jcbAuthors.setModel(dcbm);

        DefaultListModel dlm = new DefaultListModel();
        // заполняеем список категорий
        for (Category category : categoryList) {
            dlm.addElement(category);
        }

        jlCategory.setModel(dlm);

        DateFormat date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        DateFormatter dateFormatter = new DateFormatter(date);
////        MaskFormatter dateFormatter = null;
////        try {
////            dateFormatter = new MaskFormatter("##.##.#### ##:##:##");
////        } catch (ParseException ex) {
////            Logger.getLogger(ArticleDialog.class.getName()).log(Level.SEVERE, null, ex);
////        }
////        // Форматирующий объект даты
////        DateFormatter dateFormatter = new DateFormatter(date);
//        dateFormatter.setAllowsInvalid(false);
////        dateFormatter.setMask("##.##.#### ##:##:##");
//        dateFormatter.setOverwriteMode(true);
//
//        // Создание форматированного текстового поля даты
        jftfTimestamp = new JFormattedTextField(dateFormatter);
//        jftfTimestamp.setColumns(32);
        jftfTimestamp.setValue(new Date());

//        MaskFormatter phoneFormatter = null;
//        try {
//            phoneFormatter = new MaskFormatter("+#-###-###-##-##");
//        } catch (ParseException ex) {
//            Logger.getLogger(ArticleDialog.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        phoneFormatter.setPlaceholderCharacter('0');
//        JFormattedTextField ftfPhone = new JFormattedTextField(phoneFormatter);
//        jftfTimestamp.setColumns(16);
        if (EModeArticleDialog.EDIT.equals(modeArticleDialog) | EModeArticleDialog.VIEW.equals(modeArticleDialog)) {
            jtfId.setText(article.getId().toString());

            jtfTitle.setText(article.getTitle());
            jtaContent.setText(article.getContent());

//            jftfTimestamp = new JFormattedTextField(new RegexFormatter("\\(\\d{3}\\)\\d{3}-\\d{4}"));
            jcbAuthors.setSelectedItem(article.getAuthor());

            List<Integer> indicesArticleCategory = new ArrayList<>();
            int numRow = 0;

            // заполняеем список категорий
            for (Category category : categoryList) {

                // ищем категорию в списке категорий статьи, если есть то помечаем как выбранную
                int foundCategory = articleCategoryList.indexOf(category);
                if (foundCategory > -1) {
                    indicesArticleCategory.add(numRow);
                }
                numRow++;
            }
            jlCategory.setSelectedIndices(indicesArticleCategory.stream().mapToInt(i -> i).toArray());
        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfId = new javax.swing.JTextField();
        jtfTitle = new javax.swing.JTextField();
        jftfTimestamp = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaContent = new javax.swing.JTextArea();
        jcbAuthors = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlCategory = new javax.swing.JList<>();
        jToolBar1 = new javax.swing.JToolBar();
        jbAccept = new javax.swing.JButton();
        jbAccept1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(" Article "));

        jLabel1.setText("ID");

        jLabel2.setText("Title");

        jLabel3.setText("Author");

        jLabel4.setText("Timestamp");

        jLabel5.setText("Content");

        jtfId.setEditable(false);
        jtfId.setBackground(new java.awt.Color(204, 204, 204));

        jtaContent.setColumns(20);
        jtaContent.setLineWrap(true);
        jtaContent.setRows(5);
        jScrollPane1.setViewportView(jtaContent);

        jcbAuthors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAuthorsActionPerformed(evt);
            }
        });

        jLabel6.setText("Category");

        jScrollPane2.setViewportView(jlCategory);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jftfTimestamp)
                            .addComponent(jtfId)
                            .addComponent(jtfTitle)
                            .addComponent(jcbAuthors, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbAuthors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jftfTimestamp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );

        jToolBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setFocusable(false);

        jbAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ok.png"))); // NOI18N
        jbAccept.setFocusable(false);
        jbAccept.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbAccept.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAcceptActionPerformed(evt);
            }
        });
        jToolBar1.add(jbAccept);

        jbAccept1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        jbAccept1.setFocusable(false);
        jbAccept1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbAccept1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbAccept1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAccept1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jbAccept1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAccept1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAccept1ActionPerformed
        dispose();
    }//GEN-LAST:event_jbAccept1ActionPerformed

    private void jbAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAcceptActionPerformed
        article.setAuthor((Author) jcbAuthors.getSelectedItem());
        article.setTitle(jtfTitle.getText());
        article.setContent(jtaContent.getText());
        article.setTimestamp((Date) jftfTimestamp.getValue());

        List<Category> categories;
        categories = jlCategory.getSelectedValuesList();

        article.setCategories(categories);
//        article.setTimestamp(jftfTimestamp.getText());

        for (IArtilceDialogListener artilceDialogListener : addEditArticleListeners) {
            artilceDialogListener.addEditDialogAction();
        }

        dispose();
    }//GEN-LAST:event_jbAcceptActionPerformed

    private void jcbAuthorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAuthorsActionPerformed

    }//GEN-LAST:event_jcbAuthorsActionPerformed

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
            java.util.logging.Logger.getLogger(ArticleDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArticleDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArticleDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArticleDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ArticleDialog dialog = new ArticleDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbAccept;
    private javax.swing.JButton jbAccept1;
    private javax.swing.JComboBox<Author> jcbAuthors;
    private javax.swing.JFormattedTextField jftfTimestamp;
    private javax.swing.JList<Category> jlCategory;
    private javax.swing.JTextArea jtaContent;
    private javax.swing.JTextField jtfId;
    private javax.swing.JTextField jtfTitle;
    // End of variables declaration//GEN-END:variables
}
