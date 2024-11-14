//Задание №2.1
//Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
//Вывести название каждой планеты и количество его повторений в списке.


import java.util.ArrayList;
import java.util.List;

public class Task2 {

    public static void main(String[] args) {
        List<String> planets = List.of("Венера", "Земля", "Марс", "Сатурн", "Земля");
        List<Integer> counters = new ArrayList<>();
        List<String> uniquePlanets = new ArrayList<>();

        for (int i = 0; i < planets.size(); i++) {
            String planet = planets.get(i);
            int position = uniquePlanets.indexOf(planet);
            if(position >= 0){
                counters.set(position, counters.get(position) + 1);
            }else{
                uniquePlanets.add(planet);
                counters.add(1);
            }
        }
        printPlanetCount(uniquePlanets, counters);

        System.out.println(planets2for(planets));
    }


    private static void printPlanetCount(List<String> planets, List<Integer> counts){
        for (int i = 0; i < planets.size(); i++) {
            System.out.printf("%-10s : %3d%n", planets.get(i), counts.get(i));
        }
    }



    //МЕТОД ПО ПРОЩЕ

    public static String planets2for(List<String> planets) {
        StringBuilder builder = new StringBuilder();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < planets.size(); i++) {
            if (!result.contains(planets.get(i))){
                result.add(planets.get(i));
                int counter = 0;
                for (int j = 0; j < planets.size(); j++) {
                    if (planets.get(j).equals(planets.get(i))) counter++;
                }
                builder.append(planets.get(i)).append(" : ").append(counter).append(", ");
            }
        }
        //System.out.println(builder);
        return builder.toString();
    }

}
