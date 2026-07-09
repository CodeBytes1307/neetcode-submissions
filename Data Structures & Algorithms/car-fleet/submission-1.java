class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Pair each car's position and speed
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort by position (ascending)
        Arrays.sort(cars, (a, b) -> a[0] - b[0]);

        Stack<Double> st = new Stack<>();

        // Process from the car closest to the target
        for (int i = n - 1; i >= 0; i--) {
            double time = (double)(target - cars[i][0]) / cars[i][1];

            // New fleet
            if (st.isEmpty() || time > st.peek()) {
                st.push(time);
            }
            // Else: this car catches the fleet ahead,
            // so we do nothing.
        }

        return st.size();
    }
}