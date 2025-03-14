package example.kiosk;

public enum UserType {
    NATIONAL_PERSON(0.10), // 국가유공자 10% 할인
    SOLDIER(0.05), // 군인 5% 할인
    STUDENT(0.03),  // 학생 3% 할인
    GENERAL(0.00);  // 일반 0% 할인

    private final double discountRate;
    UserType(double discountRate) {
        this.discountRate = discountRate;
    }
    public double getDiscountRate() {
        return discountRate;
    }
}

