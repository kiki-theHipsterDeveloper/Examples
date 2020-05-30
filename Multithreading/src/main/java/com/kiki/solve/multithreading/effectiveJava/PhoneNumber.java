package com.kiki.solve.multithreading.effectiveJava;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.*;

import static com.google.common.base.Preconditions.checkArgument;

public class PhoneNumber implements Formattable, Comparable<PhoneNumber> {
    //Flyway pattern
    private static final PhoneNumber COMMON = new PhoneNumber(813, 1234, "FLORIDA");

    private final int areaCode;
    private final int number;
    private String areaName;
    private int hashCode;

    private PhoneNumber(int areaCode, int number, String areaName) {
        this.areaCode = areaCode;
        this.number = number;
        this.areaName = areaName;
    }

    //@Override
    public boolean intellijEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return areaCode == that.areaCode &&
                number == that.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof PhoneNumber) {
            PhoneNumber other = (PhoneNumber) o;
            return this.areaCode == other.areaCode && this.number == other.number && java.util.Objects.equals(this.areaName, other.areaName);
        }
        return false;
    }

    public int intellijHashCode() {
        return Objects.hashCode(areaCode, number);
    }

    @Override
    public int hashCode() {
        int result;
        result = hashCode;
        if (result == 0) {
            result = java.util.Objects.hash(this.areaCode, this.areaName, this.number);
            this.hashCode = result;
        }
        return result;
    }

    public static PhoneNumber of(int areaCode, int number, String areaName) {
        checkArgument(areaCode > 100);
        checkArgument(number > 1000);
        if (areaCode == 813 && number == 1234) {
            return COMMON;
        }
        return new PhoneNumber(areaCode, number, areaName);
    }


    public static void main(String[] args) {
        PhoneNumber common = PhoneNumber.of(123, 1234, "GEORGIA");
        PhoneNumber common2 = PhoneNumber.of(123, 1234, "GEORGIA");
        System.out.println(common == common2);
        System.out.println(common.equals(common2));
        System.out.println(common.intellijEquals(common2));
        System.out.println(common.toString());
        System.out.println(String.format("%s", common2));
        PhoneNumber p1 = PhoneNumber.of(123, 1234, "GEORGIA");
        PhoneNumber p2 = PhoneNumber.of(122, 1231, "ALABAMA");
        PhoneNumber p3 = PhoneNumber.of(122, 1230, "BEIURUT");
        ArrayList<PhoneNumber> phoneNumbers = new ArrayList();
        phoneNumbers.add(p1);
        phoneNumbers.add(p2);
        phoneNumbers.add(p3);
        System.out.println("before " +phoneNumbers);
        Collections.sort(phoneNumbers);
        System.out.println("after " + phoneNumbers);

        phoneNumbers.sort(COMPARATOR_AREANAME);
        System.out.println("after sorting by areaname " + phoneNumbers);
    }

    //for debugging output
    @Override
    public String toString() {
       /* return "PhoneNumber{" +
                "areaCode=" + areaCode +
                ", number=" + number +
                ", areaName='" + areaName + '\'' +
                ", hashCode=" + hashCode +
                '}';*/

        return MoreObjects.toStringHelper(this).add("areaCode", this.areaCode)
                .add("number", this.number)
                .add("areaName", this.areaName)
                .toString();

    }

    //for business outputs
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("%d-%d-%s", areaCode, number, areaName);
    }

    private static final Comparator<PhoneNumber> COMPARATOR = Comparator.comparingInt((PhoneNumber p) -> p.areaCode)
            .thenComparingInt((p) -> p.number)
            .thenComparing((p) -> p.areaName);
    private static final Comparator<PhoneNumber> COMPARATOR_AREANAME = Comparator.comparing((PhoneNumber p) -> p.areaName)
            .thenComparingInt((p) -> p.number)
            .thenComparingInt((p) -> p.areaCode);


    @Override
    public int compareTo(PhoneNumber o) {

        return COMPARATOR.compare(this, o);

        //guava way of sorting things
       /* return ComparisonChain.start().compare(this.areaCode,o.areaCode)
                .compare(this.areaName,o.areaName)
                .compare(this.number,o.number)
                .result();*/


    }
}


