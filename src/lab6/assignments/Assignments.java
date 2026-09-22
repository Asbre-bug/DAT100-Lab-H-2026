package lab6.assignments;

import java.util.Arrays;

public class Assignments {
    public static double[][] obs = {
            {1.4,1.7,1.9,2.0},
            {5.4,7.8,9.8,7.9,3.0},
            {-1.7,-1.7,-2.8}
    };

    public static void G1A(){
        skrivUt(obs);
    }

    public static void G1B(){
        System.out.printf("Length er lengden på det fyrste arrayet. Length = %s\n", obs.length);
    }

    public static void G1C(){
        System.out.printf("obs[0].length henter ut det fyrste elementet i obs, %n og deretter finner lengden til lista som er i posision 1 i obs. Length = %s\n", obs[0].length);
        System.out.printf("Same for obs[1].length, men det henter ut lista i %n posisjon 2 Length = %s\n", obs[1].length);
        System.out.printf("Og same her, men for posisjon 3. Length = %s\n", obs[2].length);
    }

    private static void skrivUt(double[][] tabell) {

        StringBuilder sb = new StringBuilder();

        sb.append("{ \n");
        for (double[] row : tabell){
            sb.append("\t { ");
            for (double value: row){
                sb.append(value);
                if(!Double.valueOf(row[row.length -1]).equals(value)) {
                    sb.append(", ");
                }
            }
            sb.append(" }");
            if(!Arrays.equals(tabell[tabell.length -1], row)) {
                sb.append(", \n ");
            }
        }
        sb.append("\n }");

        System.out.println(sb);
    }

    public static void G1D(){
        System.out.printf("Er ein observasjon er større ein limit? Svar: %s %n", finnes(obs, 3));
    }

    private static boolean finnes(double[][] obs, double limit){
        for (int i = 0; i < obs.length; i++) {
            if (obs[i].length > limit) {
                System.out.printf("Observasjon %s er større ein limit: %s %n", i+1, limit);
                return true;
            }
        }

        return false;
    }

    public static void G1E() {
        double[][] outObs = obs.clone();

        double[] temp = outObs[0];
        outObs[0] = outObs[outObs.length -1];
        outObs[outObs.length -1] = temp;

        skrivUt(outObs);
    }
}
