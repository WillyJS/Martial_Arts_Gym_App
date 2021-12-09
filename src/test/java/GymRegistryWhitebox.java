package test.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import main.java.memoranda.GymRegistry;
import main.java.memoranda.GymUser;

public class GymRegistryWhitebox {

    GymRegistry registry = new GymRegistry();

    // Test check for a default registry having 1 user.
    @Test
    public void findDefaultAdminAccount() {
        assertEquals(1,registry.registrySize());
    }

    // Test if only user contained has username admin. 
    @Test
    public void defaultAccountShouldBeAdmin( ) {
        assertEquals(true,registry.findUser("admin"));
    }

    // Test if new user is added to the registry.
    @Test
    public void setUserIncreasesRegistrySize() {
        int registrySize = registry.registrySize();
        GymUser user2 = new GymUser("newuser","mypassword","Jane Doe","student","white");
        registry.setUser(user2);
        assertEquals(registrySize + 1,registry.registrySize());
    }

    // Test if user is removed from the registry using getUser method. 
    @Test
    public void deleteUserShouldDecreaseRegistrySize() {
        int registrySize = registry.registrySize();
        registry.deleteUser("admin");
        assertEquals(registrySize - 1,registry.registrySize());
    }
}
