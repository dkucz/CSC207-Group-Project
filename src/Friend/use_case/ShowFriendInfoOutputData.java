package Friend.use_case;

import java.util.ArrayList;

public class ShowFriendInfoOutputData{
    private String friendUserName;
    private String friendGmail;
    public ShowFriendInfoOutputData(String friendUserName, String friendGmail){
        this.friendUserName = friendUserName;
        this.friendGmail = friendGmail;
    }
    public ArrayList<String> getOutputDataAsAList() {
        ArrayList<String> outputDataList = new ArrayList<>();
        outputDataList.add(this.friendUserName);
        outputDataList.add(this.friendGmail);
        return outputDataList;
    }
}
