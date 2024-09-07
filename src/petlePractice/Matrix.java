package petlePractice;

public class Matrix {

    public static void main(String[] args) {

        int n = 3;
        int number = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }
    }
}

