class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, 
    int[][] containedBoxes, int[] initialBoxes) {
        int total = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> boxSet = new HashSet<>();
        boolean[] visited = new boolean[candies.length];

        // Add all initial boxes to the set
        for (int box : initialBoxes) {
            boxSet.add(box);
            if (status[box] == 1) {
                queue.offer(box);
            }
        }

        while (!queue.isEmpty()) {
            int box = queue.poll();

            if (visited[box]) continue;

            total += candies[box];
            visited[box] = true;

            // Use keys to unlock new boxes
            for (int key : keys[box]) {
                if (status[key] == 0) {
                    status[key] = 1;
                    if (boxSet.contains(key) && !visited[key]) {
                        queue.offer(key);
                    }
                }
            }

            // Add contained boxes
            for (int contained : containedBoxes[box]) {
                boxSet.add(contained);
                if (status[contained] == 1 && !visited[contained]) {
                    queue.offer(contained);
                }
            }

            for (int b : boxSet) {
                if (status[b] == 1 && !visited[b]) {
                    queue.offer(b);
                }
            }
        }

        return total;
    }
}