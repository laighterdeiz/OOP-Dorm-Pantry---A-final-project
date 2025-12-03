import java.time.LocalDate;

public class CannedItem extends PantryItem {
    public CannedItem(String name, LocalDate expirationDate) {
        super(name, expirationDate);
    }

    @Override
    public String getCategory() {
        return "Canned";
    }
}
