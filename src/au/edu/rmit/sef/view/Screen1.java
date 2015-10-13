/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.rmit.sef.view;

/**
 *
 * @author Khang
 */
public class Screen1 extends javax.swing.JPanel {

    /**
     * Creates new form Screen1
     */
    public Screen1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        startButton = new javax.swing.JLabel();
        instructionsButton = new javax.swing.JLabel();
        scoreButton = new javax.swing.JLabel();
        quitButton = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.PNG"))); // NOI18N

        startButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/startButton.PNG"))); // NOI18N

        instructionsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/instrustionButton.PNG"))); // NOI18N

        scoreButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highScoreButton.PNG"))); // NOI18N

        quitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quitGameButton.PNG"))); // NOI18N
        quitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(quitButton)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(instructionsButton)
                                .addComponent(startButton)
                                .addComponent(scoreButton)))))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(startButton)
                .addGap(18, 18, 18)
                .addComponent(instructionsButton)
                .addGap(18, 18, 18)
                .addComponent(scoreButton)
                .addGap(18, 18, 18)
                .addComponent(quitButton)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>                        


    
    public javax.swing.JLabel getInstructionsButton() {
		return instructionsButton;
	}

	public void setInstructionsButton(javax.swing.JLabel instructionsButton) {
		this.instructionsButton = instructionsButton;
	}

	public javax.swing.JLabel getQuitButton() {
		return quitButton;
	}

	public void setQuitButton(javax.swing.JLabel quitButton) {
		this.quitButton = quitButton;
	}

	public javax.swing.JLabel getScoreButton() {
		return scoreButton;
	}

	public void setScoreButton(javax.swing.JLabel scoreButton) {
		this.scoreButton = scoreButton;
	}

	public javax.swing.JLabel getStartButton() {
		return startButton;
	}

	public void setStartButton(javax.swing.JLabel startButton) {
		this.startButton = startButton;
	}



	// Variables declaration - do not modify                     
    private javax.swing.JLabel instructionsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel quitButton;
    private javax.swing.JLabel scoreButton;
    private javax.swing.JLabel startButton;
    // End of variables declaration                   
}
