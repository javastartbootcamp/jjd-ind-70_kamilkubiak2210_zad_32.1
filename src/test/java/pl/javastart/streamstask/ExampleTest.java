package pl.javastart.streamstask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

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
    public void shouldReturnAverageMenAgeOrElseZero() {
        //given
        StreamsTask streamsTask = new StreamsTask();
        List<User> users = new ArrayList<>();

        users.add(new User(1L, "Alicja", 20));
        users.add(new User(2L, "Hanna", 15));
        users.add(new User(3L, "Patrycja", 25));
        users.add(new User(4L, "Kamila", 30));
        users.add(new User(5L, "Bogusława", 18));
        users.add(new User(6L, "Marianna", 26));

        //when
        Double averageMenAge = streamsTask.averageMenAge(users);

        //then
        Assertions.assertEquals(0.0, averageMenAge);

    }

    @Test
    public void shouldReturnAverageMenAge2() {
        //given
        StreamsTask streamsTask = new StreamsTask();
        List<User> users = new ArrayList<>();

        users.add(new User(1L, "Alicja", 20));
        users.add(new User(2L, "Dominik", 30));
        users.add(new User(3L, "Patrycja", 25));
        users.add(new User(4L, "Marcin", 38));
        users.add(new User(5L, "Tomek", 25));
        users.add(new User(6L, "Damian", 12));

        //when
        Double averageMenAge = streamsTask.averageMenAge(users);

        //then
        Assertions.assertEquals(26.25, averageMenAge);

    }

    @Test
    public void shouldReturnGroupExpensesByUserId() {
        //given
        StreamsTask streamsTask = new StreamsTask();
        List<User> users = new ArrayList<>();
        User alicja = new User(1L, "Alicja", 20);
        users.add(alicja);
        User dominik = new User(2L, "Dominik", 15);
        users.add(dominik);
        users.add(new User(3L, "Patrycja", 25));
        users.add(new User(4L, "Marcin", 30));
        users.add(new User(5L, "Tomek", 18));
        users.add(new User(6L, "Damian", 26));
        List<Expense> expenses = new ArrayList<>();
        Expense buty = new Expense(1L, "Buty", new BigDecimal("149.99"), ExpenseType.WEAR);
        expenses.add(buty);
        Expense sałatka = new Expense(1L, "Sałatka", new BigDecimal("14.99"), ExpenseType.FOOD);
        expenses.add(sałatka);
        Expense bluza = new Expense(2L, "Bluza", new BigDecimal("100"), ExpenseType.WEAR);
        expenses.add(bluza);
        Expense skarpetki = new Expense(2L, "Skarpetki", new BigDecimal("39"), ExpenseType.WEAR);
        expenses.add(skarpetki);
        Expense pizza = new Expense(2L, "Pizza", new BigDecimal("25"), ExpenseType.FOOD);
        expenses.add(pizza);

        //when
        Map<Long, List<Expense>> groupExpensesByUserId = streamsTask.groupExpensesByUserId(users, expenses);
        Map<Long, List<Expense>> groupExpensesByUserIdAssert = new HashMap<>();
        groupExpensesByUserIdAssert.put(1L, List.of(buty, sałatka));
        groupExpensesByUserIdAssert.put(2L, List.of(bluza, skarpetki, pizza));

        //then
        assertThat(groupExpensesByUserId.size()).isEqualTo(2);
        assertThat(groupExpensesByUserId.get(alicja.getId())).isEqualTo(groupExpensesByUserIdAssert.get(alicja.getId()));
        assertThat(groupExpensesByUserId.get(dominik.getId())).isEqualTo(groupExpensesByUserIdAssert.get(dominik.getId()));

    }

    @Test
    public void shouldReturnGroupExpensesByUser() {
        //given
        StreamsTask streamsTask = new StreamsTask();
        List<User> users = new ArrayList<>();
        User alicja = new User(1L, "Alicja", 20);
        users.add(alicja);
        User dominik = new User(2L, "Dominik", 15);
        users.add(dominik);
        users.add(new User(3L, "Patrycja", 25));
        users.add(new User(4L, "Marcin", 30));
        users.add(new User(5L, "Tomek", 18));
        users.add(new User(6L, "Damian", 26));
        List<Expense> expenses = new ArrayList<>();
        Expense buty = new Expense(1L, "Buty", new BigDecimal("149.99"), ExpenseType.WEAR);
        expenses.add(buty);
        Expense sałatka = new Expense(1L, "Sałatka", new BigDecimal("14.99"), ExpenseType.FOOD);
        expenses.add(sałatka);
        Expense bluza = new Expense(2L, "Bluza", new BigDecimal("100"), ExpenseType.WEAR);
        expenses.add(bluza);
        Expense skarpetki = new Expense(2L, "Skarpetki", new BigDecimal("39"), ExpenseType.WEAR);
        expenses.add(skarpetki);
        Expense pizza = new Expense(2L, "Pizza", new BigDecimal("25"), ExpenseType.FOOD);
        expenses.add(pizza);

        //when
        Map<User, List<Expense>> groupExpensesByUser = streamsTask.groupExpensesByUser(users, expenses);
        Map<User, List<Expense>> groupExpensesByUserAssert = new HashMap<>();
        groupExpensesByUserAssert.put(alicja, List.of(buty, sałatka));
        groupExpensesByUserAssert.put(dominik, List.of(bluza, skarpetki, pizza));

        //then
        assertThat(groupExpensesByUser.size()).isEqualTo(6);
        assertThat(groupExpensesByUser.get(alicja)).isEqualTo(groupExpensesByUserAssert.get(alicja));
        assertThat(groupExpensesByUser.get(dominik)).isEqualTo(groupExpensesByUserAssert.get(dominik));

    }
}
