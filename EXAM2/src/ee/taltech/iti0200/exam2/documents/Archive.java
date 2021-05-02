package ee.taltech.iti0200.exam2.documents;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Archive {
    List<Document> documents = new ArrayList<>();

    public Archive() {
    }

    public boolean addDocument(Document document) {
        if (!(getDocuments().contains(document) || this.getDocumentById(document.getId()).isPresent())
                && document.getSigner().isPresent()) {
            documents.add(document);
            return true;
        }
        return false;
    }

    public List<Document> getDocumentsByOwner(Person person) {
        return documents.stream()
                .filter(document -> document.getOwner().equals(person))
                .collect(Collectors.toList());
    }

    public List<Document> getDocumentsBySigner(Person signer) {
        return documents.stream()
                .filter(document -> document.getSigner().get().equals(signer))
                .collect(Collectors.toList());
    }

    public Optional<Document> getDocumentById(int id) {
        return documents.stream()
                .filter(document -> document.getId() == id).findFirst();
    }

    public List<Document> getDocumentsWithSimilarContent(String stringToLookFor) {
        return documents.stream().filter(document -> document.getContent().contains(stringToLookFor))
                .collect(Collectors.toList());
    }

    public List<Document> getDocuments() {
        return documents;
    }

}
