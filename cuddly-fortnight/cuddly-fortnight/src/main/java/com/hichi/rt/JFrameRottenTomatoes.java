/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.hichi.rt;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



import java.io.FileReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.json.JSONObject;

/**
 *
 * @author Hector
 */
public class JFrameRottenTomatoes extends javax.swing.JFrame {

    // Read files
    private List<String> movies_lines;
    private List<String> reviews_lines;
    
    
    // Items for lists
    private List<String> movies_list;
    private List<String> publishers_list;
    
    /**
     * Creates new form JFrameRottenTomatoes
     */
    public JFrameRottenTomatoes() {
        initComponents();
        initialize();
        initUX();
    }
    
    private void initialize() {
        movies_lines = new ArrayList<>();
        reviews_lines = new ArrayList<>();
        movies_list = new ArrayList<>();
        publishers_list = new ArrayList<>();
        
        try {
            System.out.println(new File(".").getCanonicalPath());
        } catch (IOException ex) {
            Logger.getLogger(JFrameRottenTomatoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        filePanel.setBorder(BorderFactory.createTitledBorder("Carga inicial"));
        userPanel.setBorder(BorderFactory.createTitledBorder("Creación de usuario"));
        reviewPanel.setBorder(BorderFactory.createTitledBorder("Calificación en base a score de usuario"));
        reviewPanel2.setBorder(BorderFactory.createTitledBorder("Calificación en base a reseña de usuario"));
        
        batchPanel.setBorder(BorderFactory.createTitledBorder("Calificación en batch"));
        
        jListPublisher.addListSelectionListener(event -> {
            int selectedPosition = event.getLastIndex();
            if (!publishers_list.isEmpty())
                print_message("Publisher seleccionado: " + publishers_list.get(selectedPosition), "warning");
        });
        
        jListMovie.addListSelectionListener(event -> {
            int selectedPosition = event.getLastIndex();
            if (!movies_list.isEmpty())
                print_message("Película seleccionada: " + movies_list.get(selectedPosition), "warning");
        });
    }
    
    private void initUX() {
        toggleUserPanel(false);
        toggleReviewPanel(false);
        toggleReview1Panel(false);
    }
    
    private void toggleImg1(String result) {
        if (result.equalsIgnoreCase("fresh")) {
            imgFresh.setEnabled(true);
            imgRotten.setEnabled(false);
        }
        else if (result.equalsIgnoreCase("rotten")) {
            imgFresh.setEnabled(false);
            imgRotten.setEnabled(true);
        }
    }
    
    private void toggleImg2(String result) {
        if (result.equalsIgnoreCase("fresh")) {
            imgFresh2.setEnabled(true);
            imgRotten2.setEnabled(false);
        }
        else if (result.equalsIgnoreCase("rotten")) {
            imgFresh2.setEnabled(false);
            imgRotten2.setEnabled(true);
        }
    }
    
    private void toggleUserPanel(boolean isActive) {
        userPanel.setEnabled(isActive);
        lblName.setEnabled(isActive);
        tfCriticName.setEnabled(isActive);
        lblPublisher.setEnabled(isActive);
        jListPublisher.setEnabled(isActive);
        btnCreateUser.setEnabled(isActive);
    }
    
    private void toggleReviewPanel(boolean isActive) {
        reviewPanel.setEnabled(isActive);
        lblMovie.setEnabled(isActive);
        jListMovie.setEnabled(isActive);
        lblScore.setEnabled(isActive);
        cbScore.setEnabled(isActive);
        lblResult.setEnabled(isActive);
        lblResultValue.setEnabled(isActive);
        btnClasifyReview.setEnabled(isActive);
    }
    
    private void toggleReview1Panel(boolean isActive) {
        reviewPanel2.setEnabled(isActive);
        lblMovie2.setEnabled(isActive);
        jListMovie2.setEnabled(isActive);
        lblScore2.setEnabled(isActive);
        lblResult2.setEnabled(isActive);
        lblResultValue2.setEnabled(isActive);
        btnClasifyReview2.setEnabled(isActive);
        tfUserReview.setEnabled(isActive);
    }
    
    private void toggleBatchPanel(boolean isActive) {
        batchPanel.setEnabled(isActive);
        lblReviewFile2.setEnabled(isActive);
        tfReviewFileRoute2.setEnabled(isActive);
        btnSelectReviewFile2.setEnabled(isActive);
        jListBatch.setEnabled(isActive);
        lblResultBatch.setEnabled(isActive);
        jListResultBatch.setEnabled(isActive);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        filePanel = new javax.swing.JPanel();
        tfMovieFileRoute = new javax.swing.JTextField();
        btnSelectMovieFile = new javax.swing.JButton();
        lblMovieFile = new javax.swing.JLabel();
        lblReviewFile = new javax.swing.JLabel();
        tfReviewFileRoute = new javax.swing.JTextField();
        btnSelectReviewFile = new javax.swing.JButton();
        userPanel = new javax.swing.JPanel();
        tfCriticName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblPublisher = new javax.swing.JLabel();
        btnCreateUser = new javax.swing.JButton();
        jScrollPanePublishers = new javax.swing.JScrollPane();
        jListPublisher = new javax.swing.JList<>();
        reviewPanel = new javax.swing.JPanel();
        lblMovie = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        cbScore = new javax.swing.JComboBox<>();
        lblResult = new javax.swing.JLabel();
        btnClasifyReview = new javax.swing.JButton();
        lblResultValue = new javax.swing.JLabel();
        jScrollPaneMovies = new javax.swing.JScrollPane();
        jListMovie = new javax.swing.JList<>();
        imgFresh = new javax.swing.JLabel();
        imgRotten = new javax.swing.JLabel();
        reviewPanel2 = new javax.swing.JPanel();
        lblMovie2 = new javax.swing.JLabel();
        lblScore2 = new javax.swing.JLabel();
        lblResult2 = new javax.swing.JLabel();
        btnClasifyReview2 = new javax.swing.JButton();
        lblResultValue2 = new javax.swing.JLabel();
        jScrollPaneMovies2 = new javax.swing.JScrollPane();
        jListMovie2 = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tfUserReview = new javax.swing.JTextArea();
        imgFresh2 = new javax.swing.JLabel();
        imgRotten2 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        batchPanel = new javax.swing.JPanel();
        lblReviewFile2 = new javax.swing.JLabel();
        tfReviewFileRoute2 = new javax.swing.JTextField();
        btnSelectReviewFile2 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListBatch = new javax.swing.JList<>();
        lblResultBatch = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jListResultBatch = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clasificador Rotten Tomatoes");

        filePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tfMovieFileRoute.setEditable(false);
        tfMovieFileRoute.setFocusable(false);
        tfMovieFileRoute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMovieFileRouteActionPerformed(evt);
            }
        });

