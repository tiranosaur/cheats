package org.example;

import lombok.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String>list = new ArrayList<String>();
        System.out.println(list.size());
        System.out.println(list.);
    }
}

@AllArgsConstructor
@ToString
class First {
    private String firstName;
    @ToString.Exclude
    private String lastName;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}


