abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }
    public abstract int getLoanDuration();
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
}
class Book extends LibraryItem {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    public int getLoanDuration() {
        return 14;
    }
}
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    public int getLoanDuration() {
        return 7;
    }
}
class DVD extends LibraryItem {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    public int getLoanDuration() {
        return 5;
    }
}
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}
class BookReservable extends Book implements Reservable {
    private boolean available;
    public BookReservable(String itemId, String title, String author, boolean available) {
        super(itemId, title, author);
        this.available = available;
    }
    public void reserveItem() {
        if (available) {
            System.out.println("Book reserved.");
            available = false;
        } else {
            System.out.println("Book is not available.");
        }
    }
    public boolean checkAvailability() {
        return available;
    }
}
class LibraryManagement {
    public static void main(String[] args) {
        LibraryItem book = new BookReservable("B001", "Java Programming", "John Smith", true);
        LibraryItem magazine = new Magazine("M001", "Tech Today", "Jane Doe");
        LibraryItem dvd = new DVD("D001", "Inception", "Christopher Nolan");
        LibraryItem[] items = { book, magazine, dvd };
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                reservableItem.reserveItem();
                System.out.println("Available: " + reservableItem.checkAvailability());
            }
            System.out.println();
        }
    }
}
