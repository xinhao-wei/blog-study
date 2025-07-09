package com.wei.basic.clone;

import java.io.*;
 
class Address implements Serializable {
    public Address(String city) {
        this.city = city;
    }

    private static final long serialVersionUID = 1L;
    String city;
}
 
class User implements Serializable {
    public User(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    private static final long serialVersionUID = 1L;
    int id;
    String name;
    Address address;
}
 
public class DeepCopyBySerialization {
    public static Object deepCopy(Object obj) throws Exception {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(obj);

            try (ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
                 ObjectInputStream ois = new ObjectInputStream(bis)) {
                return ois.readObject();
            }
        }

    }
 
    public static void main(String[] args) throws Exception {
        User u1 = new User(1, "Alice", new Address("Beijing"));
        User u2 = (User) deepCopy(u1);
        
        u2.address.city = "Shanghai";
        System.out.println(u1.address.city);  // 输出Beijing，完全独立
    }
}