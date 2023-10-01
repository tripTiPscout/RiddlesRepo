package bg.codexio.riddles;

import bg.codexio.riddles.thegoodelf.ElfBusiness;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElfBusinessTest {

    @Test
    public void testCalculateLettersToRemove_SameWords() {
        int result = ElfBusiness.calculateLettersToRemove("hello", "hello");
        assertEquals(0, result);
    }

    @Test
    public void testCalculateLettersToRemove_DifferentWords() {
        int result = ElfBusiness.calculateLettersToRemove("codewars", "hackerrank");
        assertEquals(10, result);
    }

    @Test
    public void testCalculateLettersToRemove_DifferentLengths() {
        int result = ElfBusiness.calculateLettersToRemove("abc", "abcd");
        assertEquals(1, result);
    }

    @Test
    public void testCalculateLettersToRemove_IgnoreCase() {
        int result = ElfBusiness.calculateLettersToRemove("TeSt", "tEsT");
        assertEquals(0, result);
    }

    @Test
    public void testCalculateLettersToRemove_EmptyStrings() {
        int result = ElfBusiness.calculateLettersToRemove("", "");
        assertEquals(0, result);
    }
}
