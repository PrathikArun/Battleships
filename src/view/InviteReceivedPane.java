package view;

import model.MatchRoom;

import javax.swing.*;
import java.awt.*;

public class InviteReceivedPane extends JOptionPane {

    private JDialog dialog;
    private MatchRoom matchRoom;
    private String key;
    public InviteReceivedPane(String key, String name, MatchRoom matchRoom) {
        super();
        this.setMessage(name + " would like to play with you.");
        this.setMessageType(QUESTION_MESSAGE);
        this.setOptionType(YES_NO_OPTION);
        String[] options = {"Accept", "Reject"};
        this.setOptions(options);
        this.key = key;
        this.matchRoom = matchRoom;
    }
    public void showOptionPane(Component parent) {
        dialog = this.createDialog(parent, "Invite");
        dialog.setVisible(true);
        dialog.dispose();
        if (getValue() == "Accept") {
            matchRoom.sendStringArray(new String[]{"join", "accept", key});
        } else if (getValue() == "Reject") {
            matchRoom.sendStringArray(new String[]{"join", "reject", key});
        }
    }

    public void dispose() {
        dialog.dispose();
    }
}
