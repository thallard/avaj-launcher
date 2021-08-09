import java.io.*;
import classes.*;
import classes.aircrafts.*;
import classes.weather.WeatherTower;

class Main {
    // Constant variables for Aircraft names in MD5
    public static final String baloonHash = "994736b4f0aec72f6e5ae580051d012f";
    public static final String jetplaneHash = "3145ba416e54a114cb3aac3f174c22dd";
    public static final String helicopterHash = "d0309a20530ee9b892113d29949ca11c";

    // Parse each line of aircrafts in scenario file to return an object Flyable
    // which pairs with the type of Aircraft
    public static Flyable createAircraft(AircraftFactory factory, String line, boolean isMD5) throws Exception {
        String tmp = line, type = null, typeToRemove = null;

        // Replace hash type by the real type
            typeToRemove = tmp.substring(0, tmp.indexOf(" ")).replace(tmp + " ", "");
            switch (typeToRemove) {
                case baloonHash:
                    type = "Baloon";
                    break;
                case jetplaneHash:
                    type = "JetPlane";
                    break;
                case helicopterHash:
                    type = "Helicopter";
                    break;
                default:
                    type = typeToRemove;
            }

        tmp = tmp.replace(typeToRemove + " ", "");
        String name = tmp.substring(0, tmp.indexOf(" ")).replace(tmp + " ", "");
        tmp = tmp.replace(name + " ", "");
        String longitude = tmp.substring(0, tmp.indexOf(" ")).replace(tmp + " ", "");
        tmp = tmp.replace(longitude + " ", "");
        String latitude = tmp.substring(0, tmp.indexOf(" ")).replace(tmp + " ", "");
        tmp = tmp.replace(latitude + " ", "");
        String height = tmp.replace(tmp + " ", "");
        return (factory.newAircraft(type, name, Integer.parseInt(longitude), Integer.parseInt(latitude), Integer.parseInt(height)));
    }

    public static Game parsing(String path, boolean isMD5) throws FileException {
        Game game = new Game();
        File file = null;
        try {
            file = new File(path);
            String line;

            int count = 0;
            if (!file.exists() || !file.canRead())
                throw new FileException(path);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            AircraftFactory factory = new AircraftFactory();

            while ((line = br.readLine()) != null) {
                String tmp = line;
                if (line.length() == 0)
                    continue;
                // Parse first line (number of loops)
                if (count++ == 0) {
                    long nbLoops = Long.parseLong(line);
                    if (nbLoops < 0) {
                        System.out.println("\033[91mError (scenario file) : Invalid number of loops.\u001B[0m");
                        br.close();
                        return (null);
                    }

                    game.setCountLoop(nbLoops);
                    continue;
                }

                // Parse aircrafts names and coordinates
                tmp = tmp.substring(0, tmp.indexOf(" "));
                switch (tmp) {
                    case baloonHash: case helicopterHash: case jetplaneHash:
                    case "Helicopter": case "Baloon": case "JetPlane":
                        game.addAircraft(createAircraft(factory, line, isMD5));
                        break;
                    default:
                        System.out.println("\u001B[91mError (scenario file) : Invalid name of aircraft. (" + tmp + ")\u001B[0m");
                        br.close();
                        return (null);
                }
            }
            br.close();
        } catch (Exception e) {
            assert file != null;
            if (file.exists())
                System.out.println("\u001B[91mError (scenario file) " + e + ": Invalid number of loops.\u001B[0m");
            return (null);
        }
        return (game);
    }

    public static void simulation(Game game) {
        WeatherTower weatherTower = game.getWeatherTower();

        for (int loop = 0; loop < game.getCountLoops(); loop++)
           weatherTower.changeWeather();
    }

    public static void main(String[] args) {
        boolean isMD5 = false;
        if (args.length != 1 && args.length != 2) {
            System.out.println("\u001B[91mNumbers of parameters incorrect. (Need one scenario file)");
            return;
        }
        if (args.length == 2 && args[1].equalsIgnoreCase("MD5"))
            isMD5 = true;
        Game game;
        try {
            if ((game = parsing(args[0], isMD5)) == null)
                return ;
        } catch (FileException e) {
            return ;
        }

        simulation(game);
    }
}
