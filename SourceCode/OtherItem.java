import java.time.LocalDate;

public class OtherItem extends PantryItem {
    public OtherItem(String name, LocalDate expirationDate) {
        super(name, expirationDate);
    }

    @Override
    public String getCategory() {
        return "Other";
    }
}
