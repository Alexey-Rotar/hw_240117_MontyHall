import java.lang.Math;
import java.util.Map;
import java.util.HashMap;

public class MontyHall
{
    public static void main(String[] args) {
        int DRAWS_COUNT = 1000;
        int winDoor, firstChoice, secondChoice = 0, openedDoor = 0, wins = 0;
        Map <Integer, Boolean> result = new HashMap<>();
        for (int i = 1; i < DRAWS_COUNT; i++){
            // случайное определение  выигрышной двери
            winDoor = (int) (Math.random() * 3) + 1;
            // случайный первый выбор
            firstChoice = (int) (Math.random() * 3) + 1;
            // открывается дверь, не совпадающая с выигрышной и выбранной
            do { openedDoor ++; }
            while(openedDoor == winDoor || openedDoor == firstChoice);
            // второй выбор, не совпадающий с первым выбором и уже открытой дверью
            do { secondChoice ++; }
            while(secondChoice == firstChoice || secondChoice == openedDoor);
            // занесение текущего результата
            if (secondChoice == winDoor) {
                result.put(i, true);
            } else {
                result.put(i, false);
            }
            openedDoor = 0;
            secondChoice = 0;
        }
        for (int i = 1; i <= result.size(); i++){
            if (result.get(i))
                wins++;
        }
        System.out.printf("Всего розыгрышей: %s", DRAWS_COUNT);
        System.out.printf("\nВыигрышей: %.1f%%", (float)wins/DRAWS_COUNT*100);
        System.out.printf("\nПроигрышей: %.1f%%", 100-(float)wins/DRAWS_COUNT*100);
    }
}
