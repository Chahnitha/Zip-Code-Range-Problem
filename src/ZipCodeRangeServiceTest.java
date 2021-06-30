import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Zip Code Range Service Tests")
class ZipCodeRangeServiceTest {

    @Test
    @DisplayName("When input is null, return null")
    public void test_null_input_range() {
        ZipCodeRangeService zipCodeRangeService = ZipCodeRangeService.getInstance();
        ZipCodeRange[] actual = zipCodeRangeService.getOptimizedRanges(null);
        assertNull(actual);
    }

    @Test
    @DisplayName("When there is no overlap then it should return back the zip codes")
    public void test_no_overlap() {
        ZipCodeRange[] input = new ZipCodeRange[3];
        input[0] = new ZipCodeRange(94133, 94133);
        input[1] = new ZipCodeRange(94200, 94299);
        input[2] = new ZipCodeRange(94600, 94600);

        ZipCodeRangeService zipCodeRangeService = ZipCodeRangeService.getInstance();
        ZipCodeRange[] actual = zipCodeRangeService.getOptimizedRanges(input);

        assertArrayEquals(input, actual);
    }

    @Test
    @DisplayName("When there is overlap then it should merge and return back the zip codes")
    public void test_overlap() {
        ZipCodeRange[] input = new ZipCodeRange[3];
        input[0] = new ZipCodeRange(94133, 94133);
        input[1] = new ZipCodeRange(94200, 94299);
        input[2] = new ZipCodeRange(94226, 94399);

        ZipCodeRangeService zipCodeRangeService = ZipCodeRangeService.getInstance();
        ZipCodeRange[] actual = zipCodeRangeService.getOptimizedRanges(input);

        ZipCodeRange[] expected = new ZipCodeRange[2];
        expected[0] = new ZipCodeRange(94133, 94133);
        expected[1] = new ZipCodeRange(94200, 94399);

        assertArrayEquals(expected, actual);
    }
}