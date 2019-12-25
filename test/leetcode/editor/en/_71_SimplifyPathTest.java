package leetcode.editor.en;

import org.hamcrest.Matcher;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.experimental.theories.Theory;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class _71_SimplifyPathTest {
    @Rule
    @Test
    public void test_simplifyPath(){
        System.out.println("in method");
        _71_SimplifyPath.Solution simplifyPath = new _71_SimplifyPath.Solution();
        String result = simplifyPath.simplifyPath("/a//b////c/d//././/..");
        String expected = "/a/b/c";
        Assert.assertEquals(expected, result);
        Assert.assertThat(result, is(expected));
        assertThat(result, is(expected));
    }
}