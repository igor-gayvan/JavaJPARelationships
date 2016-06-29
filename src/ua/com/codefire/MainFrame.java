/*
 * Copyright (C) 2016 CodeFireUA <edu@codefire.com.ua>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ua.com.codefire;

import ua.com.codefire.listener.IArtilceDialogListener;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import ua.com.codefire.entity.Article;
import ua.com.codefire.entity.Category;
import ua.com.codefire.listener.ICategoryDialogListener;

/**
 *
 * @author CodeFireUA <edu@codefire.com.ua>
 */
public class MainFrame extends javax.swing.JFrame {

    static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("MainPU");
    }

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();

        this.setLocationRelativeTo(null);

        // Statement
        EntityManager manager = factory.createEntityManager();

        TypedQuery<Category> query = manager.createQuery("SELECT c FROM Category c", Category.class);
        List<Category> categoryList = query.getResultList();

        DefaultListModel dlm = new DefaultListModel();

        for (Category category : categoryList) {
            dlm.addElement(category);
        }

        jlCategories.setModel(dlm);

        manager.close();

        UIManager.put("OptionPane.okButtonText", "Понятно");
        UIManager.put("OptionPane.cancelButtonText", "Отмена");
        UIManager.put("OptionPane.yesButtonText", "Да");
        UIManager.put("OptionPane.noButtonText", "Нет");

