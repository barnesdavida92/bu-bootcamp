package module3.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach; 
 
public class ContactTest { 

    private Contact contact; 
 
    @BeforeEach
    void setUp() {
        contact = new Contact("Zelda Hyrule", "+1 374 432 2222");
    } 

    @Test
    void getName_returnsCorrectName() {
        assertEquals("Zelda Hyrule", contact.getName());
    } 
 
    @Test
    void getPhone_returnsCorrectPhone() {
        assertEquals("+1 374 432 2222", contact.getPhoneNumber());
    } 
 
    @Test
    void toString_containsBothFields() {
        assertTrue(contact.toString().contains("Zelda Hyrule"));
        assertTrue(contact.toString().contains("+1 374 432 2222"));
    }
} 