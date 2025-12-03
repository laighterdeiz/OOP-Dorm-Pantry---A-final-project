import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;

public class Pantry {
    private List<PantryItem> items = new ArrayList<>();
    private LocalDate lastAccessed; // track last access of pantry

    public Pantry() {
        lastAccessed = LocalDate.now();
    }

    public void addItem(PantryItem item) {
        items.add(item);
        System.out.println("Item added: " + item.getName());
    }

    public boolean removeItem(String name) {
        Iterator<PantryItem> it = items.iterator();
        boolean removed = false;
        while (it.hasNext()) {
            PantryItem p = it.next();
            if (p.getName().equalsIgnoreCase(name)) {
                it.remove();
                removed = true;
            }
        }
        return removed;
    }

    public void updateItems() {
        for (PantryItem item : items) {
            item.updateExpiration(lastAccessed);
        }
        lastAccessed = LocalDate.now();
    }

    public void showAllItems() {
        updateItems();
        if (items.isEmpty()) {
            System.out.println("Pantry is empty.");
            return;
        }
        System.out.println("All items in pantry:");
        for (PantryItem item : items) {
            System.out.println(item);
        }
    }

    public void showExpiringSoon() {
        updateItems();
        boolean found = false;
        System.out.println("Items expiring within 5 days or already expired:");
        for (PantryItem item : items) {
            if (item.isExpiringSoon()) {
                System.out.println(item);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items are expiring soon.");
        }
    }

    public boolean containsItem(String name) {
        return items.stream().anyMatch(i -> i.getName().equalsIgnoreCase(name));
    }

    // Analytics: percentage ng mga categories
    public void showAnalytics() {
        updateItems();
        if (items.isEmpty()) {
            System.out.println("Pantry is empty. No analytics to show.");
            return;
        }
        Map<String, Integer> counts = new HashMap<>();
        for (PantryItem item : items) {
            counts.put(item.getCategory(), counts.getOrDefault(item.getCategory(), 0) + 1);
        }

        System.out.println("\n===== Pantry Analytics =====");
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            double percentage = ((double) entry.getValue() / items.size()) * 100;
            System.out.printf("%s: %d items (%.2f%%)\n", entry.getKey(), entry.getValue(), percentage);
        }
    }
}
