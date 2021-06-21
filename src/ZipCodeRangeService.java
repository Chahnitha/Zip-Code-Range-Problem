import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ZipCodeRangeService {

    private static ZipCodeRangeService instance;

    public static ZipCodeRangeService getInstance() {
        if(instance == null) {
            instance = new ZipCodeRangeService();
        }
        return instance;
    }

    private ZipCodeRangeService() {}

    public ZipCodeRange[] getOptimizedRanges(ZipCodeRange[] inputRanges) {
        if(inputRanges != null) {
            // Sort based on start value of each range
            Arrays.sort(inputRanges, Comparator.comparing(ZipCodeRange::getStart));

            ZipCodeRange onGoingRange = inputRanges[0];

            List<ZipCodeRange> finalRanges = new LinkedList<>();

            // If overlap then merge, else add to finalRange list
            for(int i=1;i<inputRanges.length;i++) {
                ZipCodeRange currentRange = inputRanges[i];
                if(currentRange.getStart() <= onGoingRange.getEnd() ) {
                    onGoingRange = mergeRanges(onGoingRange, currentRange);
                } else {
                    finalRanges.add(onGoingRange);
                    onGoingRange = currentRange;
                }
            }
            finalRanges.add(onGoingRange);
            return finalRanges.toArray(new ZipCodeRange[0]);
        }
        return null;
    }

    // Merge [ start will min of both range start values, and end will the max of both range end values
    private ZipCodeRange mergeRanges(ZipCodeRange range1, ZipCodeRange range2) {
        int start = Math.min(range1.getStart(), range2.getStart());
        int end = Math.max(range1.getEnd(), range2.getEnd());

        return new ZipCodeRange(start, end);
    }
}
