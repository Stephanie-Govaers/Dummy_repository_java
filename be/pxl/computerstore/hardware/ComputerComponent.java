package be.pxl.computerstore.hardware;

public abstract class ComputerComponent {
    private String vendor;
    private String name;
    private double price;
    private String articleNumber;
    private static int counter = 0;

    {
        counter++;
    }

    public ComputerComponent(String vendor, String name, double price) {
        this.vendor = vendor;
        this.name = name;
        this.price = price;
        generateArticleNumber();
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    private void generateArticleNumber() {
        StringBuilder articleNumberBuilder = new StringBuilder();
        articleNumberBuilder.append(generateVendorCode());
        articleNumberBuilder.append("-");
        articleNumberBuilder.append(String.format("%05d", counter));
        this.articleNumber = articleNumberBuilder.toString();
    }

    private String generateVendorCode() {
        if (vendor != null && vendor.length() >= 3) {
            return vendor.substring(0, 3).toUpperCase();
        } else {
            return String.format("%-3s", vendor).replace(' ', 'X')
                    .toUpperCase();
        }
    }

    @Override
    public String toString() {
        return name + " (" + articleNumber + ")";
    }

    public String getFullDescription() {
        StringBuilder description = new StringBuilder();
        description.append("ArticleNumber = ").append(articleNumber).append("\n");
        description.append("Vendor = ").append(vendor).append("\n");
        description.append("Name = ").append(name).append("\n");
        description.append("Price = ").append(price).append("\n");
        return description.toString();
    }
}
