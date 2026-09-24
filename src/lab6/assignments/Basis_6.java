package lab6.assignments;

public class Basis_6 {

    public static int B1A() {
        int ledigePlasser = 0;

        for (boolean [] row : aud){
            for (boolean isOccupied : row) {
                if (!isOccupied) {
                    ledigePlasser++;
                }
            }
        }

        return ledigePlasser;
    }

    public static float B1B() {
        int ledigePlasser = 0;
        int antallPlasser = 0;

        for (boolean [] row : aud){
            for (boolean isOccupied : row) {
                antallPlasser++;
                if (!isOccupied) {
                    ledigePlasser++;
                }
            }
        }

        return ((float) ledigePlasser / antallPlasser) * 100;
    }

    public static String B1C_SearchFirst() {

        for (int i = 0; i < aud.length; i++){
            for (int j = 0; j < aud[i].length; j++) {
                if (aud[i][j] == true) {
                    return "(%s,%s)".formatted(i+1,j+1);
                }
            }
        }

        return "No available seats";
    }

    public static String B1C_SearchLast() {

        for (int i = aud.length-1; i > 0; i--){
            for (int j = aud[i-1].length-1; j > 0; j--) {
                if (aud[i][j] == true) {
                    return "(%s,%s)".formatted(i+1,j+1);
                }
            }
        }

        return "No available seats";
    }

    public static String B1D() {

        for (boolean[] row : aud){
            for (boolean seat : row) {
                if (seat == true)
                    return "Det er eit ledig sete";
            }
        }

        return "No available seats";
    }

    public static String B1E() {

        int ledigeSeter = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < aud.length; i++) {
            boolean[] row = aud[i];
            for (int j = 0; j < row.length; j++) {
                if (
                    row[j] &&
                    (j+1 == row.length || row[j + 1]) &&
                    (j == 0 || row[j - 1])
                ) {
                    ledigeSeter++;
                    //return "Det er eit ledig sete med plass rundt. Sete rad: %s, nr: %s".formatted(i + 1, j + 1);
                    sb.append("%n \t Sete rad: %s, nr: %s".formatted(i + 1, j + 1));
                }
            }
        }

        sb.insert(0, "Det er %s ledig sete med plass rundt:".formatted(ledigeSeter));
        if (ledigeSeter == 0) sb.replace(0, sb.length(), "No available seats");
        return sb.toString();
    }

    public static boolean[][] aud =
    {
            { false, false, false, false}, // rad 0
            { false, false, true,  false}, // rad 1
            { true,  false, true,  true }, // rad 2
            { true,  true,  true,  true }, // rad 3
    };

    public static void Audiotorium() {

        boolean[][] audp;

        int ANTALL = 8;
        int RADER = 6;

        boolean[][] d111 = new boolean[RADER][ANTALL];

        // avlese en verdi
        boolean plass12 = aud[1][2];
        System.out.println(plass12);

        boolean plass21 = aud[2][1];
        System.out.println(plass21);

        // sette en verdi
        System.out.println(aud[0][1]);
        aud[0][1] = true;
        System.out.println(aud[0][1]);

        // ta ut en rad
        boolean[] rad0 = aud[2];

        // skrive ut en rad
        for (int p = 0; p < rad0.length; p++) {

            boolean plass = rad0[p];

            if (plass) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
        }

        System.out.println();

        System.out.println("version 1");

        for (int r = 0; r < aud.length; r++) {

            boolean[] rad = aud[r];

            for (int p = 0; p < rad.length; p++) {

                boolean plass = rad[p];

                if (plass) {
                    System.out.print("X");
                } else {
                    System.out.print("O");
                }

            }

            System.out.println();
        }

        System.out.println("version 2");

        for (int r = 0; r < aud.length; r++) {

            for (int p = 0; p < aud[r].length; p++) {

                if (aud[r][p]) {
                    System.out.print("X");
                } else {
                    System.out.print("O");
                }

            }

            System.out.println();
        }

        System.out.println("version 3");

        for (boolean[] rad : aud) {

            for (boolean plass : rad) {

                if (plass) {
                    System.out.print("X");
                } else {
                    System.out.print("O");
                }

            }

            System.out.println();
        }

        int r = 0;
        boolean funnet = false;

        while (r < aud.length && !funnet) {

            int p = 0;
            while (p<aud[r].length && !funnet) {

                if (!(aud[r][p])) {
                    funnet = true;
                }

                p++;
            }

            r++;
        }

        System.out.println(funnet);
    }
}
