package pl.javastart.streamstask;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsTask {

    // metoda powinna zwracać listę kobiet (sprawdzając, czy imię kończy się na "a")
    Collection<User> findWomen(Collection<User> users) {
        return users.stream().filter(user -> user.getName().endsWith("a")).toList();
    }

    // metoda powinna zwracać średni wiek mężczyzn (sprawdzając, czy imię nie kończy się na "a")
    Double averageMenAge(Collection<User> users) {
        return users.stream().filter(user -> !user.getName().endsWith("a")).mapToDouble(User::getAge).average().orElse(0.0);
    }

    // metoda powinna zwracać wydatki zgrupowane po ID użytkownika
    Map<Long, List<Expense>> groupExpensesByUserId(Collection<User> users, List<Expense> expenses) {
        return expenses.stream().collect(Collectors.groupingBy(Expense::getUserId));
    }

    // metoda powinna zwracać wydatki zgrupowane po użytkowniku
    // podobne do poprzedniego, ale trochę trudniejsze
    Map<User, List<Expense>> groupExpensesByUser(Collection<User> users, List<Expense> expenses) {
        Map<Long, List<Expense>> groupExpensesByUserId = groupExpensesByUserId(users, expenses);

        return users.stream().collect(
                Collectors.toMap(Function.identity(),
                        user -> groupExpensesByUserId.getOrDefault(user.getId(), Collections.emptyList())));
    }
}