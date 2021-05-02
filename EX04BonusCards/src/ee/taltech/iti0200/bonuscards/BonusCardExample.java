//package ee.taltech.iti0200.bonuscards;
//
//import ee.taltech.iti0200.bonuscards.cards.BonusCard;
//
//import java.math.BigDecimal;
//import java.util.Optional;
//
//public class BonusCardExample {
//    public static void main(String[] args) {
//
//        Store coop = new Store("Coop");
//        Store rimi = new Store("Rimi");
//
//        Person kalle = new Person(
//                "Kalle",
//                "Kuusk",
//                17,
//                Person.Gender.MALE
//        );
//
//        Person malle = new Person(
//                "Malle",
//                "Mänd",
//                15,
//                Person.Gender.MALE
//        );
//
//        BonusCard kalleCoopBonusCard = BonusCard.createCard(BonusCard.CardType.COOP, coop, kalle);
//        BonusCard malleRimiBonusCard = BonusCard.createCard(BonusCard.CardType.COOP, coop, malle);
//        malle.addBonusCard(malleRimiBonusCard);
//        //kalleCoopBonusCard.useBonus(BigDecimal.valueOf(10));
//
////        System.out.println(kalleCoopBonusCard.getBonusBalance());  // 10
////        System.out.println(malleRimiBonusCard.getBonusBalance());  // 10
//
//        kalleCoopBonusCard.collectBonus(100);
//        malleRimiBonusCard.collectBonus(50);
//        Optional<Person> x = coop.getCustomerWithLowestBonusBalanceYoungerThan(BonusCard.CardType.COOP, 18);
//
//
//        System.out.println(kalleCoopBonusCard.getBonusBalance());  // 15.000
//        System.out.println(malleRimiBonusCard.getBonusBalance());  // 1.000
//
//        System.out.println(coop.getTotalBonuses(BonusCard.CardType.COOP));
//        System.out.println(coop.getAverageBonus(BonusCard.CardType.COOP));
//
//        System.out.println(kalleCoopBonusCard.useBonus(BigDecimal.valueOf(10)));
//        //malleRimiBonusCard.useBonus(BigDecimal.valueOf(1000000));  // BonusException
//
//        System.out.println(kalleCoopBonusCard.getBonusBalance());  // 5.000
//        System.out.println(malleRimiBonusCard.getBonusBalance());  // 1.000
//
//    }
//}
