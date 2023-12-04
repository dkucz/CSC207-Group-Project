package friend.view.add_friend;

import friend.app.AddFriendUseCaseFactory;
import friend.interface_adapter.add_friend.AddFriendViewModel;
import friend.view.FriendViewManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class AddFriendView extends JFrame implements PropertyChangeListener {
    private String currentUsername;
    private FriendViewManager friendViewManager;
    private final int width;
    private final int height;
    private final AddFriendViewModel addFriendViewModel;
    private JButton add;
    private JTextField wantToAddFriendUsernameTextField;
    private final JLayeredPane jLayeredPane;
    private final Canvas canvas = new Canvas(){
        @Override
        public void paint(Graphics g){
            g.setFont(new Font(addFriendViewModel.getFontName(), Font.BOLD, addFriendViewModel.getFontSize()));
            g.setColor(addFriendViewModel.getFontColour());
            g.drawString(addFriendViewModel.getFriendUsername(),
                    addFriendViewModel.getStringXValue(),
                    addFriendViewModel.getStringYValue());
        }
    };
    public AddFriendView(AddFriendViewModel addFriendViewModel){
        this.addFriendViewModel = addFriendViewModel;
        this.addFriendViewModel.addPropertyChangeListener(this);
        this.width = addFriendViewModel.getWidth();
        this.height = addFriendViewModel.getHeight();
        this.jLayeredPane = new JLayeredPane();
        initializeTextField();
        initializeAddButton();
        initializeCanvas();
        initializeJlayeredPane();
        this.setSize(new Dimension(width,height));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(this.jLayeredPane);
    }
    public AddFriendViewModel getAddFriendViewModel(){
        return this.addFriendViewModel;
    }
    private void initializeTextField(){
        this.wantToAddFriendUsernameTextField = new JTextField();
        this.wantToAddFriendUsernameTextField.setBounds(addFriendViewModel.getTextFieldXValue(),
                addFriendViewModel.getTextFieldYValue(),
                addFriendViewModel.getTextFieldWidth(),
                addFriendViewModel.getTextFieldHeight());
    }
    private void initializeAddButton(){
        this.add = new JButton("Add");
        this.add.setBounds(addFriendViewModel.getButtonXValue(),
                addFriendViewModel.getButtonYValue(),
                addFriendViewModel.getButtonWidth(),
                addFriendViewModel.getButtonHeight());
        this.add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wantToAddFriendUsername = wantToAddFriendUsernameTextField.getText();
                wantToAddFriendUsernameTextField.setText("");
                friendViewManager.getAddFriendView().setVisible(false);
                try {
                    AddFriendUseCaseFactory.create(friendViewManager).execute(currentUsername,wantToAddFriendUsername);
                } catch (ExecutionException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (GeneralSecurityException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    private void initializeCanvas(){
        this.canvas.setBounds(0,0,width,height);
        this.canvas.setBackground(Color.GRAY);

    }
    private void initializeJlayeredPane(){
        this.jLayeredPane.setBounds(0,0,width,height);
        this.jLayeredPane.add(this.canvas,0);
        this.jLayeredPane.add(this.wantToAddFriendUsernameTextField,0);
        this.jLayeredPane.add(this.add,0);
    }
    private void update(){
        this.canvas.repaint();
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("setUsernameAndManager")){
            ArrayList<Object> outputDataList = (ArrayList<Object>) evt.getNewValue();
            this.currentUsername = (String) outputDataList.get(0);
            this.friendViewManager = (FriendViewManager) outputDataList.get(1);
            update();
        }
    }
}
