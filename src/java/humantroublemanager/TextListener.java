package humantroublemanager;

/*
 * Copyright 2012 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developers.sun.com/license/berkeley_license.html
 */


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.jms.MessageListener;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.jms.JMSException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;


/**
 * The TextListener class implements the MessageListener
 * interface by defining an onMessage method that displays
 * the contents of a TextMessage.
 *
 * This class acts as the listener for the SimpleAsynchConsumer
 * class.
 */
public class TextListener implements MessageListener {
    /**
     * Casts the message to a TextMessage and displays its text.
     *
     * @param message     the incoming message
     */
    public void onMessage(Message message) {
        TextMessage msg = null;

        try {
            if (message instanceof TextMessage) {
                msg = (TextMessage) message;
                System.out.println("Reading message: " + msg.getText());
                String str=msg.getText();
                String[] damagemsg=str.split(";");
                String[] desc={"Car Id: ","Brand: ","Reason: ","Member: ","Timestamp: "};
                String popMessage = "Car out of order!!!";
                JFrame frame = new JFrame();
                frame.setSize(300,125);
                frame.setLayout(new GridBagLayout());
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = 0;
                constraints.gridy = 0;
                constraints.weightx = 1.0f;
                constraints.weighty = 1.0f;
                constraints.insets = new Insets(14,8,8,8);
                constraints.fill = GridBagConstraints.BOTH;
                JLabel headingLabel = new JLabel(popMessage);
                headingLabel.setOpaque(false);
                frame.add(headingLabel, constraints);
                constraints.gridx++;
                constraints.weightx = 0f;
                constraints.weighty = 0f;
                constraints.fill = GridBagConstraints.NONE;
                constraints.anchor = GridBagConstraints.NORTH;
                JButton closeButton = new JButton("X");
                closeButton.setMargin(new Insets(1, 4, 1, 4));
                closeButton.setFocusable(false);
                frame.add(closeButton, constraints);
                constraints.gridx=0;
                constraints.gridy=1;
                constraints.fill = GridBagConstraints.BOTH;
                JLabel messageLabel;
                for(int i=0,j=2;i<5;i++,j++)
                {
                    messageLabel=new JLabel("<HtMl>"+desc[i]+damagemsg[i]);
                    frame.add(messageLabel, constraints);
                   constraints.gridy=j;
                }
                
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
            } else {
                System.err.println("Message is not a TextMessage");
            }
        } catch (JMSException e) {
            System.err.println("JMSException in onMessage(): " + e.toString());
        } catch (Throwable t) {
            System.err.println("Exception in onMessage():" + t.getMessage());
        }
    }
}
