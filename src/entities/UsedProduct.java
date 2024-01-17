package entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class UsedProduct extends Product{
    static SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
    private LocalDate manufactureDate;

    public UsedProduct(){
        super();
    }

    public UsedProduct(String name, Double price, LocalDate manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
    @Override
    public String priceTag(){
        return getName() + " (used) $ " + getPrice()+ " (Manufacture date: " + getManufactureDate() + " )";
    }

}
