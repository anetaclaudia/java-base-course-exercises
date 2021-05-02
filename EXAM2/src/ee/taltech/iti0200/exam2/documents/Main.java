package ee.taltech.iti0200.exam2.documents;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Archive archive = new Archive();
        List<Person> people = Arrays.asList(
                new Person("Chris", "Evans", 36), // 0
                new Person("Robert", "Downey Jr.", 53), // 1
                new Person("Chris", "Hemsworth", 34), // 2
                new Person("Tom", "Holland", 21), // 3
                new Person("Scarlett", "Johansson", 33), // 4
                new Person("Stan", "Lee", 95), // 5
                new Person("Some", "Child", 12)); // 6

//        System.out.println("Initial values:");
//        System.out.println("All of them have active licence: (all should be true)");
//        people.forEach(person -> System.out.print(person.isLicenceActive() + " "));
//        System.out.println();
//        System.out.println("Should be empty: " + archive.getDocuments()); // []

        Document document0 = new Document(1, people.get(1), "contract for the purchase of an apartment...");
        System.out.println("\n\nAdding document to archive:");
        System.out.print("Document is not signed, should be false: ");
        System.out.println(archive.addDocument(document0));

        System.out.println("\n\nSigning document:");
        System.out.println("A child cannot sign a document, because he/she is not 18 yo:");
        System.out.print("Should be false: ");
        System.out.println(document0.sign(people.get(6)));

        System.out.println("\n\nRobert Downey Jr. cannot sign the document, because he is the owner:");
        System.out.print("Should be false: ");
        System.out.println(document0.sign(people.get(1)));

        System.out.println("\n\nScarlett Johansson can sign the document:");
        System.out.print("Should be true: ");
        System.out.println(document0.sign(people.get(4)));

        Optional<Person> document0SignerOptional = document0.getSigner();
        if (document0SignerOptional.isPresent()) {
            Person signer = document0SignerOptional.get();
            System.out.printf("Should be Scarlett Johansson: %s %s%n", signer.getFirstName(), signer.getSecondName());
        } else {
            System.out.println("WRONG! Document is signed, but no signer found!!");
        }

        System.out.println("\n\nNobody can sign this document now, because it is already signed:");
        System.out.println("Should be false 7 times: ");
        people.forEach(person -> System.out.print(document0.sign(person) + " "));
        System.out.println();

        System.out.println("\n\nAdding signed document to archive: ");
        System.out.print("Should be true: ");
        System.out.println(archive.addDocument(document0));

        System.out.println("archive.getDocuments() should contain 1 element: " + archive.getDocuments());

        Document document1 = new Document(1, people.get(2), "fail");
        document1.sign(people.get(3));

        System.out.println("\n\nAdding signed document with existing id should fail:");
        System.out.print("Should be false: ");
        System.out.println(archive.addDocument(document1));

        List<Document> documentList = Arrays.asList(
                new Document(20, people.get(0), "Some content here"),
                new Document(21, people.get(5), "Some content there"),
                new Document(22, people.get(1), "Some content nowhere"),
                new Document(23, people.get(6), "Some content everywhere"));

        documentList.forEach(document -> document.sign(people.get(2))); // all true

        documentList.forEach(archive::addDocument);

        System.out.print("\n\nShould be 5: ");
        System.out.println(archive.getDocuments().size());

        System.out.println("\n\nSearching document by id:");
        System.out.println("No document with id 200:");
        System.out.print("Should be false: ");
        System.out.println(archive.getDocumentById(200).isPresent());

        System.out.println("\n\nSearching document with id 21, which is in archive:");
        System.out.print("Should be true: ");
        System.out.println(archive.getDocumentById(21).isPresent());

        System.out.println("\n\nGetting documents by author:");
        System.out.println("Should be documents with ids 1 and 22:");
        System.out.println("(Override toString to see more details)");
        archive.getDocumentsByOwner(people.get(1))
                .forEach(System.out::println);

        System.out.println("\n\nGetting documents by signer:");
        System.out.println("Should be documents with ids 20-23:");
        archive.getDocumentsBySigner(people.get(2))
                .forEach(System.out::println);

        System.out.println("\n\nSearching documents by content:");
        System.out.println("There are no documents with content which contains 'apache'");
        System.out.print("Should be 0:");
        System.out.println(archive.getDocumentsWithSimilarContent("apache").size());

        System.out.print("\n\nShould be 0, because search is case-sensitive: ");
        System.out.println(archive.getDocumentsWithSimilarContent("Content").size());

        System.out.println("\n\nShould be documents with ids 20-23:");
        archive.getDocumentsWithSimilarContent("content")
                .forEach(System.out::println);
    }
}
