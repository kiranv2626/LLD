package splitwise;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    List<Group> groupList;

    public GroupController() {
        groupList = new ArrayList<>();
    }

    public void addGroup(String groupId, String groupName, String groupDescription, User createdBy) {
        Group group = new Group(groupId, groupName, groupDescription);
        group.addUser(createdBy);
        groupList.add(group);
    }

    public Group getGroup(String groupId) {
        for (Group group : groupList) {
            if (group.getGroupId().equals(groupId)) {
                return group;
            }
        }
        return null;
    }

    public List<Group> getGroups() {
        return groupList;
    }

    public void deleteGroup(Group group) {
        groupList.remove(group);
    }
}
