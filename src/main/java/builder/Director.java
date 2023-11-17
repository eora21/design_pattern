package builder;

public class Director {
    private final Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public String construct() {
        builder.makeTitle("Greeting");
        builder.makeString("인사");
        builder.makeItems("How r u?", "Hello.", "Hi.");
        builder.makeString("시간대별 인사");
        builder.makeItems("아침인사", "점심인사", "저녁인사");
        return builder.close();
    }
}
