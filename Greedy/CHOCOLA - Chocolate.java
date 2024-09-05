import java.util.*;
import java.lang.*;

class Main {

    static int minimumcost(int row, int col, int[] harr, int[] varr) {
        int i = 0;
        int j = 0;
        int cost = 0;
        Arrays.sort(harr);
        Arrays.sort(varr);
        int hpart = 1;
        int vpart = 1;
        while (i < row && j < col) {
            if (varr[j] >= harr[i]) {
                cost += varr[j] * vpart;
                j++;
                hpart++;
            } else {
                cost += harr[i] * hpart;
                i++;
                vpart++;
            }
        }
        while (i < row) {
            cost += harr[i] * hpart;
            i++;
        }

        while (j < col) {
            cost += varr[j] * vpart;
            j++;
        }
        return cost;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner ob = new Scanner(System.in);
        if (ob.hasNextInt()) {
            int m = ob.nextInt();
            if (ob.hasNextInt()) {
                int n = ob.nextInt();
                if (m <= 0 || n <= 0) {
                    System.out.println("Invalid input: m and n must be greater than 0");
                } else {
                    int row = m - 1;
                    int col = n - 1;
                    int harr[] = new int[row];
                    for (int i = 0; i < row; i++) {
                        if (ob.hasNextInt()) {
                            harr[i] = ob.nextInt();
                        } else {
                            System.out.println("Invalid input: not enough integers for harr array");
                            return;
                        }
                    }
                    int varr[] = new int[col];
                    for (int j = 0; j < col; j++) {
                        if (ob.hasNextInt()) {
                            varr[j] = ob.nextInt();
                        } else {
                            System.out.println("Invalid input: not enough integers for varr array");
                            return;
                        }
                    }

                    if (harr.length == 0 || varr.length == 0) {
                        System.out.println("Invalid input: harr and varr arrays cannot be empty");
                        return;
                    }
                    int mincost = minimumcost(row, col, harr, varr);
                    System.out.println("the minimum cost is " + mincost);
                }
            } else {
                System.out.println("Invalid input: not enough integers for n");
                return;
            }
        } else {
            System.out.println("Invalid input: not enough integers for m");
            return;
        }
    }
}
