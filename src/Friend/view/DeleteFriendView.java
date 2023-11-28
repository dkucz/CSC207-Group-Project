package Friend.view;

import Friend.interface_adapter.DeleteFriendViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class DeleteFriendView extends JFrame implements PropertyChangeListener {
    private DeleteFriendViewModel deleteFriendViewModel;
    private int width;
    private int height;
    private String message;
    private boolean deleteFriendCompleted;
    private JLayeredPane jLayeredPane;
    private Canvas canvas;
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
            this.canvas = new Canvas(){
                @Override
                public void paint(Graphics g){
                    g.setFont(new Font("Safari", Font.BOLD, 32));
                    g.drawString(message,(int)(width * 0.23),50);
                }
            };
            this.canvas.setBounds(0,0,width,(int)(height * 0.7));
            this.jLayeredPane.add(this.canvas);
            this.add(this.jLayeredPane);
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
            this.setSize(width,height);
            updateView();
        }
    }
}
