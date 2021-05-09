import java.io.*;
import java.util.*;
import classes.*;
import classes.aircrafts.*;

class Main {
    public static boolean parsing(String path) {
        try {
            File file = new File(path.toString());
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
                // Parse first line
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
                if (!tmp.equalsIgnoreCase("Baloon") && !tmp.equalsIgnoreCase("JetPlane") && !tmp.equalsIgnoreCase("Helicopter") && tmp.contains(" ")) {
                    tmp = tmp.substring(0, tmp.indexOf(" "));
                    if (!tmp.equalsIgnoreCase("Baloon") && !tmp.equalsIgnoreCase("JetPlane")
                            && !tmp.equalsIgnoreCase("Helicopter")) {
                        System.out.println(
                                "\u001B[91mError (scenario file) : Invalid name of aircraft. (" + tmp + ")\u001B[0m");
                        br.close();
                        return (false);
                    }
                    // tmp = line.substring(1, tmp.indexOf(" "));
                    game.addAircraft(factory.newAircraft(tmp, tmp, 10, 20, 30));
                }
                // } else {
                //     // factory.
                //     game.addAircraft(factory.newAircraft(tmp, tmp, 10, 20, 30));
                // }
                // System.out.println(line);
            }
            br.close();
            ArrayList<Flyabe> aircrafts = game.getAircrafts();
            for( Flyabe flyabe : aircrafts) 
                System.out.println("Name : " + flyabe.getName() );
        } catch (Exception e) {
            System.out.println("\u001B[91mError (scenario file) : Invalid number of loops.\u001B[0m");
            return (false);
        }
          
        {

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
