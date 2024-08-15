class Solution {
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[]) {
        int n = petrol.length;
        int totalPetrol = 0, totalDistance = 0;
        int start = 0, currPetrol = 0;

        for (int i = 0; i < n; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
            currPetrol += petrol[i] - distance[i];

            if (currPetrol < 0) {
                start = i + 1;
                currPetrol = 0;
            }
        }

        return totalPetrol >= totalDistance ? start : -1;
    }
}