        btnSelectMovieFile.setText("Seleccionar archivo");
        btnSelectMovieFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectMovieFileActionPerformed(evt);
            }
        });

        lblMovieFile.setText("Películas:");

        lblReviewFile.setText("Reseñas:");

        tfReviewFileRoute.setEditable(false);
        tfReviewFileRoute.setFocusable(false);

        btnSelectReviewFile.setText("Seleccionar archivo");
        btnSelectReviewFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectReviewFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filePanelLayout = new javax.swing.GroupLayout(filePanel);
        filePanel.setLayout(filePanelLayout);
        filePanelLayout.setHorizontalGroup(
            filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMovieFile)
                    .addComponent(lblReviewFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfMovieFileRoute, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                    .addComponent(tfReviewFileRoute))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSelectMovieFile)
                    .addComponent(btnSelectReviewFile))
                .addGap(17, 17, 17))
        );
        filePanelLayout.setVerticalGroup(
            filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filePanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMovieFileRoute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelectMovieFile)
                    .addComponent(lblMovieFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfReviewFileRoute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelectReviewFile)
                    .addComponent(lblReviewFile))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        userPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblName.setText("Nombre de crítico:");

        lblPublisher.setText("Publisher:");

        btnCreateUser.setText("Crear");

        jScrollPanePublishers.setViewportView(jListPublisher);

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName)
                    .addComponent(lblPublisher))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addComponent(tfCriticName, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPanePublishers, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCreateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCreateUser)
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(tfCriticName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPanePublishers, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPublisher))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        reviewPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        reviewPanel.setPreferredSize(new java.awt.Dimension(838, 220));
        reviewPanel.setRequestFocusEnabled(false);

        lblMovie.setText("Película:");

        lblScore.setText("Valoración:");

        cbScore.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));

        lblResult.setText("Resultado:");

        btnClasifyReview.setText("Clasificar reseña");
        btnClasifyReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClasifyReviewActionPerformed(evt);
            }
        });

        lblResultValue.setText("...");

        jScrollPaneMovies.setViewportView(jListMovie);

        imgFresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fresh_img.png"))); // NOI18N
        imgFresh.setEnabled(false);

        imgRotten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotten_img.png"))); // NOI18N
        imgRotten.setEnabled(false);

        javax.swing.GroupLayout reviewPanelLayout = new javax.swing.GroupLayout(reviewPanel);
        reviewPanel.setLayout(reviewPanelLayout);
        reviewPanelLayout.setHorizontalGroup(
            reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMovie)
                    .addComponent(lblScore))
                .addGap(50, 50, 50)
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reviewPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPaneMovies, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(reviewPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reviewPanelLayout.createSequentialGroup()
                                        .addComponent(lblResult)
                                        .addGap(116, 116, 116))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reviewPanelLayout.createSequentialGroup()
                                        .addComponent(lblResultValue)
                                        .addGap(137, 137, 137))))
                            .addGroup(reviewPanelLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(imgFresh)
                                .addGap(33, 33, 33)
                                .addComponent(imgRotten)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(reviewPanelLayout.createSequentialGroup()
                        .addComponent(cbScore, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClasifyReview, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53))
        );
        reviewPanelLayout.setVerticalGroup(
            reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMovie)
                    .addComponent(jScrollPaneMovies, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(reviewPanelLayout.createSequentialGroup()
                        .addComponent(lblResult)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(reviewPanelLayout.createSequentialGroup()
                                .addComponent(lblResultValue)
                                .addGap(12, 12, 12)
                                .addComponent(imgFresh))
                            .addComponent(imgRotten))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblScore)
                    .addComponent(btnClasifyReview))
                .addGap(83, 83, 83))
        );

        reviewPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        reviewPanel2.setRequestFocusEnabled(false);

        lblMovie2.setText("Película:");

        lblScore2.setText("Reseña :");

        lblResult2.setText("Resultado:");

        btnClasifyReview2.setText("Clasificar reseña");
        btnClasifyReview2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClasifyReview2ActionPerformed(evt);
            }
        });

        lblResultValue2.setText("...");

        jScrollPaneMovies2.setViewportView(jListMovie2);

        tfUserReview.setColumns(20);
        tfUserReview.setRows(5);
        jScrollPane4.setViewportView(tfUserReview);

        imgFresh2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fresh_img.png"))); // NOI18N
        imgFresh2.setEnabled(false);

        imgRotten2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotten_img.png"))); // NOI18N
        imgRotten2.setEnabled(false);

        javax.swing.GroupLayout reviewPanel2Layout = new javax.swing.GroupLayout(reviewPanel2);
        reviewPanel2.setLayout(reviewPanel2Layout);
        reviewPanel2Layout.setHorizontalGroup(
            reviewPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reviewPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblScore2)
                    .addComponent(lblMovie2))
                .addGap(60, 60, 60)
                .addGroup(reviewPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneMovies2, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addGroup(reviewPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reviewPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(reviewPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(reviewPanel2Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(btnClasifyReview2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(reviewPanel2Layout.createSequentialGroup()
                                .addGroup(reviewPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(reviewPanel2Layout.createSequentialGroup()
                                        .addGap(164, 164, 164)
                                        .addComponent(lblResultValue2))
                                    .addGroup(reviewPanel2Layout.createSequentialGroup()
                                        .addGap(131, 131, 131)
                                        .addComponent(lblResult2)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reviewPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imgFresh2)
                        .addGap(33, 33, 33)
                        .addComponent(imgRotten2)
                        .addGap(86, 86, 86))))
        );
        reviewPanel2Layout.setVerticalGroup(
            reviewPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reviewPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(reviewPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(reviewPanel2Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(lblResultValue2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClasifyReview2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reviewPanel2Layout.createSequentialGroup()
                        .addGroup(reviewPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reviewPanel2Layout.createSequentialGroup()
                                .addGroup(reviewPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblResult2)
                                    .addComponent(lblMovie2))
                                .addGroup(reviewPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(reviewPanel2Layout.createSequentialGroup()
                                        .addGap(178, 178, 178)
                                        .addComponent(lblScore2))
                                    .addGroup(reviewPanel2Layout.createSequentialGroup()
                                        .addGap(102, 102, 102)
                                        .addGroup(reviewPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(imgFresh2)
                                            .addComponent(imgRotten2)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reviewPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPaneMovies2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        btnReset.setText("Reiniciar");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        batchPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblReviewFile2.setText("Reseñas:");

        tfReviewFileRoute2.setEditable(false);
        tfReviewFileRoute2.setFocusable(false);

        btnSelectReviewFile2.setText("Seleccionar archivo");
        btnSelectReviewFile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectReviewFile2ActionPerformed(evt);
            }
        });

        jScrollPane6.setViewportView(jListBatch);

        lblResultBatch.setText("Resultado:");

        jScrollPane7.setViewportView(jListResultBatch);

        javax.swing.GroupLayout batchPanelLayout = new javax.swing.GroupLayout(batchPanel);
        batchPanel.setLayout(batchPanelLayout);
        batchPanelLayout.setHorizontalGroup(
            batchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(batchPanelLayout.createSequentialGroup()
                .addGroup(batchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(batchPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(batchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7)
                            .addGroup(batchPanelLayout.createSequentialGroup()
                                .addGroup(batchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblResultBatch)
                                    .addComponent(btnSelectReviewFile2)
                                    .addComponent(lblReviewFile2)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 1, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, batchPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfReviewFileRoute2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        batchPanelLayout.setVerticalGroup(
            batchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(batchPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblReviewFile2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfReviewFileRoute2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSelectReviewFile2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(lblResultBatch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(userPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(reviewPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reviewPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(batchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {filePanel, reviewPanel, userPanel});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(filePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reviewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(batchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reviewPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(914, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectMovieFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectMovieFileActionPerformed
        String line = "";
        try {
            /**
             * llamamos el metodo que permite cargar la ventana
             */
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(this);
            /**
             * abrimos el archivo seleccionado
             */
            File directorio = file.getSelectedFile();

            /**
             * recorremos el archivo, lo leemos para plasmarlo en el area de
             * texto
             */
            if (directorio != null) {
               tfMovieFileRoute.setText(directorio.getAbsolutePath());
                BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(directorio), "utf-8"));
                Set<String> movies_set = new TreeSet<>();
    
                while ((line = bfr.readLine()) != null) {
                    movies_lines.add(line);
                    movies_set.add(line.split(",")[1]);
                }
                
                bfr.close();
                movies_list = movies_set.stream().toList();
                loadMoviesToList();
                
                if (!tfReviewFileRoute.getText().isEmpty()) {
                    toggleUserPanel(true);
                    toggleReviewPanel(true);
                    toggleReview1Panel(true);
                }
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSelectMovieFileActionPerformed

    private void loadMoviesToList() {
        // Create a DefaultListModel to store the strings
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String item : movies_list) {
            listModel.addElement(item);
        }
        
        jListMovie.setModel(listModel);
        jListMovie2.setModel(listModel);
    }
    
        private void loadReviewsToList(ArrayList<String> listado1, ArrayList<String> listado2) {
        // Create a DefaultListModel to store the strings
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String item : listado1) {
            listModel.addElement(item);
        }
        
        jListBatch.setModel(listModel);
        
        DefaultListModel<String> listModel2 = new DefaultListModel<>();
        for (String item : listado2) {
            listModel2.addElement(item);
        }
        
        jListResultBatch.setModel(listModel2);
    }
    
    private void btnSelectReviewFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectReviewFileActionPerformed
        String line = "";
        try {
            /**
             * llamamos el metodo que permite cargar la ventana
             */
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(this);
            /**
             * abrimos el archivo seleccionado
             */
            File directorio = file.getSelectedFile();

            /**
             * recorremos el archivo, lo leemos para plasmarlo en el area de
             * texto
             */
            if (directorio != null) {
               tfReviewFileRoute.setText(directorio.getAbsolutePath());
                BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(directorio), "utf-8"));
                Set<String> publishers_set = new TreeSet<>();
                
                while ((line = bfr.readLine()) != null) {
                    reviews_lines.add(line);
                    publishers_set.add(line.split(",")[3]);
                }
                
                bfr.close();
                publishers_list = publishers_set.stream().toList();
                loadPublishersToList();
                
                if (!tfMovieFileRoute.getText().isEmpty()) {
                    toggleUserPanel(true);
                    toggleReviewPanel(true);
                    toggleReview1Panel(true);
                }
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSelectReviewFileActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clean();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnClasifyReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClasifyReviewActionPerformed
         try {
            // Recopilar datos
            String critic = tfCriticName.getText();
            String publisher = jListPublisher.getSelectedValue();
            String movieName = jListMovie.getSelectedValue();
            int score = cbScore.getSelectedIndex();  // Supone que cbScore contiene opciones 0 a 5
            String formattedScore = score + "/5";

            // Crear JSON de solicitud
            JSONObject requestJson = new JSONObject();
            requestJson.put("critic", critic);
            requestJson.put("publisher", publisher);
            requestJson.put("movie_name", movieName);
            requestJson.put("score", formattedScore);
            requestJson.put("review_content", "");
            requestJson.put("result", "");

            // Configurar la conexión
            URL url = new URL("http://localhost:5000/classifyMovie");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            // Enviar solicitud
            try(OutputStream os = conn.getOutputStream()) {
                byte[] input = requestJson.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Leer la respuesta
            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

                // Parsear la respuesta JSON
                JSONObject responseJson = new JSONObject(response.toString());
                String result = responseJson.getString("result");

                // Actualizar el JLabel con el resultado
                lblResultValue.setText(result);
                
                toggleImg1(result);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            lblResultValue.setText("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnClasifyReviewActionPerformed

    private void btnClasifyReview2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClasifyReview2ActionPerformed
        try {
            // Recopilar datos
            String critic = tfCriticName.getText();
            String publisher = jListPublisher.getSelectedValue();
            String movieName = jListMovie.getSelectedValue();
            String reviewContent = tfUserReview.getText();

            // Crear JSON de solicitud
            JSONObject requestJson = new JSONObject();
            requestJson.put("critic", critic);
            requestJson.put("publisher", publisher);
            requestJson.put("movie_name", movieName);
            requestJson.put("score", "");
            requestJson.put("review_content", reviewContent);
            requestJson.put("result", "");

            // Configurar la conexión
            URL url = new URL("http://localhost:5000/classifyMovie");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            // Enviar solicitud
            try(OutputStream os = conn.getOutputStream()) {
                byte[] input = requestJson.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Leer la respuesta
            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

                // Parsear la respuesta JSON
                JSONObject responseJson = new JSONObject(response.toString());
                String result = responseJson.getString("result");

                // Actualizar el JLabel con el resultado
                lblResultValue2.setText(result);

                toggleImg2(result);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            lblResultValue2.setText("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnClasifyReview2ActionPerformed

    private void btnSelectReviewFile2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectReviewFile2ActionPerformed

        try {
            /**
             * llamamos el metodo que permite cargar la ventana
             */
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(this);
            /**
             * abrimos el archivo seleccionado
             */
            File directorio = file.getSelectedFile();

            /**
             * recorremos el archivo, lo leemos para plasmarlo en el area de
             * texto
             */
            if (directorio != null) {
                int x = 0;
                ArrayList<String> reviewsBatch = new ArrayList<>();
                ArrayList<String> resultsBatch = new ArrayList<>();
                List<String[]> csvData = readCsv(directorio.getAbsolutePath());
                tfReviewFileRoute2.setText(directorio.getAbsolutePath());
                        for (String[] line : csvData) {
                            
                            if(line.length > 7){
                                String link = line[0];
                                String reviewContent = line[7];
                                reviewsBatch.add(link + " - " + reviewContent);
                                String result = makeHttpRequest(reviewContent);
                                resultsBatch.add(link + " - " + result);
                                x++;
                                
                            }
                        }
                        
                loadReviewsToList(reviewsBatch, resultsBatch);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSelectReviewFile2ActionPerformed
    
    private String makeHttpRequest(String reviewContent) {
        String result = "";
        try {
            // Crear JSON de solicitud
            JSONObject requestJson = new JSONObject();
            requestJson.put("critic", "");
            requestJson.put("publisher", "");
            requestJson.put("movie_name", "");
            requestJson.put("score", "");
            requestJson.put("review_content", reviewContent);
            requestJson.put("result", "");

            // Configurar la conexión
            URL url = new URL("http://localhost:5000/classifyMovie");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            // Enviar solicitud
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = requestJson.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Leer la respuesta
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

                // Parsear la respuesta JSON
                JSONObject responseJson = new JSONObject(response.toString());
                result = responseJson.getString("result");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private List<String[]> readCsv(String filePath) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    
    
    private void tfMovieFileRouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMovieFileRouteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMovieFileRouteActionPerformed

    private void clean() {
        movies_lines.clear();
        reviews_lines.clear();
        movies_list = new ArrayList<>();
        publishers_list = new ArrayList<>();
        
        tfMovieFileRoute.setText("");
        tfReviewFileRoute.setText("");
        
        jListPublisher.setModel(new DefaultListModel<>());
        jListResultBatch.setModel(new DefaultListModel<>());
        jListMovie.setModel(new DefaultListModel<>());
        jListMovie2.setModel(new DefaultListModel<>());
        toggleUserPanel(false);
        toggleReviewPanel(false);
        toggleReview1Panel(false);
        lblResultValue2.setText("...");
        
        lblResultValue.setText("...");
        
        tfReviewFileRoute2.setText("");
        jListBatch.setModel(new DefaultListModel<>());
        jListResultBatch.setModel(new DefaultListModel<>());
        
        imgFresh.setEnabled(false);
        imgRotten.setEnabled(false);
        imgFresh2.setEnabled(false);
        imgRotten2.setEnabled(false);
        tfUserReview.setText("");
    }
    
    private void loadPublishersToList() {
        // Create a DefaultListModel to store the strings
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String item : publishers_list) {
            listModel.addElement(item);
        }
        
        jListPublisher.setModel(listModel);
    }
    
    
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
            java.util.logging.Logger.getLogger(JFrameRottenTomatoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameRottenTomatoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameRottenTomatoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameRottenTomatoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameRottenTomatoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel batchPanel;
    private javax.swing.JButton btnClasifyReview;
    private javax.swing.JButton btnClasifyReview2;
    private javax.swing.JButton btnCreateUser;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSelectMovieFile;
    private javax.swing.JButton btnSelectReviewFile;
    private javax.swing.JButton btnSelectReviewFile2;
    private javax.swing.JComboBox<String> cbScore;
    private javax.swing.JPanel filePanel;
    private javax.swing.JLabel imgFresh;
    private javax.swing.JLabel imgFresh2;
    private javax.swing.JLabel imgRotten;
    private javax.swing.JLabel imgRotten2;
    private javax.swing.JList<String> jListBatch;
    private javax.swing.JList<String> jListMovie;
    private javax.swing.JList<String> jListMovie2;
    private javax.swing.JList<String> jListPublisher;
    private javax.swing.JList<String> jListResultBatch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPaneMovies;
    private javax.swing.JScrollPane jScrollPaneMovies2;
    private javax.swing.JScrollPane jScrollPanePublishers;
    private javax.swing.JLabel lblMovie;
    private javax.swing.JLabel lblMovie2;
    private javax.swing.JLabel lblMovieFile;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPublisher;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblResult2;
    private javax.swing.JLabel lblResultBatch;
    private javax.swing.JLabel lblResultValue;
    private javax.swing.JLabel lblResultValue2;
    private javax.swing.JLabel lblReviewFile;
    private javax.swing.JLabel lblReviewFile2;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblScore2;
    private javax.swing.JPanel reviewPanel;
    private javax.swing.JPanel reviewPanel2;
    private javax.swing.JTextField tfCriticName;
    private javax.swing.JTextField tfMovieFileRoute;
    private javax.swing.JTextField tfReviewFileRoute;
    private javax.swing.JTextField tfReviewFileRoute2;
    private javax.swing.JTextArea tfUserReview;
    private javax.swing.JPanel userPanel;
    // End of variables declaration//GEN-END:variables

    private void print_message(String text, String tipo) {
        switch (tipo) {
            case "error":
                JOptionPane.showMessageDialog(new JFrame(), text, "Recomendación", JOptionPane.ERROR_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(new JFrame(), text, "Atención", JOptionPane.DEFAULT_OPTION);
        }
    }
}
