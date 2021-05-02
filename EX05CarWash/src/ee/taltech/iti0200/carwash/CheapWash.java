package ee.taltech.iti0200.carwash;

public class CheapWash extends WashStrategy {
    static final int SESSION_PRICE = 10;
    static final int SESSION_DURATION = 10;
    static final int WASH_FACTOR = 40;
    static final int DRY_DURATION = 1;
    static final int DRY_PRICE = 2;

    @Override
    public void wash(Car car, CarOwner owner) {
        setSessionDuration(SESSION_DURATION);
        setSessionPrice(SESSION_PRICE);
        if ((car.getDirtiness() - WASH_FACTOR) < 0) {
            car.setDirtiness(0);
        } else {
            car.setDirtiness(car.getDirtiness() - WASH_FACTOR);
        }
    }

    @Override
    public void dry(Car car, CarOwner owner) {
        setSessionDuration(SESSION_DURATION + DRY_DURATION);
        setSessionPrice(SESSION_PRICE + DRY_PRICE);
    }

    @Override
    public int getWashAndDryPrice() {
        //setSessionPrice(getSessionPrice() + DRY_PRICE);
        return SESSION_PRICE + DRY_PRICE;
    }

    @Override
    public int getWashPrice() {
        return SESSION_PRICE;
    }
}
