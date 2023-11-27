package Friend.view;

import Friend.interface_adapter.AddFriendViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class AddFriendView extends JFrame implements PropertyChangeListener {
    private String currentUsername;
    private FriendViewManager friendViewManager;
    private final int width;
    private final int height;
    private final AddFriendViewModel addFriendViewModel;
    private JButton add;

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
    private void initializeAddButton(){
        this.add = new JButton("Add");
        this.add.setBounds(70,150,100,50);
    }
    private void initializeCanvas(){
        this.canvas.setBounds(0,0,width,height);
        this.canvas.setBackground(Color.GRAY);

    }
    private void initializeJlayeredPane(){
        this.jLayeredPane.setBounds(0,0,width,height);
        this.jLayeredPane.add(this.canvas,0);
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
