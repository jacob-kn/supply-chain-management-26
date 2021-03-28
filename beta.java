import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.util.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class beta {
    //Testing out VS code integration

    //test1
    /*
    test constructor of inventory
    uses getters to make sure proper Instantiation of class
    */
    @Test
    public void testConstructor(){
        Inventory invent = new Inventory("jdbc:mysql://localhost/inventory", "scm", "esnf409");
        assertTrue("DBURL", "jdbc:mysql://localhost/inventory".equals(invent.getDBURL));
        assertTrue("USERNAME", "scm".equals(invent.getUSERNAME));
        assertTrue("PASSWORD", "esnf409".equals(invent.getPASSWORD));
    }

    //test2
    /*
    test initializeConnection

    */
}
