package kr.codesqaud.cafe.Repository;

import kr.codesqaud.cafe.domain.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private final Map<String, User> store = new HashMap<>();

    public User save(User user) {
        store.put(user.getId(), user);
        return user;
    }

    public Optional<User> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    public Optional<User> findByEmail(String email) {
        return store.values().stream().filter(user -> user.getEmail().equals(email)).findAny();
    }

    public List<User> findAllUser() {
        return new ArrayList<>(store.values());
    }



}
