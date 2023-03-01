package codility;


import java.math.BigDecimal;
import java.text.CollationElementIterator;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SoldProduct{
    String name;
    BigDecimal price;
    String currency;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
interface ExchangeService {
    Optional<BigDecimal> rate(String currency);
}

class SimpleSoldProduct{
    String name;
    BigDecimal price;

    public SimpleSoldProduct(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

class SoldProductsAggregate{
    List<SimpleSoldProduct> products;
    BigDecimal total;

    public SoldProductsAggregate(List<SimpleSoldProduct> emptyList, BigDecimal zero) {
        this.products = emptyList;
        this.total = zero;
    }
}

public class SoldProductsAggregator {
    private final ExchangeService exchangeService;

    public SoldProductsAggregator(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    public SoldProductsAggregate aggregate(Stream<SoldProduct> products) {

        if(products == null){
            return new SoldProductsAggregate(Collections.emptyList(), BigDecimal.ZERO);
        }
        List<SimpleSoldProduct> simpleSoldProducts = products
                .map(soldProduct -> {
                    Optional<BigDecimal> rate = exchangeService.rate(soldProduct.getCurrency());
                    if (rate.isPresent() && rate.get().compareTo(BigDecimal.ZERO) > 0) {
                        return new SimpleSoldProduct(
                                soldProduct.getName(),
                                soldProduct.getPrice().multiply(rate.get())
                        );
                    } else {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        BigDecimal total = simpleSoldProducts.stream()
                .map(SimpleSoldProduct::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new SoldProductsAggregate(simpleSoldProducts, total);

    }