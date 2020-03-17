import java.io.*;
import java.util.logging.Logger;

public class SerializableTest implements java.io.Serializable {

    private static final long serialVersionUID = 8190135642996084478L;
    private static final String fileName = "Serializable.ser";
    private static final Logger logger = Logger.getLogger("");
    private static String var;
    transient private String tran = "this is a transient instance field";
    private int number;
    private Thread th;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        if (args[0].startsWith("ser")) {
            SerializableTest test = new SerializableTest();
            test.number = 1;
            var = "this is a static variable";
            writeOut(test);
            System.out.println("SerializableTest to be saved: = " + test);
        } else if (args[0].startsWith("deser")) {
            System.out.println("SerializableTest deserialized: = " + readIn());
        }

    }

    private static Object readIn() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(fileName)));
        return ois.readObject();
    }

    private static void writeOut(java.io.Serializable obj) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
        oos.writeObject(obj);
        oos.close();
    }

    @Override
    public String toString() {
        return "SerializableTest: final static fileName=" + fileName + ", final static logger=" + logger
                + ", non-final static var=" + var + ", instance number=" + number
                + ", transient instance tran=" + tran + ", non-serializable instance field:=" + th;
    }

}
