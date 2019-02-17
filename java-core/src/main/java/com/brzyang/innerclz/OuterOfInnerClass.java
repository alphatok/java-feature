package com.brzyang.innerclz;

import java.util.Set;

public class OuterOfInnerClass {
    public Set<Integer>  m;

    @Override
    public String toString() {
        return "OuterOfInnerClass{" +
                "m=" + m +
                '}';
    }

    public static final class InnerOfInnerClass {
        private Integer val;

        @Override
        public String toString() {
            return "InnerOfInnerClass{" +
                    "val=" + val +
                    '}';
        }
    }
}
