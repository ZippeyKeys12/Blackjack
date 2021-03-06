package zipp.blackjack;

//import java.awt.*;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * BlackJack with a GUI
 *
 * @author Zain
 */
public class BlackJackGUI extends JFrame {
    private final Map<Character, Image[]> cardPics = new HashMap<>();
    private boolean insured;
    private volatile boolean showDHand;
    private volatile boolean acted = false;
    private int nCharlie, action, playing = 0;
    private volatile int handNum;
    private Shoe shoe;
    private Hand dHand;
    private Dealer dealer;
    private Player player;
    private Image cardBack;
    private JTextField betAmount;
    private JLabel betShower;
    private JButton butDDown;
    private JButton butHit;
    private JButton butInsur;
    private JButton butNext;
    private JButton butPlay;
    private JButton butQuit;
    private JButton butSplit;
    private JButton butStand;
    private JButton butSurr;
    private JTextField initialMoney;
    private JLabel moneyCount;
    private JComboBox<String> noDecks, chooseCharlie;
    private JDialog startPopUp;
    private Canvas canvas;
    private Group root;
    private bGroundPanel gameScreen;

    /**
     * Creates new form BlackJackGUI
     */
    private BlackJackGUI() {
        init();
    }

    private void init() {
        initComponents();
        startPopUp.pack();
        startPopUp.setVisible(true);
        this.setVisible(false);
        Platform.runLater(this::initJavaFX);
        new Thread(this::loadImages).start();
    }