//        factory.close();
    }

    private void showArticlesList() {
        if (jlCategories.getSelectedIndex() >= 0) {
            int selectedIndex = jlCategories.getSelectedIndex();
            Category category = jlCategories.getModel().getElementAt(selectedIndex);

            // Statement
            EntityManager manager = factory.createEntityManager();

            List<Article> articleList = category.getArticles();
            DefaultComboBoxModel dcbm = new DefaultComboBoxModel();

            for (Article article : articleList) {
                dcbm.addElement(article);
            }

            jcbArtcles.setModel(dcbm);

            if (articleList.size() > 0) {
                jtaArticleContent.setText(articleList.get(0).getContent());
            }
            manager.close();
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

        jSlider1 = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlCategories = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jcbArtcles = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaArticleContent = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        jbAddCategory = new javax.swing.JButton();
        jbEditCategory = new javax.swing.JButton();
        jbDelCategory = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        jbAddArticle = new javax.swing.JButton();
        jbEditArticle = new javax.swing.JButton();
        jbDelArticle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jlCategories.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jlCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlCategoriesMouseClicked(evt);
            }
        });
        jlCategories.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jlCategoriesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jlCategories);

        jLabel1.setText("Category");

        jcbArtcles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbArtclesActionPerformed(evt);
            }
        });
        jcbArtcles.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jcbArtclesPropertyChange(evt);
            }
        });

        jLabel2.setText("Article");

        jtaArticleContent.setColumns(20);
        jtaArticleContent.setLineWrap(true);
        jtaArticleContent.setRows(5);
        jtaArticleContent.setWrapStyleWord(true);
        jtaArticleContent.setEnabled(false);
        jScrollPane2.setViewportView(jtaArticleContent);

        jToolBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setFocusable(false);

        jbAddCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jbAddCategory.setFocusable(false);
        jbAddCategory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbAddCategory.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddCategoryActionPerformed(evt);
            }
        });
        jToolBar1.add(jbAddCategory);

        jbEditCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_blue.png"))); // NOI18N
        jbEditCategory.setFocusable(false);
        jbEditCategory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbEditCategory.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbEditCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditCategoryActionPerformed(evt);
            }
        });
        jToolBar1.add(jbEditCategory);

        jbDelCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        jbDelCategory.setFocusable(false);
        jbDelCategory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbDelCategory.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbDelCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDelCategoryActionPerformed(evt);
            }
        });
        jToolBar1.add(jbDelCategory);

        jToolBar2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        jToolBar2.setFocusable(false);

        jbAddArticle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jbAddArticle.setFocusable(false);
        jbAddArticle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbAddArticle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbAddArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddArticleActionPerformed(evt);
            }
        });
        jToolBar2.add(jbAddArticle);

        jbEditArticle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_blue.png"))); // NOI18N
        jbEditArticle.setFocusable(false);
        jbEditArticle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbEditArticle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbEditArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditArticleActionPerformed(evt);
            }
        });
        jToolBar2.add(jbEditArticle);

        jbDelArticle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        jbDelArticle.setFocusable(false);
        jbDelArticle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbDelArticle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbDelArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDelArticleActionPerformed(evt);
            }
        });
        jToolBar2.add(jbDelArticle);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(67, 67, 67))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(7, 7, 7))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                    .addComponent(jcbArtcles, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbArtcles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCategoriesMouseClicked

        if (evt.getClickCount() == 2) {
            evt.consume();

            showArticlesList();
        }

    }//GEN-LAST:event_jlCategoriesMouseClicked

    private void jcbArtclesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbArtclesActionPerformed
        jtaArticleContent.setText(((Article) jcbArtcles.getSelectedItem()).getContent());
    }//GEN-LAST:event_jcbArtclesActionPerformed

    private void jlCategoriesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jlCategoriesKeyPressed
        showArticlesList();
    }//GEN-LAST:event_jlCategoriesKeyPressed

    private void jbEditArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditArticleActionPerformed
        int curRow = jcbArtcles.getSelectedIndex();

        if (curRow == -1) {
            JOptionPane.showMessageDialog(this, "Выберите статью для редактирования", "Предупреждение", JOptionPane.OK_OPTION);
            return;
        }

        Article article = (Article) jcbArtcles.getSelectedItem();

        ArticleDialog articleDialog = new ArticleDialog(this, true, article, EModeArticleDialog.EDIT);

        articleDialog.setLocationRelativeTo(this);

        articleDialog.addActionListener(new IArtilceDialogListener() {
            @Override
            public void addEditDialogAction() {

                Article article = articleDialog.getArticle();

                // Statement
                EntityManager manager = factory.createEntityManager();

                manager.getTransaction().begin();
                manager.merge(article);

                manager.flush();
                manager.getTransaction().commit();

                manager.close();

                jcbArtcles.getModel().setSelectedItem(article);
                jtaArticleContent.setText(((Article) jcbArtcles.getSelectedItem()).getContent());
            }
        });

        articleDialog.setVisible(true);
    }//GEN-LAST:event_jbEditArticleActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        factory.close();
    }//GEN-LAST:event_formWindowClosing

    private void jbAddArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddArticleActionPerformed
        Article article = new Article();

        ArticleDialog articleDialog = new ArticleDialog(this, true, article, EModeArticleDialog.ADD);

        articleDialog.setLocationRelativeTo(this);

        articleDialog.addActionListener(new IArtilceDialogListener() {
            @Override
            public void addEditDialogAction() {
                Article article = articleDialog.getArticle();
                Category category = jlCategories.getModel().getElementAt(jlCategories.getSelectedIndex());

                // Statement
                EntityManager manager = factory.createEntityManager();

                manager.getTransaction().begin();
                manager.persist(article);
//                manager.merge(category);
//                manager.refresh(category);
                manager.flush();
                manager.getTransaction().commit();                

                manager.close();

                //TODO добавляем статью в список только в том случае если категории совпадат
                showArticlesList();
//                List<Article> al = category.getArticles();
//                int f = al.indexOf(article);
//
//                if (f > -1) {
//                    jcbArtcles.getModel().setSelectedItem(article);
//                }
            }
        });

        articleDialog.setVisible(true);
    }//GEN-LAST:event_jbAddArticleActionPerformed

    private void jbDelArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDelArticleActionPerformed
        int curRow = jcbArtcles.getSelectedIndex();

        if (curRow == -1) {
            JOptionPane.showMessageDialog(this, "Выберите статью для удаления", "Предупреждение", JOptionPane.OK_OPTION);
            return;
        }

        if (JOptionPane.showConfirmDialog(this, "Вы действительно хотите удалить запись?", "Предупреждение", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
            Article article = (Article) jcbArtcles.getSelectedItem();

            // Statement
            EntityManager manager = factory.createEntityManager();

            manager.getTransaction().begin();

            Article toBeRemoved = manager.merge(article);
            manager.remove(toBeRemoved);

            manager.flush();
            manager.getTransaction().commit();
            manager.close();

            ((DefaultComboBoxModel) jcbArtcles.getModel()).removeElement(article);
        }


    }//GEN-LAST:event_jbDelArticleActionPerformed

    private void jcbArtclesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jcbArtclesPropertyChange
    }//GEN-LAST:event_jcbArtclesPropertyChange

    private void jbEditCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditCategoryActionPerformed
        int curRow = jlCategories.getSelectedIndex();

        if (curRow == -1) {
            JOptionPane.showMessageDialog(this, "Выберите категорию для редактирования", "Предупреждение", JOptionPane.OK_OPTION);
            return;
        }

        Category category = (Category) jlCategories.getSelectedValue();

        CategoryDialog categoryDialog = new CategoryDialog(this, true, category, EModeArticleDialog.EDIT);

        categoryDialog.setLocationRelativeTo(this);

        categoryDialog.addActionListener(new ICategoryDialogListener() {
            @Override
            public void addEditDialogAction() {

                Category category = categoryDialog.getCategory();

                // Statement
                EntityManager manager = factory.createEntityManager();

                manager.getTransaction().begin();
                manager.merge(category);

                manager.flush();
                manager.getTransaction().commit();

                manager.close();

//                jcbArtcles.getModel().setSelectedItem(article);
//                jtaArticleContent.setText(((Article) jcbArtcles.getSelectedItem()).getContent());
            }
        });

        categoryDialog.setVisible(true);
    }//GEN-LAST:event_jbEditCategoryActionPerformed

    private void jbAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddCategoryActionPerformed
        Category category = new Category();

        CategoryDialog categoryDialog = new CategoryDialog(this, true, category, EModeArticleDialog.ADD);

        categoryDialog.setLocationRelativeTo(this);

        categoryDialog.addActionListener(new ICategoryDialogListener() {
            @Override
            public void addEditDialogAction() {
                Category category = categoryDialog.getCategory();

                // Statement
                EntityManager manager = factory.createEntityManager();

                manager.getTransaction().begin();
                manager.persist(category);
                manager.flush();
                manager.getTransaction().commit();

                manager.close();

                ((DefaultListModel) jlCategories.getModel()).addElement(category);
                jlCategories.setSelectedValue(category, true);
            }
        });

        categoryDialog.setVisible(true);
    }//GEN-LAST:event_jbAddCategoryActionPerformed

    private void jbDelCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDelCategoryActionPerformed
        int curRow = jlCategories.getSelectedIndex();

        if (curRow == -1) {
            JOptionPane.showMessageDialog(this, "Выберите запись для удаления", "Предупреждение", JOptionPane.OK_OPTION);
            return;
        }

        if (JOptionPane.showConfirmDialog(this, "Вы действительно хотите удалить запись?", "Предупреждение", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
            Category category = (Category) jlCategories.getSelectedValue();

            // Statement
            EntityManager manager = factory.createEntityManager();

            manager.getTransaction().begin();

            Category toBeRemoved = manager.merge(category);
            manager.remove(toBeRemoved);

            manager.flush();
            manager.getTransaction().commit();
            manager.close();

            ((DefaultListModel) jlCategories.getModel()).removeElement(category);
        }
    }//GEN-LAST:event_jbDelCategoryActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JButton jbAddArticle;
    private javax.swing.JButton jbAddCategory;
    private javax.swing.JButton jbDelArticle;
    private javax.swing.JButton jbDelCategory;
    private javax.swing.JButton jbEditArticle;
    private javax.swing.JButton jbEditCategory;
    private javax.swing.JComboBox<Article> jcbArtcles;
    private javax.swing.JList<Category> jlCategories;
    private javax.swing.JTextArea jtaArticleContent;
    // End of variables declaration//GEN-END:variables
}
