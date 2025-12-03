import java.time.LocalDate;

public class FrozenItem extends PantryItem {

    public FrozenItem(String name, LocalDate expirationDate) {
        super(name, expirationDate);
    }

    @Override
    public String getCategory() {
        return "Frozen Goods";
    }

    @Override
    public boolean isExpiringSoon() {
        // Frozen items expiring within 30 days considered "soon"
        return getExpirationDate().isBefore(LocalDate.now().plusDays(30));
    }
}