    private void initJavaFX() {
        root = new Group();
        Scene scene = new Scene(root, 1000, 750, javafx.scene.paint.Color.TRANSPARENT);
        canvas = new Canvas(1000, 750);
        gameScreen.setScene(scene);
        root.getChildren().add(canvas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        startPopUp = new JDialog();
        initialMoney = new JTextField();
        JLabel gameOptions = new JLabel();
        JButton donDone = new JButton();
        JLabel decksInShoeLbl = new JLabel();
        JLabel nCardCharlie = new JLabel();
        noDecks = new JComboBox<>();
        chooseCharlie = new JComboBox<>();
        gameScreen = new bGroundPanel();
        JPanel buttonPanel = new JPanel();
        JLabel betLbl = new JLabel();
        betAmount = new JTextField();
        butStand = new JButton();
        butHit = new JButton();
        butSurr = new JButton();
        butDDown = new JButton();
        butSplit = new JButton();
        butInsur = new JButton();
        butPlay = new JButton();
        butQuit = new JButton();
        betShower = new JLabel();
        moneyCount = new JLabel();
        butNext = new JButton();
        startPopUp.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        startPopUp.setTitle("Options");
        startPopUp.setAlwaysOnTop(true);
        startPopUp.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        startPopUp.setSize(new Dimension(212, 120));
        addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent evt) {
                butQuitActionPerformed();
            }
        });
        initialMoney.setText("Initial Player Money");
        initialMoney.setToolTipText("Initial Player Money");
        gameOptions.setText("Game Options");
        donDone.setText("Done");
        donDone.addActionListener(evt2 -> donDoneActionPerformed());
        decksInShoeLbl.setText("# of Decks in a Shoe");
        noDecks.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "4", "6", "8"}));
        nCardCharlie.setText("_-Card Charlie");
        chooseCharlie.setModel(new DefaultComboBoxModel<>(new String[]{"5", "6"}));
        GroupLayout startPopUpLayout = new GroupLayout(startPopUp.getContentPane());
        startPopUp.getContentPane().setLayout(startPopUpLayout);
        startPopUpLayout.setHorizontalGroup(
                startPopUpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(startPopUpLayout.createSequentialGroup()
                                                          .addGroup(startPopUpLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                    .addGroup(startPopUpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                                              .addGroup(startPopUpLayout.createSequentialGroup()
                                                                                                                                        .addGap(73, 73, 73)
                                                                                                                                        .addComponent(gameOptions))
                                                                                                              .addGroup(startPopUpLayout.createSequentialGroup()
                                                                                                                                        .addGap(31, 31, 31)
                                                                                                                                        .addComponent(initialMoney, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
                                                                                    .addGroup(startPopUpLayout.createSequentialGroup()
                                                                                                              .addComponent(decksInShoeLbl)
                                                                                                              .addGap(19, 19, 19)
                                                                                                              .addComponent(noDecks, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                                    .addGroup(startPopUpLayout.createSequentialGroup()
                                                                                                              .addComponent(nCardCharlie)
                                                                                                              .addGap(19, 19, 19)
                                                                                                              .addComponent(chooseCharlie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                          .addContainerGap(33, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, startPopUpLayout.createSequentialGroup()
                                                                                          .addGap(0, 0, Short.MAX_VALUE)
                                                                                          .addComponent(donDone)
                                                                                          .addGap(76, 76, 76))
                                           );
        startPopUpLayout.setVerticalGroup(
                startPopUpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(startPopUpLayout.createSequentialGroup()
                                                          .addGap(4, 4, 4)
                                                          .addComponent(gameOptions, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                          .addComponent(initialMoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                          .addGroup(startPopUpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                    .addComponent(noDecks, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                    .addComponent(decksInShoeLbl))
                                                          .addGroup(startPopUpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                    .addComponent(chooseCharlie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                    .addComponent(nCardCharlie))
                                                          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                          .addComponent(donDone)
                                                          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                         );
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("BlackJack");
        setEnabled(false);
        setResizable(false);
        setSize(new Dimension(1000, 750));
        addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent evt) {
                butQuitActionPerformed();
            }
        });
        gameScreen.setBackground(new java.awt.Color(0, 51, 0));
        GroupLayout gameScreenLayout = new GroupLayout(gameScreen);
        gameScreen.setLayout(gameScreenLayout);
        gameScreenLayout.setHorizontalGroup(
                gameScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGap(0, 1000, Short.MAX_VALUE)
                                           );
        gameScreenLayout.setVerticalGroup(
                gameScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGap(0, 750, Short.MAX_VALUE)
                                         );
        betLbl.setText("Bet:");
        initialMoney.setEnabled(true);
        initialMoney.addActionListener(evt2 -> donDoneActionPerformed());
        betAmount.setEnabled(false);
        betAmount.addActionListener(evt3 -> betAmountActionPerformed());
        butStand.setText("Stand");
        butStand.setEnabled(false);
        butStand.addActionListener(evt1 -> butStandActionPerformed());
        butHit.setText("Hit");
        butHit.setEnabled(false);
        butHit.addActionListener(evt5 -> butHitActionPerformed());
        butSurr.setText("Surrender");
        butSurr.setEnabled(false);
        butSurr.addActionListener(evt4 -> butSurrActionPerformed());
        butDDown.setText("Double Down");
        butDDown.setEnabled(false);
        butDDown.addActionListener(evt4 -> butDDownActionPerformed());
        butSplit.setText("Split");
        butSplit.setEnabled(false);
        butSplit.addActionListener(evt4 -> butSplitActionPerformed());
        butInsur.setText("Insurance");
        butInsur.setEnabled(false);
        butInsur.addActionListener(evt3 -> butInsurActionPerformed());
        butPlay.setText("Play");
        butPlay.setEnabled(false);
        butPlay.addActionListener(evt2 -> butPlayActionPerformed());
        butQuit.setText("Quit");
        butQuit.setEnabled(false);
        butQuit.addActionListener(evt1 -> butQuitActionPerformed());
        butNext.setText("Next");
        butNext.setEnabled(false);
        butNext.addActionListener(evt -> butNextActionPerformed());
        GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
                buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                 .addGroup(GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                                                                                            .addContainerGap(192, Short.MAX_VALUE)
                                                                                            .addComponent(moneyCount)
                                                                                            .addGap(18, 18, 18)
                                                                                            .addComponent(betLbl)
                                                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                            .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                                                       .addComponent(betShower, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                       .addComponent(betAmount, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                                                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                            .addComponent(butStand)
                                                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                            .addComponent(butHit)
                                                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                            .addComponent(butSurr)
                                                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                            .addComponent(butDDown)
                                                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                            .addComponent(butSplit)
                                                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                            .addComponent(butInsur)
                                                                                            .addGap(16, 16, 16)
                                                                                            .addComponent(butNext)
                                                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                            .addComponent(butPlay)
                                                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                            .addComponent(butQuit)
                                                                                            .addGap(27, 27, 27))
                                            );
        buttonPanelLayout.setVerticalGroup(
                buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                 .addGroup(GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                                                                                            .addComponent(betShower, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
                                                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                            .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                                                                                                       .addComponent(butQuit)
                                                                                                                       .addComponent(betLbl)
                                                                                                                       .addComponent(betAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                                       .addComponent(butStand)
                                                                                                                       .addComponent(butHit)
                                                                                                                       .addComponent(butSurr)
                                                                                                                       .addComponent(butDDown)
                                                                                                                       .addComponent(butSplit)
                                                                                                                       .addComponent(butInsur)
                                                                                                                       .addComponent(butPlay)
                                                                                                                       .addComponent(moneyCount)
                                                                                                                       .addComponent(butNext))
                                                                                            .addContainerGap())
                                          );
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                                      .addGap(38, 38, 38)
                                      .addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                      .addComponent(gameScreen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                 );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                      .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                      .addContainerGap()
                                                                      .addComponent(gameScreen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                      .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                               );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butQuitActionPerformed() {System.exit(0);}

    private void donDoneActionPerformed() {
        try {
            int initMoney=Integer.parseInt(initialMoney.getText());
            new Thread(() -> prepGame(initMoney, Integer.parseInt(noDecks.getSelectedItem().toString()), Integer.parseInt(chooseCharlie.getSelectedItem().toString()))).start();
            this.setEnabled(true);
            this.setVisible(true);
            startPopUp.setVisible(false);
        } catch (NumberFormatException ignored) {}
    }

    private void betAmountActionPerformed() {
        try {
            if (Integer.parseInt(betAmount.getText()) > 0 && Integer.parseInt(betAmount.getText()) <= getAvailableFunds()) {
                betShower.setText("$" + betAmount.getText());
                if (playing == 0) {
                    butPlay.setEnabled(true);
                }
                betAmount.setText("");
                return;
            }
        } catch (NumberFormatException ignored) {}
        butPlay.setEnabled(false);
        betShower.setText("Invalid");
        betAmount.setText("");
    }

    private void butStandActionPerformed() {
        action = 0;
        acted = true;
    }

    private void butHitActionPerformed() {
        action = 1;
        acted = true;
    }

    private void butSurrActionPerformed() {
        player.surrender();
        action = 10;
        acted = true;
    }

    private void butDDownActionPerformed() {
        action = 3;
        acted = true;
    }

    private void butSplitActionPerformed() {
        action = 2;
        acted = true;
    }

    private void butInsurActionPerformed() {
        try {
            if (Integer.parseInt(betShower.getText().substring(1)) > 0 && Integer.parseInt(betShower.getText().substring(1)) <= player.getHand(0).getBet()/2) {
                action = -1;
                insured=player.setInsurance(Integer.parseInt(betShower.getText().substring(1)));
                butInsur.setEnabled(false);
                acted = true;
                betShower.setText("");
            }
        } catch (NumberFormatException ignored) {}
        reload();
    }

    private void butPlayActionPerformed() {
        player.getHand(0).setBet(Integer.parseInt(betShower.getText().substring(1)));
        betShower.setText("");
        moneyCount.setText("Money: $" + getAvailableFunds() + "     Bets: $" + (player.getMoney() - getAvailableFunds()));
        butPlay.setEnabled(false);
        startRound();
    }

    private void butNextActionPerformed() {acted = true;}

    private void prepGame(int startMoney, int deckNum, int nCharlie) {
        playing = 0;
        this.nCharlie=nCharlie;
        shoe = new Shoe(deckNum);
        player = new Player(shoe, startMoney);
        butQuit.setEnabled(true);
        betAmount.setEnabled(true);
        moneyCount.setText("Money: $" + getAvailableFunds() + "     Bets: $" + (player.getMoney() - getAvailableFunds()));
    }

    /**
     * Returns available money for betting
     *
     * @return Available money for betting
     */
    private int getAvailableFunds() {
        return player.getMoney() - player.getHand(0).getBet() * player.getNumHands() - player.getInsurance();
    }

    private void startRound() {
        insured = false;
        dealer = new Dealer(shoe);
        dHand = dealer.getHand();
        playing = 1;
        Platform.runLater(() -> {
            drawCard(0,75, dHand);
            drawAnimatedCard(cardBack, (1000-150*nCharlie)/(2*nCharlie)+150+(1000-150*nCharlie)/nCharlie, 75);
            for(int i=0; i<2; i++) {
                drawCard(i, 450, player.getHand(0));
            }
        });
        //Draw Dealer Cards
        new Thread(this::playHands).start();
        reload();
    }

    private void reload() {
        moneyCount.setText("Money: $" + getAvailableFunds() + "     Bets: $" + (player.getMoney() - getAvailableFunds()));
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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(BlackJackGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

		/* Create and display the form */
        EventQueue.invokeLater(() -> new BlackJackGUI().setVisible(false));
    }

    private void playHands() {playHands(0);}
    private void playHands(int handNum) {
        try {Thread.sleep(1000);}
        catch (InterruptedException ex)
            {Logger.getLogger(BlackJackGUI.class.getName()).log(Level.SEVERE, null, ex);}
        this.handNum = handNum;
        boolean win;
        Hand pHand = player.getHand(handNum);
        //Draw Hand Cards
        do {
            win = false;
            if (pHand.getNumCards() == 2 && pHand.getCardsVal() == 21)
                win = pHand.giveBlackJack();
            //N-Card Charlie
            if (pHand.getNumCards() == this.nCharlie&&!pHand.isBust())
                win = pHand.isWin();
            if (win) {
                action = 0;
                acted = true;
            } else {
                if(playing==1)
                    updateButtons();
                acted = false;
                while (!acted)
                    try {Thread.sleep(200);}
                    catch (InterruptedException ex)
                    {Logger.getLogger(BlackJackGUI.class.getName()).log(Level.SEVERE, null, ex);}
                acted = false;
                butStand.setEnabled(false);
                butHit.setEnabled(false);
                butSurr.setEnabled(false);
                butDDown.setEnabled(false);
                butSplit.setEnabled(false);
                butInsur.setEnabled(false);
            }
            if(playing==1)
                betAmount.setEnabled(false);
            playing=2;
            if(insured) {
                JOptionPane.showMessageDialog(this, "Insurance " + (player.winInsurance(dHand.getCardsVal() == 21 && dHand.getNumCards() == 2) ? "Won" : "Lost"));
                if (dHand.getCardsVal() == 21 && dHand.getNumCards() == 2)
                    cleanUp();
            }
            if (action == 10) {
                player.surrender();
                cleanUp();
                return;
            }
            if(!win&&!(action==0)&&!(action==-1))
                Platform.runLater(this::drawNextCard);
        } while (player.toDo(action, handNum) && !win);
        butStand.setEnabled(false);
        butHit.setEnabled(false);
        butSurr.setEnabled(false);
        butDDown.setEnabled(false);
        butSplit.setEnabled(false);
        butInsur.setEnabled(false);
        butNext.setEnabled(true);
        acted = false;
        while (!acted)
            try {Thread.sleep(200);}
            catch (InterruptedException ex)
            {Logger.getLogger(BlackJackGUI.class.getName()).log(Level.SEVERE, null, ex);}
        acted = false;
        butNext.setEnabled(false);
        if (handNum < player.getNumHands() - 1) {
            Platform.runLater(this::switchHands);
            playHands(handNum + 1);
        }
        if (handNum != 0)
            return;
        showDHand = false;
        for (Hand i : player.getHands())
            if (!i.getWin() && !i.isBust())
                showDHand = true;
        if (showDHand) {
            dealer.cheapAct();
            Platform.runLater(() -> {
                for(int i=1; i<dHand.getNumCards(); i++)
                    drawCard(i, 75, dHand);
            });
        }
        playing = 3;
        acted = false;
        while (!acted)
            try {Thread.sleep(200);} catch (InterruptedException ex) {
                Logger.getLogger(BlackJackGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        acted = false;
        butNext.setEnabled(false);
        for (int i = 0; i < player.getNumHands(); i++) {
            this.handNum = i;
            if (!player.getHand(i).isBust() && (player.getHand(i).getCardsVal() > dHand.getCardsVal() || dHand.isBust()))
                player.getHand(i).isWin();
            JOptionPane.showMessageDialog(this, ((player.getHand(i).isBlackJack()) ? "Blackjack!" : "Hand" + ((player.getNumHands() == 1) ? "" : (" "+(i+1)))) + ((player.getHand(i).getWin()) ? " Won!" : " Lost..."));
            player.win(player.getHand(i).getWin(), i);
            reload();
        }
        Platform.runLater(this::cleanUp);
    }

    private void cleanUp() {
        butPlay.setEnabled(false);
        butQuit.setEnabled(true);
        butStand.setEnabled(false);
        butHit.setEnabled(false);
        butSurr.setEnabled(false);
        butDDown.setEnabled(false);
        butSplit.setEnabled(false);
        butInsur.setEnabled(false);
        butNext.setEnabled(false);
        playing = 0;

        root = new Group();
        Scene scene = new Scene(root, 1000, 750, javafx.scene.paint.Color.TRANSPARENT);
        canvas = new Canvas(1000, 750);
        gameScreen.setScene(scene);
        drawCurrent();
        root.getChildren().add(canvas);
        FadeTransition ft = new FadeTransition(Duration.millis(3000),canvas);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.play();
        ft.setOnFinished(event -> betAmount.setEnabled(true));
        player.reset();
        new Thread(this::cleanJavaFX).start();
        reload();
    }

    private void cleanJavaFX(){
        try {Thread.sleep(3000);}
        catch (InterruptedException ex)
        {Logger.getLogger(BlackJackGUI.class.getName()).log(Level.SEVERE, null, ex);}
        Platform.runLater(this::initJavaFX);
    }

    private synchronized void loadImages() {
        try {
            cardBack = SwingFXUtils.toFXImage(ImageIO.read(getClass().getResource("/img/deck/back.png")),null);
            char[] suits = {'H', 'C', 'D', 'S'};
            Image[] pics;
            for (char i : suits) {
                pics = new Image[13];
                for (int j = 0; j < 13; j++)
                    pics[j] = SwingFXUtils.toFXImage(ImageIO.read(getClass().getResource("/img/deck/" + (j + 2) + i + ".png")),null);
                cardPics.put(i, pics);
            }
        } catch (IOException ex) {
            Logger.getLogger(BlackJackGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateButtons(){
        boolean play=true;
        if(player.getHand(handNum).isBust()
          ||(player.getHand(handNum).getNumCards()==2&&player.getHand(handNum).getCardsVal()==21)
          ||(player.getHand(handNum).getNumCards()==nCharlie))
            play=false;
        if(playing<3&&play){
            butStand.setEnabled(true);
            butHit.setEnabled(true);
            butSurr.setEnabled((player.getHand(handNum).getNumCards() == 2));
            butDDown.setEnabled((player.getHand(handNum).getBet() <= getAvailableFunds()) && player.getHand(handNum).getNumCards() == 2);
            butSplit.setEnabled(player.getHand(handNum).getCard(0).getRank() == player.getHand(handNum).getCard(1).getRank() && player.getHand(handNum).getBet() <= getAvailableFunds() && player.getHand(handNum).getNumCards() == 2 && player.getNumHands() < 4);
            butInsur.setEnabled((dHand.getCard(0).getRank() == 14 && player.getHand(handNum).getNumCards() == 2 && !insured && getAvailableFunds() >= player.getHand(handNum).getBet() / 2));
        }else if(playing==3)
            butNext.setEnabled(true);
    }

    private void switchHands(){
        FadeTransition ft;
        try {
            PixelReader reader = SwingFXUtils.toFXImage(ImageIO.read(getClass().getResource("/img/background.png")), null).getPixelReader();
            WritableImage newImage = new WritableImage(reader, 0, 440, 1000, 310);
            ImageView iv=new ImageView()
            {{
                setOpacity(0);
                setImage(newImage);
                setTranslateY(440);
            }};
            root.getChildren().add(iv);
            ft = new FadeTransition(Duration.millis(3000),iv);
            ft.setFromValue(0);
            ft.setToValue(1);
            ft.play();
        } catch (IOException ex) {
            Logger.getLogger(BlackJackGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        drawCard(player.getHand(handNum).getNumCards()-2,450, player.getHand(handNum));
        drawCard(player.getHand(handNum).getNumCards()-1,450, player.getHand(handNum));
    }

    private void drawCurrent(){
        Hand[] hands={dHand, player.getHand(0)};
        int[] ys={75, 450};
        GraphicsContext gc=canvas.getGraphicsContext2D();
        for(int i=0; i<2; i++)
            for(int j=0; j<hands[i].getNumCards(); j++) {
                gc.setFill(Color.WHITE);
                gc.fillRect((1000-150*nCharlie)/(2*nCharlie)+150*j+(1000-150*nCharlie)/nCharlie*j, ys[i], 150, 225);
                gc.drawImage(cardPics.get(hands[i].getCard(j).getSuit().toString().charAt(0))[hands[i].getCard(j).getRank() - 2], (1000-150*nCharlie)/(2*nCharlie)+150*j+(1000-150*nCharlie)/nCharlie*j, ys[i], 150, 225);}
        if(!showDHand)
            gc.drawImage(cardBack, (1000-150*nCharlie)/(2*nCharlie)+150+(1000-150*nCharlie)/nCharlie, 75, 150, 225);
    }

    private void drawNextCard(){drawCard(player.getHand(handNum).getNumCards()-1,450, player.getHand(handNum));}

    private void drawCard(int num, int y, Hand hand){
        GraphicsContext gc=canvas.getGraphicsContext2D();
        gc.setFill(javafx.scene.paint.Color.WHITE);
        gc.fillRect((1000-150*nCharlie)/(2*nCharlie)+150*num+(1000-150*nCharlie)/nCharlie*num, y, 150, 225);
        drawAnimatedCard(cardPics.get(hand.getCard(num).getSuit().toString().charAt(0))[hand.getCard(num).getRank() - 2], (1000-150*nCharlie)/(2*nCharlie)+150*num+(1000-150*nCharlie)/nCharlie*num, y);
    }

    private void drawAnimatedCard(Image img, int x, int y) {
        GraphicsContext gc=canvas.getGraphicsContext2D();
        try
            {gc.drawImage(SwingFXUtils.toFXImage(ImageIO.read(getClass().getResource("/img/background.png")),null),0,0);}
        catch (IOException ex)
            {ex.printStackTrace();}
        Rectangle rect = new Rectangle(x, y) {{
            setFill(Color.WHITE);
            setOpacity(0);
            setTranslateX(x);
            setTranslateY(y);
            setWidth(150);
            setHeight(225);
        }};
        ImageView imgView = new ImageView() {{
            setImage(img);
            setOpacity(0);
            setTranslateX(x);
            setTranslateY(y);
            setFitWidth(150);
            setFitHeight(225);
        }};
        root.getChildren().add(rect);
        root.getChildren().add(imgView);
        FadeTransition ft1 = new FadeTransition(Duration.millis(3000), imgView);
        ft1.setFromValue(0);
        ft1.setToValue(1);
        FadeTransition ft2 = new FadeTransition(Duration.millis(3000), rect);
        ft2.setFromValue(0);
        ft2.setToValue(1);
        ParallelTransition pt1=new ParallelTransition(ft1, ft2);
        pt1.play();
        pt1.setOnFinished(event -> updateButtons());
        //new Thread(this::cleanDrawTransition).start();
    }

    /*private void cleanDrawTransition(){
        try {Thread.sleep(3000);}
        catch (InterruptedException ex)
            {Logger.getLogger(BlackJackGUI.class.getName()).log(Level.SEVERE, null, ex);}
        Platform.runLater(this::drawCurrent);
    }*/

    private class bGroundPanel extends JFXPanel {
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            try
                {g2.drawImage(ImageIO.read(getClass().getResource("/img/background.png")), 0, 0, null);}
            catch (IOException ex)
                {Logger.getLogger(BlackJackGUI.class.getName()).log(Level.SEVERE, null, ex);}
            super.paintComponent(g2);
        }
    }
}