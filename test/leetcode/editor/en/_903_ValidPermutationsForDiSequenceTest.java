package leetcode.editor.en;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class _903_ValidPermutationsForDiSequenceTest {
    @Test
    public void test(){
        _903_ValidPermutationsForDiSequence.Solution solution = new _903_ValidPermutationsForDiSequence.Solution();
        Assert.assertThat(solution.numPermsDISequence("DID"), is(5));
        Assert.assertThat(solution.numPermsDISequence_numPermsDISequence_DP_N2("IDDDIIDIIIIIIIIDIDID"), is(853197538));
    }

}