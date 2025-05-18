package work_with_files;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryDataIOExample {
  /**
   * Main method of the class. It writes and reads binary data to/from a file.
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    try (DataOutputStream dos =
             new DataOutputStream(new FileOutputStream("work_with_files/FileForTest.bin"));
         DataInputStream dis =
             new DataInputStream(new FileInputStream("work_with_files/FileForTest.bin"))) {
      // Writing binary data to the file
      dos.writeBoolean(true);
      dos.writeByte(127);
      dos.writeChar('A');
      dos.writeDouble(3.14);
      dos.writeFloat(3.14f);
      dos.writeInt(123456789);
      dos.writeLong(1234567890123456789L);
      dos.writeShort(12345);
      dos.writeUTF("Hello, World!");

      // Reading binary data from the file and printing it
      System.out.println(dis.readBoolean());
      System.out.println(dis.readByte());
      System.out.println(dis.readChar());
      System.out.println(dis.readDouble());
      System.out.println(dis.readFloat());
      System.out.println(dis.readInt());
      System.out.println(dis.readLong());
      System.out.println(dis.readShort());
      System.out.println(dis.readUTF());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
