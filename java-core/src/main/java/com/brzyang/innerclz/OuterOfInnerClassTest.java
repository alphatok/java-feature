package com.brzyang.innerclz;

import java.util.Set;

public class OuterOfInnerClassTest {
    public Set<Integer>  m;

    @Override
    public String toString() {
        return "OuterOfInnerClassTest{" +
                "m=" + m +
                '}';
    }

    public static final class InnerOfInnerClassTest {
        private Integer val;

        @Override
        public String toString() {
            return "InnerOfInnerClassTest{" +
                    "val=" + val +
                    '}';
        }
    }
}
