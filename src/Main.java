public class Main {
    public static void main(String[] args) {

        ZipCodeRangeService service = ZipCodeRangeService.getInstance();

        // [94133,94133] [94200,94299] [94600,94699]
        ZipCodeRange[] input1 = new ZipCodeRange[3];
        input1[0] = new ZipCodeRange(94133, 94133);
        input1[1] = new ZipCodeRange(94200, 94299);
        input1[2] = new ZipCodeRange(94600, 94600);

        ZipCodeRange[] output1 = service.getOptimizedRanges(input1);
        printInputAndOutputRanges(input1, output1);

        // [94133,94133] [94200,94299] [94226,94399]
        ZipCodeRange[] input2 = new ZipCodeRange[3];
        input2[0] = new ZipCodeRange(94133, 94133);
        input2[1] = new ZipCodeRange(94200, 94299);
        input2[2] = new ZipCodeRange(94226, 94399);

        ZipCodeRange[] output2 = service.getOptimizedRanges(input2);
        printInputAndOutputRanges(input2, output2);

    }

    private static void printInputAndOutputRanges(ZipCodeRange[] input1, ZipCodeRange[] output1) {
        System.out.print("Input : ");
        printRange(input1);
        System.out.print("Output: ");
        printRange(output1);
        System.out.println("-------------------------------------------------------------");
    }

    private static void printRange(ZipCodeRange[] ranges) {
        for(ZipCodeRange range: ranges) {
            System.out.print(range.toString()+" ");
        }
        System.out.print("\n");
    }
}
