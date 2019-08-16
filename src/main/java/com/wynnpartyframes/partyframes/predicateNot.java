package com.wynnpartyframes.partyframes;

import java.util.function.Predicate;

public class predicateNot {
    public static <R> Predicate<R> not(Predicate<R> predicate) {
        return predicate.negate();
    }
}
