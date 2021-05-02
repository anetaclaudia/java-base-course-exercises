package ee.taltech.iti0200.exam2.documents;

import java.util.Optional;

public class Document {
    public static final int ADULT_AGE = 18;
    private int id;
    private Person owner;
    private String content;
    private Person signer;
    private boolean isSigned = false;

    public Document(int id, Person owner, String content) {
        this.id = id;
        this.owner = owner;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public Person getOwner() {
        return owner;
    }

    public String getContent() {
        return content;
    }

    public boolean sign(Person signer) {
        if (signer.getAge() >= ADULT_AGE
                && signer.isLicenceActive()
                && !signer.equals(this.owner)
                && !isSigned) {
            this.isSigned = true;
            this.signer = signer;
            return true;
        } else {
            return false;
        }
    }

    public Optional<Person> getSigner() {
        if (this.signer != null) {
            return Optional.of(signer);
        }
        return Optional.empty();
    }

}
