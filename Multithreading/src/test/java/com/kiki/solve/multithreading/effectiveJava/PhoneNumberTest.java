package com.kiki.solve.multithreading.effectiveJava;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class PhoneNumberTest {
    @Test
    public void testReflexive() {
        PhoneNumber p1 = PhoneNumber.of(843, 6155882, "SOUTH CAROLINA");
        assertTrue(p1.equals(p1));
    }

    @Test
    public void testTransitive() {
        PhoneNumber x = PhoneNumber.of(843, 6155882, "SOUTH CAROLINA");
        PhoneNumber y = PhoneNumber.of(843, 6155882, "SOUTH CAROLINA");
        assertTrue(x.equals(y));
        assertTrue(y.equals(x));
    }

    @Test
    public void testSymmetrical() {
        PhoneNumber x = PhoneNumber.of(843, 6155882, "SOUTH CAROLINA");
        PhoneNumber y = PhoneNumber.of(843, 6155882, "SOUTH CAROLINA");
        PhoneNumber z = PhoneNumber.of(843, 6155882, "SOUTH CAROLINA");
        assertTrue(x.equals(y));
        assertTrue(y.equals(z));
        assertTrue(z.equals(x));
    }

    @Test
    public void testConsistent() {
        PhoneNumber x = PhoneNumber.of(843, 6155882, "SOUTH CAROLINA");
        PhoneNumber y = PhoneNumber.of(843, 6155882, "SOUTH CAROLINA");
        assertTrue(x.equals(y));
        assertTrue(x.equals(y));
        assertTrue(x.equals(y));
        assertTrue(x.equals(y));
        assertTrue(x.equals(y));
        assertTrue(x.equals(y));
    }

    @Test
    public void testNonNullability() {
        PhoneNumber x = PhoneNumber.of(843,6155882,"SOUTH CAROLINA");
        assertFalse(x.equals(null));
    }


}