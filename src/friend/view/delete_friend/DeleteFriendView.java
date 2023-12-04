package friend.view.delete_friend;
import friend.app.DeleteFriendUseCaseFactory;
import friend.interface_adapter.delete_friend.DeleteFriendViewModel;
import friend.view.FriendViewManager;

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
    private boolean deleteFriendCompleted = false;
    private FriendViewManager friendViewManager;
    private String deletedFriendUserName;
    private String currentUsername;
    private boolean n = true;
    private boolean p = true;
    private JLayeredPane jLayeredPane;
    private Canvas canvas;
    private JButton yes;
    private JButton no;
    private JButton ok;
    public DeleteFriendView(DeleteFriendViewModel deleteFriendViewModel){
        this.deleteFriendViewModel = deleteFriendViewModel;
        this.deleteFriendViewModel.addPropertyChangeListener(this);
    }
    public DeleteFriendViewModel getDeleteFriendViewModel() {
        return deleteFriendViewModel;
    }
    private void updateView(){
        if(!deleteFriendCompleted){
            if(n){
                this.jLayeredPane = new JLayeredPane();
                this.jLayeredPane.setBounds(0,0,width,height);
                this.jLayeredPane.setBackground(Color.GRAY);
                this.jLayeredPane.setOpaque(true);
                this.canvas = new Canvas(){
                    @Override
                    public void paint(Graphics g){
                        if(!deleteFriendCompleted){
                            g.setFont(new Font(deleteFriendViewModel.getFontName(),
                                    Font.BOLD, deleteFriendViewModel.getFontSize()));
                            g.setColor(Color.black);
                            g.drawString(message,
                                    deleteFriendViewModel.getAskingMessageXValue(),
                                    deleteFriendViewModel.getAskingMessageYValue());
                        }else{
                            g.setFont(new Font(deleteFriendViewModel.getFontName(),
                                    Font.BOLD, deleteFriendViewModel.getFontSize()));
                            g.setColor(Color.black);
                            g.drawString(deletedFriendUserName,
                                    deleteFriendViewModel.getDeletedFriendUsernameXValue(),
                                    deleteFriendViewModel.getDeletedFriendUsernameYValue());
                            g.drawString(message,
                                    deleteFriendViewModel.getResultMessageXValue(),
                                    deleteFriendViewModel.getResultMessageYValue());
                        }
                    }
                };
                this.canvas.setBounds(0,0,deleteFriendViewModel.getCanvasWidth(),deleteFriendViewModel.getCanvasHeight());
                this.canvas.setBackground(Color.GRAY);
                this.yes = new JButton("Yes");
                this.no = new JButton("No");
                this.yes.setBounds(deleteFriendViewModel.getYesButtonXValue(),
                        deleteFriendViewModel.getYesButtonYValue(),
                        deleteFriendViewModel.getYesButtonWidth(),
                        deleteFriendViewModel.getYesButtonHeight());
                this.no.setBounds(deleteFriendViewModel.getNoButtonXValue(),
                        deleteFriendViewModel.getNoButtonYValue(),
                        deleteFriendViewModel.getNoButtonWidth(),
                        deleteFriendViewModel.getNoButtonHeight());
                this.yes.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            DeleteFriendUseCaseFactory.create(friendViewManager).
                                    execute(currentUsername,deletedFriendUserName);
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
                this.ok = new JButton("Ok.");
                this.ok.setBounds(deleteFriendViewModel.getOkButtonXValue(),
                        deleteFriendViewModel.getOkButtonYValue(),
                        deleteFriendViewModel.getOkButtonWidth(),
                        deleteFriendViewModel.getOkButtonHeight());
                this.ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        friendViewManager.getShowFriendInfoView().setVisible(false);
                        friendViewManager.getDeleteFriendView().setVisible(false);
                    }
                });
                this.jLayeredPane.add(this.ok, 0);
                this.jLayeredPane.add(this.yes);
                this.jLayeredPane.add(this.no);
                this.jLayeredPane.add(this.canvas);
                this.add(this.jLayeredPane);
                n = false;
            }
            this.ok.setVisible(false);
            yes.setVisible(true);
            no.setVisible(true);
        }else{
            this.canvas.repaint();
            yes.setVisible(false);
            no.setVisible(false);
            ok.setVisible(true);
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
