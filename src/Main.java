import java.io.*;
import java.util.*;
import classes.*;
import classes.aircrafts.*;

class Main {

    // Parse each line of aircrafts in scenario file to return an object Flyabe
    // which pairs with the type of Aircraft
    public static Flyabe createAircraft(AircraftFactory factory, String line) {
        System.out.println("create airfracft : " + line + "\n");
        String tmp = line;

        String type = tmp.substring(0, tmp.indexOf(" ")).replace(tmp + " ", "");
        tmp = tmp.replace(type + " ", "");
        String name = tmp.substring(0, tmp.indexOf(" ")).replace(tmp + " ", "");
        tmp = tmp.replace(name + " ", "");
        String longitude = tmp.substring(0, tmp.indexOf(" ")).replace(tmp + " ", "");
        tmp = tmp.replace(longitude + " ", "");
        String latitude = tmp.substring(0, tmp.indexOf(" ")).replace(tmp + " ", "");
        tmp = tmp.replace(latitude + " ", "");
        String height = tmp.replace(tmp + " ", "");
        return (factory.newAircraft(type, name, Integer.parseInt(longitude), Integer.parseInt(latitude),
                Integer.parseInt(height)));
    }

    public static boolean parsing(String path) {
        try {
            File file = new File(path);
            String line;
            int count = 0;
            if (!file.exists() || !file.canRead()) {
                System.out.println(
                        "\u001B[91mError : File doesnt exist/not enough permissions : \"" + path + "\".\u001B[0m");
                return (false);
            }
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            Game game = new Game();
            AircraftFactory factory = new AircraftFactory();

            while ((line = br.readLine()) != null) {
                String tmp = line;
                if (line.length() == 0)
                    continue;
                // Parse first line (number of loops)
                if (count++ == 0) {
                    long nbLoops = Long.parseLong(line);
                    if (nbLoops < 0) {
                        System.out.println("\u001B[91mError (scenario file) : Invalid number of loops.\u001B[0m");
                        br.close();
                        return (false);
                    }
                    game.setCountLoop(nbLoops);
                    continue;
                }
                // Parse aircrafts names and coordinates
                if (!tmp.equalsIgnoreCase("Baloon") && !tmp.equalsIgnoreCase("JetPlane")
                        && !tmp.equalsIgnoreCase("Helicopter") && tmp.contains(" ")) {
                    tmp = tmp.substring(0, tmp.indexOf(" "));
                    if (!tmp.equalsIgnoreCase("Baloon") && !tmp.equalsIgnoreCase("JetPlane")
                            && !tmp.equalsIgnoreCase("Helicopter")) {
                        System.out.println(
                                "\u001B[91mError (scenario file) : Invalid name of aircraft. (" + tmp + ")\u001B[0m");
                        br.close();
                        return (false);
                    }
                    // tmp = line.substring(1, tmp.indexOf(" "));
                    // System.out.println(line);
                    game.addAircraft(createAircraft(factory, line));
                }

                // } else {
                // // factory.
                // game.addAircraft(factory.newAircraft(tmp, tmp, 10, 20, 30));
                // }
                // System.out.println(line);
            }
            br.close();
            ArrayList<Flyabe> aircrafts = game.getAircrafts();
            for (Flyabe flyabe : aircrafts)
                System.out.println("Name : " + flyabe.getType() + " " + flyabe.getName() + " " + flyabe.getLongitude() + " " + flyabe.getLatitude() + " " + flyabe.getHeight());
        } catch (Exception e) {
            System.out.println("\u001B[91mError (scenario file) " + e + ": Invalid number of loops.\u001B[0m");
            return (false);
        }

        return (true);
    }

    public static void main(String[] args) {
        if (args.length > 1 || args.length == 0) {
            System.out.println("\u001B[91mNumbers of parameters incorrect. (Need one scenario file)");
            return;
        }
        if (!parsing(args[0]))
            return;

        System.out.println("Hello, World! " + args[0]);
        System.out.println("\uD83C\uDF27");

    }
}
