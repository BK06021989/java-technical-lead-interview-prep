package com.java.oops;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 1. Class is declared final to prevent subclassing
public final class UserProfileImmutable {

    // 2. Fields are private and final
    private final String username;
    private final int id;
    private final List<String> permissions;

    // 3. Constructor performs defensive copying on mutable parameters
    public UserProfileImmutable(String username, int id, List<String> permissions) {
        this.username = username;
        this.id = id;
        
        // Make a defensive copy to prevent callers from modifying their original list
        if (permissions == null) {
            this.permissions = Collections.emptyList();
        } else {
            this.permissions = new ArrayList<>(permissions);
        }
    }

    // 4. Expose only getters, no setters
    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    // 5. Return an unmodifiable view or defensive copy
    public List<String> getPermissions() {
        return Collections.unmodifiableList(permissions);
    }
}