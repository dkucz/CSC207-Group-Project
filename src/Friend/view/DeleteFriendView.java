package Friend.view;

import Friend.app.DeleteFriendUseCaseFactory;
import Friend.interface_adapter.DeleteFriendViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class DeleteFriendView extends JFrame implements PropertyChangeListener {
    private DeleteFriendViewModel deleteFriendViewModel;
    private int width;
    private int height;
    private String message;
    private boolean deleteFriendCompleted;
    private FriendViewManager friendViewManager;
    private String deletedFriendUserName;
    private String currentUsername;

    private JLayeredPane jLayeredPane;
    private Canvas canvas;
    private JButton yes;
    private JButton no;
    private JButton completed;
    public DeleteFriendView(DeleteFriendViewModel deleteFriendViewModel){
        this.deleteFriendViewModel = deleteFriendViewModel;
        this.deleteFriendViewModel.addPropertyChangeListener(this);
    }

    public DeleteFriendViewModel getDeleteFriendViewModel() {
        return deleteFriendViewModel;
    }
    private void updateView(){
        if(!deleteFriendCompleted){
            this.jLayeredPane = new JLayeredPane();
            this.jLayeredPane.setBounds(0,0,width,height);
            this.jLayeredPane.setBackground(Color.GRAY);
            this.jLayeredPane.setOpaque(true);
            this.canvas = new Canvas(){
                @Override
                public void paint(Graphics g){
                    g.setFont(new Font("Safari", Font.BOLD, 32));
                    g.drawString(message,(int)(width * 0.23),(int)(height * 0.36));
                }
            };
            this.canvas.setBounds(0,0,width,height/2);
            this.canvas.setBackground(Color.GRAY);
            this.yes = new JButton("Yes");
            this.no = new JButton("No");
            this.yes.setBounds((int)(width * 0.18), (int)(height * 0.55), width/4,height/5);
            this.no.setBounds((int)(width * 0.51), (int)(height * 0.55), width/4,height/5);
            this.yes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        DeleteFriendUseCaseFactory.create(friendViewManager).execute();
                    } catch (ExecutionException ex) {
                        throw new RuntimeException(ex);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            this.no.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    friendViewManager.getDeleteFriendView().setVisible(false);
                }
            });
            this.jLayeredPane.add(this.yes);
            this.jLayeredPane.add(this.no);
            this.jLayeredPane.add(this.canvas);
            this.add(this.jLayeredPane);
        }else{
            this.message = this.deletedFriendUserName + message;
            this.canvas.repaint();
            this.jLayeredPane.removeAll();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("outputData")){
            ArrayList<Object> outputDataList = (ArrayList<Object>) evt.getNewValue();
            this.width = (int) outputDataList.get(0);
            this.height = (int) outputDataList.get(1);
            this.message = (String) outputDataList.get(2);
            this.deleteFriendCompleted = (boolean) outputDataList.get(3);
            this.friendViewManager = (FriendViewManager) outputDataList.get(4);
            this.deletedFriendUserName = (String) outputDataList.get(5);
            this.currentUsername = (String) outputDataList.get(6);
            this.setSize(width,height);
            updateView();
        }
    }
}
