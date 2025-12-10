package arrays;

public class TrappingWater {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(trappingWater(arr));
    }

    private static int trappingWater(int[] arr) {
        int sum = 0;
        int left = 0, right = arr.length - 1, leftMax = 0, rightMax = 0;
        while (left < right) {
            if (arr[left] < arr[right]) {
                if (arr[left] > leftMax) {
                    leftMax = arr[left];
                } else {
                    sum = sum + (leftMax - arr[left]);
                }
                left++;
            } else {
                if (arr[right] > rightMax) {
                    rightMax = arr[right];
                } else {
                    sum = sum + (rightMax - arr[right]);
                }
                right--;
            }
        }
        return sum;
    }
}
