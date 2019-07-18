public class Main {

    public static void main(String[] args) {

        String[] stripes = { "red", "green", "yellow", "black", "brown"};
        boolean inRange = IsInRange(stripes, 254);

        System.out.println(inRange);
    }


    public static boolean IsInRange(String[] stripeColor, double measuredOhms) {

        double resistanceDouble = 0.0;
        double tensDigit;
        double onesDigit;
        double decimalMultiplier;
        double tolerance;
        double multiplier = 1;

        if(stripeColor.length == 5) {
            System.out.println("length is 5");
            double hundredsDigit = translateColor(stripeColor[0]);
            tensDigit = translateColor(stripeColor[1]);
            onesDigit = translateColor(stripeColor[2]);
            resistanceDouble = hundredsDigit*100;
            decimalMultiplier = translateColor(stripeColor[3]);
            tolerance = getTolerance(stripeColor[4]);
        } else {
            tensDigit = translateColor(stripeColor[0]);
            onesDigit = translateColor(stripeColor[1]);
            decimalMultiplier = translateColor(stripeColor[2]);
            if (stripeColor.length == 4) {
                System.out.println("length is 4");
                tolerance = getTolerance(stripeColor[3]);
            } else {
                System.out.println("length is 3");
                tolerance = 20;
            }
        }

        resistanceDouble += tensDigit*10;
        resistanceDouble += onesDigit;

        int resistanceDigits = (int)resistanceDouble;
        tolerance = tolerance/100;

        if (0 < decimalMultiplier && decimalMultiplier <1) {
            multiplier *= decimalMultiplier;
        } else {
            for (int i = 0; i < decimalMultiplier; i++) {
                multiplier *=10;
            }
        }



        double resistance = resistanceDigits*multiplier;

        System.out.println("Resistance = " + resistance);
        System.out.println("Decimal Multiplier = " + decimalMultiplier);
        System.out.println("Tolerance = " + tolerance);

        // Compare observed value to valid range
        double lowerRange = resistance*(1 - tolerance);
        double upperRange = resistance*(1 + tolerance);

        System.out.println("Lower Range = " + lowerRange);
        System.out.println("Upper Range = " + upperRange);

        if (lowerRange < measuredOhms && measuredOhms < upperRange) {
            return true;
        } else {
            return false;
        }

    }

    public static double translateColor(String color) {

        double digit;

        switch (color.toLowerCase()) {
            case "black":
                digit=0;
                break;
            case "brown":
                digit=1;
                break;
            case "red":
                digit=2;
                break;
            case "orange":
                digit=3;
                break;
            case "yellow":
                digit=4;
                break;
            case "green":
                digit=5;
                break;
            case "blue":
                digit=6;
                break;
            case "violet":
                digit=7;
                break;
            case "gray":
                digit=8;
                break;
            case "white":
                digit=9;
                break;
            case "gold":
                digit=0.1;
                break;
            case "silver":
                digit=0.01;
                break;
                default:
                    digit=99;
                    break;
        }
        return digit;
    }

    public static int getTolerance(String color) {

        int tolerance;

        switch (color.toLowerCase()) {
            case "brown":
                tolerance=1;
                break;
            case "red":
                tolerance=2;
                break;
            case "gold":
                tolerance=5;
                break;
            case "silver":
                tolerance=10;
                break;
            default:
                tolerance=20;
                break;
        }
        return tolerance;
    }

}
