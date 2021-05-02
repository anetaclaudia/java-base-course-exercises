package ee.taltech.iti0200.carwash;

public class CarWashService {
    private WashStrategy washStrategy;

    public void setWashStrategy(WashStrategy washStrategy) {
        this.washStrategy = washStrategy;
    }

    public WashStrategy getWashStrategy() {
        return washStrategy;
    }

    /**
     * Using provided WashStrategy to wash the owners car.
     *
     * @return the boolean if wash was successful
     */
    public boolean wash(Car car, CarOwner owner) {
        if (washStrategy != null) {
            if (!(washStrategy.isClientBlacklisted(owner.getName()))) {
                if (owner.getBalance() >= washStrategy.getWashPrice()) {
                    washStrategy.wash(car, owner);
                    owner.setBalance(owner.getBalance() - washStrategy.getWashPrice());
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Using provided WashStrategy to wash and dry the owners car.
     *
     * @return the boolean if wash and dry was successful
     */
    public boolean washAndDry(Car car, CarOwner owner) {
        if (washStrategy != null) {
            if (!(washStrategy.isClientBlacklisted(owner.getName()))) {
                if (owner.getBalance() >= washStrategy.getWashAndDryPrice()) {
                    washStrategy.wash(car, owner);
                    washStrategy.dry(car, owner);
                    owner.setBalance(owner.getBalance() - washStrategy.getWashAndDryPrice());
                    return true;
                }
            }
        }
        return false;
    }

//    public static void main(String[] args) {
//        CarOwner kai = new CarOwner("Kai", 72000); // see loll luud ei saa autot pesta
//        Car audi = new Car(5);
//        CarOwner siim = new CarOwner("Siim", 1500);
//        Car honda = new Car(80);
//        CarOwner martin = new CarOwner("Martin", 0);
//        Car bmw = new Car(100);
//
//        CarWashService carWashService = new CarWashService();
//        PremiumWash premiumWash = new PremiumWash();
//        System.out.println(premiumWash.getWashAndDryPrice()); //70
//        RegularWash regularWash = new RegularWash();
//        System.out.println(regularWash.getWashAndDryPrice()); //35
//        CheapWash cheapWash = new CheapWash();
//        System.out.println(cheapWash.getWashAndDryPrice()); //12
//
////        System.out.println(carWashService.washAndDry(audi, kai));
////        carWashService.setWashStrategy(premiumWash);
////        System.out.println(carWashService.washAndDry(audi, kai));
////        //    carWashService.setWashStrategy(regularWash);
////        System.out.println(carWashService.wash(honda, siim));
////        System.out.println(carWashService.washAndDry(honda, siim));
////        //    carWashService.setWashStrategy(cheapWash);
////        System.out.println(carWashService.washAndDry(bmw, martin));
//    }

}
