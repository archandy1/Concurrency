package petlePractice;

public class forLoop {

    public static void main(String[] args) {

        // wypisuje liczby od 1 do 10 w petli for
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(i);
//        }

//        // wypisuje liczby od 1 do 5 w petli while
//        int i = 1;
//        while(i <= 5){
//            System.out.println(i);
//            i++;
//        }

        // tabliczka mnozenia
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <=10 ; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }

        // trojkat liczbowy
        int rows = 5;
        int number = 1;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }






//        int i = 0;
//        while(i < 20){
//            i++;
//            if(i % 3 == 0){
//                System.out.println("Fizz");
//            } else {
//                System.out.println(i);
//            }
//        }
    }
}
