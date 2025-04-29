public class CompassDirections {

    public static String DirectionConverter(double angle){
        String[] directions = {"North", "Northeast", "East", "Southeast", "South", "Southwest", "West", "Northwest", "North"};
        return directions[(int)Math.round(((angle % 360) / 45))];
    }
}
