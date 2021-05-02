package ee.taltech.iti0200.warehouses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class WorkerTest {
    Worker worker;
    Worker anotherWorker;

    @BeforeEach
    void setWorker() {
        worker = new Worker("Mari", "Mets", "1234567", 20);
        anotherWorker = new Worker("Mart", "Martinson", "123456", 28);
    }

    @Test
    void getWorkerSummary() {
        assert worker.getWorkerSummary().equals("Mari Mets, 20 (1234567)");
    }

    @Test
    void getFirstName() {
        assert worker.getFirstName().equals("Mari");
    }

    @Test
    void setFirstName() {
        worker.setFirstName("Martin");
        assert worker.getFirstName().equals("Martin");
    }

    @Test
    void getLastName() {
        assert worker.getLastName().equals("Mets");
    }

    @Test
    void setLastName() {
        worker.setLastName("Metskond");
        assert worker.getLastName().equals("Metskond");
    }

    @Test
    void getIdCode() {
        assert worker.getIdCode().equals("1234567");
    }

    @Test
    void setIdCode() {
        worker.setIdCode("12345678");
        assert worker.getIdCode().equals("12345678");
    }

    @Test
    void getAge() {
        assert worker.getAge().equals(20);
    }

    @Test
    void setAge() {
        worker.setAge(21);
        assert worker.getAge().equals(21);
    }

    @Test
    void equals() {
        assert !(worker.equals(anotherWorker) && anotherWorker.equals(worker));
    }

    @Test
    void testHashCode() {
        assert !(worker.hashCode() == anotherWorker.hashCode());
    }
}
