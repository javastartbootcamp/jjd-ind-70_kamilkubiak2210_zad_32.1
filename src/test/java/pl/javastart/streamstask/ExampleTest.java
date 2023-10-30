package pl.javastart.streamstask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

public class ExampleTest {

    @Test

    public void shouldReturnAllWomen() {
        //given
        StreamsTask streamsTask = new StreamsTask();
        List<User> users = new ArrayList<>();

        users.add(new User(1L, "Alicja", 20));
        users.add(new User(2L, "Dominik", 15));
        users.add(new User(3L, "Patrycja", 25));
        users.add(new User(4L, "Marcin", 30));
        users.add(new User(5L, "Tomek", 18));
        users.add(new User(6L, "Damian", 26));

        //when
        Collection<User> women = streamsTask.findWomen(users);
        List<User> womenAssert = new ArrayList<>();
        womenAssert.add(new User(1L, "Alicja", 20));
        womenAssert.add(new User(3L, "Patrycja", 25));

        //then
        Assertions.assertEquals(womenAssert, women);

    }

    @Test
    public void shouldReturnAverageMenAge() {
        //given
        StreamsTask streamsTask = new StreamsTask();
        List<User> users = new ArrayList<>();

        users.add(new User(1L, "Alicja", 20));
        users.add(new User(2L, "Dominik", 15));
        users.add(new User(3L, "Patrycja", 25));
        users.add(new User(4L, "Marcin", 30));
        users.add(new User(5L, "Tomek", 18));
        users.add(new User(6L, "Damian", 26));

        //when
        Double averageMenAge = streamsTask.averageMenAge(users);

        //then
        Assertions.assertEquals(22.25, averageMenAge);

    }

    @Test
    public void shouldReturnGroupExpensesByUserId() {
        //given
        StreamsTask streamsTask = new StreamsTask();
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Alicja", 20));
        users.add(new User(2L, "Dominik", 15));
        users.add(new User(3L, "Patrycja", 25));
        users.add(new User(4L, "Marcin", 30));
        users.add(new User(5L, "Tomek", 18));
        users.add(new User(6L, "Damian", 26));
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense(1L, "Buty", new BigDecimal("149.99"), ExpenseType.WEAR));
        expenses.add(new Expense(1L, "Sałatka", new BigDecimal("14.99"), ExpenseType.FOOD));
        expenses.add(new Expense(2L, "Bluza", new BigDecimal("100"), ExpenseType.WEAR));
        expenses.add(new Expense(2L, "Skarpetki", new BigDecimal("39"), ExpenseType.WEAR));
        expenses.add(new Expense(2L, "Pizza", new BigDecimal("25"), ExpenseType.FOOD));

        //when
        Map<Long, List<Expense>> groupExpensesByUserId = streamsTask.groupExpensesByUserId(users, expenses);
        Map<Long, List<Expense>> groupExpensesByUserIdAssert = new HashMap<>();
        groupExpensesByUserIdAssert.put(1L,
                List.of(new Expense(1L, "Buty", new BigDecimal("149.99"), ExpenseType.WEAR),
                        new Expense(1L, "Sałatka", new BigDecimal("14.99"), ExpenseType.FOOD)));
        groupExpensesByUserIdAssert.put(2L,
                List.of(new Expense(2L, "Bluza", new BigDecimal("100"), ExpenseType.WEAR)
                        , new Expense(2L, "Skarpetki", new BigDecimal("39")
                                , ExpenseType.WEAR), new Expense(2L, "Pizza", new BigDecimal("25"), ExpenseType.FOOD)));

        //then
        Assertions.assertEquals(groupExpensesByUserIdAssert, groupExpensesByUserId);

    }

    @Test
    public void shouldReturnGroupExpensesByUser() {
        //given
        StreamsTask streamsTask = new StreamsTask();
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Alicja", 20));
        users.add(new User(2L, "Dominik", 15));
        users.add(new User(3L, "Patrycja", 25));
        users.add(new User(4L, "Marcin", 30));
        users.add(new User(5L, "Tomek", 18));
        users.add(new User(6L, "Damian", 26));
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense(1L, "Buty", new BigDecimal("149.99"), ExpenseType.WEAR));
        expenses.add(new Expense(1L, "Sałatka", new BigDecimal("14.99"), ExpenseType.FOOD));
        expenses.add(new Expense(2L, "Bluza", new BigDecimal("100"), ExpenseType.WEAR));
        expenses.add(new Expense(2L, "Skarpetki", new BigDecimal("39"), ExpenseType.WEAR));
        expenses.add(new Expense(2L, "Pizza", new BigDecimal("25"), ExpenseType.FOOD));

        //when
        Map<User, List<Expense>> groupExpensesByUser = streamsTask.groupExpensesByUser(users, expenses);
        Map<User, List<Expense>> groupExpensesByUserAssert = new HashMap<>();
        groupExpensesByUserAssert.put(new User(1L, "Alicja", 20),
                List.of(new Expense(1L, "Buty", new BigDecimal("149.99"), ExpenseType.WEAR),
                        new Expense(1L, "Sałatka", new BigDecimal("14.99"), ExpenseType.FOOD)));
        groupExpensesByUserAssert.put(new User(2L, "Dominik", 15),
                List.of(new Expense(2L, "Bluza", new BigDecimal("100"), ExpenseType.WEAR),
                        new Expense(2L, "Skarpetki", new BigDecimal("39"), ExpenseType.WEAR),
                        new Expense(2L, "Pizza", new BigDecimal("25"), ExpenseType.FOOD)));

        //then
        Assertions.assertEquals(groupExpensesByUserAssert, groupExpensesByUser);

    }
}
