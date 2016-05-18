import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by sebastian on 17.05.2016.
 */
public class Loto {
    private final static int k = 1; //nr. extrageri pe saptamana

    public static void main(String[] a) {
        System.out.println("cate bilete doresti sa joci?");
        Scanner sc = new Scanner(System.in);
        int nrBilete = sc.nextInt();
        if (nrBilete != 0) {
            //prep. lotto machine
            Random lottoMachine = new Random();
            lottoMachine.setSeed(k);
            //gen. lotto no.
            Set setofSix = new HashSet<Integer>();
            int counter = 0;
            System.out.println("set lotto machine");
            do {
                int nr = lottoMachine.nextInt(49) + 1;
                boolean success = setofSix.add(nr);
                if (success) {
                    counter++;
                    if (counter <= 5) {
                        System.out.print(nr + " / ");
                    } else {
                        System.out.println(nr);
                    }
                }
            } while (counter < 6);

            //alte 6 nr pentru bilet client


            Random setClient = new Random();
            setClient.setSeed(System.nanoTime());
            Set myOwnSetOfSix = new HashSet<Integer>();

            for (int i = 0; i < nrBilete; i++) {
                System.out.println("set client");
                int count = 0;
                while (count < 6) {
                    int nr = setClient.nextInt(49) + 1;
                    boolean success = myOwnSetOfSix.add(nr);
                    if (success) {
                        count++;
                        if (count <= 5) {
                            System.out.print(nr + " / ");
                        } else {
                            System.out.println(nr);
                        }
                    }
                }

                while (setofSix.retainAll(myOwnSetOfSix)) {

                    System.out.println(setofSix.size());
                    int x = setofSix.size();
                    switch (x) {
                        case 3:
                            System.out.println("ai castigat la categoria 4 dupa " + "i" + " incercari.\n");
                            break;
                        case 4:
                            System.out.println("ai castigat la categoria 3 dupa " + "i" + " incercari.\n");
                            break;
                        case 5:
                            System.out.println("ai castigat la categoria 2 dupa " + "i" + " incercari.\n");
                            break;
                        case 6:
                            System.out.println("ai castigat la categoia 1 dupa " + "i" + "incercari. BRAVO!!!\n");
                            break;
                        default:
                            System.out.println("biletul nu este castigator, mai incearca! \n");
                            break;
                    }
                }
            }
        }  else if (nrBilete == 0) {
            System.out.println("Nu ai introdus niciun numar de bilete, introdu un numar!");
        }

    }
}
