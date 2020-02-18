package util;

import jdk.nashorn.internal.runtime.regexp.RegExp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;
import java.util.Vector;


public class RandomizerAssistant {
    private static String SALT_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static String SALT_AND_NUMBERS_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    public static final String NUMERICAL_REGEX = ("-?\\d+(\\.\\d+)?");

    private static Random random = new Random();



    public static String nextEmail (String domain) {
        StringBuilder retorno = new StringBuilder();
        retorno.append(nextString(nextInt(6, 15)));
        retorno.append("@");
        if (domain == null || domain.isEmpty()) {
            retorno.append(nextString(nextInt(4, 8)));
            retorno.append(".");
            retorno.append(nextString(nextInt(2, 4)));
        } else {
            retorno.append(domain);
        }
        return retorno.toString();
    }

    /**
     * @param length the number of random chars to be generated
     * @return
     */
    public static String nextString (int length) {
        return nextString(0, length);
    }

    public static String nextString (int pmin, int pmax) {
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 ";
        StringBuilder sb = new StringBuilder();
        int min;
        int max;
        if (pmin > pmax) {
            int aux = pmin;
            pmin = pmax;
            pmax = aux;

        }
        min = pmin;
        max = pmax;
        for (int i = min; i < max; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }

        return sb.toString();
    }

    public static String getRandomString (int min, int max) {
        StringBuilder retorno = new StringBuilder();
        while (retorno.length() < min && retorno.length() < max) { // length of the random string.
            retorno.append(getRandomChar());
            if (!RandomizerAssistant.nextBoolean()) {
                break;
            }
        }
        return retorno.toString();
    }


    public static char getRandomChar () {
        int index = (int) (RandomizerAssistant.nextDouble() * SALT_CHARS.length());
        return SALT_CHARS.charAt(index);
    }

    public static int nextInt (int min, int max) {
        int retorno = -1;
        while (retorno < min || retorno > max) {
            retorno = random.nextInt(max + 1);
        }

        return retorno;
    }

    public static int nextInt (int max) {
        int retorno = Integer.MAX_VALUE;
        while (retorno > max) {
            retorno = random.nextInt(max + 1);
        }

        return retorno;
    }

    public static int nextInt () {
        return random.nextInt();
    }

    public static double nextDouble (int max) {
        int retorno = -1;
        while (retorno > max) {
            retorno = random.nextInt(max + 1);
            retorno *= random.nextDouble();
        }

        return retorno;
    }

    public static double nextDouble () {

        return random.nextDouble();
    }

    public static boolean nextBoolean () {
        return random.nextBoolean();
    }

    @Deprecated //use double instead
    public static float nextFloat () {
        return random.nextFloat();
    }

    public static Long nextLong () {
        return random.nextLong();
    }

    public static long RQ_round (double param) {
        return new BigDecimal(param).setScale(0, RoundingMode.HALF_DOWN).longValue();
    }

    /**
     * double roundedFactor = Math.round(skillPercent / 20.0);
     * double floorFactor = Math.floor(skillPercent / 20.0);
     * double rqFactor = RandomizerAssistant.RQ_round(skillPercent / 20.0);
     * double ceilFactor = Math.ceil(skillPercent / 20.0);
     *
     * @param roundStrategy
     * @param valueToRound
     * @return
     */
    public static double getRoundFactor (ROUND_STRATEGY roundStrategy, double valueToRound) {
        if (roundStrategy == ROUND_STRATEGY.CLOSEST) {
            return Math.round(valueToRound);
        } else if (roundStrategy == ROUND_STRATEGY.CEIL) {
            return Math.ceil(valueToRound);
        } else if (roundStrategy == ROUND_STRATEGY.FLOOR) {
            return Math.floor(valueToRound);
        } else //if (roundStrategy == ROUND_STRATEGY.RQ)
        {
            return RQ_round(valueToRound);
        }
    }

    /**
     * This a silly method but it forces the sign in a quantity and does not put double - in negative.
     *
     * @param input
     * @return
     */
    public static String makeExplicitSign (Double input) {
        String retorno = "";
        if (input > 0.0) {
            retorno += "+";
        }
        retorno += input.intValue();
        return retorno;
    }


    /**
     * Loot price in a probability of wining the price
     * 0 <= p
     * p <= 1
     *
     * @param probability
     * @return
     */
    public static boolean winsPrice (double probability) {
        boolean retorno;
        if (probability > 1) {
            probability = 1.0;
        } else if (probability < 0.0) {
            probability = 0.0;
        }
        retorno = nextDouble() <= probability;
        return retorno;
    }


    public static Double getPercent (double total, double percent) {
        return (percent * 100) / total;
    }

    public static Timestamp getTimeStamp () {
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        return ts;
    }

    public static double inverse (double value) {
        return  1.0 / value;
    }

    public static boolean isNotNumber (String param) {
        boolean retorno = false;
        if (param != null)
        {
            try
            {
                retorno = NUMERICAL_REGEX.matches(param);
            }
            catch (Exception e)
            {

            }
        }
        return retorno;
    }

    public enum ROUND_STRATEGY {CLOSEST, FLOOR, CEIL, RQ}
}
